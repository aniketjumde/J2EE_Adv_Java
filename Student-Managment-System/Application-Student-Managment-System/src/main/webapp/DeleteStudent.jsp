<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*, com.tca.entities.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Delete Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script type="text/javascript">
    
    		function del(srno)
    		{
    			var status = confirm("Do you want to delete Student for Roll Number : " + srno);
    			
    			if(status==true)
    			{
    				// call a DeleteServlet with rno as trno=101 with REQUEST_METHOD = POST
    				// collect status[success, failed] from servlet
    				
    				// suceess --> show delete message
    				// failed  --> failure message
    				
    				fetch("http://localhost:8080/Application-Student-Managment-System/delete", 
    						{
    							method :'POST',
    							body   : new URLSearchParams({'trno':srno})
    						}
    				)
    				.then(response => response.text())
    				.then(data  => 
    							{
    								if(data.trim() == "Success")
    								{
    									//alert("Record is Deleted for Roll Number :" + srno);
    									swal("Deleted Successfully !!", "Record is Deleted for Roll Number :" + srno, "success");

    									var tr = document.getElementById(srno);
    				    					tr.remove();
    								}
    								if(data.trim()=="failed")
    								{
    									//alert("Failed to Delete Record for Roll Number :" + srno);
    									swal("Failed to Delete!", "Failed to Delete Record for Roll Number :" + srno, "error");

    								}
    							}
    				)
    				.catch( error => console.error("MyError while Deleting Rollnumber =" + srno));
    					
    			}
    			else
    			{
    				alert("Delete Skipped !!");
    			}
    		}
    	
    </script>
    
    
    
    
  </head>
<body>

<div class="container">

<h2 class="text-center text-primary mt-5 mb-3"> Student Information </h2>

<div class="d-flex justify-content-end">
	
	<form class="d-flex  mb-4" role="search" method="GET" action="./delete">
		<input class="form-control me-3" type="search" name="srno" placeholder="Search Here">
		<input class="btn btn-outline-success me-3" type="submit" name="sbtn" value="Search">
		<input class="btn btn-outline-success" type="submit" name="sbtn" value="Refresh">		
	</form>
</div>

<table class="table table-hover table-bordered text-center" >
<thead >
	<tr class="table-primary">
		<th> RNO </th> <th> NAME</th> <th>PER</th> <th> ACTION</th>
	</tr>
</thead>

<%
	List<Student> L = (List<Student>) request.getAttribute("students");
	
	if(L==null || L.isEmpty())
	{
%>
		<tr>
			<td class ="text-danger bg-danger-subtle" colspan="4"> No Data Found !!! </td>
		</tr>
<% 
	}
	else
	{

		for( Student s : L)
		{
%>
			<tr id="<%= s.getRno()  %>">
			
				<td> <%= s.getRno()  %>  </td>
				<td> <%= s.getName() %> </td>
				<td> <%= s.getPer()  %> </td>
				<td>
					<button type="button" class="btn btn-danger" onclick="del(<%= s.getRno()  %>)" >Delete</button>
				</td>
			</tr>
<% 		
		}
	}//else

%>
</table>


</div>  <!-- end of container tag -->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>