package com.pkg.Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Subject;
import com.pkg.hibernate.TeacherToSubject;
import com.pkg.hibernate.TeacherToSubjectId;
import com.pkg.utilities.UtilityCollection;







public class SchoolMasterDatTeacherToSubjectAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtPerson = request.getParameter("gpid");
		String parameterOperationgtsubjid = request.getParameter("gtype");
		

		String parameterAddOperation = request.getParameter("add");
		ArrayList<TeacherToSubject> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("TeacherToSubject")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			TeacherToSubject c = new TeacherToSubject();
			
			Date d =UtilityCollection.getIndianStrng2Date(addstdnt.getTeachertoSubjectStartDate());
			long time = Calendar.getInstance().getTimeInMillis();
			 Timestamp ts =new Timestamp(d.getYear(),d.getMonth()-1,d.getDate(),0,0,0,0);
			c.setStartDate(ts);
			
			d =UtilityCollection.getIndianStrng2Date(addstdnt.getTeachertoSubjectendDate());
			time = Calendar.getInstance().getTimeInMillis();
			ts =new Timestamp(d.getYear(),d.getMonth()-1,d.getDate(),0,0,0,0);
			
			c.setEndDate(ts);
			c.setVersion(1);
			TeacherToSubjectId tid= new TeacherToSubjectId();
			tid.setPersonId(addstdnt.getTeacherToSubject().getId().getPersonId());
			tid.setSubjectId(addstdnt.getTeacherToSubject().getId().getSubjectId());
			c.setId(tid);
			
			request.removeAttribute("TeacherTosubjectList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("TeacherToSubject")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("TeacherTosubjectList");
			lst = getSession("TeacherToSubject");

		} else if (parameterMaster.equalsIgnoreCase("TeacherToSubject")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("TeacherTosubjectList");
			lst = getDeleteSession("TeacherToSubject", "delete",parameterOperationgtPerson, parameterOperationgtsubjid);

		}

					
		
		request.setAttribute("TeacherTosubjectList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(TeacherToSubject c) throws Exception {
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
			
			crit = s.createCriteria(TeacherToSubject.class);
		
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

			if (adminType.equalsIgnoreCase("TeacherToSubject")) {
				crit = s.createCriteria(TeacherToSubject.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String PER,String Sub) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("TeacherToSubject") && operation != null) {
				crit = s.createCriteria(TeacherToSubject.class);
				TeacherToSubjectId tid =new TeacherToSubjectId();
				tid.setPersonId(PER);
				Subject subj = new Subject();
				subj.setSubjectId(Sub);
				tid.setSubjectId(subj.getSubjectId());
				
				TeacherToSubject cnew = (TeacherToSubject) s.load(TeacherToSubject.class, tid);
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
