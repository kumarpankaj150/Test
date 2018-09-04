package com.sparks.ra.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sparks.ra.model.Defect;
import com.sparks.ra.model.Release;
import com.sparks.ra.model.Ticket;

@Repository("reportDao")
public class ReportDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportDAO.class);
	
	/**
	 * Get list of all projects.
	 * @return
	 */
	public List<String> getProjects(){
		Session session = null;
		Criteria criteria = null;
		List<String> projectList = null;
		try {
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Release.class);
			projectList = new ArrayList<String>();
			criteria.setProjection(Projections.distinct(Projections.property("project")));
			projectList = criteria.list();
			logger.info("Total projects: "+projectList.size());
		}catch(Exception e) {
			logger.info("Exception in  getProjects(): "+e.getMessage());
			
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return projectList;
	}
	
	public List<String> getReleases(String project){
		List<String> releases = null;
		Session session = null;
		Criteria criteria = null;
		try {
			releases = new ArrayList<String>();
			session = sessionFactory.openSession();
			criteria = session.createCriteria(Release.class);
			criteria.add(Restrictions.eq("project", project));
			criteria.setProjection(Projections.distinct(Projections.property("releaseVersion")));
			releases = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in  getReleases(): "+e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return releases;
	}
	
	/**
	 * Get payload items of a Release.
	 * @param projectName
	 * @param release
	 * @return
	 */
	public List<Ticket> getReleaseTickets(String projectName,String release){
		List<Ticket> ticketList = null;
		Session session = null;
		Criteria ticketCriteria = null;
		try {
			ticketList = new ArrayList<Ticket>();
			session = sessionFactory.openSession();
			ticketCriteria = session.createCriteria(Ticket.class);
			
			Release releaseDetails = this.getReleaseDetails(session, projectName, release);
			if(releaseDetails!=null) {
				logger.info("ReportDAO.getReleaseTickets() --> Got Release details: "+releaseDetails.getReleaseId());
				ticketCriteria.add(Restrictions.eq("releaseID", releaseDetails.getReleaseId()));
				ticketList = ticketCriteria.list();
				logger.info("ReportDAO.getReleaseTickets() --> Total tickets : "+ticketList.size());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in  ReportDAO.getReleaseTickets() -->: "+e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return ticketList;
	}
	
	public List<Defect> getReleaseDefects(String projectName,String release){
		List<Defect> defectList = null;
		Session session = null;
		Criteria defectCriteria = null;
		try {
			session = sessionFactory.openSession();
			defectList = new ArrayList<Defect>();
			Release releaseDetails = this.getReleaseDetails(session, projectName, release);
			if(releaseDetails!=null) {
				logger.info("ReportDAO.getReleaseDefects() --> Got Release details: "+releaseDetails.getReleaseId());
				defectCriteria = session.createCriteria(Defect.class);
				defectCriteria.add(Restrictions.eq("releaseID", releaseDetails.getReleaseId()));
				defectList = defectCriteria.list();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return defectList;
	}
	
	
	public Release getReleaseDetails(Session session,String projectName,String release) {
		Release releaseDetails = null;
		Criteria releaseCriteria = null;
		try {
			releaseCriteria = session.createCriteria(Release.class);
			releaseCriteria.add(Restrictions.eq("project", projectName));
			releaseCriteria.add(Restrictions.eq("releaseVersion", release));
			releaseDetails = (Release)releaseCriteria.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in  ReportDAO.getReleaseDetails() -->: "+e.getMessage());
		}
		return releaseDetails;
	}
}
