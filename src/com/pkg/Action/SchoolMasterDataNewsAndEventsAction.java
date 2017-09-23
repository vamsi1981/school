package com.pkg.Action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import com.pkg.hibernate.Event;
import com.pkg.hibernate.NewsAndEvents;
import com.pkg.hibernate.NewsAndEventsId;
import com.pkg.utilities.UtilityCollection;



public class SchoolMasterDataNewsAndEventsAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		String schoolid = request.getParameter("gschoolid");
		String gtype = request.getParameter("gtype");
		String gtime = request.getParameter("gtime");
		
		ArrayList<NewsAndEvents> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("NewsAndEvents")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			NewsAndEvents c = new NewsAndEvents();
			c.setVersion(1);
			NewsAndEventsId nid = new NewsAndEventsId();
			nid.setEventType(addstdnt.getNewsAndEvents().getId().getEventType());
			nid.setSchoolId(addstdnt.getNewsAndEvents().getId().getSchoolId());
			Date d =UtilityCollection.getIndianStrng2Date(addstdnt.getNewsAndEventsStartDate());
			long time = Calendar.getInstance().getTimeInMillis();
			 Timestamp ts =new Timestamp(d.getYear(),d.getMonth()-1,d.getDate(),0,0,0,0);
			nid.setStartDttm(ts);
			c.setId(nid);
					
			getAddSession(c);
			request.removeAttribute("NewsAndEventsList");
			lst = getSession("NewsAndEvents");

		}
		if (parameterMaster.equalsIgnoreCase("NewsAndEvents")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("NewsAndEventsList");
			lst = getSession("NewsAndEvents");

		} else if (parameterMaster.equalsIgnoreCase("NewsAndEvents")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("NewsAndEventsList");
			lst = getDeleteSession("NewsAndEvents", "delete",schoolid,gtype,gtime);

		}

					
		
		request.setAttribute("NewsAndEventsList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(NewsAndEvents c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			Event e =new Event();
			e.setEventType(c.getId().getEventType());
			c.setEvent(e);
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(NewsAndEvents.class);
		
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

			if (adminType.equalsIgnoreCase("NewsAndEvents")) {
				crit = s.createCriteria(NewsAndEvents.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String gschoolid,String gtype,String gtime) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("NewsAndEvents") && operation != null) {
				crit = s.createCriteria(NewsAndEvents.class);
				NewsAndEvents c = new NewsAndEvents();
				NewsAndEventsId hid = new NewsAndEventsId();
				hid.setSchoolId(gschoolid);
				hid.setEventType(gtype);
				
				
				int []timedate =UtilityCollection.dateConv(gtime);
				Timestamp ts= new Timestamp(timedate[0],timedate[1],timedate[2],timedate[3],timedate[4],timedate[5],timedate[6]);
				hid.setStartDttm(ts);
				c.setId(hid);
				NewsAndEvents cnew = (NewsAndEvents) s.load(NewsAndEvents.class, hid);
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
