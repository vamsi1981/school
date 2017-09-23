<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function test(id)
{
	var st =id.innerHTML;
	var kt =id.childNodes[0].childNodes[0].childNodes[0].childNodes[0].innerHTML;
	var mt =id.childNodes[0].childNodes[0].childNodes[0].childNodes[1].innerHTML;
	var ct =id.childNodes[0].childNodes[0].childNodes[0].childNodes[2].innerHTML;
	


var form1 = document.getElementById("myform1");
form1.action="TeacherDetail.do?id="+kt+"&type="+ct;
form1.submit();

}
</script>
</head>
<body bgcolor="Red"><h3>Teacher</h3>
<html:form styleId="myform1"  action="/TeacherDetail"  method="post" target="view_frame">
<logic:iterate id="mylist" name="lstForm" property="plist" >
<font color=blue><a onclick="test(this)"  id="ahref"  target="view_frame" >
<table>
<tr><td><bean:write  name="mylist" property="id.id"/></td>
<td><bean:write name="mylist" property="name"/></td>
<td><bean:write  name="mylist" property="id.personType"/></td></tr>
</table>
</a></font>
<br>
</logic:iterate>
</html:form>
</body>
</html>