package com.pkg.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Classlevel entity.
 */

public class Classlevel implements java.io.Serializable {

	// Fields

	private String classId;
	private String classType;
	private String section;
	private String description;
	private Set timeTables = new HashSet(0);
	private Set examSchedules = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classlevel() {
	}

	/** minimal constructor */
	public Classlevel(String classId) {
		this.classId = classId;
	}

	/** full constructor */
	public Classlevel(String classId, String classType, String section,
			String description, Set timeTables, Set examSchedules) {
		this.classId = classId;
		this.classType = classType;
		this.section = section;
		this.description = description;
		this.timeTables = timeTables;
		this.examSchedules = examSchedules;
	}

	// Property accessors

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
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

	public Set getExamSchedules() {
		return this.examSchedules;
	}

	public void setExamSchedules(Set examSchedules) {
		this.examSchedules = examSchedules;
	}

}