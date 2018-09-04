package com.sparks.ra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "DEFECT")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="DEFECT_ID")
	private long defectId;
	
	@Column(name = "RELEASE_ID")
    private long releaseID;
	
	@Column(name ="DEFECT_DISCRIPTION")
	private String description;
	@Column(name ="DEFECT_STATUS")
	private String status;
	@Column(name ="DEFECT_RAISED_BY")
	private String raisedBy;
	@Column(name ="DEFECT_ASSIGNED_TO")
	private String assignedTo;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name ="DEFECT_CREATED_TIME_STAMP")
	private Date createTimeStamp;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name ="DEFECT_UPDATED_TIME_STAMP")
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
