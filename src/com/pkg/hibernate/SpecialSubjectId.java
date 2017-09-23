package com.pkg.hibernate;

/**
 * SpecialSubjectId entity. @author MyEclipse Persistence Tools
 */

public class SpecialSubjectId implements java.io.Serializable {

	// Fields

	private String subjectId;
	private String personId;

	// Constructors

	/** default constructor */
	public SpecialSubjectId() {
	}

	/** full constructor */
	public SpecialSubjectId(String subjectId, String personId) {
		this.subjectId = subjectId;
		this.personId = personId;
	}

	// Property accessors

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SpecialSubjectId))
			return false;
		SpecialSubjectId castOther = (SpecialSubjectId) other;

		return ((this.getSubjectId() == castOther.getSubjectId()) || (this
				.getSubjectId() != null && castOther.getSubjectId() != null && this
				.getSubjectId().equals(castOther.getSubjectId())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSubjectId() == null ? 0 : this.getSubjectId().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		return result;
	}

}