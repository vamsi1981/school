package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * MarksSectionWiseId generated by hbm2java
 */
public class MarksSectionWiseId implements java.io.Serializable {

	private String personId;
	private String subjectId;
	private Float marks;
	private String sectionId;
	private String examCode;
	private String remarks;
	private String personType;

	public MarksSectionWiseId() {
	}

	public MarksSectionWiseId(String personId) {
		this.personId = personId;
	}

	public MarksSectionWiseId(String personId, String subjectId, Float marks,
			String sectionId, String examCode, String remarks, String personType) {
		this.personId = personId;
		this.subjectId = subjectId;
		this.marks = marks;
		this.sectionId = sectionId;
		this.examCode = examCode;
		this.remarks = remarks;
		this.personType = personType;
	}

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

	public Float getMarks() {
		return this.marks;
	}

	public void setMarks(Float marks) {
		this.marks = marks;
	}

	public String getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getExamCode() {
		return this.examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPersonType() {
		return this.personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MarksSectionWiseId))
			return false;
		MarksSectionWiseId castOther = (MarksSectionWiseId) other;

		return ((this.getPersonId() == castOther.getPersonId()) || (this
				.getPersonId() != null && castOther.getPersonId() != null && this
				.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getSubjectId() == castOther.getSubjectId()) || (this
						.getSubjectId() != null
						&& castOther.getSubjectId() != null && this
						.getSubjectId().equals(castOther.getSubjectId())))
				&& ((this.getMarks() == castOther.getMarks()) || (this
						.getMarks() != null && castOther.getMarks() != null && this
						.getMarks().equals(castOther.getMarks())))
				&& ((this.getSectionId() == castOther.getSectionId()) || (this
						.getSectionId() != null
						&& castOther.getSectionId() != null && this
						.getSectionId().equals(castOther.getSectionId())))
				&& ((this.getExamCode() == castOther.getExamCode()) || (this
						.getExamCode() != null
						&& castOther.getExamCode() != null && this
						.getExamCode().equals(castOther.getExamCode())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this
						.getRemarks() != null && castOther.getRemarks() != null && this
						.getRemarks().equals(castOther.getRemarks())))
				&& ((this.getPersonType() == castOther.getPersonType()) || (this
						.getPersonType() != null
						&& castOther.getPersonType() != null && this
						.getPersonType().equals(castOther.getPersonType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37 * result
				+ (getSubjectId() == null ? 0 : this.getSubjectId().hashCode());
		result = 37 * result
				+ (getMarks() == null ? 0 : this.getMarks().hashCode());
		result = 37 * result
				+ (getSectionId() == null ? 0 : this.getSectionId().hashCode());
		result = 37 * result
				+ (getExamCode() == null ? 0 : this.getExamCode().hashCode());
		result = 37 * result
				+ (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		result = 37
				* result
				+ (getPersonType() == null ? 0 : this.getPersonType()
						.hashCode());
		return result;
	}

}