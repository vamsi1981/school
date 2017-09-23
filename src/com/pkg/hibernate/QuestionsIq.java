package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:47 PM by Hibernate Tools 3.4.0.CR1

/**
 * QuestionsIq generated by hbm2java
 */
public class QuestionsIq implements java.io.Serializable {

	private String questionId;
	private String questionDesc;
	private String remarks;
	private MultipleQuestionAnswer multipleQuestionAnswer;

	public QuestionsIq() {
	}

	public QuestionsIq(String questionId) {
		this.questionId = questionId;
	}

	public QuestionsIq(String questionId, String questionDesc, String remarks,
			MultipleQuestionAnswer multipleQuestionAnswer) {
		this.questionId = questionId;
		this.questionDesc = questionDesc;
		this.remarks = remarks;
		this.multipleQuestionAnswer = multipleQuestionAnswer;
	}

	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDesc() {
		return this.questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public MultipleQuestionAnswer getMultipleQuestionAnswer() {
		return this.multipleQuestionAnswer;
	}

	public void setMultipleQuestionAnswer(
			MultipleQuestionAnswer multipleQuestionAnswer) {
		this.multipleQuestionAnswer = multipleQuestionAnswer;
	}

}