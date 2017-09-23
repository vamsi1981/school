package com.pkg.Action;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.pkg.ActionForm.List_StudentForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Address;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;
import com.pkg.hibernate.PersonDependentDetailId;
import com.pkg.hibernate.PersonId;

public class ListStudentsAction extends Action 
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
			   		
			      String squery=null; 
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
			           squery = "from Person p where upper(p.name) like '%"+p1.getName().toUpperCase().trim()+"%'";
			         Query q= s.createQuery(squery);
			         //List lfs = q.list();
			         ls.addAll(q.list());
			         //return ls;
		          }
		          
		          //Person retObj =(Person)s.get(Person.class, pid);
		          Person perObj = (Person) s.get(Person.class,pid);
		          ls.add(perObj);
		         
		         
		          squery = "from PersonDependentDetail p where p.id.catId='"+p1.getId().getPersonType()+"' and p.id.uniqueId='"+p1.getId().getId()+"'";
		                       PersonDependentDetailId pdepid= new PersonDependentDetailId();
		                       pdepid.setUniqueId(perObj.getId().getId());
		                       pdepid.setCatId(perObj.getCategory().getCategoryType());
		                       //pdepid.setGuardianType("GUR-01");
		                       PersonDependentDetail pdepObj = (PersonDependentDetail)s.get(PersonDependentDetail.class,pdepid);
			         Query q2= s.createQuery(squery);
			         Person perdep = null;
			         List <PersonDependentDetail> lsPersonDependept = null;
			         Address address = null;
			         if(q2!=null && q2.list().size()>0 && ls.size()==1)
			         {
		              lsPersonDependept = q2.list();
		              perdep=ls.get(0);
		              
		              if(lsPersonDependept!=null && lsPersonDependept.size()==1)
		              {
		            	  address=   (Address)s.get(Address.class,lsPersonDependept.get(0).getAddress().getAddCode());
		            	  lsPersonDependept.get(0).setAddress(address);
		              }
		              Set<PersonDependentDetail> sDep =  new HashSet<PersonDependentDetail>(lsPersonDependept);
		              perdep.setPersonDependentDetails(sDep);
		             }
		          
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
