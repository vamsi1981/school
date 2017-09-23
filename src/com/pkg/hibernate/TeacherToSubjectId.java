package com.pkg.hibernate;

/**
 * TeacherToSubjectId entity. @author MyEclipse Persistence Tools
 */

public class TeacherToSubjectId implements java.io.Serializable {

	// Fields

	private String personId;
	private String subjectId;

	// Constructors

	/** default constructor */
	public TeacherToSubjectId() {
	}

	/** full constructor */
	public TeacherToSubjectId(String personId, String subjectId) {
		this.personId = personId;
		this.subjectId = subjectId;
	}

	// Property accessors

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeacherToSubjectId))
			return false;
		TeacherToSubjectId castOther = (TeacherToSubjectId) other;

		return ((this.getPersonId() == castOther.getPersonId()) || (this
				.getPersonId() != null && castOther.getPersonId() != null && this
				.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getSubjectId() == castOther.getSubjectId()) || (this
						.getSubjectId() != null
						&& castOther.getSubjectId() != null && this
						.getSubjectId().equals(castOther.getSubjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37 * result
				+ (getSubjectId() == null ? 0 : this.getSubjectId().hashCode());
		return result;
	}

}