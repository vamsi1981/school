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
	var gtime= obj.childNodes[2].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddHelpSchoolInfo.do?masterData=HelpSchoolInfo&delete="+gtype+"&gtime="+gtime;
	form1.submit();
}

function addHelpSchoolInfo()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddHelpSchoolInfo.do?masterData=HelpSchoolInfo&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>General Info</h3>
<html:form styleId="myform1"   action="/AddHelpSchoolInfo"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>School Name:</td><td>School Id:</td><td>Info Created on Date:</td><td>About:</td></tr>



<logic:iterate name="HelpSchoolInfoList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="schoolName"/>
</td><td>
<bean:write name="listMsgId" property="id.schoolId"/>
</td>
<td>
<bean:write name="listMsgId" property="id.startDttm"/>
</td>
<td>
<bean:write name="listMsgId" property="about"/>
</td>
<td>
<bean:write name="listMsgId" property="remarks"/>
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
<td>School Id:<html:text property="helpSc.id.schoolId"/></td>
<td>School Name:<html:text property="helpSc.schoolName"/></td>
<td>School About:<html:text property="helpSc.about"/></td>
<td>School Remarks:<html:text property="helpSc.remarks"/></td>

<td><html:button value="Add HelpSchoolInfo" property="addCategoryButton" onclick="addHelpSchoolInfo()"/></td>
</tr>
</table>
</html:form>

</body>
</html>