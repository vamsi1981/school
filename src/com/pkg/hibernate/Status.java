package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * Status generated by hbm2java
 */
public class Status implements java.io.Serializable {

	private String statusCode;
	private String statusType;

	public Status() {
	}

	public Status(String statusCode) {
		this.statusCode = statusCode;
	}

	public Status(String statusCode, String statusType) {
		this.statusCode = statusCode;
		this.statusType = statusType;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

}