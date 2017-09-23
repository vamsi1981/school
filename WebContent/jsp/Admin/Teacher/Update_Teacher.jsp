<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../../jquery/jquery-1.9.1.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../css/jquery/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="../../../css/Teacher/style.css"/>
<script>
function loadPage()
{
	var form1 = document.getElementById("myform1");
	form1.action="UpdateTeacher.do?confirm=yes";
	form1.submit();
}
$(function ()
{
	$("#dob").datepicker();
	$("#doj").datepicker();
});
</script>
</head>
<body><h3>Teacher</h3>
<html:form styleId="myform1"  action="/UpdateSaveTeacher"  method="post">
<table border="0" cellpadding="5" cellspacing="5" align="center">
<tr><td>Person Id:</td><td><bean:write name="lstForm" property="person.id.id"/></td></tr>

<tr><td>Person Type:</td><td><html:select property="person.id.personType" styleId="ptype">
<html:option value="S">Student</html:option>
<html:option value="T">Teacher</html:option>
</html:select>
</td></tr>

<tr><td>Name:</td><td><html:text styleId="pname" property="person.name"/></td>
<td>Gender:</td><td><html:select  property="person.sex">
<html:option value="F">Female</html:option>
<html:option value="M">Male</html:option>
</html:select>
</td></tr>
<tr><td>Record Created:</td><td><html:text property="cre_dttm"/></td>
<td>Date of Birth:</td><td><html:text  property="dob"/></td></tr>
<tr><td>Date of Release Date:</td><td><html:text  property="release_date"/></td>
<td>Date of Joining Date:</td><td><html:text  property="joining_date"/></td></tr>
<tr><td>
Fill Person Dependent Details:</td></tr>

<tr><td>Guardian Name: <html:text property="personDependentDetail.guardianName" styleId="GuardianName"/></td>
<td>Guardian Type: <html:text property="personDependentDetail.guardian.guardianType" styleId="GuardianType"/></td>
</tr>

<tr><td>Category Type: <html:text property="personDependentDetail.category.categoryType" styleId="CategoryType"/></td>
<td>Category  Name: <html:text property="personDependentDetail.category.category" styleId="Category"/></td>
</tr>

<tr><td>Street: <html:text property="personDependentDetail.address.street" styleId="street"/></td>
<td>House no: <html:text property="personDependentDetail.address.houseNo" styleId="houseno"/></td>
</tr>

<tr><td>PinCode: <html:text property="personDependentDetail.address.pin" styleId="pincode"/></td>
<td>Country Name: <html:text property="personDependentDetail.address.country" styleId="pincode"/></td>
</tr>

<tr><td>Address/State : <html:text property="personDependentDetail.address.address1" styleId="stateAddress"/></td>
<td>Last Address : <html:text property="personDependentDetail.address.refAddress" styleId="pincode"/></td>
</tr>

<tr><td>caste : <html:text property="personDependentDetail.caste" styleId="caste"/></td>
<td>Qualification : <html:text property="personDependentDetail.qualificationCode" styleId="qualificationCode"/></td>
</tr>
<tr><td><html:button  property="buttonPress" onclick="loadPage()" value="Confirm Update" /></td></tr>


</table>
</html:form>
</body>
</html>