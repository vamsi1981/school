package com.pkg.hibernate;

/**
 * HelpSc entity.
 */

public class HelpSc implements java.io.Serializable {

	// Fields

	private HelpScId id;
	private GeneralInfo generalInfo;
	private String schoolName;
	private String about;
	private String remarks;

	// Constructors

	/** default constructor */
	public HelpSc() {
		id =new HelpScId();
	}

	/** minimal constructor */
	public HelpSc(HelpScId id, GeneralInfo generalInfo) {
		this.id = id;
		this.generalInfo = generalInfo;
	}

	/** full constructor */
	public HelpSc(HelpScId id, GeneralInfo generalInfo, String schoolName,
			String about, String remarks) {
		this.id = id;
		this.generalInfo = generalInfo;
		this.schoolName = schoolName;
		this.about = about;
		this.remarks = remarks;
	}

	// Property accessors

	public HelpScId getId() {
		return this.id;
	}

	public void setId(HelpScId id) {
		this.id = id;
	}

	public GeneralInfo getGeneralInfo() {
		return this.generalInfo;
	}

	public void setGeneralInfo(GeneralInfo generalInfo) {
		this.generalInfo = generalInfo;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}