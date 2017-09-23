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
	
	//var gpid= obj.childNodes[0].innerHTML;
	var gtype= obj.childNodes[0].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&delete=true&gtype="+gtype;
	//form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	form1.submit();
}

function addUpdateTimeTable()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Add TimeTable Screen3 </h3>
<html:form styleId="myform1"   action="/AddUpdatecmnTimeTable"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Class Type:</td><td>TT :</td><td>Class Id:</td><td>Period code:</td><td>Subject Id:</td><td>Teacher Id:</td></tr>
<logic:iterate name="TimeTableList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="classType"/>
</td>
<td>
<table>
<logic:iterate name="listMsgId" id="listBean" property="listBean">
<tr><td>
<bean:write name="listBean" property="timeTableId"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="timeTableSchedule"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="classId"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="section"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="periodCode"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="subjectId"/>
</td></tr>
<tr><td>
<bean:write name="listBean" property="subjectName"/>
</td></tr>
<tr><td>
<html:button property="deleteProperty" value="Delete" onclick="loadPage(this.parentNode.parentNode)"/>
</td></tr>
</logic:iterate>
</table>
<tr>

</tr>
</logic:iterate>
<tr><td>Time Table Schedule: <html:text property="timeTable.timetableschedule.timetableType"></html:text></td></tr>
<tr><td>Time Table Id: <html:text property="timeTable.timeTableId"></html:text></td></tr>
<tr><td>Class : <html:text property="timeTable.classlevel.classId"></html:text></td></tr>
<tr><td>Period: <html:text property="timeTable.period.periodCode"></html:text></td></tr>
<tr><td>Subject: <html:text property="timeTable.subject.subjectId"></html:text></td></tr>
<tr><td>Teacher : <html:text property="timeTable.teacherToSubject.id.personId"></html:text></td></tr>
<tr><td><html:button value="Add/Update Time Table" property="addCategoryButton" onclick="addUpdateTimeTable()"/></td>
</tr>
</table>
</html:form>

</body>
</html>