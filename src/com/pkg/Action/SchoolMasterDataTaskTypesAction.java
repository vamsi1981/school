package com.pkg.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.Session;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Task;






public class SchoolMasterDataTaskTypesAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("statusType");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<Task> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Task")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Task c = new Task();
			c.setTaskCode(addstdnt.getTask().getTaskCode());
			c.setTaskStatus(addstdnt.getTask().getTaskStatus());
			
			
			
			request.removeAttribute("TaskTopicsList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("Task")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("TaskTopicsList");
			lst = getSession("Task");

		} else if (parameterMaster.equalsIgnoreCase("Task")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("TaskTopicsList");
			lst = getDeleteSession("Task", "delete", parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("TaskTopicsList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList<Task> getAddSession(Task c) throws Exception {
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
			
			crit = s.createCriteria(Task.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<Task>) crit.list();
	}

	private ArrayList<Task> getSession(String adminType) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("Task")) {
				crit = s.createCriteria(Task.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList<Task> getDeleteSession(String adminType, String operation,
			String PER) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("Task") && operation != null) {
				crit = s.createCriteria(Task.class);		
				Task cnew = (Task) s.load(Task.class, PER);
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
