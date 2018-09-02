package com.sparks.ra.model;

public class Defect {

	Long defectId;
	String project;
	String release;
	String description;
	String status;
	String raisedBy;
	String assignedTo;
	String createTimeStamp;
	String updateTimeStamp;
	
	public Long getBugId() {
		return defectId;
	}
	public void setBugId(Long defectId) {
		this.defectId = defectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	
}
