<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="../../css/Generic/G_SearchWindow.css" rel="stylesheet"/>
<script>
function loadPage()
{	
	
	var form1 = document.getElementById("myform1");
	form1.action="../../../ListTeachers.do";
	form1.submit();
}
</script>
</head>
<body><h3>Teacher</h3>
<html:form styleId="myform1"  action="/ListTeachers"  method="post">
<B>Search Student</B>
<table>
<tr><td>ID:</td><td><html:text property="id" size="5"></html:text></td></tr>
<tr><td>Type:</td><td><html:text property="type" size="2"></html:text></td></tr>
<tr><td><hr></td><td><hr></td></tr>
<tr><td>Name like:</td><td><html:text property="name" size="10"></html:text></td></tr>
<tr><td></td><td><html:button property="classCode" onclick="loadPage()"/></td></tr>
</table>
<a href="/School/jsp/Admin/Teacher/Add_Teacher.jsp" target="view_frame" >Add Teacher</a><br>
<a  href="/School/StudentDetail.do" target="view_frame">Delete Teacher</a>
<a  href="/School/jsp/Admin/Teacher/Search_Teacher.jsp" target="view_frame">Advanced Search</a>
</html:form>
</body>
</html>