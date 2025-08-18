<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String fname=request.getParameter("fn");
	String lname=request.getParameter("ln");

	session.setAttribute("fn",fname);
	session.setAttribute("ln",lname);
%>

<form method="post" action="./Page3.jsp">

Percentage : <input type="text" name="per" > <br> <br>
Grade      : <input type="text" name="gra" > <br> <br>

<input type="submit" value="Marksheet"> <br>
</form>

</body>
</html>