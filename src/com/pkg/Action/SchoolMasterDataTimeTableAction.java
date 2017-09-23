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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Classlevel;
import com.pkg.hibernate.Period;
import com.pkg.hibernate.Subject;
import com.pkg.hibernate.TeacherToSubject;
import com.pkg.hibernate.TeacherToSubjectId;
import com.pkg.hibernate.TimeTable;
import com.pkg.hibernate.Timetableschedule;

public class SchoolMasterDataTimeTableAction extends Action {
	private SessionFactory sessionFactory;
	static int i=1;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterOperationgtime = request.getParameter("gtype");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<TimeTable> lst = null;
		
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("TimeTable")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			TimeTable c = new TimeTable();
			c.setRemarks("Good");
			c.setDate(Calendar.getInstance().getTime());
			
			Classlevel classlevel = new Classlevel();
			classlevel.setClassId(addstdnt.getTimeTable().getClasslevel().getClassId());
			c.setClasslevel(classlevel);
			
			Subject subject = new Subject();
			subject.setSubjectId(addstdnt.getTimeTable().getTeacherToSubject().getId().getSubjectId());
			c.setSubject(subject);
			
			TeacherToSubject teacherToSubject = new TeacherToSubject();
			TeacherToSubjectId teacherToSubjectId = new TeacherToSubjectId();
			teacherToSubjectId.setSubjectId(subject.getSubjectId());
			teacherToSubjectId.setPersonId(addstdnt.getTimeTable().getTeacherToSubject().getId().getPersonId());
			teacherToSubject.setId(teacherToSubjectId);
			c.setTeacherToSubject(teacherToSubject);
			
			c.setTimeTableId(addstdnt.getTimeTable().getTimeTableId());
			Timetableschedule timetableschedule = addstdnt.getTimeTable().getTimetableschedule();

			timetableschedule.setTimetableType(addstdnt.getTimeTable().getTimetableschedule().getTimetableType());
			c.setTimetableschedule(timetableschedule);
			
			Period period = new Period();
			period.setPeriodCode(addstdnt.getTimeTable().getPeriod().getPeriodCode());
			c.setPeriod(period);
			
			
			request.removeAttribute("TimeTableList");
			lst = getAddSession(c);

		}
		if (parameterMaster.equalsIgnoreCase("TimeTable")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("TimeTableList");
			lst = getSession("TimeTable",null);

		} else if (parameterMaster.equalsIgnoreCase("TimeTable")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("TimeTableList");
			lst = getDeleteSession("TimeTable", "delete", parameterOperationgtime);

		}

					
		
		request.getSession().setAttribute("TimeTableList", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(TimeTable c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			//s.update(c.getTimetableschedule());
			Timetableschedule tscheule= c.getTimetableschedule();
			tscheule.setVersion(++i);
			//s.update(tscheule);
			//tx.commit();
			c.setTimetableschedule(tscheule);
			s.merge(c);
			tx.commit();
			
			
			crit = s.createCriteria(TimeTable.class);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	public ArrayList getSession(String adminType,String classId) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			//tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("TimeTable")) {
				crit = s.createCriteria(TimeTable.class);
				/*if(null!=classId)
				{
		        crit.add(Restrictions.eq("classlevel.classId",classId));
		        crit.addOrder(Order.asc("period.periodCode"));
				}*/

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	private ArrayList getDeleteSession(String adminType, String operation,
			String gtime) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("TimeTable") && operation != null) {
				crit = s.createCriteria(TimeTable.class);
							
				TimeTable cnew = (TimeTable) s.load(TimeTable.class, gtime);
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
