package com.pkg.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Timetableschedule entity. @author MyEclipse Persistence Tools
 */

public class Timetableschedule implements java.io.Serializable {

	// Fields

	private String timetableType;
	private Integer version;
	private Date scheduledFrom;
	private Date scheduleTo;
	private Set timeTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Timetableschedule() {
	}

	/** minimal constructor */
	public Timetableschedule(String timetableType) {
		this.timetableType = timetableType;
	}

	/** full constructor */
	public Timetableschedule(String timetableType, Date scheduledFrom,
			Date scheduleTo, Set timeTables) {
		this.timetableType = timetableType;
		this.scheduledFrom = scheduledFrom;
		this.scheduleTo = scheduleTo;
		this.timeTables = timeTables;
	}

	// Property accessors

	public String getTimetableType() {
		return this.timetableType;
	}

	public void setTimetableType(String timetableType) {
		this.timetableType = timetableType;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getScheduledFrom() {
		return this.scheduledFrom;
	}

	public void setScheduledFrom(Date scheduledFrom) {
		this.scheduledFrom = scheduledFrom;
	}

	public Date getScheduleTo() {
		return this.scheduleTo;
	}

	public void setScheduleTo(Date scheduleTo) {
		this.scheduleTo = scheduleTo;
	}

	public Set getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(Set timeTables) {
		this.timeTables = timeTables;
	}

}