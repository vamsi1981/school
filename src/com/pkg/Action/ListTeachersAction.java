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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.pkg.ActionForm.List_StudentForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Category;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonId;

public class ListTeachersAction extends Action 
{	
	private SessionFactory sessionFactory;
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		List_StudentForm stdntlistform=(List_StudentForm)form;
		System.out.println(stdntlistform);
		List s = new ArrayList();
		if(stdntlistform.getId()!=null || stdntlistform.getId().equals(""))
		s.add(stdntlistform.getId());
		s.add(stdntlistform.getType());
		s.add(stdntlistform.getName());
		Person p = new Person();
		p.setName(stdntlistform.getName());
		PersonId pid= new PersonId();
		pid.setId(stdntlistform.getId());
		pid.setPersonType(stdntlistform.getType());
		p.setId(pid);
		
		ArrayList<Person> l =getSession(p,s);
		stdntlistform.setPlist(l);
		return mapping.findForward("success");
	}
	
	public ArrayList getSession(Person p1,List Values) throws Exception
	{
		 Session s = null;
		 ArrayList <Person> ls = new ArrayList<Person>();
		   
		   try 
		   		{
			   
			   
		          s = DBConnection.getSession();
		          System.out.println("Begin transaction");
		       
		         /* Person p = new Person();
		          p.setId(p1.getId());*/
		          PersonId pid=new PersonId(); 
		        	  //p1.getId();
		          pid.setId(p1.getId().getId());
		          pid.setPersonType(p1.getId().getPersonType());
		          
		          if(p1.getName()!=null && (p1.getId()== null || p1.getId().getPersonType().equals("") || p1.getId().getPersonType().equals("")))
		          {
		        	// where p.name like '%"+p1.getName().trim()+"%'
			          String squery = "from Person p where upper(p.name) like '%"+p1.getName().toUpperCase().trim()+"%'";
			         Query q= s.createQuery(squery);
			         //List lfs = q.list();
			         ls.addAll(q.list());
			         return ls;
		          }
		          
		          //Person retObj =(Person)s.get(Person.class, pid);
		          Person perObj = (Person) s.get(Person.class,pid);
		         
		          ls.add(perObj);
		         
		          
		  		//g.setRelation("GGFather");
		  		//g.setRemarks("Good");
		  		
		        
		          System.out.println("Sessions created");
			    }
		   catch (Exception e)
		   		{
		            System.out.println("Error in getSession()"+e.getMessage());
		        }
		   return ls;
		}
	public Date getStrng2Date(String adate)
	{  
		Date ddd =null;
		try
		{
			String[] split1=adate.split("/");
			int month=Integer.valueOf(split1[0]);
			int day=Integer.valueOf(split1[1]);
			int year=Integer.valueOf(split1[2]);
			Calendar cal=new GregorianCalendar();
			cal.set(year, month, day);
			 ddd = cal.getTime();
			
		}
		catch(Exception e)
		{
			System.out.println("Error in getStrng2Date(String adate)"+e);
		}
		return ddd;
	}
	
	public Date getCurrentDate()
	{  
		Date ddd =null;
		try
		{
			
			Calendar cal=GregorianCalendar.getInstance();
			
			 ddd = cal.getTime();
			
		}
		catch(Exception e)
		{
			System.out.println("Error in getStrng2Date(String adate)"+e);
		}
		return ddd;
	}
	
}
