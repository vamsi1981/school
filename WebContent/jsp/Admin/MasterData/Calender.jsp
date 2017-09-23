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
	var gtype= obj.childNodes[1].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddCalendar.do?masterData=Calendar&delete="+gtype;
	form1.submit();
}

function addNewCalendar()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddCalendar.do?masterData=Calendar&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Calendar for Holidays</h3>
<html:form styleId="myform1"   action="/AddCalendar"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Description :</td><td>Code:</td><td>Date:</td><td>Is National Holiday:</td></tr>



<logic:iterate name="CalendarList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="description"/>
</td>
<td>
<bean:write name="listMsgId" property="code"/>
</td>
<td>
<bean:write name="listMsgId" property="date"/>
</td>
<td>
<bean:write name="listMsgId" property="isNationalHoliday"/>
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
<td>Description:<html:text property="calender.description"/></td>
<td>Code:<html:text property="calender.code"/></td>
<td>Date:<html:text property="calenderdate"/></td>
<td>Is National Holiday:<html:text property="calender.isNationalHoliday"/></td>
<td><html:button value="Add Calendar" property="addCategoryButton" onclick="addNewCalendar()"/></td>
</tr>
</table>
</html:form>

</body>
</html>