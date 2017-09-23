package com.pkg.ActionForm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.pkg.hibernate.Category;
import com.pkg.hibernate.PersonDependentDetail;
import com.pkg.hibernate.PersonId;
import com.pkg.hibernate.PersonTransaction;

public class StudentDetailForm extends ActionForm 
{
	private PersonId id;
	private Category category;
	private String name;
	private String sex;
	private Date dob;
	private Date joinigDate;
	private Date releaseDate;
	private Date creDttm;
	private Set<PersonDependentDetail> personDependentDetails = new HashSet<PersonDependentDetail>(
			0);
	private Set<PersonTransaction> personTransactions = new HashSet<PersonTransaction>(
			0);
	StudentDetailForm()
	{
		
	}
	public PersonId getId() {
		return id;
	}
	public void setId(PersonId id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getJoinigDate() {
		return joinigDate;
	}
	public void setJoinigDate(Date joinigDate) {
		this.joinigDate = joinigDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getCreDttm() {
		return creDttm;
	}
	public void setCreDttm(Date creDttm) {
		this.creDttm = creDttm;
	}
	public Set<PersonDependentDetail> getPersonDependentDetails() {
		return personDependentDetails;
	}
	public void setPersonDependentDetails(
			Set<PersonDependentDetail> personDependentDetails) {
		this.personDependentDetails = personDependentDetails;
	}
	public Set<PersonTransaction> getPersonTransactions() {
		return personTransactions;
	}
	public void setPersonTransactions(Set<PersonTransaction> personTransactions) {
		this.personTransactions = personTransactions;
	}
}
