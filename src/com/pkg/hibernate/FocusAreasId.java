package com.pkg.hibernate;

/**
 * FocusAreasId entity. 
 */

public class FocusAreasId implements java.io.Serializable {

	// Fields

	private String personId;
	private String personType;
	private String subjectId;

	// Constructors

	/** default constructor */
	public FocusAreasId() {
	}

	/** full constructor */
	public FocusAreasId(String personId, String personType, String subjectId) {
		this.personId = personId;
		this.personType = personType;
		this.subjectId = subjectId;
	}

	// Property accessors
		
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
		
	}

	public String getPersonType() {
		return this.personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
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
		if (!(other instanceof FocusAreasId))
			return false;
		FocusAreasId castOther = (FocusAreasId) other;

		return ((this.getPersonId() == castOther.getPersonId()) || (this
				.getPersonId() != null && castOther.getPersonId() != null && this
				.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getPersonType() == castOther.getPersonType()) || (this
						.getPersonType() != null
						&& castOther.getPersonType() != null && this
						.getPersonType().equals(castOther.getPersonType())))
				&& ((this.getSubjectId() == castOther.getSubjectId()) || (this
						.getSubjectId() != null
						&& castOther.getSubjectId() != null && this
						.getSubjectId().equals(castOther.getSubjectId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37
				* result
				+ (getPersonType() == null ? 0 : this.getPersonType()
						.hashCode());
		result = 37 * result
				+ (getSubjectId() == null ? 0 : this.getSubjectId().hashCode());
		return result;
	}

}