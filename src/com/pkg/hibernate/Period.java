package com.pkg.hibernate;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Period entity. @author MyEclipse Persistence Tools
 */

public class Period implements java.io.Serializable {

	// Fields

	private String periodCode;
	private Date startTime;
	private Date endTime;
	private String description;
	private Set timeTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Period() {
	}

	/** minimal constructor */
	public Period(String periodCode) {
		this.periodCode = periodCode;
	}

	/** full constructor */
	public Period(String periodCode, Time startTime, Time endTime,
			String description, Set timeTables) {
		this.periodCode = periodCode;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.timeTables = timeTables;
	}

	// Property accessors

	public String getPeriodCode() {
		return this.periodCode;
	}

	public void setPeriodCode(String periodCode) {
		this.periodCode = periodCode;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date  endTime) {
		this.endTime = endTime;
	}

	public Set getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(Set timeTables) {
		this.timeTables = timeTables;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}