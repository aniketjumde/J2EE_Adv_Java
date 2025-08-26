<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	int visited=0;  
	// In this tag declare Data Type is Created on jspServiec.java  and Get Created on  Data Member 
%>

<%
	visited++;
// In this tag declare Data Type is Created on jspServiec.java  and Get Created on local varible

%>

<h1>Visited Count : <%=visited %></h1>
</body>
</html>