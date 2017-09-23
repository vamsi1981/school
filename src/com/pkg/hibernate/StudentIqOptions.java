package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * StudentIqOptions generated by hbm2java
 */
public class StudentIqOptions implements java.io.Serializable {

	private String testType;
	private String classId;
	private String questionId;
	private String answers;
	private Character answer;

	public StudentIqOptions() {
	}

	public StudentIqOptions(String testType) {
		this.testType = testType;
	}

	public StudentIqOptions(String testType, String classId, String questionId,
			String answers, Character answer) {
		this.testType = testType;
		this.classId = classId;
		this.questionId = questionId;
		this.answers = answers;
		this.answer = answer;
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

	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswers() {
		return this.answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Character getAnswer() {
		return this.answer;
	}

	public void setAnswer(Character answer) {
		this.answer = answer;
	}

}
