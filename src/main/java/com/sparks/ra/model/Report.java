package com.sparks.ra.model;

import java.util.List;

public class Report {

	String date;
	String status;
	String project;
	double progress;
	List<Ticket> payloadItems;
	List<Defect> bugList;
	String comments;
	String attachments;
	String submittedBy;
	String reviewdBy;
	String createTimeStamp;
	String updateTimeStamp;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getCreateTimeStamp() {
		return createTimeStamp;
	}
	public void setCreateTimeStamp(String createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}
	public String getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(String updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public List<Ticket> getPayloadItems() {
		return payloadItems;
	}
	public void setPayloadItems(List<Ticket> payloadItems) {
		this.payloadItems = payloadItems;
	}
	public List<Defect> getBugList() {
		return bugList;
	}
	public void setBugList(List<Defect> bugList) {
		this.bugList = bugList;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	public String getReviewdBy() {
		return reviewdBy;
	}
	public void setReviewdBy(String reviewdBy) {
		this.reviewdBy = reviewdBy;
	}
	
	
}
