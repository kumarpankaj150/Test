package com.sparks.ra.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparks.ra.manager.ReportManager;
import com.sparks.ra.model.Defect;
import com.sparks.ra.model.Release;
import com.sparks.ra.model.Ticket;
import com.sparks.ra.repo.ReportDAO;
import com.sparks.ra.request.CreateReportRequest;
import com.sparks.ra.request.SubmitReportRequest;
import com.sparks.ra.request.dto.ReportDto;
import com.sparks.ra.response.Response;
import com.sparks.ra.response.ResponseKey;

@RestController
@RequestMapping(value="/report")
public class ReportController {

	@Autowired
	ReportManager reportMgr;
	
	@Autowired
	ReportDAO reportDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class); 
	
	@RequestMapping(value="/create",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response createReport(@RequestBody CreateReportRequest request) {
		logger.info("createReport(): Request: "+request.toString());
		Response response = new Response();
		try {
			response = reportMgr.createReport(request);
			logger.info("createReport(): Response: "+response.toString());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("createReport(): Exception: "+e.getMessage());
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getProjects",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response getProjects() {
		Response response = new Response();
		try {
			List<String> projectList = reportDao.getProjects();
			logger.info("Total projects: "+projectList.size()+"---> "+projectList.toString());
			response.addResponseData(ResponseKey.PROJECTS, projectList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in getProjects()");
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/getReleases/{projectName}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response getReleases(@PathVariable("projectName") String pojectName) {
		Response response = new Response();
		try {
			List<String> releaseList = reportDao.getReleases(pojectName);
			logger.info("Total releases for "+pojectName+ ":"+releaseList.size()+"---> "+releaseList.toString());
			response.addResponseData(ResponseKey.PROJECT, pojectName);
			response.addResponseData(ResponseKey.RELEASES, releaseList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in getReleases()");
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response submitReport() {
		//@RequestBody SubmitReportRequest request
		SubmitReportRequest request = new SubmitReportRequest();
		request.setReport(new ReportDto());
		//logger.info("submitReport(): Request: "+request.toString());
		Response response = new Response();
		try {
			/*response = reportMgr.submitReport(request);
			logger.info("createReport(): Response: "+response.toString());*/
			response.addResponseData(ResponseKey.TEST, request);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("createReport(): Exception: "+e.getMessage());
			
		}
		return response;
	}
	
	@RequestMapping(value="/getReleaseTickets/{projectName}/{release}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response getReleaseTickets(@PathVariable("projectName")String projectName,@PathVariable("release")String release) {
		logger.info("getReleaseTickets(): ");
		Response response = new Response();
		try {
			List<Ticket> ticketsList = reportDao.getReleaseTickets(projectName, release);
			response.addResponseData(ResponseKey.PROJECT, projectName);
			response.addResponseData(ResponseKey.RELEASE, release);
			response.addResponseData(ResponseKey.TICKETS, ticketsList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in ReportController.getReleaseTickets()");
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());

		}
		return response;
	}
	
	@RequestMapping(value="/getReleaseDefects/{projectName}/{release}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response getReleaseDefects(@PathVariable("projectName")String projectName,@PathVariable("release")String release) {
		logger.info("getReleaseDefects(): ");
		Response response = new Response();
		try {
			List<Defect> defectList = reportDao.getReleaseDefects(projectName, release);
			response.addResponseData(ResponseKey.PROJECT, projectName);
			response.addResponseData(ResponseKey.RELEASE, release);
			response.addResponseData(ResponseKey.DEFECTS, defectList);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Exception in ReportController.getReleaseDefects()");
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());
		}
		return response;
	}
	
	
}
