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
	
	var gpid= obj.childNodes[1].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/StatusTypes.do?masterData=Status&delete=true&statusType="+gpid;
	//form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	form1.submit();
}

function addSpecialSubjects()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/StatusTypes.do?masterData=Status&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Status Types</h3>
<html:form styleId="myform1"   action="/StatusTypes"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Status Type:</td><td>Status Code :</td></tr>

<logic:iterate name="StatusTypesList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="statusType"/>
</td>
<td>
<bean:write name="listMsgId" property="statusCode"/>
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

<td>Status Description  :<html:text property="status.statusType"/></td>
<td>Status Type  :<html:text property="status.statusCode"/></td>


<td><html:button value="Add Special Subjecs" property="addCategoryButton" onclick="addSpecialSubjects()"/></td>
</tr>
</table>
</html:form>

</body>
</html>