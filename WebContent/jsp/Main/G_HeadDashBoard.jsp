<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../Student/studentScript.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../../jquery/jquery-1.9.1.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.min.js"></script>

<link href='${urls["CSS"]}' rel="stylesheet" type="text/css" />
</head>
<body bgcolor="Gold" onload="loadMenu()">
<br>
<div id="wrapper" align="right" style="display: block;"><div id="navMenu">
<table border="0" cellpadding="1" cellspacing="1" >
<tr><td width="15"></td><td></td></tr>
<tr>
<td width="15"></td>
<td>
<c:forEach var="ob" items="${urls}" begin="1" end="5">
<ul>
<li>
<a href='<c:out value="${ob.value}"/>' id="home" target="search_frame"><c:out value='${ob.key}'/></a>
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