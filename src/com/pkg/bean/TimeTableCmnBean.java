package com.pkg.bean;

import java.util.ArrayList;
import java.util.List;

public class TimeTableCmnBean {
public String classType;
public List <TimeTableReferBean>  referBean = new ArrayList<TimeTableReferBean>();
public List<TimeTableCmnListBean> listBean = new ArrayList<TimeTableCmnListBean>();

public List<TimeTableCmnListBean> getListBean() {
	return listBean;
}

public void setListBean(List<TimeTableCmnListBean> listBean) {
	this.listBean = listBean;
}

public List<TimeTableReferBean> getReferBean() {
	return referBean;
}

public void setReferBean(List<TimeTableReferBean> referBean) {
	this.referBean = referBean;
}

public String getClassType() {
	return classType;
}

public void setClassType(String classType) {
	this.classType = classType;
}

}
