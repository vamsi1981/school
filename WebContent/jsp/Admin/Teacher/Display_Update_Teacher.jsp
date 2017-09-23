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
<body><h3>Teacher vamsi</h3>
<html:form styleId="myform1"  action="/UpdateSaveTeacher"  method="post">
<table border="0" cellpadding="20" cellspacing="20" align="center">
<tr><td>New Data</td><td>Old Data</td></tr>
<tr><td>Person Id:<bean:write name="lstForm" property="updatedPerson.id.id"/></td><td><bean:write name="lstForm"  property="oldPerson.id.id"/></td></tr>
<tr><td>Person Type:<bean:write name="lstForm"  property="updatedPerson.id.personType" /></td><td><bean:write name="lstForm"  property="oldPerson.id.personType" /></td></tr>


<tr><td>Name:<bean:write name="lstForm"  property="updatedPerson.name"/></td><td><bean:write name="lstForm"  property="oldPerson.name"/></td></tr>
<tr><td>Gender:<bean:write name="lstForm"   property="updatedPerson.sex"/></td><td><bean:write name="lstForm"   property="oldPerson.sex"/></td></tr>

<tr><td>Record Created:<bean:write name="lstForm"  property="updatedPerson.creDttm"/></td><td><bean:write name="lstForm"  property="oldCre_dttm"/></td></tr>
<tr><td>Date of Birth:<bean:write name="lstForm"   property="updatedPerson.dob"/></td><td><bean:write name="lstForm"   property="oldDob"/></td></tr>
<tr><td>Date of Release Date:<bean:write name="lstForm"   property="updatedPerson.releaseDate"/></td><td><bean:write name="lstForm"   property="oldRelease_date"/></td></tr>
<tr><td>Date of Joining Date:<bean:write name="lstForm"  property="updatedPerson.joinigDate"/></td><td><bean:write name="lstForm"  property="oldJoining_date"/></td></tr>
<tr><td>
Fill Person Dependent Details:</td></tr>

<tr><td>Guardian Name: <bean:write property="personDependentDetail.guardianName" name="lstForm" /></td>
<td>Guardian Type: <bean:write property="personDependentDetail.guardian.guardianType" name="lstForm" /></td>
</tr>

<tr><td>Category Type: <bean:write property="personDependentDetail.category.categoryType" name="lstForm" /></td>
<td>Category  Name: <bean:write property="personDependentDetail.category.category" name="lstForm" /></td>
</tr>

<tr><td>Street: <bean:write property="personDependentDetail.address.street" name="lstForm" /></td>
<td>House no: <bean:write property="personDependentDetail.address.houseNo" name="lstForm" /></td>
</tr>

<tr><td>PinCode: <bean:write property="personDependentDetail.address.pin" name="lstForm" /></td>
<td>Country Name: <bean:write property="personDependentDetail.address.country" name="lstForm" /></td>
</tr>

<tr><td>Address/State : <bean:write property="personDependentDetail.address.address1" name="lstForm" /></td>
<td>Last Address : <bean:write property="personDependentDetail.address.refAddress" name="lstForm" /></td>
</tr>

<tr><td>caste : <bean:write property="personDependentDetail.caste" name="lstForm" /></td>
<td>Qualification : <bean:write property="personDependentDetail.qualificationCode" name="lstForm" /></td>
</tr>

</table>
</html:form>
</body>
</html>