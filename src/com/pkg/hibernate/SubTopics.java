package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * SubTopics generated by hbm2java
 */
public class SubTopics implements java.io.Serializable {

	private String focusArea;
	private String remarks;

	public SubTopics() {
	}

	public SubTopics(String focusArea) {
		this.focusArea = focusArea;
	}

	public SubTopics(String focusArea, String remarks) {
		this.focusArea = focusArea;
		this.remarks = remarks;
	}

	public String getFocusArea() {
		return this.focusArea;
	}

	public void setFocusArea(String focusArea) {
		this.focusArea = focusArea;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
