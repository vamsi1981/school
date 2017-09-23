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

import com.pkg.hibernate.GroupType;



public class SchoolMasterDataGroupTypesAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<GroupType> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("GroupTypes")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			GroupType c = new GroupType();
			c.setGroupType(addstdnt.getGroupType().getGroupType());
			
			getAddSession(c);
			request.removeAttribute("GroupTypesList");
			lst = getSession("GroupTypes");

		}
		if (parameterMaster.equalsIgnoreCase("GroupTypes")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("GroupTypesList");
			lst = getSession("GroupTypes");

		} else if (parameterMaster.equalsIgnoreCase("GroupTypes")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("GroupTypesList");
			lst = getDeleteSession("GroupTypes", "delete", parameterOperation);

		}

					
		
		request.setAttribute("GroupTypesList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(GroupType c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(GroupType.class);
		
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

			if (adminType.equalsIgnoreCase("GroupTypes")) {
				crit = s.createCriteria(GroupType.class);

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

			if (adminType.equalsIgnoreCase("GroupTypes") && operation != null) {
				crit = s.createCriteria(GroupType.class);
				GroupType c = new GroupType();
				c.setGroupType(code);
				GroupType cnew = (GroupType) s.load(GroupType.class, code);
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
