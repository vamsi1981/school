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

import com.pkg.hibernate.Grades;



public class SchoolMasterDataGradesInfoAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Grades> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Grades")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Grades c = new Grades();
			c.setGradeType(addstdnt.getGrades().getGradeType());
			c.setDescription(addstdnt.getGrades().getDescription());
			c.setPercentage(new Float(addstdnt.getGrades().getPercentage()));
			c.setLatestUpdateDt(Calendar.getInstance().getTime());
			
			getAddSession(c);
			request.removeAttribute("GradesInfoList");
			lst = getSession("Grades");

		}
		if (parameterMaster.equalsIgnoreCase("Grades")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("GradesInfoList");
			lst = getSession("Grades");

		} else if (parameterMaster.equalsIgnoreCase("Grades")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("GradesInfoList");
			lst = getDeleteSession("Grades", "delete", parameterOperation);

		}

					
		
		request.setAttribute("GradesInfoList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Grades c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Grades.class);
		
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

			if (adminType.equalsIgnoreCase("Grades")) {
				crit = s.createCriteria(Grades.class);

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

			if (adminType.equalsIgnoreCase("Grades") && operation != null) {
				crit = s.createCriteria(Grades.class);
				Grades c = new Grades();
				c.setGradeType(code);
				Grades cnew = (Grades) s.load(Grades.class, code);
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
