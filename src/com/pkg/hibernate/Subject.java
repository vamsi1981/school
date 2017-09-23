package com.pkg.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. 
 */

public class Subject implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6669820478872360390L;
	private String subjectId;
	private String subjectCode;
	private String subjectName;
	private Set focusAreases = new HashSet(0);
	private Set timeTables = new HashSet(0);
	private Set markses = new HashSet(0);
	private Set subjectSections = new HashSet(0);
	private Set dailyWorks = new HashSet(0);
	private Set teacherToSubjects = new HashSet(0);
	private Set specialSubjects = new HashSet(0);
	private Set performanceTypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** full constructor */
	public Subject(String subjectCode, String subjectName, Set focusAreases,
			Set timeTables, Set markses, Set subjectSections, Set dailyWorks,
			Set teacherToSubjects, Set specialSubjects, Set performanceTypes) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.focusAreases = focusAreases;
		this.timeTables = timeTables;
		this.markses = markses;
		this.subjectSections = subjectSections;
		this.dailyWorks = dailyWorks;
		this.teacherToSubjects = teacherToSubjects;
		this.specialSubjects = specialSubjects;
		this.performanceTypes = performanceTypes;
	}

	// Property accessors

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set getFocusAreases() {
		return this.focusAreases;
	}

	public void setFocusAreases(Set focusAreases) {
		this.focusAreases = focusAreases;
	}

	public Set getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(Set timeTables) {
		this.timeTables = timeTables;
	}

	public Set getMarkses() {
		return this.markses;
	}

	public void setMarkses(Set markses) {
		this.markses = markses;
	}

	public Set getSubjectSections() {
		return this.subjectSections;
	}

	public void setSubjectSections(Set subjectSections) {
		this.subjectSections = subjectSections;
	}

	public Set getDailyWorks() {
		return this.dailyWorks;
	}

	public void setDailyWorks(Set dailyWorks) {
		this.dailyWorks = dailyWorks;
	}

	public Set getTeacherToSubjects() {
		return this.teacherToSubjects;
	}

	public void setTeacherToSubjects(Set teacherToSubjects) {
		this.teacherToSubjects = teacherToSubjects;
	}

	public Set getSpecialSubjects() {
		return this.specialSubjects;
	}

	public void setSpecialSubjects(Set specialSubjects) {
		this.specialSubjects = specialSubjects;
	}

	public Set getPerformanceTypes() {
		return this.performanceTypes;
	}

	public void setPerformanceTypes(Set performanceTypes) {
		this.performanceTypes = performanceTypes;
	}

}