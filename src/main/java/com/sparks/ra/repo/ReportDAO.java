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

import com.sparks.ra.model.Release;

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
}
