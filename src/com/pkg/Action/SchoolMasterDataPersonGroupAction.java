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
import com.pkg.hibernate.NonNativeStudent;
import com.pkg.hibernate.PersonGroup;
import com.pkg.hibernate.PersonGroupId;
import com.pkg.utilities.UtilityCollection;

public class SchoolMasterDataPersonGroupAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtid = request.getParameter("gpersonid");
		String parameterOperationgtype = request.getParameter("personType");
		String parameterOperationGroup = request.getParameter("personGroupId");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<PersonGroup> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("PersonGroup")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			PersonGroup c = new PersonGroup();
			PersonGroupId pid =new PersonGroupId();
			
			pid.setGroupType(addstdnt.getPersonGroup().getId().getGroupType());
			pid.setPersonId(addstdnt.getPersonGroup().getId().getPersonId());
			pid.setPersonType(addstdnt.getPersonGroup().getId().getPersonType());
			GroupType gtyupe= new GroupType();
			gtyupe.setGroupType(addstdnt.getPersonGroup().getId().getGroupType());
			c.setGroupType(gtyupe);
			c.setId(pid);
			c.setDate(UtilityCollection.getIndianStrng2Date(addstdnt.getPersonGroupDate()));
			
			
			request.removeAttribute("PersonGroupList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("PersonGroup")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("PersonGroupList");
			lst = getSession("PersonGroup");

		} else if (parameterMaster.equalsIgnoreCase("PersonGroup")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("PersonGroupList");
			lst = getDeleteSession("PersonGroup", "delete", parameterOperationgtid,parameterOperationgtype,parameterOperationGroup);

		}

					
		
		request.setAttribute("PersonGroupList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(PersonGroup c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(PersonGroup.class);
		
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

			if (adminType.equalsIgnoreCase("PersonGroup")) {
				crit = s.createCriteria(PersonGroup.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String id,String gtype,String Group) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("PersonGroup") && operation != null) {
				crit = s.createCriteria(PersonGroup.class);
				PersonGroup c = new PersonGroup();
				PersonGroupId pid= new PersonGroupId();
				pid.setGroupType(Group);
				pid.setPersonId(id);
				pid.setPersonType(gtype);
				c.setId(pid);
				
				PersonGroup cnew = (PersonGroup) s.load(PersonGroup.class, pid);
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
