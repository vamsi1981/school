package com.pkg.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Classlevel;

import com.pkg.hibernate.Event;

public class SchoolMasterDataEventAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Event> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Event")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Event c = new Event();
			c.setEventType(addstdnt.getEvent().getEventType());
			c.setEventName(addstdnt.getEvent().getEventName());
			
			getAddSession(c);
			request.removeAttribute("EventTypeList");
			lst = getSession("Event");

		}
		if (parameterMaster.equalsIgnoreCase("Event")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("EventTypeList");
			lst = getSession("Event");

		} else if (parameterMaster.equalsIgnoreCase("Event")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("EventTypeList");
			lst = getDeleteSession("Event", "delete", parameterOperation);

		}

					
		
		request.setAttribute("EventTypeList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Event c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Event.class);
		
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

			if (adminType.equalsIgnoreCase("Event")) {
				crit = s.createCriteria(Event.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String code) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("Event") && operation != null) {
				crit = s.createCriteria(Event.class);
				Event c = new Event();
				c.setEventType(code);
				Event cnew = (Event) s.load(Event.class, code);
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
