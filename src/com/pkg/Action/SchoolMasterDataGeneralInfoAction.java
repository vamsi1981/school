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

import com.pkg.hibernate.GeneralInfo;



public class SchoolMasterDataGeneralInfoAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<GeneralInfo> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("GeneralInfo")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			GeneralInfo c = new GeneralInfo();
			c.setInfo(addstdnt.getGeneralInfo().getInfo());
			c.setSchoolId(addstdnt.getGeneralInfo().getSchoolId());
			
			getAddSession(c);
			request.removeAttribute("GeneralInfoList");
			lst = getSession("GeneralInfo");

		}
		if (parameterMaster.equalsIgnoreCase("GeneralInfo")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("GeneralInfoList");
			lst = getSession("GeneralInfo");

		} else if (parameterMaster.equalsIgnoreCase("GeneralInfo")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("GeneralInfoList");
			lst = getDeleteSession("GeneralInfo", "delete", parameterOperation);

		}

					
		
		request.setAttribute("GeneralInfoList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(GeneralInfo c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(GeneralInfo.class);
		
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

			if (adminType.equalsIgnoreCase("GeneralInfo")) {
				crit = s.createCriteria(GeneralInfo.class);

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

			if (adminType.equalsIgnoreCase("GeneralInfo") && operation != null) {
				crit = s.createCriteria(GeneralInfo.class);
				GeneralInfo c = new GeneralInfo();
				c.setSchoolId(code);
				GeneralInfo cnew = (GeneralInfo) s.load(GeneralInfo.class, code);
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
