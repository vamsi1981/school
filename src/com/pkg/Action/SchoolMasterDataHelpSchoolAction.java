package com.pkg.Action;

import java.sql.Timestamp;
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

import com.pkg.hibernate.HelpSc;
import com.pkg.hibernate.HelpScId;
import com.pkg.utilities.UtilityCollection;

public class SchoolMasterDataHelpSchoolAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtime = request.getParameter("gtime");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<HelpSc> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("HelpSchoolInfo")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			HelpSc c = new HelpSc();
			c.setGeneralInfo(addstdnt.getHelpSc().getGeneralInfo());
			c.setRemarks(addstdnt.getHelpSc().getRemarks());
			c.setAbout(addstdnt.getHelpSc().getAbout());
			c.setSchoolName(addstdnt.getHelpSc().getSchoolName());
			HelpScId hid = new HelpScId();
			hid.setSchoolId(addstdnt.getHelpSc().getId().getSchoolId());
			
			long time = Calendar.getInstance().getTimeInMillis();
			 Timestamp ts =new Timestamp(time);
			 hid.setStartDttm(ts);
			 c.setId(hid);
			 
			getAddSession(c);
			request.removeAttribute("HelpSchoolInfoList");
			lst = getSession("HelpSchoolInfo");

		}
		if (parameterMaster.equalsIgnoreCase("HelpSchoolInfo")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("HelpSchoolInfoList");
			lst = getSession("HelpSchoolInfo");

		} else if (parameterMaster.equalsIgnoreCase("HelpSchoolInfo")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("HelpSchoolInfoList");
			lst = getDeleteSession("HelpSchoolInfo", "delete", parameterOperation,parameterOperationgtime);

		}

					
		
		request.setAttribute("HelpSchoolInfoList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(HelpSc c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(HelpSc.class);
		
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

			if (adminType.equalsIgnoreCase("HelpSchoolInfo")) {
				crit = s.createCriteria(HelpSc.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String code,String gtime) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("HelpSchoolInfo") && operation != null) {
				crit = s.createCriteria(HelpSc.class);
				HelpSc c = new HelpSc();
				HelpScId hid= new HelpScId();
				hid.setSchoolId(code);
				int []timedate =UtilityCollection.dateConv(gtime);
				Timestamp ts= new Timestamp(timedate[0],timedate[1],timedate[2],timedate[3],timedate[4],timedate[5],timedate[6]);
				hid.setStartDttm(ts);
				c.setId(hid);
				
				HelpSc cnew = (HelpSc) s.load(HelpSc.class, hid);
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
