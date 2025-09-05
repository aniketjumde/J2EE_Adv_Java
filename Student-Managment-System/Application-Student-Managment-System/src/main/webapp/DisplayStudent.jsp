<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*  , com.tca.entities.*" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Display Inforamtion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  </head>
 
<body>

<div class="container">

<h1 class="text-center text-primary mt-5 mb-3"> Student Information </h1>

<div class="container-fluid d-flex justify-content-end">
	
	<form class="d-flex  mb-4" role="search" method="GET" action="./display">
		<input class="form-control me-3" type="search" name="srno" placeholder="Search Here">
		<input class="btn btn-outline-success me-3" type="submit" name="sbtn" value="Search">
		<input class="btn btn-outline-success" type="submit" name="sbtn" value="Refresh">		
	</form>
</div>

	
<table class="table table-hover table-bordered text-center">

<thead >
	<tr class="table-primary">
		<th> RNO </th> <th> NAME</th> <th>PER</th>
	</tr>
</thead>
<%
	List<Student> L = (List<Student>) request.getAttribute("students");

	if(L==null || L.isEmpty())
	{
%>
		<tr>
			<td class ="text-danger bg-danger-subtle" colspan="3"> No Data Found !!! </td>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>