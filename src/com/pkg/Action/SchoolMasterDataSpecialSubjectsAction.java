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
import com.pkg.hibernate.SpecialSubject;
import com.pkg.hibernate.SpecialSubjectId;
import com.pkg.hibernate.Subject;

public class SchoolMasterDataSpecialSubjectsAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtsubjid = request.getParameter("gsubjectid");
		String parameterOperationgtperid = request.getParameter("gpersonid");

		String parameterAddOperation = request.getParameter("add");
		ArrayList<SpecialSubject> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("SpecialSubject")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			SpecialSubject c = new SpecialSubject();
			
			
			//c.setPersonId(
					SpecialSubjectId sid= new SpecialSubjectId();
				sid.setPersonId(addstdnt.getSpecialSubject().getId().getPersonId());
				sid.setSubjectId(addstdnt.getSpecialSubject().getId().getSubjectId());
			c.setRemarks(addstdnt.getSpecialSubject().getRemarks());
			c.setId(sid);
			Subject sb= new Subject();
			sb.setSubjectId(addstdnt.getSpecialSubject().getId().getSubjectId());
			c.setSubject(sb);
			
			request.removeAttribute("SpecialSubjectsList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("SpecialSubject")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("SpecialSubjectsList");
			lst = getSession("SpecialSubject");

		} else if (parameterMaster.equalsIgnoreCase("SpecialSubject")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("SpecialSubjectsList");
			lst = getDeleteSession("SpecialSubject", "delete", parameterOperationgtsubjid,parameterOperationgtperid);

		}

					
		
		request.setAttribute("SpecialSubjectsList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(SpecialSubject c) throws Exception {
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
			
			crit = s.createCriteria(SpecialSubject.class);
		
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

			if (adminType.equalsIgnoreCase("SpecialSubject")) {
				crit = s.createCriteria(SpecialSubject.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String SUB,String PER) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("SpecialSubject") && operation != null) {
				crit = s.createCriteria(SpecialSubject.class);
				SpecialSubject c = new SpecialSubject();
				
				SpecialSubjectId sid= new SpecialSubjectId();
				sid.setPersonId(PER);
				sid.setSubjectId(SUB);
				
				SpecialSubject cnew = (SpecialSubject) s.load(SpecialSubject.class, sid);
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
