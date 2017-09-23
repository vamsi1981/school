package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * StudentIqTest generated by hbm2java
 */
public class StudentIqTest implements java.io.Serializable {

	private String questionCode;
	private String testType;
	private String classId;
	private String complexity;
	private String remarks;

	public StudentIqTest() {
	}

	public StudentIqTest(String questionCode, String testType, String classId) {
		this.questionCode = questionCode;
		this.testType = testType;
		this.classId = classId;
	}

	public StudentIqTest(String questionCode, String testType, String classId,
			String complexity, String remarks) {
		this.questionCode = questionCode;
		this.testType = testType;
		this.classId = classId;
		this.complexity = complexity;
		this.remarks = remarks;
	}

	public String getQuestionCode() {
		return this.questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getComplexity() {
		return this.complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
