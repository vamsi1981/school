<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function home_search()
{	
	
	var form=document.getElementById("home_searchwindow");
	alert(form);
	form.action="../../StudentServlet";
	form.submit();
}
function loadMenu()
{alert("test");
var ss= "${utype}";
alert(ss);
if(ss=='Student')
	{
	alert("my oh mty");
	
	}
	}
</script>
</head>
</html>