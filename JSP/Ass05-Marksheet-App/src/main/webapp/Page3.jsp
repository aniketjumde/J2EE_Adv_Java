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
	String fname=(String)session.getAttribute("fn");
	String lname=(String)session.getAttribute("ln");
	session.invalidate();
	
	String per=request.getParameter("per");
	String gra=request.getParameter("gra");
	
	/*
	out.println("First Name : "+fname+" <br>");     this is used in Servlet
	out.println("Last  Name : "+lname+" <br>");
	out.println("Percentage : "+per+"<br>");
	out.println("Grade      : "+gra);
	*/

%>
<h1>MarkSheet</h1>
<hr>

First Name : <%=fname %>  <br><%-- Expression Tag. --%>
Last  Name : <%=lname %>  <br>
Percentage : <%=per %>	<br>
Grade      : <%=gra %><br>
Time : <%= new java.util.Date() %><br>

</body>
</html>