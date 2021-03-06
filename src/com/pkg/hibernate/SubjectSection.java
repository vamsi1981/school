package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * SubjectSection generated by hbm2java
 */
public class SubjectSection implements java.io.Serializable {

	private String sectionId;
	private Subject subject;
	private String sectionDecription;
	private Set marksSectionWises = new HashSet(0);

	public SubjectSection() {
	}

	public SubjectSection(String sectionId) {
		this.sectionId = sectionId;
	}

	public SubjectSection(String sectionId, Subject subject,
			String sectionDecription, Set marksSectionWises) {
		this.sectionId = sectionId;
		this.subject = subject;
		this.sectionDecription = sectionDecription;
		this.marksSectionWises = marksSectionWises;
	}

	public String getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getSectionDecription() {
		return this.sectionDecription;
	}

	public void setSectionDecription(String sectionDecription) {
		this.sectionDecription = sectionDecription;
	}

	public Set getMarksSectionWises() {
		return this.marksSectionWises;
	}

	public void setMarksSectionWises(Set marksSectionWises) {
		this.marksSectionWises = marksSectionWises;
	}

}
