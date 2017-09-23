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
	form1.action="/School/AddFormat.do?masterData=Format&delete="+gtype;
	form1.submit();
}

function addNewFormat()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddFormat.do?masterData=Format&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Format Types</h3>
<html:form styleId="myform1"   action="/AddFormat"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Format Types:</td></tr>



<logic:iterate name="FormatTypeList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="formatType"/>
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
<td>Exam Type:<html:text property="format.formatType"/></td>


<td><html:button value="Add Format" property="addCategoryButton" onclick="addNewFormat()"/></td>
</tr>
</table>
</html:form>

</body>
</html>