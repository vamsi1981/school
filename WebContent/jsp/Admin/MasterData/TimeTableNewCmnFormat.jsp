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
	var gclassid= obj.childNodes[1].innerHTML;
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&delete=true&gtype="+gtype;
	alert("krishna");
	alert(gtype);
	alert(gclassid);
	openwindowForAddEditView(gclassid);
	//form1.action="/School/AddPersonGroup.do?masterData=PersonGroup&add=true";
	//form1.submit();
}


function modelesswin(url,mwidth,mheight){
	if (document.all&&window.print) //if ie5
	eval('window.showModelessDialog(url,"","help:0;resizable:1;dialogWidth:'+mwidth+'px;dialogHeight:'+mheight+'px")')
	else
	eval('window.showModelessDialog(url,"","width='+mwidth+'px,height='+mheight+'px,resizable=1,scrollbars=1")')
	}

	//configure URL and window dimensions (width/height)
	function openwindowForAddEditView(classid)
	{
	modelesswin("/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&myclassId="+classid,600,600);
	}

function addUpdateTimeTable()

{
	alert("add");
	
	var form1 = document.getElementById("myform1");
	form1.action="/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&add=true";
	form1.submit();
}

</script>
</head>
<body><h3>Add TimeTable Screen1 </h3>
<html:form styleId="myform1"   action="/AddUpdatecmnTimeTable"  method="post">
<table border="5" cellpadding="10" cellspacing="10" align="left">
<tr>
<td>Class Type:</td><td><table border="5" cellpadding="5" cellspacing="5"><tr><td>Section :</td><td style="display:none">Class ID:</td><td>Period-1:</td><td>Period-2:</td><td>Period-3:</td><td>Period-4:</td><td>Period-5:</td><td>Period-6:</td><td>Operation-6:</td></tr></table></tr>
<logic:iterate name="TimeTableList" id="listMsgId" >
<tr>
<td>
<bean:write name="listMsgId" property="classType"/>
</td>
<td>
<table border="5" cellpadding="15" cellspacing="5">
<logic:iterate name="listMsgId" id="listBean" property="referBean">
<tr><td>
<bean:write name="listBean" property="section"/>
</td><td style="display:none">
<bean:write name="listBean" property="classID"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod1"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod2"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod3"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod4"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod5"/>
</td><td>
<bean:write name="listBean" property="subjectNameofPeriod6"/>
</td>
<td>
<html:button property="deleteProperty" value="Delete" onclick="loadPage(this.parentNode.parentNode)"/>
</td></tr>
</logic:iterate>
</table>
<tr>

</tr>
</logic:iterate>
</table>

<table>
<tr><td>Time Table Schedule: <html:text property="timeTable.timetableschedule.timetableType"></html:text></td><td>Time Table Id: <html:text property="timeTable.timeTableId"></html:text></td></tr>
<tr><td>Class : <html:text property="timeTable.classlevel.classId"></html:text></td><td>Period: <html:text property="timeTable.period.periodCode"></html:text></td></tr>
<tr><td>Subject: <html:text property="timeTable.subject.subjectId"></html:text></td><td>Teacher : <html:text property="timeTable.teacherToSubject.id.personId"></html:text></td></tr>
<tr><td><html:button value="Add/Update Time Table" property="addCategoryButton" onclick="addUpdateTimeTable()"/></td><td></td></tr>
</table>
</html:form>

</body>
</html>