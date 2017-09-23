package com.pkg.bean;

import com.pkg.hibernate.Person;
import com.pkg.hibernate.Subject;

public class LabelValueCombo {
String label;
String value;
Subject subject;
Person person;

public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}

public LabelValueCombo(){
	
	subject= new Subject();
	person= new Person();
}

public Subject getSubject() {
	return subject;
}

public void setSubject(Subject subject) {
	this.subject = subject;
}

public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}

}
