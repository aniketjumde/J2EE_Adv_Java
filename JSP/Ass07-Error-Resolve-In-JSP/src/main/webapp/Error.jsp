<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<font color="red">

<%
	String message="";

	if(exception instanceof NumberFormatException)
	{
		message="Given Input for Conversition is String !!!";
	}
	
	if(exception instanceof ArrayIndexOutOfBoundsException)
	{
		message="Array Index is not in range";
	}
	
%>

<%=
	message
%>

</font>

</body>
</html>