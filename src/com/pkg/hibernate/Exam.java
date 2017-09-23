package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Exam generated by hbm2java
 */
public class Exam implements java.io.Serializable {

	private String examCode;
	private String exam;
	private Set multipleQuestionAnswers = new HashSet(0);
	private Set examSchedules = new HashSet(0);

	public Exam() {
	}

	public Exam(String examCode) {
		this.examCode = examCode;
	}

	public Exam(String examCode, String exam, Set multipleQuestionAnswers,
			Set examSchedules) {
		this.examCode = examCode;
		this.exam = exam;
		this.multipleQuestionAnswers = multipleQuestionAnswers;
		this.examSchedules = examSchedules;
	}

	public String getExamCode() {
		return this.examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getExam() {
		return this.exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public Set getMultipleQuestionAnswers() {
		return this.multipleQuestionAnswers;
	}

	public void setMultipleQuestionAnswers(Set multipleQuestionAnswers) {
		this.multipleQuestionAnswers = multipleQuestionAnswers;
	}

	public Set getExamSchedules() {
		return this.examSchedules;
	}

	public void setExamSchedules(Set examSchedules) {
		this.examSchedules = examSchedules;
	}

}
