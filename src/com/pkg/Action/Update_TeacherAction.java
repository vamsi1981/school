package com.pkg.Action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.pkg.ActionForm.List_StudentForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonId;
import com.pkg.utilities.UtilityCollection;

public class Update_TeacherAction extends Action 
{	
	private static SessionFactory sessionFactory;
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		List_StudentForm addstdnt=(List_StudentForm) form;
		System.out.println(addstdnt);
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("type"));
		/*String dateofbirth = addstdnt.getDojS();
		String dateofjoin=addstdnt.getRdS();
		Person p1 = addstdnt.getPerson();
		p1.setDob(getStrng2Date(dateofbirth));
		p1.setCreDttm(getCurrentDate());
		p1.setJoinigDate(getStrng2Date(dateofjoin));
		getSession(p1);*/
		String returnForward="success";
		if(request.getParameter("id")!=null)
		{
		List s = new ArrayList();
		
		Person p = new Person();
		PersonId pid= new PersonId();
		pid.setId(request.getParameter("id"));
		pid.setPersonType(request.getParameter("type"));
		p.setId(pid);
		
		ArrayList<Person> l =new ListStudentsAction().getSession(p,s);
		
		Person pp =(Person)l.get(0);
		addstdnt.setPerson(pp);
		addstdnt.setOldPerson(pp);
		
		
		
		addstdnt.setOldPersonName(pp.getName());
		
		addstdnt.setOldCre_dttm(UtilityCollection.constructDate(addstdnt.getPerson().getCreDttm()));
		addstdnt.setOldDob(UtilityCollection.constructDate(addstdnt.getPerson().getDob()));
		addstdnt.setOldJoining_date(UtilityCollection.constructDate(addstdnt.getPerson().getJoinigDate()));
		addstdnt.setOldRelease_date(UtilityCollection.constructDate(addstdnt.getPerson().getReleaseDate()));
		
		//addstdnt
		addstdnt.setCre_dttm(UtilityCollection.constructDate(addstdnt.getPerson().getCreDttm()));
		addstdnt.setDob(UtilityCollection.constructDate(addstdnt.getPerson().getDob()));
		addstdnt.setJoining_date(UtilityCollection.constructDate(addstdnt.getPerson().getJoinigDate()));
		addstdnt.setRelease_date(UtilityCollection.constructDate(addstdnt.getPerson().getReleaseDate()));
		
		/*addstdnt.getPerson().setCreDttm(null);
		addstdnt.getPerson().setDob(null);
		addstdnt.getPerson().setJoinigDate(null);
		addstdnt.getPerson().setReleaseDate(null);*/
		
		
		System.out.println("asdf");
		returnForward="success";
		}
		if(request.getParameter("confirm")!=null)
		{
			Person existingPerson =addstdnt.getPerson();
 			System.out.println("");
 			
 			existingPerson.setCreDttm(UtilityCollection.constructStringToDate(addstdnt.getCre_dttm()));
 			existingPerson.setDob(UtilityCollection.constructStringToDate(addstdnt.getDob()));
 			existingPerson.setJoinigDate(UtilityCollection.constructStringToDate(addstdnt.getJoining_date()));
 			existingPerson.setReleaseDate(UtilityCollection.constructStringToDate(addstdnt.getRelease_date()));
 			addstdnt.setUpdatedPerson(existingPerson);
 			saveUpdateSession(addstdnt.getUpdatedPerson());
			returnForward="displayUpdate";
		}
		return mapping.findForward(returnForward);
	}
	
	/*public static void main(String[] args) throws Exception 
	{
		
		///TODO category
		Category c1 = new Category();
		c1.setCategoryType("Guardian1");
		c1.setCategory("Close Relative");
		
		//TODO classlevel
		Classlevel c1 = new Classlevel();
		c1.setClassId("CID-09");
		c1.setClassType("Class-V");
		c1.setSection("A");
		
		
		//TODO
		Calender c1 = new Calender();
		c1.setCode("CAL4");
		c1.setDate(new Date());
		c1.setNationalHoliday("Diwali");
		c1.setPublicHoliday("Y");
		
		//TODO
		Complexity c1 = new Complexity();
		c1.setComplexityType("Average");
		
		//TODO
		Exam c1= new Exam();
		c1.setExam("Semester-1");
		c1.setExamCode("Test-7");
		
		//TODO
		Format c1= new Format();
		c1.setFormatType("Doc");
		
		//TODO
		GeneralInfo c1 = new GeneralInfo();
		c1.setSchoolId("011HA1");
		c1.setInfo("Bharatiya Vidya Bhavan");
		
		
		///TODO
		Grades c1 = new Grades();
		c1.setGradeType("E");
		c1.setPercentage(80f);
		c1.setLatestUpdateDt(new Date());
		
		//TODO Graphs
		Graphs c1= new Graphs();
		c1.setGraphTypes("Donut");
		
		//TODO Guardian GUR-06	Step Father
		Guardian c1 = new Guardian();
		c1.setGuardianType("GUR-07");
		c1.setRelation("Uncle");
		
		
		//new Add_StudentAction().getSession(c1);
	}*/
	private static Session saveUpdateSession(Object c1) throws Exception
	{
		 Session s = null;
		   
		   try 
		   		{
			   Transaction tx = null;
		          s = DBConnection.getSession();
		          System.out.println("Begin transaction");
		          tx = s.beginTransaction();
		        
		  		//g.setRelation("GGFather");
		  		//g.setRemarks("Good");
		  		s.saveOrUpdate(c1);
		          tx.commit();
		          System.out.println("Sessions created");
			    }
		   catch (Exception e)
		   		{
		            System.out.println("Error in getSession()"+e.getMessage());
		        }
		       return s;
		}
	//Construct a bean object
	private static Session getSession(Person p1) throws Exception
	{
		 Session s = null;
		   
		   try 
		   		{
			   Transaction tx = null;
			   Configuration c = new Configuration();
			   sessionFactory = c.configure("hibernate.cfg.xml").buildSessionFactory();
		          s = sessionFactory.openSession();
		          System.out.println("Begin transaction");
		          tx = s.beginTransaction();
		        
		          //String squery = "select  huge from maa.person";
		         //Query q= s.createQuery(squery);
		          /*Criteria crit=s.createCriteria(Person.class);
		          int count=crit.list().size();
		          count++;
		          
		          String cons ="P"+count;
		          PersonId pid= new PersonId();
		          pid.setId(cons);
		          pid.setPersonType(p1.getId().getPersonType());
		          p1.setId(pid);*/
		          
		          
		  		//g.setRelation("GGFather");
		  		//g.setRemarks("Good");
		  		s.saveOrUpdate(p1);
		          tx.commit();
		          System.out.println("Sessions created");
			    }
		   catch (Exception e)
		   		{
		            System.out.println("Error in getSession()"+e.getMessage());
		        }
		       return s;
		}
	
	
}
