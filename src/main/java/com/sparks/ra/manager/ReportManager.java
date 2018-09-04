package com.sparks.ra.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sparks.ra.common.RaConstant;
import com.sparks.ra.model.Defect;
import com.sparks.ra.model.Report;
import com.sparks.ra.model.Ticket;
import com.sparks.ra.request.CreateReportRequest;
import com.sparks.ra.request.SubmitReportRequest;
import com.sparks.ra.request.dto.DefectDto;
import com.sparks.ra.request.dto.ReportDto;
import com.sparks.ra.response.Response;
import com.sparks.ra.response.ResponseKey;
import com.sparks.ra.response.ResultKey;

@Service("reportMgr")
public class ReportManager {

	private static final Logger logger = LoggerFactory.getLogger(ReportManager.class);
	
	public Response createReport(CreateReportRequest request) {
		logger.info(this.getClass().getName()+"->createReport():: Request: "+request.toString());
		Response response = new Response();
		try {
			Report report = new Report();
			report.setDate(new Date());
			report.setSubmittedBy(request.getSubmittedBy());
			report.setProject(request.getProject());
			/*report.setPayloadItems(new ArrayList<Ticket>());
			report.setBugList(new ArrayList<Defect>());*/
			report.setStatus("IN_PROGRESS");
			response.addResponseData(ResponseKey.REPORT,report);
		}catch(Exception e) {
			response.addResponseData(ResponseKey.ERROR, ResultKey.SYSTEM_EXCEPTION);
			response.addResponseData(ResponseKey.EXCEPTION, e.getMessage());
		}
		logger.info(this.getClass().getName()+"->createReport():: Response: "+response.toString());
		return response;
	}
	
	public boolean submitReport(SubmitReportRequest request) {
       try {
		ReportDto reportDto = request.getReport();
		Report report = new Report();
		report.setDate(new Date());
		report.setSubmittedBy(reportDto.getSubmittedBy());
		report.setReleaseID(reportDto.getReleaseID());
		report.setComments(reportDto.getComments());
		report.setAttachments(report.getAttachments());
		report.setCreateTimeStamp(new Date());
		List<Defect> defectList = new ArrayList<Defect>();
		 for(DefectDto defectDto :reportDto.getDefect()) {
			 Defect defect = new Defect();
			 defect.setAssignedTo(defectDto.getAssignedTo());
			 
			 defect.setRaisedBy(defectDto.getRaisedBy());
			 defect.setStatus(defectDto.getStatus());
			 defect.setReleaseID(defectDto.getReleaseID());
			 if(defectDto.getStatus().equalsIgnoreCase(RaConstant.DEFECT_NEW)) {
				 defect.setCreateTimeStamp(new  Date());
			 }else if(defectDto.getStatus().equalsIgnoreCase(RaConstant.DEFECT_OPEN)) {
				 continue;
			 }else {
				 defectDto.setUpdateTimeStamp(new Date());
			 }
			 defectList.add(defect);
		 }
		
		
		/*report.setPayloadItems(new ArrayList<Ticket>());
		report.setBugList(new ArrayList<Defect>());*/
		
			 report.setStatus(RaConstant.SUBMITED_SUCESSFULLY);
		
       }catch(Exception e) {
    	   
       }
	
	}
}
