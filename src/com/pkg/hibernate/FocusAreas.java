package com.pkg.hibernate;

/**
 * FocusAreas entity. 
 */

public class FocusAreas implements java.io.Serializable {

	// Fields

	private FocusAreasId id;
	private SubTopics subTopics;
	private Person person;
	private Subject subject;
	private String remarks;

	// Constructors

	/** default constructor */
	public FocusAreas() {
		subTopics =new SubTopics();
		id= new FocusAreasId();
		subject =new Subject();
		person =new Person();
	}

	/** minimal constructor */
	public FocusAreas(FocusAreasId id, Person person, Subject subject) {
		this.id = id;
		this.person = person;
		this.subject = subject;
	}

	/** full constructor */
	public FocusAreas(FocusAreasId id, SubTopics subTopics, Person person,
			Subject subject, String remarks) {
		this.id = id;
		this.subTopics = subTopics;
		this.person = person;
		this.subject = subject;
		this.remarks = remarks;
	}

	// Property accessors

	public FocusAreasId getId() {
		return this.id;
	}

	public void setId(FocusAreasId id) {
		this.id = id;
	}

	public SubTopics getSubTopics() {
		return this.subTopics;
	}

	public void setSubTopics(SubTopics subTopics) {
		this.subTopics = subTopics;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}