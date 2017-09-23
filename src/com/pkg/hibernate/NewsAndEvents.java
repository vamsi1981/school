package com.pkg.hibernate;

/**
 * NewsAndEvents entity. @author MyEclipse Persistence Tools
 */

public class NewsAndEvents implements java.io.Serializable {

	// Fields

	private NewsAndEventsId id;
	private Integer version;
	private Event event;
	private GeneralInfo generalInfo;

	// Constructors

	/** default constructor */
	public NewsAndEvents() {
		event =new Event();
		id= new NewsAndEventsId();
	}

	/** full constructor */
	public NewsAndEvents(NewsAndEventsId id, Event event,
			GeneralInfo generalInfo) {
		this.id = id;
		this.event = event;
		this.generalInfo = generalInfo;
	}

	// Property accessors

	public NewsAndEventsId getId() {
		return this.id;
	}

	public void setId(NewsAndEventsId id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public GeneralInfo getGeneralInfo() {
		return this.generalInfo;
	}

	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}

}