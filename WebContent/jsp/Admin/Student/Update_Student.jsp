<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../../jquery/jquery-1.9.1.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../css/jquery/jquery-ui.css"/>
<script>
function loadPage()
{
	var form1 = document.getElementById("myform1");
	form1.action="UpdateStudent.do?confirm=yes";
	form1.submit();
}
$(function ()
{
	$("#dob").datepicker();
	$("#doj").datepicker();
});
</script>
</head>
<body><h3>Student</h3>
<html:form styleId="myform1"  action="/UpdateSaveStudent"  method="post">
<table border="0" cellpadding="20" cellspacing="20" align="center">
<tr><td>Person Id:</td><td><html:text styleId="pid" property="person.id.id"/></td></tr>

<tr><td>Person Type:</td><td><html:select property="person.id.personType" styleId="ptype">
<html:option value="S">Student</html:option>
<html:option value="T">Teacher</html:option>
</html:select>
</td></tr>

<tr><td>Name:</td><td><html:text styleId="pname" property="person.name"/></td></tr>
<tr><td>Gender:</td><td><html:select  property="person.sex">
<html:option value="F">Female</html:option>
<html:option value="M">Male</html:option>
</html:select>
</td></tr>
<tr><td>Record Created:</td><td><html:text property="cre_dttm"/></td></tr>
<tr><td>Date of Birth:</td><td><html:text  property="dob"/></td></tr>
<tr><td>Date of Release Date:</td><td><html:text  property="release_date"/></td></tr>
<tr><td>Date of Joining Date:</td><td><html:text  property="joining_date"/></td></tr>
<tr><td><html:button  property="buttonPress" onclick="loadPage()" value="Confirm Update" /></td></tr>


</table>
</html:form>
</body>
</html>