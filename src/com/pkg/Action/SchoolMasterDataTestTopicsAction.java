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
import com.pkg.hibernate.Test;




public class SchoolMasterDataTestTopicsAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("statusType");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<Test> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("TestTopics")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Test c = new Test();
			c.setTestCode(addstdnt.getTest().getTestCode());
			c.setTestType(addstdnt.getTest().getTestType());
			
			
			
			request.removeAttribute("TestTopicsList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("TestTopics")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("TestTopicsList");
			lst = getSession("TestTopics");

		} else if (parameterMaster.equalsIgnoreCase("TestTopics")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("TestTopicsList");
			lst = getDeleteSession("TestTopics", "delete", parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("TestTopicsList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Test c) throws Exception {
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
			
			crit = s.createCriteria(Test.class);
		
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

			if (adminType.equalsIgnoreCase("TestTopics")) {
				crit = s.createCriteria(Test.class);

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

			if (adminType.equalsIgnoreCase("TestTopics") && operation != null) {
				crit = s.createCriteria(Test.class);
				
				
				
				
				Test cnew = (Test) s.load(Test.class, PER);
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
