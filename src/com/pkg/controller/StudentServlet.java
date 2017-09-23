package com.pkg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			String val=request.getParameter("details");
			System.out.println(val);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			

			out.println("krishna");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		    
		    String val=request.getParameter("details");
		    System.out.println(val);
		
			System.out.println("hello");
			response.setContentType("text/xml");
			PrintWriter out = response.getWriter();
			/*response.setContentType("text/html");
			out.println("krishna");*/
			
			String app="<students><student><studentname>vamsi</studentname><studentclass>4</studentclass><studentmarks>100</studentmarks></student>";
			app+="<student><studentname>shashank</studentname><studentclass>5</studentclass><studentmarks>102</studentmarks></student>";
			app+="<student><studentname>meraj</studentname><studentclass>6</studentclass><studentmarks>122</studentmarks></student></students>";
					
			out.println(app);
	}


}
