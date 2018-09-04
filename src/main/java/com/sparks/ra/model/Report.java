package com.sparks.ra.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name= "REPORT")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reportId ;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date date;
	@Column(name = "REPORT_STATUS")
	private String status;
	
	@Column(name = "PROGRESS")
	private double progress;
	@Column(name = "RELEASE_ID")
    private long releaseID;
	/*
	List<Ticket> payloadItems;
	
	List<Defect> bugList;*/
	@Column(name = "COMMENT")
	private String comments;
	@Column(name = "ATTACHMENT")
	@Lob
	private byte[] attachments;
	@Column(name = "REPORT_SUBMITTED_BY")
	private String submittedBy;
	@Column(name = "REPORT_REVIEWED_BY")
	private String reviewdBy;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "REPORT_CREATE_TIME_STAMP")
	private Date createTimeStamp;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "REPORT_UPDATE_TIME_STAMP")
	private Date updateTimeStamp;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	/*@OneToMany
	@JoinColumn
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
	}*/
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public byte[] getAttachments() {
		return attachments;
	}
	public void setAttachments(byte[] attachments) {
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
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public long getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(long releaseID) {
		this.releaseID = releaseID;
	}
	
	
}
