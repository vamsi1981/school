package com.pkg.Action;

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

import com.pkg.hibernate.Graphs;



public class SchoolMasterDataGraphsAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Graphs> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Graphs")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Graphs c = new Graphs();
			c.setGraphTypes(addstdnt.getGraphs().getGraphTypes());
			
			getAddSession(c);
			request.removeAttribute("GraphList");
			lst = getSession("Graphs");

		}
		if (parameterMaster.equalsIgnoreCase("Graphs")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("GraphList");
			lst = getSession("Graphs");

		} else if (parameterMaster.equalsIgnoreCase("Graphs")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("GraphList");
			lst = getDeleteSession("Graphs", "delete", parameterOperation);

		}

					
		
		request.setAttribute("GraphList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Graphs c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Graphs.class);
		
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

			if (adminType.equalsIgnoreCase("Graphs")) {
				crit = s.createCriteria(Graphs.class);

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

			if (adminType.equalsIgnoreCase("Graphs") && operation != null) {
				crit = s.createCriteria(Graphs.class);
				Graphs c = new Graphs();
				c.setGraphTypes(code);
				Graphs cnew = (Graphs) s.load(Graphs.class, code);
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
