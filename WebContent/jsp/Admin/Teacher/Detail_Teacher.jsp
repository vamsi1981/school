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
	form1.action="../../../AddTeacher.do";
	form1.submit();
}
$(function ()
{
	$("#dob").datepicker();
	$("#doj").datepicker();
});
</script>
</head>
<body><h3>Teacher </h3>
<html:form styleId="myform1" action="/AddTeacher"  method="post">
<table border="0" cellpadding="20" cellspacing="20" align="center">
<tr>
<td>Person Type:</td><td><bean:write name="addstdtform" property="person.id.personType" /></td>
</tr>

<tr>
<td>Name:</td><td><bean:write  name="addstdtform"  property="person.name"/></td>
</tr>

<tr><td>Gender:</td><td><bean:write name="addstdtform"   property="person.sex"/>
</td></tr>

<tr><td>Joining Date:</td><td><bean:write name="addstdtform"  property="rdS"/></td></tr>

<tr><td>Date of Birth:</td><td><bean:write name="addstdtform"   property="dojS"/></td></tr>

<tr><td>
Fill Person Dependent Details:</td></tr>

<tr><td>Guardian Name: <bean:write property="pdependentDetail.guardianName" name="addstdtform" /></td>
<td>Guardian Type: <bean:write property="pdependentDetail.guardian.guardianType" name="addstdtform" /></td>
</tr>

<tr><td>Category Type: <bean:write property="pdependentDetail.category.categoryType" name="addstdtform" /></td>
<td>Category  Name: <bean:write property="pdependentDetail.category.category" name="addstdtform" /></td>
</tr>

<tr><td>Street: <bean:write property="pdependentDetail.address.street" name="addstdtform" /></td>
<td>House no: <bean:write property="pdependentDetail.address.houseNo" name="addstdtform" /></td>
</tr>

<tr><td>PinCode: <bean:write property="pdependentDetail.address.pin" name="addstdtform" /></td>
<td>Country Name: <bean:write property="pdependentDetail.address.country" name="addstdtform" /></td>
</tr>

<tr><td>Address/State : <bean:write property="pdependentDetail.address.address1" name="addstdtform" /></td>
<td>Last Address : <bean:write property="pdependentDetail.address.refAddress" name="addstdtform" /></td>
</tr>

<tr><td>caste : <bean:write property="pdependentDetail.caste" name="addstdtform" /></td>
<td>Qualification : <bean:write property="pdependentDetail.qualificationCode" name="addstdtform" /></td>
</tr>

</table>
</html:form>
</body>
</html>