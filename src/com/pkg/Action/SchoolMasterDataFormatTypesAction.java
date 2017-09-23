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

import com.pkg.hibernate.Format;

public class SchoolMasterDataFormatTypesAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Format> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Format")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Format c = new Format();
			c.setFormatType(addstdnt.getFormat().getFormatType());
			
			
			getAddSession(c);
			request.removeAttribute("FormatTypeList");
			lst = getSession("Format");

		}
		if (parameterMaster.equalsIgnoreCase("Format")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("FormatTypeList");
			lst = getSession("Format");

		} else if (parameterMaster.equalsIgnoreCase("Format")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("FormatTypeList");
			lst = getDeleteSession("Format", "delete", parameterOperation);

		}

					
		
		request.setAttribute("FormatTypeList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Format c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Format.class);
		
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

			if (adminType.equalsIgnoreCase("Format")) {
				crit = s.createCriteria(Format.class);

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

			if (adminType.equalsIgnoreCase("Format") && operation != null) {
				crit = s.createCriteria(Format.class);
				Format c = new Format();
				c.setFormatType(code);
				Format cnew = (Format) s.load(Format.class, code);
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
