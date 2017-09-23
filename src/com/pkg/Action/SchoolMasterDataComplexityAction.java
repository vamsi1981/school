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
import com.pkg.hibernate.Complexity;

public class SchoolMasterDataComplexityAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Complexity> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Complexity")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Complexity c = new Complexity();
			c.setComplexityType(addstdnt.getComplexity().getComplexityType());
			
			getAddSession(c);
			request.removeAttribute("ComplexityList");
			lst = getSession("Complexity");

		}
		if (parameterMaster.equalsIgnoreCase("Complexity")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("ComplexityList");
			lst = getSession("Complexity");

		} else if (parameterMaster.equalsIgnoreCase("Complexity")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("ComplexityList");
			lst = getDeleteSession("Complexity", "delete", parameterOperation);

		}

					
		
		request.setAttribute("ComplexityList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Complexity c) throws Exception {
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

			if (adminType.equalsIgnoreCase("Complexity")) {
				crit = s.createCriteria(Complexity.class);

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

			if (adminType.equalsIgnoreCase("Complexity") && operation != null) {
				crit = s.createCriteria(Complexity.class);
				Complexity c = new Complexity();
				c.setComplexityType(code);
				Complexity cnew = (Complexity) s.load(Complexity.class, code);
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
