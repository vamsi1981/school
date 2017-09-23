package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * PersonGroup generated by hbm2java
 */
public class PersonGroup implements java.io.Serializable {

	private PersonGroupId id;
	private Person person;
	private GroupType groupType;
	private Date date;

	public PersonGroup() {
		id= new PersonGroupId();
		groupType = new GroupType();
		person =new Person();
	}

	public PersonGroup(PersonGroupId id, Person person, GroupType groupType) {
		this.id = id;
		this.person = person;
		this.groupType = groupType;
	}

	public PersonGroup(PersonGroupId id, Person person, GroupType groupType,
			Date date) {
		this.id = id;
		this.person = person;
		this.groupType = groupType;
		this.date = date;
	}

	public PersonGroupId getId() {
		return this.id;
	}

	public void setId(PersonGroupId id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public GroupType getGroupType() {
		return this.groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}