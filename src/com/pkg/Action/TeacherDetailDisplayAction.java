package com.pkg.Action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pkg.ActionForm.List_StudentForm;
import com.pkg.hibernate.Person;
import com.pkg.hibernate.PersonDependentDetail;
import com.pkg.hibernate.PersonId;

public class TeacherDetailDisplayAction extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List_StudentForm StdForm =	(List_StudentForm)form;
		String pname =request.getParameter("id");
		String ptype=request.getParameter("type");
		System.out.println(pname);
		StdForm.setName("Vamsi");
		System.out.println("test");
		List s = new ArrayList();
		Person p = new Person();
		//p.setName(pname.toUpperCase());
		PersonId pid= new PersonId();
		pid.setId(pname);
		pid.setPersonType(ptype);
		p.setId(pid);
		ListStudentsAction LS = new ListStudentsAction();
		ArrayList ls =LS.getSession(p,s);
		
		
		StdForm.setPerson((Person)ls.get(0));
		StdForm.setPersonDependentDetail((PersonDependentDetail)((Person)ls.get(0)).getPersonDependentDetails().iterator().next());
		return mapping.findForward("perfect");
	}
	
}
