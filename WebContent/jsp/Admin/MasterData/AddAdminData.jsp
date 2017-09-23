<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../../../jquery/jquery-1.9.1.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.js"></script>
<script src="../../../jquery/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../css/jquery/jquery-ui.css"/>
<script>
function loadPage()
{
	var form1 = document.getElementById("myform1");
	form1.action="../../../AddStudent.do";
	form1.submit();
}
$(function ()
{
	$("#rdS").datepicker();
	$("#dojS").datepicker();
});
</script>
</head>
<body><h3>Add Admin Data</h3>
<html:form styleId="myform1"   action="/AddStudent"  method="post">
<table border="0" cellpadding="10" cellspacing="10" align="left">
<tr>
<td><a href="/School/AddCalendar.do?masterData=Calendar">Add Holidays</a></td>
<td><a href="/School/AddCategories.do?masterData=Category">Add Category</a></td>
<td><a href="/School/AddClassAndSections.do?masterData=ClassSections">Add Class/Sections</a></td>
<td><a href="/School/AddComplexity.do?masterData=Complexity">Add Complexity</a></td>
<td><a href="/School/AddEvent.do?masterData=Event">Add Events</a></td>
<td><a href="/School/AddExam.do?masterData=Exam">Add Exam</a></td>
</tr>

<tr>
<td><a href="/School/AddFormat.do?masterData=Format">Add Formats</a></td>
<td><a href="/School/AddGeneralInfo.do?masterData=GeneralInfo">Add General Info</a></td>
<td><a href="/School/AddGrades.do?masterData=Grades">Add Grades</a></td>
<td><a href="/School/AddGraphs.do?masterData=Graphs">Add Graphs</a></td>
<td><a href="/School/AddGroupTypes.do?masterData=GroupTypes">Add GroupTypes</a></td>
<td><a href="/School/AddGuardian.do?masterData=Guardian">Add Guardian</a></td>
</tr>

<tr>
<td><a href="/School/AddHelpSchoolInfo.do?masterData=HelpSchoolInfo">Add School Info</a></td>
<td><a href="/School/AddNewsAndEvents.do?masterData=NewsAndEvents">Add News/Events</a></td>
<td><a href="/School/AddNonNativeStudent.do?masterData=NonNativeStudent">Add Non-Native Student</a></td>
<td><a href="/School/AddPeriodTypes.do?masterData=PeriodTypes">Add Periods</a></td>
<td><a href="/School/AddPersonGroup.do?masterData=PersonGroup">Add Person Group</a></td>
<td><a href="/School/SpecialSubjects.do?masterData=SpecialSubject">Add Special Subject</a></td>
</tr>

<tr>
<td><a href="/School/StatusTypes.do?masterData=Status">Add Status</a></td>
<td><a href="/School/SubTopics.do?masterData=SubTopics">Add SubTopics</a></td>
<td><a href="/School/TestTopics.do?masterData=TestTopics">Add Test Topics</a></td>
<td><a href="/School/Subject.do?masterData=Subject">Add Subjects</a></td>
<td><a href="/School/TaskTypes.do?masterData=Task">Add Tasks</a></td>
<td><a href="/School/AddExamSchedule.do?masterData=ExamSchedule">Add Exam Schedule</a></td>
</tr>

<tr>
<td><a href="/School/StatusTypes.do?masterData=Status">Add Focus Areas</a></td>
<td><a href="/School/SubTopics.do?masterData=SubTopics">Add Student I/Q Assessment</a></td>
<td><a href="/School/TestTopics.do?masterData=TestTopics">Add Student I/Q Test</a></td>
<td><a href="/School/AddUpdatecmnTimeTable.do?masterData=TimeTable">Add Student Group</a></td>
<td><a href="/School/AddTeacherToSubject.do?masterData=TeacherToSubject">Add Teacher to Subject</a></td>
<td><a href="/School/AddUpdateTimeTable.do?masterData=TimeTable">Add Time Table</a></td>
</tr>


</table>
</html:form>
</body>
</html>