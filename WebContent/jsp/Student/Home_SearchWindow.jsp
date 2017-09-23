<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="studentScript.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../css/Student/Home_SearchWindow.css"/>
</head>
<body bgcolor="olive">
<form name="home_searchwindow" method="get" id="home_searchwindow">
<div id="home_sw">
<ul>
<li>
<a id="student_details" name="student_details" onclick="home_search()" target="view_frame">STUDENT DETAILS</a>
<a href="#" id="teacher_details">TEACHER DETAILS</a>
</li>
</ul>
</div>
</form>
</body>
</html>