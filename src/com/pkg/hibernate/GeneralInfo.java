package com.pkg.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * GeneralInfo entity.
 */

public class GeneralInfo implements java.io.Serializable {

	// Fields

	private String schoolId;
	private String info;
	private Set helpScs = new HashSet(0);
	private Set newsAndEventses = new HashSet(0);

	// Constructors

	/** default constructor */
	public GeneralInfo() {
	}

	/** full constructor */
	public GeneralInfo(String info, Set helpScs, Set newsAndEventses) {
		this.info = info;
		this.helpScs = helpScs;
		this.newsAndEventses = newsAndEventses;
	}

	// Property accessors

	public String getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set getHelpScs() {
		return this.helpScs;
	}

	public void setHelpScs(Set helpScs) {
		this.helpScs = helpScs;
	}

	public Set getNewsAndEventses() {
		return this.newsAndEventses;
	}

	public void setNewsAndEventses(Set newsAndEventses) {
		this.newsAndEventses = newsAndEventses;
	}

}