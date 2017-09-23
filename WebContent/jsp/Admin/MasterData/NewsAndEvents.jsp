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

{   var gtschoolid= obj.childNodes[0].innerHTML;
	var gtype= obj.childNodes[1].innerHTML;
	var gtime= obj.childNodes[2].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddNewsAndEvents.do?masterData=NewsAndEvents&delete=true&gschoolid="+gtschoolid+"&gtype="+gtype+"&gtime="+gtime;
	form1.submit();
}

function addNewNewsAndEvent()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddNewsAndEvents.do?masterData=NewsAndEvents&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>News And Events</h3>
<html:form styleId="myform1"   action="/AddNewsAndEvents"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>School ID :</td><td>Event Type:</td><td>Event Created Date:</td></tr>



<logic:iterate name="NewsAndEventsList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="id.schoolId"/>
</td>
<td>
<bean:write name="listMsgId" property="id.eventType"/>
</td>
<td>
<bean:write name="listMsgId" property="id.startDttm"/>
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

<td>School ID:<html:text property="newsAndEvents.id.schoolId"/></td>
<td>Event Type :<html:text property="newsAndEvents.id.eventType"/></td>
<td>Start Date:<html:text property="newsAndEventsStartDate"/></td>
<td><html:button value="Add News Events" property="addCategoryButton" onclick="addNewNewsAndEvent()"/></td>
</tr>
</table>
</html:form>

</body>
</html>