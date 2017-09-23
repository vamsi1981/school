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
import com.pkg.hibernate.Exam;



public class SchoolMasterDataExamAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Exam> lst = null;
		
		//request.auth
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Exam")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Exam c = new Exam();
			c.setExam(addstdnt.getExam().getExam());
			c.setExamCode(addstdnt.getExam().getExamCode());
			
			getAddSession(c);
			request.removeAttribute("ExamTypeList");
			lst = getSession("Exam");

		}
		if (parameterMaster.equalsIgnoreCase("Exam")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("ExamTypeList");
			lst = getSession("Exam");

		} else if (parameterMaster.equalsIgnoreCase("Exam")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("ExamTypeList");
			lst = getDeleteSession("Exam", "delete", parameterOperation);

		}

					
		
		request.setAttribute("ExamTypeList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Exam c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Exam.class);
		
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

			if (adminType.equalsIgnoreCase("Exam")) {
				crit = s.createCriteria(Exam.class);

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

			if (adminType.equalsIgnoreCase("Exam") && operation != null) {
				crit = s.createCriteria(Exam.class);
				Exam c = new Exam();
				c.setExamCode(code);
				Exam cnew = (Exam) s.load(Exam.class, code);
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
