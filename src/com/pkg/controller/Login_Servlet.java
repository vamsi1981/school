package com.pkg.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg.bean.SchoolMenu;

/**
 * Servlet implementation class Login_Servlet
 */
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   
		LinkedHashMap<String,String> urls=new LinkedHashMap<String, String>();
		urls.put("CSS","../../css/Generic/Header.css");
		String val=request.getParameter("hid");
		if(null!=val)
		{
			if(val.equalsIgnoreCase("hid1"))
			{
				//String uname=request.getParameter("uname");
				//String pwd=request.getParameter("pwd");
				String u_type=request.getParameter("u_type");
				if(u_type.equalsIgnoreCase("Student"))
				{
					urls.put("Home","#");
					urls.put("Attendance","#");
					urls.put("Peformance","#");
					urls.put("Health Status","#");
					urls.put("Contact Us","#");
					
					
				}
				if(u_type.equalsIgnoreCase("Teacher"))
				{
					
					urls.put("Home","#");
					urls.put("Attendance","#");					
					urls.put("Student List","#");
					urls.put("Time Tables","#");
					
				}
				if(u_type.equalsIgnoreCase("Admin"))
				{
					urls.put("HOME","../Admin/Student/AdminConfig.jsp");
					urls.put("Student Config","../Admin/Student/Student_Config.jsp");
					urls.put("Teacher Config","../Admin/Teacher/Teacher_Config.jsp");
					urls.put("Issues","#");
					 
				}	
				request.getSession().setAttribute("urls", urls);
				response.sendRedirect("jsp/Main/UserHomePage.jsp");
			}
		}
		
	}

}
