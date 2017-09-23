<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="Login_Script.jsp" %>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
<br><br>
<form name="form1" method="post" id="form1" target="_parent" onsubmit="login()">
<table border="0" cellpadding="10" cellspacing="10" align="center">
<tr> 
<td style="font-family: fantasy;font-style: oblique;font-size: x-large;">UserName:</td><td><input type="text" name="uname" id="uname" maxlength="12"/></td></tr>
<tr>
<td style="font-family: fantasy;font-style: oblique;font-size: x-large;">PassWord:</td><td><input type="password" name="pwd" id="pwd"/></td>
</tr>
<tr>
<td style="font-family: fantasy;font-style: oblique;font-size: x-large;">User Type:</td>
<td>
<select name="u_type">
<option value="">Select Type of User</option>
<option value="Student">STUDENT</option>
<option value="Teacher">TEACHER</option>
<option value="Admin">ADMIN</option>
</select></td>
</tr>
<tr><td></td><td><input type="hidden" name="hid" value="hid1"/><input type="submit" value="SUBMIT"/></td></tr>
</table>
</form>
</body>
</html>