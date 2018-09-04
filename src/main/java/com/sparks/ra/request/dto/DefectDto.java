package com.sparks.ra.request.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DefectDto {


	private long defectId;
	
	
    private long releaseID;

	private String description;
	
	private String status;
	
	private String raisedBy;
	
	private String assignedTo;
	
	private Date createTimeStamp;
	
	private Date updateTimeStamp;
	
	
	public Long getBugId() {
		return defectId;
	}
	public void setBugId(Long defectId) {
		this.defectId = defectId;
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
	public long getDefectId() {
		return defectId;
	}
	public void setDefectId(long defectId) {
		this.defectId = defectId;
	}
	public long getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(long releaseID) {
		this.releaseID = releaseID;
	}
	public Date getCreateTimeStamp() {
		return createTimeStamp;
	}
	public void setCreateTimeStamp(Date createTimeStamp) {
		this.createTimeStamp = createTimeStamp;
	}
	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	
	

}
