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
	var grouptype= obj.childNodes[2].innerHTML;
	alert(gtschoolid+"   "+gtype+"  "+grouptype);
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&delete=true&gpersonid="+gtschoolid+"&personType="+gtype+"&personGroupId="+grouptype;
	//form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	form1.submit();
}

function addNewPersonGroup()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Person Group</h3>
<html:form styleId="myform1"   action="/AddPersonGroup"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Person ID :</td><td>Person Type:</td><td>Group :</td><td>Date Created</td></tr>

<logic:iterate name="PersonGroupList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="id.personId"/>
</td>
<td>
<bean:write name="listMsgId" property="id.personType"/>
</td>
<td>
<bean:write name="listMsgId" property="id.groupType"/>
</td>
<td>
<bean:write name="listMsgId" property="date"/>
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

<td>Person Id :<html:text property="personGroup.id.personId"/></td>
<td>Person type :<html:text property="personGroup.id.personType"/></td>
<td>Group :<html:text property="personGroup.id.groupType"/></td>
<td>Date :<html:text property="personGroupDate"/></td>
<td><html:button value="Add Person Groups" property="addCategoryButton" onclick="addNewPersonGroup()"/></td>
</tr>
</table>
</html:form>

</body>
</html>