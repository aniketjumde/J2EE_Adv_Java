<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Home Page</h1>
	<hr>
	
	<%
		String un=request.getParameter("uname");
		String msg="";
		Date d=new Date();
		int hr=d.getHours();
		
		if(hr<12)
		{
			msg="Good Morning";
		}
		else if(hr<17)
		{
			msg="Good Afternoon";
		}
		else
		{
			msg="Good Evening";
		}
		
		out.println(msg+" "+un);
	%>


</body>
</html>