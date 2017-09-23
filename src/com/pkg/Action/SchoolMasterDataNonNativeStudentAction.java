package com.pkg.Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

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

import com.pkg.hibernate.NonNativeStudent;
import com.pkg.utilities.UtilityCollection;

public class SchoolMasterDataNonNativeStudentAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtime = request.getParameter("gtype");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<NonNativeStudent> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("NonNativeStudent")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			NonNativeStudent c = new NonNativeStudent();
			c.setCountry(addstdnt.getNonNativeStudent().getCountry());
			c.setLanguage(addstdnt.getNonNativeStudent().getLanguage());
			c.setState(addstdnt.getNonNativeStudent().getState());
			c.setId(addstdnt.getNonNativeStudent().getId());
			
			request.removeAttribute("NonNativeStudentList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("NonNativeStudent")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("NonNativeStudentList");
			lst = getSession("NonNativeStudent");

		} else if (parameterMaster.equalsIgnoreCase("NonNativeStudent")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("NonNativeStudentList");
			lst = getDeleteSession("NonNativeStudent", "delete", parameterOperation,parameterOperationgtime);

		}

					
		
		request.setAttribute("NonNativeStudentList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(NonNativeStudent c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(NonNativeStudent.class);
		
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

			if (adminType.equalsIgnoreCase("NonNativeStudent")) {
				crit = s.createCriteria(NonNativeStudent.class);

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

			if (adminType.equalsIgnoreCase("NonNativeStudent") && operation != null) {
				crit = s.createCriteria(NonNativeStudent.class);
				NonNativeStudent c = new NonNativeStudent();
				c.setId(gtime);
				
				NonNativeStudent cnew = (NonNativeStudent) s.load(NonNativeStudent.class, gtime);
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
