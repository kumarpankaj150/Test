package com.sparks.ra.model;

public class ReportDefectStatus {

	private Long id;
	private Long reportId;
	private Long defectId;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public Long getDefectId() {
		return defectId;
	}
	public void setDefectId(Long defectId) {
		this.defectId = defectId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
