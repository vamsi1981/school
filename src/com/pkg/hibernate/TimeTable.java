package com.pkg.hibernate;

import java.util.Date;

/**
 * TimeTable entity. 
 */

public class TimeTable implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7548439133117448478L;
	private String timeTableId;
	private TeacherToSubject teacherToSubject;
	private Timetableschedule timetableschedule;
	private Classlevel classlevel;
	private Period period;
	private Subject subject;
	private Date date;
	private String remarks;

	// Constructors

	/** default constructor */
	public TimeTable() {
		teacherToSubject = new TeacherToSubject();
		timetableschedule = new Timetableschedule();
		classlevel = new Classlevel();
		period= new Period();
		subject = new Subject();
	}

	/** minimal constructor */
	public TimeTable(String timeTableId) {
		this.timeTableId = timeTableId;
	}

	/** full constructor */
	public TimeTable(String timeTableId, TeacherToSubject teacherToSubject,
			Timetableschedule timetableschedule, Classlevel classlevel,
			Period period, Subject subject, Date date, String remarks) {
		this.timeTableId = timeTableId;
		this.teacherToSubject = teacherToSubject;
		this.timetableschedule = timetableschedule;
		this.classlevel = classlevel;
		this.period = period;
		this.subject = subject;
		this.date = date;
		this.remarks = remarks;
	}

	// Property accessors

	public String getTimeTableId() {
		return this.timeTableId;
	}

	public void setTimeTableId(String timeTableId) {
		this.timeTableId = timeTableId;
	}

	public TeacherToSubject getTeacherToSubject() {
		return this.teacherToSubject;
	}

	public void setTeacherToSubject(TeacherToSubject teacherToSubject) {
		this.teacherToSubject = teacherToSubject;
	}

	public Timetableschedule getTimetableschedule() {
		return this.timetableschedule;
	}

	public void setTimetableschedule(Timetableschedule timetableschedule) {
		this.timetableschedule = timetableschedule;
	}

	public Classlevel getClasslevel() {
		return this.classlevel;
	}

	public void setClasslevel(Classlevel classlevel) {
		this.classlevel = classlevel;
	}

	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}