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

import com.pkg.hibernate.Guardian;



public class SchoolMasterDataGuardianTypesAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Guardian> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Guardian")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Guardian c = new Guardian();
			c.setGuardianType(addstdnt.getGuardian().getGuardianType());
			c.setRelation(addstdnt.getGuardian().getRelation());
			c.setRemarks(addstdnt.getGuardian().getRemarks());
			
			getAddSession(c);
			request.removeAttribute("GuardianTypeList");
			lst = getSession("Guardian");

		}
		if (parameterMaster.equalsIgnoreCase("Guardian")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("GuardianTypeList");
			lst = getSession("Guardian");

		} else if (parameterMaster.equalsIgnoreCase("Guardian")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("GuardianTypeList");
			lst = getDeleteSession("Guardian", "delete", parameterOperation);

		}

					
		
		request.setAttribute("GuardianTypeList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Guardian c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Guardian.class);
		
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

			if (adminType.equalsIgnoreCase("Guardian")) {
				crit = s.createCriteria(Guardian.class);

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

			if (adminType.equalsIgnoreCase("Guardian") && operation != null) {
				crit = s.createCriteria(Guardian.class);
				Guardian c = new Guardian();
				c.setGuardianType(code);
				Guardian cnew = (Guardian) s.load(Guardian.class, code);
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
