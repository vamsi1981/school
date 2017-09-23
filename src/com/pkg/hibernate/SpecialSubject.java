package com.pkg.hibernate;

/**
 * SpecialSubject entity. @author MyEclipse Persistence Tools
 */

public class SpecialSubject implements java.io.Serializable {

	// Fields

	private SpecialSubjectId id;
	private Subject subject;
	private String remarks;

	// Constructors

	/** default constructor */
	public SpecialSubject() {
		id= new SpecialSubjectId();
		subject =new Subject();
	}

	/** minimal constructor */
	public SpecialSubject(SpecialSubjectId id, Subject subject) {
		this.id = id;
		this.subject = subject;
	}

	/** full constructor */
	public SpecialSubject(SpecialSubjectId id, Subject subject, String remarks) {
		this.id = id;
		this.subject = subject;
		this.remarks = remarks;
	}

	// Property accessors

	public SpecialSubjectId getId() {
		return this.id;
	}

	public void setId(SpecialSubjectId id) {
		this.id = id;
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