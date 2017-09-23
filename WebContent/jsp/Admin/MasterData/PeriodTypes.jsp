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
	form1.action="/School/AddPeriodTypes.do?masterData=PeriodTypes&delete=true&gtype="+gtype;
	form1.submit();
}

function addPeriods()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddPeriodTypes.do?masterData=PeriodTypes&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Period Types</h3>
<html:form styleId="myform1"   action="/AddPeriodTypes"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Period Code :</td><td>Start Time:</td><td>End Time: </td></tr>



<logic:iterate name="PeriodTypesList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="periodCode"/>
</td>
<td>
<bean:write name="listMsgId" property="startTime"/>
</td>
<td>
<bean:write name="listMsgId" property="endTime"/>
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

<td>Period Code :<html:text property="period.periodCode"/></td><td></td></tr>
<tr><td>StartTime Hours :<html:text property="periodStartTimeHours" size="5"/> StartTime Minutes:<html:text property="periodStartTimeMinutes" size="5"/></td></tr>
<tr><td>EndTime Hours:<html:text property="periodEndTimeHours" size="5"/> EndTime Minutes :<html:text property="periodEndTimeMinutes" size="5"/></td></tr>

<tr><td><html:button value="Add News Events" property="addCategoryButton" onclick="addPeriods()"/></td>
</tr>
</table>
</html:form>

</body>
</html>