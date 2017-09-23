package com.pkg.Action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Period;
import com.pkg.hibernate.Subject;

public class SchoolMasterDataPeriodTypesAction extends Action {
	private SessionFactory sessionFactory;

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtime = request.getParameter("gtype");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Period> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("PeriodTypes")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Period c = new Period();
			c.setPeriodCode(addstdnt.getPeriod().getPeriodCode());

			c.setStartTime(new Date(0,0,0,Integer.parseInt(addstdnt.getPeriodStartTimeHours()),Integer.parseInt(addstdnt.getPeriodStartTimeMinutes()),0));
			c.setEndTime(new Date(0,0,0,Integer.parseInt(addstdnt.getPeriodEndTimeHours()),Integer.parseInt(addstdnt.getPeriodEndTimeMinutes()),0));
			request.removeAttribute("PeriodTypesList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("PeriodTypes")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("PeriodTypesList");
			lst = getSession("PeriodTypes");

		} else if (parameterMaster.equalsIgnoreCase("PeriodTypes")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("PeriodTypesList");
			lst = getDeleteSession("PeriodTypes", "delete", parameterOperation,parameterOperationgtime);

		}

					
		
		request.setAttribute("PeriodTypesList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Period c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Period.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getSession(String adminType) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("PeriodTypes")) {
				crit = s.createCriteria(Period.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String code,String gtime) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("PeriodTypes") && operation != null) {
				crit = s.createCriteria(Period.class);
				Period c = new Period();
				c.setPeriodCode(gtime);
				
				Period cnew = (Period) s.load(Period.class, gtime);
				s.flush();
				s.delete(cnew);

			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	
	
	

}
