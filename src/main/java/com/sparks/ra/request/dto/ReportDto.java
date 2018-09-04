package com.sparks.ra.request.dto;

import java.util.Date;
import java.util.List;



public class ReportDto {
		
		private Date date;
		
		private String status;
		
		private double progress;
		
	    private long releaseID;
		
		private String comments;
		
		private String attachments;
		
		private String submittedBy;
		
		private String reviewdBy;
		
		private List<DefectDto> defect;
		
		
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
		
		public double getProgress() {
			return progress;
		}
		public void setProgress(double progress) {
			this.progress = progress;
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
		
		public long getReleaseID() {
			return releaseID;
		}
		public void setReleaseID(long releaseID) {
			this.releaseID = releaseID;
		}
		public List<DefectDto> getDefect() {
			return defect;
		}
		public void setDefect(List<DefectDto> defect) {
			this.defect = defect;
		}
		
}
