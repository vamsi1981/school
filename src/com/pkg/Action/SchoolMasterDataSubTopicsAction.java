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

import com.pkg.hibernate.SubTopics;


public class SchoolMasterDataSubTopicsAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("statusType");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<SubTopics> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("SubTopics")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			SubTopics c = new SubTopics();
			c.setFocusArea(addstdnt.getSubTopics().getFocusArea());
			c.setRemarks(addstdnt.getSubTopics().getRemarks());
			
			
			
			request.removeAttribute("SubTopicsList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("SubTopics")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("SubTopicsList");
			lst = getSession("SubTopics");

		} else if (parameterMaster.equalsIgnoreCase("SubTopics")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("SubTopicsList");
			lst = getDeleteSession("SubTopics", "delete", parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("SubTopicsList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(SubTopics c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			if(s.isOpen()){
			s.merge(c);
			tx.commit();
			}
			
			crit = s.createCriteria(SubTopics.class);
		
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

			if (adminType.equalsIgnoreCase("SubTopics")) {
				crit = s.createCriteria(SubTopics.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String PER) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("SubTopics") && operation != null) {
				crit = s.createCriteria(SubTopics.class);
				
				
				
				
				SubTopics cnew = (SubTopics) s.load(SubTopics.class, PER);
				s.flush();
				s.delete(cnew);
				tx.commit();

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	
	
	

}
