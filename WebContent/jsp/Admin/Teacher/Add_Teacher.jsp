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
	form1.action="../../../AddTeacher.do";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Teacher</h3>
<html:form styleId="myform1"   action="/AddTeacher"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Person Type:</td>
<td>
<html:select name="addstdtform" property="person.category.categoryType" styleId="ptype">
<html:option value="">Select a Type</html:option>
<html:option value="S">Student</html:option>
<html:option value="T">Teacher</html:option>
</html:select>
</td>
<td>Name:</td><td><html:text styleId="pname" property="person.name"/></td>
</tr>
<tr>
<td>Gender:</td><td><html:select  property="person.sex">
<html:option value="">Select Gender</html:option>
<html:option value="F">Female</html:option>
<html:option value="M">Male</html:option>
</html:select>
</td>
<td>Joining Date:</td><td><html:text property="rdS" styleId="rdS"/></td>
</tr>
<tr>
<td>Date of Birth:</td><td><html:text  property="dojS" styleId="dojS"/></td>
</tr>
<tr><td></td><td></td><td><html:button  property="buttonPress" onclick="loadPage()"/></td></tr>




<tr><td>
Fill Person Dependent Details:</td></tr>

<tr><td>Guardian Name: <html:text property="pdependentDetail.guardianName" styleId="GuardianName"/></td>
<td>Guardian Type: <html:text property="pdependentDetail.guardian.guardianType" styleId="GuardianType"/></td>
</tr>

<tr><td>Category Type: <html:text property="pdependentDetail.category.categoryType" styleId="CategoryType"/></td>
<td>Category  Name: <html:text property="pdependentDetail.category.category" styleId="Category"/></td>
</tr>

<tr><td>Street: <html:text property="pdependentDetail.address.street" styleId="street"/></td>
<td>House no: <html:text property="pdependentDetail.address.houseNo" styleId="houseno"/></td>
</tr>

<tr><td>PinCode: <html:text property="pdependentDetail.address.pin" styleId="pincode"/></td>
<td>Country Name: <html:text property="pdependentDetail.address.country" styleId="pincode"/></td>
</tr>

<tr><td>Address/State : <html:text property="pdependentDetail.address.address1" styleId="stateAddress"/></td>
<td>Last Address : <html:text property="pdependentDetail.address.refAddress" styleId="pincode"/></td>
</tr>

<tr><td>caste : <html:text property="pdependentDetail.caste" styleId="caste"/></td>
<td>Qualification : <html:text property="pdependentDetail.qualificationCode" styleId="qualificationCode"/></td>
</tr>

</table>

</html:form>

</body>
</html>