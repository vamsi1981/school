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
import com.pkg.hibernate.Classlevel;
import com.pkg.hibernate.Exam;
import com.pkg.hibernate.ExamSchedule;
import com.pkg.utilities.UtilityCollection;







public class SchoolMasterDataExamScheduleAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<ExamSchedule> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("ExamSchedule")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			ExamSchedule c = new ExamSchedule();
			
			Exam e= new Exam();
			e.setExamCode(addstdnt.getExamSchedule().getExam().getExamCode());
			c.setExam(e);
			
			c.setScheduleId(addstdnt.getExamSchedule().getScheduleId());
			c.setExamStartDt(UtilityCollection.getIndianStrng2Date(addstdnt.getExamScheduleStartDate()));
			c.setExamEndDt(UtilityCollection.getIndianStrng2Date(addstdnt.getExamScheduleEndDate()));
			Classlevel classlevel= new Classlevel();
			classlevel.setClassId(addstdnt.getExamSchedule().getClasslevel().getClassId());
			c.setClasslevel(classlevel);
			
			request.removeAttribute("ExamScheduleList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("ExamSchedule")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("ExamScheduleList");
			lst = getSession("ExamSchedule");

		} else if (parameterMaster.equalsIgnoreCase("ExamSchedule")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("ExamScheduleList");
			lst = getDeleteSession("ExamSchedule", "delete",parameterOperation);

		}

					
		
		request.setAttribute("ExamScheduleList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(ExamSchedule c) throws Exception {
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
			
			crit = s.createCriteria(ExamSchedule.class);
		
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

			if (adminType.equalsIgnoreCase("ExamSchedule")) {
				crit = s.createCriteria(ExamSchedule.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String Sub) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("ExamSchedule") && operation != null) {
				crit = s.createCriteria(ExamSchedule.class);
							
				ExamSchedule cnew = (ExamSchedule) s.load(ExamSchedule.class, Sub);
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
