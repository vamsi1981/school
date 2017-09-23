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
	form.action="UpdateTeacher.do?id="+'<bean:write name="lstForm"  property="person.id.id"/>'+"&type="+'<bean:write name="lstForm" property="person.id.personType"/>';
	form.submit();
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Green"><h3>Teacher</h3>





Student ID/RollNo: <bean:write name="lstForm"  property="person.id.id"/><br>
Student Name:<bean:write name="lstForm" property="person.name"/><br>
Student/Teacher:<bean:write name="lstForm" property="person.id.personType"/><br>
Gender: <bean:write name="lstForm" property="person.sex"/><br>
Record Creation:<bean:write name="lstForm" property="person.creDttm"/><br>
Student BirthDate: <bean:write name="lstForm" property="person.dob"/><br>
Student Join Date:<bean:write name="lstForm" property="person.joinigDate"/><br>
Student Released on :<bean:write name="lstForm" property="person.releaseDate"/><br>

StudentDependent And Address Details
	
Teacher's Guardian Type  :<bean:write name="lstForm" property="personDependentDetail.guardian.guardianType"/><br>	
Teacher's Qualification Code :<bean:write name="lstForm" property="personDependentDetail.qualificationCode"/><br>
Teacher's Caste :<bean:write name="lstForm" property="personDependentDetail.caste"/><br>
Teacher's Guardian Name  :<bean:write name="lstForm" property="personDependentDetail.guardianName"/><br>
Teacher's AddressCode  :<bean:write name="lstForm" property="personDependentDetail.address.addCode"/><br>
Teacher's Address1  :<bean:write name="lstForm" property="personDependentDetail.address.address1"/><br>
Teacher's Street  :<bean:write name="lstForm" property="personDependentDetail.address.street"/><br>
Teacher's House No  :<bean:write name="lstForm" property="personDependentDetail.address.houseNo"/><br>

Teacher's Pin  :<bean:write name="lstForm" property="personDependentDetail.address.pin"/><br>
Teacher's Ref Address  :<bean:write name="lstForm" property="personDependentDetail.address.refAddress"/><br>
Teacher's Country  :<bean:write name="lstForm" property="personDependentDetail.address.country"/><br>


<form name="form1" method="post" id="form1"  onsubmit="login()">
<input type="submit" value="Update Teacher"/>

</form>


</body>
</html>