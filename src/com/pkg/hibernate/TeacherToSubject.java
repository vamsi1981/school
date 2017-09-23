package com.pkg.hibernate;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TeacherToSubject entity. @author MyEclipse Persistence Tools
 */

public class TeacherToSubject implements java.io.Serializable {

	// Fields

	private TeacherToSubjectId id;
	private Integer version;
	private Subject subject;
	private Timestamp startDate;
	private Timestamp endDate;
	private String description;
	private Set timeTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeacherToSubject() {
		id= new TeacherToSubjectId();
	}

	/** minimal constructor */
	public TeacherToSubject(TeacherToSubjectId id, Subject subject) {
		this.id = id;
		this.subject = subject;
	}

	/** full constructor */
	public TeacherToSubject(TeacherToSubjectId id, Subject subject,
			Timestamp startDate, Timestamp endDate, String description,
			Set timeTables) {
		this.id = id;
		this.subject = subject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.timeTables = timeTables;
	}

	// Property accessors

	public TeacherToSubjectId getId() {
		return this.id;
	}

	public void setId(TeacherToSubjectId id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(Set timeTables) {
		this.timeTables = timeTables;
	}

}