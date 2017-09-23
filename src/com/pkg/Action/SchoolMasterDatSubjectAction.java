package com.pkg.Action;

import java.util.ArrayList;
import java.util.LinkedList;

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
import com.pkg.hibernate.Subject;







public class SchoolMasterDatSubjectAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("statusType");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<Subject> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Subject")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Subject c = new Subject();
			c.setSubjectName(addstdnt.getSubject().getSubjectName());
			c.setSubjectId(addstdnt.getSubject().getSubjectId());
			c.setSubjectCode(addstdnt.getSubject().getSubjectCode());
			
			
			
			request.removeAttribute("SubjectList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("Subject")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("SubjectList");
			lst = getSession("Subject");

		} else if (parameterMaster.equalsIgnoreCase("Subject")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("SubjectList");
			lst = getDeleteSession("Subject", "delete", parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("SubjectList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Subject c) throws Exception {
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
			
			crit = s.createCriteria(Subject.class);
		
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

			if (adminType.equalsIgnoreCase("Subject")) {
				crit = s.createCriteria(Subject.class);

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

			if (adminType.equalsIgnoreCase("Subject") && operation != null) {
				crit = s.createCriteria(Subject.class);
				
				
				Subject cnew = (Subject) s.load(Subject.class, PER);
				s.flush();
				s.delete(cnew);
				tx.commit();

			}
			
			LinkedList[] ls = new LinkedList[5];
			
			String st[] = new String[5];

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	
	
	

}
