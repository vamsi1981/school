package com.pkg.ActionForm;

import java.util.ArrayList;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.pkg.hibernate.Address;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;

public class List_StudentForm extends ActionForm 
{
	private String id;
	private String type;
	private String name;
	private String classCode;
	private ArrayList<Person> plist;
	private Person person;
	private String cre_dttm;
	private String dob;
	private String release_date;
	private String joining_date;
	private Person oldPerson;
	private String oldPersonName;
	private String oldCre_dttm;
	private String oldDob;
	private Address address;
	private String dojS;
	private String rdS;
	private String oldRelease_date;
	private String oldJoining_date;
	private PersonDependentDetail personDependentDetail;
	private Set<PersonDependentDetail> listPersonDependentDetail;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDojS() {
		return dojS;
	}
	public void setDojS(String dojS) {
		this.dojS = dojS;
	}
	public String getRdS() {
		return rdS;
	}
	public void setRdS(String rdS) {
		this.rdS = rdS;
	}
	
	public Set<PersonDependentDetail> getListPersonDependentDetail() {
		return listPersonDependentDetail;
	}
	public void setListPersonDependentDetail(
			Set<PersonDependentDetail> listPersonDependentDetail) {
		this.listPersonDependentDetail = listPersonDependentDetail;
	}
	
	
	
	
	public PersonDependentDetail getPersonDependentDetail() {
		return personDependentDetail;
	}
	public void setPersonDependentDetail(PersonDependentDetail personDependentDetail) {
		this.personDependentDetail = personDependentDetail;
	}
	public String getOldPersonName() {
		return oldPersonName;
	}
	public void setOldPersonName(String oldPersonName) {
		this.oldPersonName = oldPersonName;
	}
	private Person updatedPerson;
	public Person getOldPerson() {
		return oldPerson;
	}
	public void setOldPerson(Person oldPerson) {
		this.oldPerson = oldPerson;
	}
	
	public Person getUpdatedPerson() {
		return updatedPerson;
	}
	public void setUpdatedPerson(Person updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	
	public String getOldCre_dttm() {
		return oldCre_dttm;
	}
	public void setOldCre_dttm(String oldCre_dttm) {
		this.oldCre_dttm = oldCre_dttm;
	}
	public String getOldDob() {
		return oldDob;
	}
	public void setOldDob(String oldDob) {
		this.oldDob = oldDob;
	}
	public String getOldRelease_date() {
		return oldRelease_date;
	}
	public void setOldRelease_date(String oldRelease_date) {
		this.oldRelease_date = oldRelease_date;
	}
	public String getOldJoining_date() {
		return oldJoining_date;
	}
	public void setOldJoining_date(String oldJoining_date) {
		this.oldJoining_date = oldJoining_date;
	}
	public String getCre_dttm() {
		return cre_dttm;
	}
	public void setCre_dttm(String cre_dttm) {
		this.cre_dttm = cre_dttm;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public ArrayList<Person> getPlist() {
		return plist;
	}
	public void setPlist(ArrayList<Person> plist) {
		this.plist = plist;
	}
	public List_StudentForm()
	
	{
		person =new Person();
		plist=new ArrayList<Person>();
		address = new Address();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	
}
