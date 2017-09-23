<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function login()
{
	alert("hi");
	var form=document.getElementById("form1");
	form.action="UpdateStudent.do?id="+'<bean:write name="lstForm"  property="person.id.id"/>'+"&type="+'<bean:write name="lstForm" property="person.id.personType"/>';
	form.submit();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Green"><h3>Student</h3>


<!--<logic:iterate id="mylist" name="lstForm" property="plist" >
Student ID/RollNo: <bean:write name="mylist" property="id.id"/><br>
Student Name:<bean:write name="mylist" property="name"/><br>
Student/Teacher:<bean:write name="mylist" property="id.personType"/><br>
Gender: <bean:write name="mylist" property="sex"/><br>
Record Creation:<bean:write name="mylist" property="creDttm"/><br>
Student BirthDate: <bean:write name="mylist" property="dob"/><br>
Student Join Date:<bean:write name="mylist" property="joinigDate"/><br>
Student Released on :<bean:write name="mylist" property="releaseDate"/><br>

</logic:iterate> -->


Student ID/RollNo: <bean:write name="lstForm"  property="person.id.id"/><br>
Student Name:<bean:write name="lstForm" property="person.name"/><br>
Student/Teacher:<bean:write name="lstForm" property="person.id.personType"/><br>
Gender: <bean:write name="lstForm" property="person.sex"/><br>
Record Creation:<bean:write name="lstForm" property="person.creDttm"/><br>
Student BirthDate: <bean:write name="lstForm" property="person.dob"/><br>
Student Join Date:<bean:write name="lstForm" property="person.joinigDate"/><br>
Student Released on :<bean:write name="lstForm" property="person.releaseDate"/><br>
<form name="form1" method="post" id="form1"  onsubmit="login()">
<input type="submit" value="Update Student"/>

</form>


</body>
</html>