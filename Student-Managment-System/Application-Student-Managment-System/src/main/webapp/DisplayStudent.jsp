<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*  , com.tca.entities.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Student Information </h1>

<table border="1">

<tr>
	<th>RNO</th> <th>Name</th> <th> Per </th>
</tr>
<%
	List<Student> L = (List<Student>) request.getAttribute("students");

	if(L.isEmpty())
	{
%>
		<tr>
			<td colspan="3"> No Data Found !!! </td>
		</tr>
<% 
	}
	else
	{	
	
		for(Student s : L)
		{
%>
		<tr>
				<td> <%= s.getRno() %></td>
				<td> <%= s.getName() %> </td>
				<td> <%= s.getPer() %> </td>
	
		</tr>	
<%		
		}
	}
%>


</table>


</body>
</html>