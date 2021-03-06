package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * PersonDependentDetail generated by hbm2java
 */
public class PersonDependentDetail implements java.io.Serializable {

	private PersonDependentDetailId id;
	private Category category;
	private Address address;
	private Person person;
	private Guardian guardian;
	private String guardianName;
	private String qualificationCode;
	private String caste;

	public PersonDependentDetail() {
		guardian = new Guardian();
		category = new Category();
		address = new Address();
	}

	public PersonDependentDetail(PersonDependentDetailId id, Category category,
			Address address, Person person, Guardian guardian) {
		this.id = id;
		this.category = category;
		this.address = address;
		this.person = person;
		this.guardian = guardian;
	}

	public PersonDependentDetail(PersonDependentDetailId id, Category category,
			Address address, Person person, Guardian guardian,
			String guardianName, String qualificationCode, String caste) {
		this.id = id;
		this.category = category;
		this.address = address;
		this.person = person;
		this.guardian = guardian;
		this.guardianName = guardianName;
		this.qualificationCode = qualificationCode;
		this.caste = caste;
	}

	public PersonDependentDetailId getId() {
		return this.id;
	}

	public void setId(PersonDependentDetailId id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Guardian getGuardian() {
		return this.guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getQualificationCode() {
		return this.qualificationCode;
	}

	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	public String getCaste() {
		return this.caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

}
