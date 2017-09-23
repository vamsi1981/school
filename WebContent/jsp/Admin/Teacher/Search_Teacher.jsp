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
	form1.action="../../../ListAdvancedTeachers.do";
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
<html:form styleId="myform1"   action="/ListAdvancedTeachers"  method="post">

<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Person Type:</td>
<td>
<html:select  property="person.category.categoryType" styleId="ptype">
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
<td>Address:</td>
<td><html:text property="address.address1" styleId="address"/></td>
</tr>
<tr>
<td>Street No:</td><td><html:text property="address.street" styleId="street"/></td>
<td>House No:</td><td><html:text property="address.houseNo" styleId="houseno"/></td>
</tr>
<tr>
<td>Pin Code:</td><td><html:text property="address.pin" styleId="pincode"/></td>
<td>Country</td><td><html:text property="address.country" styleId="country"/></td>
</tr>
<tr><td></td><td></td><td><html:button  property="buttonPress" onclick="loadPage()" value="Search"/></td></tr>

</table>
</html:form> 
Fill Person Dependent Details:
<br>

</body>
</html>