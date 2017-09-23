package com.pkg.ActionForm;

import org.apache.struts.action.ActionForm;

import com.pkg.hibernate.Address;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;

public class Add_StudentActionForm extends ActionForm
{
	private static final long serialVersionUID = -8897763262299911631L;
	private Person person;
	private PersonDependentDetail pdependentDetail;
	private Address address;
	private String dojS;
	private String rdS;
	public Add_StudentActionForm()
	{
		person=new Person();
		pdependentDetail=new PersonDependentDetail();
		address=new Address();
	
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private String buttonPress;
	public String getButtonPress() {
		return buttonPress;
	}
	public void setButtonPress(String buttonPress) {
		this.buttonPress = buttonPress;
	}
	public PersonDependentDetail getPdependentDetail() {
		return pdependentDetail;
	}
	public void setPdependentDetail(PersonDependentDetail pdependentDetail) {
		this.pdependentDetail = pdependentDetail;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public void dateConversion(String adate)
	{
		
	}
		
}
