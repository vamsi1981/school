package com.pkg.hibernate;

import java.sql.Timestamp;

/**
 * HelpScId entity. @author MyEclipse Persistence Tools
 */

public class HelpScId implements java.io.Serializable {

	// Fields

	private String schoolId;
	private Timestamp startDttm;

	// Constructors

	/** default constructor */
	public HelpScId() {
	}

	/** full constructor */
	public HelpScId(String schoolId, Timestamp startDttm) {
		this.schoolId = schoolId;
		this.startDttm = startDttm;
	}

	// Property accessors

	public String getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public Timestamp getStartDttm() {
		return this.startDttm;
	}

	public void setStartDttm(Timestamp startDttm) {
		this.startDttm = startDttm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HelpScId))
			return false;
		HelpScId castOther = (HelpScId) other;

		return ((this.getSchoolId() == castOther.getSchoolId()) || (this
				.getSchoolId() != null && castOther.getSchoolId() != null && this
				.getSchoolId().equals(castOther.getSchoolId())))
				&& ((this.getStartDttm() == castOther.getStartDttm()) || (this
						.getStartDttm() != null
						&& castOther.getStartDttm() != null && this
						.getStartDttm().equals(castOther.getStartDttm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSchoolId() == null ? 0 : this.getSchoolId().hashCode());
		result = 37 * result
				+ (getStartDttm() == null ? 0 : this.getStartDttm().hashCode());
		return result;
	}

}