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
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.pkg.ActionForm.SchoolMasterDataForm;
import com.pkg.dbConnection.DBConnection;
import com.pkg.hibernate.Address;
import com.pkg.hibernate.Category;
import com.pkg.hibernate.CategoryHome;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;
import com.pkg.hibernate.PersonDependentDetailId;
import com.pkg.hibernate.PersonId;

public class SchoolMasterDataAction extends Action {
	private SessionFactory sessionFactory;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SchoolMasterDataForm addstdnt = (SchoolMasterDataForm) form;
		String parameterMaster = request.getParameter("masterData");
		String parameterOperation = request.getParameter("delete");
		String parameterAddOperation = request.getParameter("add");
		ArrayList<Category> lst = null;
					//Category Begin
		if (parameterMaster.equalsIgnoreCase("Category")
				&& null!= parameterAddOperation && parameterAddOperation.equalsIgnoreCase("true")) {
			lst = null;
			Category c = new Category();
			c.setCategory(addstdnt.getAddCategory());
			c.setCategoryType(addstdnt.getAddCategoryType());
			getAddSession(c);
			request.removeAttribute("Category");
			lst = getSession("Category");

		}
		if (parameterMaster.equalsIgnoreCase("Category")
				&& null == parameterOperation) {
			lst = null;
			request.removeAttribute("Category");
			lst = getSession("Category");

		} else if (parameterMaster.equalsIgnoreCase("Category")
				&& parameterOperation != null) {
			lst = null;
			request.removeAttribute("Category");
			lst = getDeleteSession("Category", "delete", parameterOperation);

		}

					
		
		request.setAttribute("Category", lst);
		return mapping.findForward("success");
	}
	
	
	private ArrayList getAddSession(Category c) throws Exception {
		Session s = null;
		Criteria crit = null;
		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();
			s.merge(c);
			tx.commit();
			crit = s.createCriteria(Category.class);
		
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

			if (adminType.equalsIgnoreCase("Category")) {
				crit = s.createCriteria(Category.class);

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

			if (adminType.equalsIgnoreCase("Category") && operation != null) {
				crit = s.createCriteria(Category.class);
				Category c = new Category();
				c.setCategoryType(code);
				Category cnew = (Category) s.load(Category.class, code);
				s.flush();
				s.delete(cnew);

			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList) crit.list();
	}

	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * ///TODO category Category c1 = new Category();
	 * c1.setCategoryType("Guardian1"); c1.setCategory("Close Relative");
	 * 
	 * //TODO classlevel Classlevel c1 = new Classlevel();
	 * c1.setClassId("CID-09"); c1.setClassType("Class-V"); c1.setSection("A");
	 * 
	 * 
	 * //TODO Calender c1 = new Calender(); c1.setCode("CAL4"); c1.setDate(new
	 * Date()); c1.setNationalHoliday("Diwali"); c1.setPublicHoliday("Y");
	 * 
	 * //TODO Complexity c1 = new Complexity(); c1.setComplexityType("Average");
	 * 
	 * //TODO Exam c1= new Exam(); c1.setExam("Semester-1");
	 * c1.setExamCode("Test-7");
	 * 
	 * //TODO Format c1= new Format(); c1.setFormatType("Doc");
	 * 
	 * //TODO GeneralInfo c1 = new GeneralInfo(); c1.setSchoolId("011HA1");
	 * c1.setInfo("Bharatiya Vidya Bhavan");
	 * 
	 * 
	 * ///TODO Grades c1 = new Grades(); c1.setGradeType("E");
	 * c1.setPercentage(80f); c1.setLatestUpdateDt(new Date());
	 * 
	 * //TODO Graphs Graphs c1= new Graphs(); c1.setGraphTypes("Donut");
	 * 
	 * //TODO Guardian GUR-06 Step Father Guardian c1 = new Guardian();
	 * c1.setGuardianType("GUR-07"); c1.setRelation("Uncle");
	 * 
	 * 
	 * //new Add_StudentAction().getSession(c1); }
	 */
	private Session getSession(Object c1) throws Exception {
		Session s = null;

		try {
			Transaction tx = null;
			Configuration c = new Configuration();
			sessionFactory = c.configure("hibernate.cfg.xml")
					.buildSessionFactory();
			s = sessionFactory.openSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			// g.setRelation("GGFather");
			// g.setRemarks("Good");
			s.save(c1);
			tx.commit();
			System.out.println("Sessions created");
		} catch (Exception e) {
			System.out.println("Error in getSession()" + e.getMessage());
		}
		return s;
	}

	// Construct a bean object
	private Session getSession(Person p1,
			PersonDependentDetail personDependepntDetail) throws Exception {
		Session s = null;

		try {
			Transaction tx = null;
			s = DBConnection.getSession();
			System.out.println("Begin transaction");
			tx = s.beginTransaction();

			// String squery = "select  huge from maa.person";
			// Query q= s.createQuery(squery);
			Criteria crit = s.createCriteria(Person.class);
			int count = crit.list().size();
			count++;

			String cons = "P" + count;
			PersonId pid = new PersonId();
			pid.setId(cons);
			pid.setPersonType(p1.getCategory().getCategoryType());
			p1.setId(pid);

			PersonDependentDetailId pdepid = new PersonDependentDetailId();
			pdepid.setUniqueId(pid.getId());
			pdepid.setCatId(pid.getPersonType());
			pdepid.setGuardianType(personDependepntDetail.getGuardian()
					.getGuardianType());
			personDependepntDetail.setId(pdepid);

			String AddressId = "";
			Criteria critAdd = s.createCriteria(Address.class);
			if (critAdd.list() == null && critAdd.list().size() == 0) {
				AddressId = "A01";
			} else {
				int countAdd = critAdd.list().size();
				countAdd++;
				AddressId = "A0" + countAdd;
			}
			// Address add = new Address();
			// add.set
			personDependepntDetail.getAddress().setAddCode(AddressId);
			personDependepntDetail.getAddress().setPersonId(p1.getId().getId());

			// g.setRelation("GGFather");
			// g.setRemarks("Good");
			s.save(p1);
			s.save(personDependepntDetail.getAddress());
			s.save(personDependepntDetail);

			tx.commit();
			System.out.println("Sessions created");
		} catch (Exception e) {
			System.out.println("Error in getSession()" + e.getMessage());
		}
		return s;
	}

	public Date getStrng2Date(String adate) {
		Date ddd = null;
		try {
			String[] split1 = adate.split("/");
			int month = Integer.valueOf(split1[0]);
			int day = Integer.valueOf(split1[1]);
			int year = Integer.valueOf(split1[2]);
			Calendar cal = new GregorianCalendar();
			cal.set(year, month, day);
			ddd = cal.getTime();

		} catch (Exception e) {
			System.out.println("Error in getStrng2Date(String adate)" + e);
		}
		return ddd;
	}

	public Date getCurrentDate() {
		Date ddd = null;
		try {

			Calendar cal = GregorianCalendar.getInstance();

			ddd = cal.getTime();

		} catch (Exception e) {
			System.out.println("Error in getStrng2Date(String adate)" + e);
		}
		return ddd;
	}

}
