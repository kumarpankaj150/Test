package com.sparks.ra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="RELEASE_META")
public class Release {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="RELEASE_ID")
	private long releaseId;
	@Column(name = "RELEASE_PROJECT")
	private String project;
	@Column(name ="RELEASE_VERSION")
	private String releaseVersion;
	public long getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getReleaseVersion() {
		return releaseVersion;
	}
	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}

	
}
