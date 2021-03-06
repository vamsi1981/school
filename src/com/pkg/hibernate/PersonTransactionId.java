package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * PersonTransactionId generated by hbm2java
 */
public class PersonTransactionId implements java.io.Serializable {

	private int transId;
	private String catId;
	private String personId;

	public PersonTransactionId() {
	}

	public PersonTransactionId(int transId, String catId, String personId) {
		this.transId = transId;
		this.catId = catId;
		this.personId = personId;
	}

	public int getTransId() {
		return this.transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getCatId() {
		return this.catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
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
		if (!(other instanceof PersonTransactionId))
			return false;
		PersonTransactionId castOther = (PersonTransactionId) other;

		return (this.getTransId() == castOther.getTransId())
				&& ((this.getCatId() == castOther.getCatId()) || (this
						.getCatId() != null && castOther.getCatId() != null && this
						.getCatId().equals(castOther.getCatId())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTransId();
		result = 37 * result
				+ (getCatId() == null ? 0 : this.getCatId().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		return result;
	}

}
