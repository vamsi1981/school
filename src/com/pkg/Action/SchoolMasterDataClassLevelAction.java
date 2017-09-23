package com.pkg.Action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Address;
import com.pkg.hibernate.Category;
import com.pkg.hibernate.CategoryHome;
import com.pkg.hibernate.Classlevel;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;
import com.pkg.hibernate.PersonDependentDetailId;
import com.pkg.hibernate.PersonId;

public class SchoolMasterDataClassLevelAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Classlevel> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("ClassSections")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Classlevel c = new Classlevel();
			c.setClassId(addstdnt.getClasslevel().getClassId());
			c.setClassType(addstdnt.getClasslevel().getClassType());
			c.setSection(addstdnt.getClasslevel().getSection());
			getAddSession(c);
			request.removeAttribute("ClassAndSections");
			lst = getSession("ClassSections");

		}
		if (parameterMaster.equalsIgnoreCase("ClassSections")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("ClassAndSections");
			lst = getSession("ClassSections");

		} else if (parameterMaster.equalsIgnoreCase("ClassSections")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("ClassAndSections");
			lst = getDeleteSession("ClassSections", "delete", parameterOperation);

		}

					
		
		request.setAttribute("ClassAndSections", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Classlevel c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Classlevel.class);
		
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

			if (adminType.equalsIgnoreCase("ClassSections")) {
				crit = s.createCriteria(Classlevel.class);

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

			if (adminType.equalsIgnoreCase("ClassSections") && operation != null) {
				crit = s.createCriteria(Classlevel.class);
				Classlevel c = new Classlevel();
				c.setClassId(code);
				Classlevel cnew = (Classlevel) s.load(Classlevel.class, code);
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
