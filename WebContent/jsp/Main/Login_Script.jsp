<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function login()
{
	var form=document.getElementById("form1");
	form.action="../../Login_Servlet";
	form.submit();
}
</script>
</head>
</html>