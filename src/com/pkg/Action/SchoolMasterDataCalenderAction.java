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

import com.pkg.hibernate.Calender;

import com.pkg.utilities.UtilityCollection;



public class SchoolMasterDataCalenderAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Calender> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Calendar")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Calender c = new Calender();
			
			c.setCode(addstdnt.getCalender().getCode());
			c.setDate(UtilityCollection.getStrng2Date(addstdnt.getCalenderdate()));
			c.setDescription(addstdnt.getCalender().getDescription());
			c.setIsNationalHoliday(addstdnt.getCalender().getIsNationalHoliday());
			getAddSession(c);
			request.removeAttribute("CalendarList");
			lst = getSession("Calendar");

		}
		if (parameterMaster.equalsIgnoreCase("Calendar")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("CalendarList");
			lst = getSession("Calendar");

		} else if (parameterMaster.equalsIgnoreCase("Calendar")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("CalendarList");
			lst = getDeleteSession("Calendar", "delete", parameterOperation);

		}

					
		
		request.setAttribute("CalendarList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Calender c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Calender.class);
		
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

			if (adminType.equalsIgnoreCase("Calendar")) {
				crit = s.createCriteria(Calender.class);

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

			if (adminType.equalsIgnoreCase("Calendar") && operation != null) {
				crit = s.createCriteria(Calender.class);
				Calender c = new Calender();
				c.setCode(code);
				Calender cnew = (Calender) s.load(Calender.class, code);
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
