<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Addition of two Number </h1>
	<hr>
	
	<%
		String fnum=request.getParameter("num1");
		String snum=request.getParameter("num2");
		int num1=Integer.parseInt(fnum);
		int num2=Integer.parseInt(snum);
		int sum=num1+num2;
		
		out.println("Sum : "+sum);
	%>

</body>
</html>