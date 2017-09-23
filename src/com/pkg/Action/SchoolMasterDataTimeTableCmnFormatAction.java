package com.pkg.Action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.bean.LabelValueCombo;
import com.pkg.bean.TimeTableCmnBean;
import com.pkg.bean.TimeTableCmnListBean;
import com.pkg.bean.TimeTableReferBean;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Classlevel;
import com.pkg.hibernate.Period;
import com.pkg.hibernate.Subject;
import com.pkg.hibernate.TeacherToSubject;
import com.pkg.hibernate.TeacherToSubjectId;
import com.pkg.hibernate.TimeTable;
import com.pkg.hibernate.Timetableschedule;

public class SchoolMasterDataTimeTableCmnFormatAction extends Action {
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
		String parameterAddEditViewOperation = request.getParameter("myclassId");
		String paramAddModifyClassTimeTable = request.getParameter("addModifyClassTimeTable");
		ArrayList<TimeTable> lst = null;
		ArrayList<TimeTableCmnBean> arrcmnBean  = null;
		ArrayList<TimeTableCmnBean> xlb =null;
		String messages ="loadModification";
		
		if(null!=parameterAddEditViewOperation && null!=paramAddModifyClassTimeTable)
		{
			//SchoolMasterDataTimeTableAction timetableAction = new SchoolMasterDataTimeTableAction();
			if(parameterOperation.equals("true"))
			 {
			arrcmnBean = getSession("TimeTable",parameterAddEditViewOperation);
			 xlb =getConvertBean(arrcmnBean);
			 
			 request.getSession().setAttribute("TimeTableList", xlb);
			 }
			 if(parameterOperation.equals("false"))
			 {
				 List<LabelValueCombo> subjectList=  getSubjectSession();
				 request.setAttribute("SubjectList", subjectList);
				 
				 List<LabelValueCombo> personList=  getPersonSession();
				 request.setAttribute("PersonList", personList);
				 
				 
			 lst =getCriteriaSession("TimeTable",parameterAddEditViewOperation);
			 }
			 if(null!=paramAddModifyClassTimeTable)
			 	{
			request.getSession().setAttribute("messages", messages);
			 		}
		request.setAttribute("BareTimeTableList", lst);
		//list here
		return mapping.findForward("newtimetablewithlist");
			
		}
		
		
		if(parameterAddEditViewOperation!=null)
		{
			arrcmnBean = getSession("TimeTable",parameterAddEditViewOperation);
			 xlb =getConvertBean(arrcmnBean);
			 request.getSession().setAttribute("TimeTableList", xlb);
			 //here before display.
			 return mapping.findForward("newtimetable");
			
		}
		
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
				&& null == parameterOperation && null== parameterAddEditViewOperation) {
			lst = null;
			request.removeAttribute("TimeTableList");
			arrcmnBean = getSession("TimeTable",null);
			 xlb =getConvertBean(arrcmnBean);
			
			

		} else if (parameterMaster.equalsIgnoreCase("TimeTable")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("TimeTableList");
			lst = getDeleteSession("TimeTable", "delete", parameterOperationgtime);

		}

		
		
		request.getSession().setAttribute("TimeTableList", xlb);
		return mapping.findForward("success");
	}
	
	
	private ArrayList<TimeTableCmnBean> getConvertBean(ArrayList<TimeTableCmnBean> arrcmnBean) throws Exception {
		TimeTableCmnBean timeTableCmnBean = null;
		
		for(Iterator<TimeTableCmnBean> it=arrcmnBean.iterator();it.hasNext();)
		{
			timeTableCmnBean =it.next();
			String tempClassSection = null;
			TimeTableReferBean timeTableReferBean = null;
			TimeTableCmnListBean timeTableCmnListBean = null;
			if(timeTableCmnBean.getListBean()!=null && timeTableCmnBean.getListBean().size()>0){
				int i=0;
			for(Iterator<TimeTableCmnListBean> ittable=timeTableCmnBean.getListBean().iterator();ittable.hasNext();)
				{
				++i;
				timeTableCmnListBean=ittable.next();
				if(null!=tempClassSection && tempClassSection.equals(timeTableCmnListBean.getSection()))
				{
					//timeTableReferBean  = new TimeTableReferBean();
					timeTableReferBean = setSubjectBean(timeTableCmnListBean,timeTableReferBean);
					tempClassSection = timeTableCmnListBean.getSection();
					
				}
				else if(null!=tempClassSection && !tempClassSection.equals(timeTableCmnListBean.getSection()))
				{
					timeTableCmnBean.getReferBean().add(timeTableReferBean);
					timeTableReferBean  = new TimeTableReferBean();
					timeTableReferBean = setSubjectBean(timeTableCmnListBean,timeTableReferBean);
					tempClassSection = timeTableCmnListBean.getSection();
				}
				else
				{
					timeTableReferBean  = new TimeTableReferBean();
					timeTableReferBean = setSubjectBean(timeTableCmnListBean,timeTableReferBean);
					tempClassSection = timeTableCmnListBean.getSection();
				
				}
				
				if(i==timeTableCmnBean.getListBean().size())
				{
					timeTableCmnBean.getReferBean().add(timeTableReferBean);
				}
				
				}
		
			}
		}
		
	return arrcmnBean;
	}
	public TimeTableReferBean setSubjectBean(TimeTableCmnListBean timetableListBean,TimeTableReferBean timeTableReferBean)
	{
		if(timetableListBean.getPeriodCode().equals("PERIOD-1"))
		{
			timeTableReferBean.setPeriod1(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod1(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod1(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod1TTId(timetableListBean.getTimeTableId());
		}
		if(timetableListBean.getPeriodCode().equals("PERIOD-2"))
		{
			timeTableReferBean.setPeriod2(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod2(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod2(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod2TTId(timetableListBean.getTimeTableId());
			
		}
		if(timetableListBean.getPeriodCode().equals("PERIOD-3"))
		{
			timeTableReferBean.setPeriod3(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod3(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod3(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod3TTId(timetableListBean.getTimeTableId());
		}
		if(timetableListBean.getPeriodCode().equals("PERIOD-4"))
		{
			timeTableReferBean.setPeriod4(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod4(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod4(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod4TTId(timetableListBean.getTimeTableId());
		}
		if(timetableListBean.getPeriodCode().equals("PERIOD-5"))
		{
			timeTableReferBean.setPeriod5(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod5(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod5(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod5TTId(timetableListBean.getTimeTableId());
		}
		if(timetableListBean.getPeriodCode().equals("PERIOD-6"))
		{
			timeTableReferBean.setPeriod6(timetableListBean.getPeriodCode());
			timeTableReferBean.setSubjectofPeriod6(timetableListBean.getSubjectId());
			timeTableReferBean.setSubjectNameofPeriod6(timetableListBean.getSubjectName());
			timeTableReferBean.setPeriod6TTId(timetableListBean.getTimeTableId());
		}
		timeTableReferBean.setSection(timetableListBean.getSection());
		timeTableReferBean.setScheduleId(timetableListBean.getTimeTableSchedule());
		timeTableReferBean.setClassID(timetableListBean.getClassId());
		
		
	return timeTableReferBean;	
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

	private ArrayList getSession(String adminType,String myclassid) throws Exception {
		Session s = null;
		Criteria crit = null;
		ArrayList<TimeTableCmnBean> arrcmnBean = new ArrayList<TimeTableCmnBean>();
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			
			tx = s.beginTransaction();

			if (adminType.equalsIgnoreCase("TimeTable")) {
				Query query = null;
				StringBuilder st = new StringBuilder();
				st.append(" select TT.timeTableId, TT.timetableschedule.timetableType,cl.classType,cl.classId,cl.section,p1.periodCode,TT.subject.subjectId,sb.subjectName,p.id.id,p.name ");
				st.append(" from TimeTable  TT,Classlevel cl,Period p1,Subject sb,Person p where ");
				st.append(" TT.classlevel.classId=cl.classId and TT.subject.subjectId=sb.subjectId and TT.period.periodCode=p1.periodCode and TT.teacherToSubject.id.personId=p.id.id  ");
				if(null!=myclassid)
				{
					st.append("  and cl.classId= '"+myclassid+"' ");
					st.append("  ORDER BY TT.period.periodCode ");
				}
				else
				{
				st.append("  ORDER BY cl.classType,cl.classId ");
				}
				query = s.createQuery(st.toString());  
				List ls = query.list();
				/*query= null;
				query = s.createQuery("from TimeTable");  
				List ls2 = query.list();*/
				System.out.println(ls.size());
				
				Object [] obj= null;
				Object object[] = null;
				TimeTableCmnBean timeTableCmnBean = null;
				ArrayList<TimeTableCmnListBean> altimebean = null;
				TimeTableCmnListBean tableCmnListBean =null;
				
				
				String tempClassType=null;
				for(int i=0;i<ls.size();i++)
				{
					
					
					object =(Object[])ls.get(i);
					if(null!=tempClassType && object[2].toString().equals(tempClassType))
						{
						//altimebean = new ArrayList<TimeTableCmnListBean>();
						tableCmnListBean = new TimeTableCmnListBean();
						tableCmnListBean.setClassId(object[3].toString());
						tableCmnListBean.setPeriodCode(object[5].toString());
						tableCmnListBean.setSection(object[4].toString());
						tableCmnListBean.setSubjectId(object[6].toString());
						tableCmnListBean.setSubjectName(object[7].toString());
						tableCmnListBean.setTimeTableId(object[0].toString());
						tableCmnListBean.setTimeTableSchedule(object[1].toString());
						tableCmnListBean.setTeacherId(object[8].toString());
						tableCmnListBean.setTeacherName(object[9].toString());
						altimebean.add(tableCmnListBean);
						tempClassType = object[2].toString();
						
						}
					else if(null!=tempClassType && !object[2].toString().equals(tempClassType))
					{
						arrcmnBean.add(timeTableCmnBean);
						timeTableCmnBean = new TimeTableCmnBean();
						timeTableCmnBean.setClassType(object[2].toString());
						altimebean = new ArrayList<TimeTableCmnListBean>();
						tableCmnListBean = new TimeTableCmnListBean();
						tableCmnListBean.setClassId(object[3].toString());
						tableCmnListBean.setPeriodCode(object[5].toString());
						tableCmnListBean.setSection(object[4].toString());
						tableCmnListBean.setSubjectId(object[6].toString());
						tableCmnListBean.setSubjectName(object[7].toString());
						tableCmnListBean.setTimeTableId(object[0].toString());
						tableCmnListBean.setTimeTableSchedule(object[1].toString());
						tableCmnListBean.setTeacherId(object[8].toString());
						tableCmnListBean.setTeacherName(object[9].toString());						
						altimebean.add(tableCmnListBean);
						timeTableCmnBean.setListBean(altimebean);
						tempClassType = object[2].toString();
						
					}
					else
					{
						timeTableCmnBean = new TimeTableCmnBean();
						timeTableCmnBean.setClassType(object[2].toString());
						altimebean = new ArrayList<TimeTableCmnListBean>();
						tableCmnListBean = new TimeTableCmnListBean();
						tableCmnListBean.setClassId(object[3].toString());
						tableCmnListBean.setPeriodCode(object[5].toString());
						tableCmnListBean.setSection(object[4].toString());
						tableCmnListBean.setSubjectId(object[6].toString());
						tableCmnListBean.setSubjectName(object[7].toString());
						tableCmnListBean.setTimeTableId(object[0].toString());
						tableCmnListBean.setTimeTableSchedule(object[1].toString());
						tableCmnListBean.setTeacherId(object[8].toString());
						tableCmnListBean.setTeacherName(object[9].toString());
						altimebean.add(tableCmnListBean);
						timeTableCmnBean.setListBean(altimebean);
						tempClassType = object[2].toString();
					}
					if(i==ls.size()-1)
					{
						arrcmnBean.add(timeTableCmnBean);
					}
					
					
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) arrcmnBean;
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

	public ArrayList<TimeTable> getCriteriaSession(String adminType,String classId) throws Exception {
		Session s = null;
		Criteria crit = null;
		Query query= null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			//tx = s.beginTransaction();
			
			if (adminType.equalsIgnoreCase("TimeTable")) {
				
				
				query = s.createQuery(" from TimeTable TT where TT.classlevel.classId='"+classId+"' order by TT.period.periodCode ");
				/*if(null!=classId)
				{
		        crit.add(Restrictions.eq("classlevel.classId",classId));
		        crit.addOrder(Order.asc("period.periodCode"));
				}*/
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<TimeTable>) query.list();
	}
	
	public static void main(String[] args) {
		//List ls =
		try{
		SchoolMasterDataTimeTableCmnFormatAction ss= new SchoolMasterDataTimeTableCmnFormatAction();
		List ls =ss.getCriteriaSession("TimeTable", "CID-01");
		}catch(Exception e){e.printStackTrace();}
	}

	
	public ArrayList<LabelValueCombo> getSubjectSession() throws Exception {
		Session s = null;
		Criteria crit = null;
		Query query= null;
		ArrayList<LabelValueCombo> lsCombo = new ArrayList<LabelValueCombo>();
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			//tx = s.beginTransaction();
			
			
				
				
				query = s.createQuery(" select SS.subjectId,SS.subjectName from Subject SS  ");
				List ls = query.list();
				Object object[] = null;
				LabelValueCombo labelvaluecombo=null;
				for(int i=0;i<ls.size();i++)
				{
					labelvaluecombo = new LabelValueCombo();
					object =(Object[])ls.get(i);
					labelvaluecombo.getSubject().setSubjectId((String)object[0]);
					labelvaluecombo.getSubject().setSubjectName((String)object[1]);
					lsCombo.add(labelvaluecombo);
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsCombo;
	}
	public ArrayList<LabelValueCombo> getPersonSession() throws Exception {
		Session s = null;
		Criteria crit = null;
		Query query= null;
		ArrayList<LabelValueCombo> lsCombo = new ArrayList<LabelValueCombo>();
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			//tx = s.beginTransaction();
			
			
				
				
				query = s.createQuery(" select PP.id.id,PP.name from Person PP  ");
				List ls = query.list();
				Object object[] = null;
				LabelValueCombo labelvaluecombo=null;
				for(int i=0;i<ls.size();i++)
				{
					labelvaluecombo = new LabelValueCombo();
					object =(Object[])ls.get(i);
					labelvaluecombo.getPerson().getId().setId((String)object[0]);
					labelvaluecombo.getPerson().setName((String)object[1]);
					lsCombo.add(labelvaluecombo);
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lsCombo;
	}
	
}
