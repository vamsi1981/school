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

import com.pkg.hibernate.Status;


public class SchoolMasterDataStatusTypesAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("statusType");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<Status> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Status")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Status c = new Status();
			c.setStatusCode(addstdnt.getStatus().getStatusCode());
			c.setStatusType(addstdnt.getStatus().getStatusType());
			
			
			
			request.removeAttribute("StatusTypesList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("Status")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("StatusTypesList");
			lst = getSession("Status");

		} else if (parameterMaster.equalsIgnoreCase("Status")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("StatusTypesList");
			lst = getDeleteSession("Status", "delete", parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("StatusTypesList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Status c) throws Exception {
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
			
			crit = s.createCriteria(Status.class);
		
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

			if (adminType.equalsIgnoreCase("Status")) {
				crit = s.createCriteria(Status.class);

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

			if (adminType.equalsIgnoreCase("Status") && operation != null) {
				crit = s.createCriteria(Status.class);
				
				
				
				
				Status cnew = (Status) s.load(Status.class, PER);
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
