<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	


	if(uname.equals("Aniket") && pwd.equals("tca"))
	{
		out.println("<h2>Login Succesfully .!!!</h2>");
		//Redirect to the third page
		//response.sendRedirect("https://development.technocompacademy.com/");
		
		RequestDispatcher rd=request.getRequestDispatcher("https://development.technocompacademy.com/");
		rd.forward(request,response);
	}
	
	else
	{
		out.println("<h2>Login Failed !!! </h2>");
	}

%>
</body>
</html>