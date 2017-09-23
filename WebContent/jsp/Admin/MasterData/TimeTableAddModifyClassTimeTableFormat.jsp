<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="../../../css/jquery/jquery-ui.css" />
	<script src="../../../jquery/jquery-1.9.1.js"></script>
<script>
	


	function deleteTimeTable(obj) {
		var gtype = obj.childNodes[0].innerHTML;
		var gclassid = obj.childNodes[1].innerHTML;
		alert(gtype);
		alert(gclassid);
	}

	function loadPage(obj)

	{
		alert("load page time table add modify class time table format");
		//var gpid= obj.childNodes[0].innerHTML;
		var gtype = obj.childNodes[0].innerHTML;
		var gclassid = obj.childNodes[1].innerHTML;
		var form1 = document.getElementById("myform1");
		form1.action = "/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&delete=false&addModifyClassTimeTable=true&myclassId="
				+ gclassid;
		alert("vamsi");
		var passstring = "/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&delete=false&addModifyClassTimeTable=false&myclassId="
				+ gclassid;
		alert(passstring);

		//window.open("abc.html",600,600);
		
		//window.close();
		openwindowForAddEditView(passstring);

	}

	function modelesswin(url, mwidth, mheight) {
		if (document.all && window.print) { //if ie5

			eval('window.showModelessDialog(url,window,"help:0;resizable:1;dialogWidth:'+ mwidth + 'px;dialogHeight:' + mheight + 'px")');
			

		} else {

			eval('window.showModelessDialog(url,window,"width=' + mwidth+ 'px,height=' + mheight + 'px,resizable=1,scrollbars=1")');

		}
	}

	//configure URL and window dimensions (width/height)
	function openwindowForAddEditView(stringid) {
		modelesswin(stringid, 600, 600);
	}

	function addUpdateTimeTable()

	{
		alert("add");

		var form1 = document.getElementById("myform1");
		form1.action = "/School/AddUpdatecmnTimeTable.do?masterData=TimeTable&add=true";
		form1.submit();
	}
</script>
</head>
<body>

	<h3>Add TimeTable Screen2</h3>
	<html:form styleId="myform1" action="/AddUpdatecmnTimeTable"
		method="post">
		<table border="5" cellpadding="10" cellspacing="10" align="left">
			<tr>
				<td>Class Type:</td>
				<td><table border="5" cellpadding="5" cellspacing="5">
						<tr>
							<td>Section :</td>
							<td style="display: none">Class ID:</td>
							<td>Period-1:</td>
							<td>Period-2:</td>
							<td>Period-3:</td>
							<td>Period-4:</td>
							<td>Period-5:</td>
							<td>Period-6:</td>
							<td>Operation-6:</td>
						</tr>
					</table>
			</tr>
			<logic:iterate name="TimeTableList" id="listMsgId">
				<tr>
					<td><bean:write name="listMsgId" property="classType" />
					</td>
					<td>
						<table border="5" cellpadding="15" cellspacing="5">
							<logic:iterate name="listMsgId" id="listBean"
								property="referBean">
								<tr>
									<td><bean:write name="listBean" property="section" />
									</td>
									<td style="display: none"><bean:write name="listBean"
											property="classID" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod1" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod2" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod3" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod4" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod5" />
									</td>
									<td><bean:write name="listBean"
											property="subjectNameofPeriod6" />
									</td>
									<td><html:button property="deleteProperty"
											value="Show Detail"
											onclick="loadPage(this.parentNode.parentNode)" />
									</td>
								</tr>
							</logic:iterate>
						</table>
				<tr>

				</tr>
			</logic:iterate>
		</table>
		<logic:present name="messages">
			<table border="0" cellpadding="10" cellspacing="10" align="left">
				<tr>
					<td>Time Table Id:</td>
					<td>Time Table Schedule Type:</td>
					<td>Class Id:</td>
					<td>Period code:</td>
					<td>Subject Id:</td>
					<td>Teacher Id:</td>
				</tr>
				<logic:iterate name="BareTimeTableList" id="NewlistMsgId">
					<tr>
						<td><html:text name="NewlistMsgId" property="timeTableId"
								readonly="true" />
						</td>
						<td><html:text name="NewlistMsgId"
								property="timetableschedule.timetableType" readonly="true" />
						</td>
						<td><html:text name="NewlistMsgId"
								property="classlevel.classId" readonly="true" />
						</td>
						<td><html:text name="NewlistMsgId"
								property="period.periodCode" readonly="true" onclick="alert('hi')" />
						</td>
						<td><html:select name="NewlistMsgId"
								property="subject.subjectId" styleId="ptype" onchange="alert('hi')">
								<html:options collection="SubjectList"
									property="subject.subjectId"
									labelProperty="subject.subjectName"
									labelName="subject.subjectId"  />
							</html:select>
						</td>
						<td><html:select name="NewlistMsgId"
								property="teacherToSubject.id.personId" styleId="personType">
								<html:options collection="PersonList" property="person.id.id"
									labelProperty="person.name" labelName="person.id.id" />
							</html:select>
						</td>
						<td><html:button property="deleteProperty" value="Delete"
								onclick="deleteTimeTable(this.parentNode.parentNode)" />
						</td>
					</tr>
				</logic:iterate>
			</table>
		</logic:present>
		<table>
			<tr>
				<td>Time Table Schedule: <html:text
						property="timeTable.timetableschedule.timetableType"></html:text>
				</td>
				<td>Time Table Id: <html:text property="timeTable.timeTableId"></html:text>
				</td>
			</tr>
			<tr>
				<td>Class : <html:text property="timeTable.classlevel.classId"></html:text>
				</td>
				<td>Period: <html:text property="timeTable.period.periodCode"></html:text>
				</td>
			</tr>
			<tr>
				<td>Subject: <html:text property="timeTable.subject.subjectId"></html:text>
				</td>
				<td>Teacher : <html:text
						property="timeTable.teacherToSubject.id.personId"></html:text></td>
			</tr>
			<tr>
				<td><html:button value="Add/Update Time Table"
						property="addCategoryButton" onclick="addUpdateTimeTable()" /></td>
				<td></td>
			</tr>
		</table>
	</html:form>

</body>
</html>