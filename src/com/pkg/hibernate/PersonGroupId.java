package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * PersonGroupId generated by hbm2java
 */
public class PersonGroupId implements java.io.Serializable {

	private String personId;
	private String personType;
	private String groupType;

	public PersonGroupId() {
	}

	public PersonGroupId(String personId, String personType, String groupType) {
		this.personId = personId;
		this.personType = personType;
		this.groupType = groupType;
	}

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

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonGroupId))
			return false;
		PersonGroupId castOther = (PersonGroupId) other;

		return ((this.getPersonId() == castOther.getPersonId()) || (this
				.getPersonId() != null && castOther.getPersonId() != null && this
				.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getPersonType() == castOther.getPersonType()) || (this
						.getPersonType() != null
						&& castOther.getPersonType() != null && this
						.getPersonType().equals(castOther.getPersonType())))
				&& ((this.getGroupType() == castOther.getGroupType()) || (this
						.getGroupType() != null
						&& castOther.getGroupType() != null && this
						.getGroupType().equals(castOther.getGroupType())));
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
				+ (getGroupType() == null ? 0 : this.getGroupType().hashCode());
		return result;
	}

}
