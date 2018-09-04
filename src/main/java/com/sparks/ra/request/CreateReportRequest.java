package com.sparks.ra.request;

import com.sparks.ra.response.ResultKey;

public class CreateReportRequest implements IRequest {

	String date;
	String project;
	String submittedBy;
	
	
	
	
	@Override
	public ResultKey authenticateRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultKey validateRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "CreateReportRequest [date=" + date + ", project=" + project + ", submittedBy=" + submittedBy + "]";
	}
	
	

}
