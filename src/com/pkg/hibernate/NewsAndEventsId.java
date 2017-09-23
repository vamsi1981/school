package com.pkg.hibernate;

import java.sql.Timestamp;

/**
 * NewsAndEventsId entity. @author MyEclipse Persistence Tools
 */

public class NewsAndEventsId implements java.io.Serializable {

	// Fields

	private String schoolId;
	private String eventType;
	private Timestamp startDttm;

	// Constructors

	/** default constructor */
	public NewsAndEventsId() {
	}

	/** full constructor */
	public NewsAndEventsId(String schoolId, String eventType,
			Timestamp startDttm) {
		this.schoolId = schoolId;
		this.eventType = eventType;
		this.startDttm = startDttm;
	}

	// Property accessors

	public String getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
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
		if (!(other instanceof NewsAndEventsId))
			return false;
		NewsAndEventsId castOther = (NewsAndEventsId) other;

		return ((this.getSchoolId() == castOther.getSchoolId()) || (this
				.getSchoolId() != null && castOther.getSchoolId() != null && this
				.getSchoolId().equals(castOther.getSchoolId())))
				&& ((this.getEventType() == castOther.getEventType()) || (this
						.getEventType() != null
						&& castOther.getEventType() != null && this
						.getEventType().equals(castOther.getEventType())))
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
				+ (getEventType() == null ? 0 : this.getEventType().hashCode());
		result = 37 * result
				+ (getStartDttm() == null ? 0 : this.getStartDttm().hashCode());
		return result;
	}

}