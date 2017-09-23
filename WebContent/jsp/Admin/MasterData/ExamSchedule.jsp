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
	var gtype= obj.childNodes[0].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddExamSchedule.do?masterData=ExamSchedule&delete="+gtype;
	form1.submit();
}

function addNewExamSchedule()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddExamSchedule.do?masterData=ExamSchedule&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Exam Schedule</h3>
<html:form styleId="myform1"   action="/AddExamSchedule"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Schedule ID:</td><td>Exam Code:</td><td>Class ID:</td><td>Start Date:</td><td>End Date:</td></tr>



<logic:iterate name="ExamScheduleList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="scheduleId"/>
</td><td>
<bean:write name="listMsgId" property="classlevel.classId"/>
</td><td>
<bean:write name="listMsgId" property="exam.examCode"/>
</td>
<td>
<bean:write name="listMsgId" property="examStartDt"/>
</td>
<td>
<bean:write name="listMsgId" property="examEndDt"/>
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
<td>Schedule ID:<html:text property="examSchedule.scheduleId"/></td>
<td>Class:<html:text property="examSchedule.classlevel.classId"/></td>
<td>Exam Code:<html:text property="examSchedule.exam.examCode"/></td>
<td>Start Date:<html:text property="examScheduleStartDate"/></td>
<td>End Date:<html:text property="examScheduleEndDate"/></td>

<td><html:button value="Add ExamSchedule" property="addCategoryButton" onclick="addNewExamSchedule()"/></td>
</tr>
</table>
</html:form>

</body>
</html>