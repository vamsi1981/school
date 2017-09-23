<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="studentScript.jsp" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../css/Student/Header.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="Gold" onload="loadMenu()">
<br>
<div id="wrapper" align="right" style="display: block;"><div id="navMenu">
<table border="0" cellpadding="1" cellspacing="1" >
<tr>
<td>
<c:forEach var="ob" varStatus="status" items="${menulist}">
<ul>
<li>
<a href='<c:out value="${ob.menuLink}"/>' id="home" target="search_frame"><c:out value="${ob.menuName}"/></a>
</li>
</ul>
 </c:forEach>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>