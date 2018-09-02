package com.sparks.ra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparks.ra.manager.ReportManager;
import com.sparks.ra.request.CreateReportRequest;
import com.sparks.ra.response.Response;
import com.sparks.ra.response.ResponseKey;

@RestController
@RequestMapping(value="/report")
public class ReportController {

	@Autowired
	ReportManager reportMgr;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class); 
	
	@RequestMapping(value="/create",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
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
}
