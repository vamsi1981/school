package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * StudentGroup generated by hbm2java
 */
public class StudentGroup implements java.io.Serializable {

	private String personId;
	private String groupType;
	private String remarks;

	public StudentGroup() {
	}

	public StudentGroup(String personId) {
		this.personId = personId;
	}

	public StudentGroup(String personId, String groupType, String remarks) {
		this.personId = personId;
		this.groupType = groupType;
		this.remarks = remarks;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
