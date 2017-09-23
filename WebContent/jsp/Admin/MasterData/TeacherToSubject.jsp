<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../../jquery/jquery-1.9.1.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../css/jquery/jquery-ui.css"/>
<script>
function loadPage(obj)

{  
	
	var gpid= obj.childNodes[0].innerHTML;
	var gtype= obj.childNodes[1].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddTeacherToSubject.do?masterData=TeacherToSubject&delete=true&gpid="+gpid+"&gtype="+gtype;
	//form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	form1.submit();
}

function addTeacherToSubject()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddTeacherToSubject.do?masterData=TeacherToSubject&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Add Teacher to Subject</h3>
<html:form styleId="myform1"   action="/AddTeacherToSubject"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Person Id :</td><td>Subject Id :</td><td>Start Date:</td><td>end Date :</td></tr>

<logic:iterate name="TeacherTosubjectList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="id.personId"/>
</td>
<td>
<bean:write name="listMsgId" property="id.subject.subjectId"/>
</td>
<td>
<bean:write name="listMsgId" property="startDate"/>
</td>
<td>
<bean:write name="listMsgId" property="endDate"/>
</td>
<td>
<html:button property="deleteProperty" value="Delete" onclick="loadPage(this.parentNode.parentNode)"/>
</td>
</tr>
</logic:iterate>

</table>
<br>
<table>
<tr>

<td>Person Id  :<html:text property="teacherToSubject.id.personId"/></td>
<td>Subject Id  :<html:text property="teacherToSubject.id.subject.subjectId"/></td>
<td>Start Date :<html:text property="teachertoSubjectStartDate"/></td>
<td>End Date :<html:text property="teachertoSubjectendDate"/></td>

<td><html:button value="Add Subject To Teacher" property="addCategoryButton" onclick="addTeacherToSubject()"/></td>
</tr>
</table>
</html:form>

</body>
</html>