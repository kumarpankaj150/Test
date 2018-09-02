package com.sparks.ra.request;

import com.sparks.ra.response.ResultKey;

public class CreateReportRequest implements IRequest {

	String date;
	String project;
	String submittedBy;
	
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

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
