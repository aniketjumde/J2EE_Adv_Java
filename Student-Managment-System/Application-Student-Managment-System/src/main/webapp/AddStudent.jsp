<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>


<div class="container  " style="width: 500px;">


<h1 class="text-center text-primary mt-5 mb-3"> Registration Form </h1>


<form method="POST" action="./addstudent">

	<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Roll No</label>
    <input type="text" name="rno" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>   
 	</div>

	<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>   
 	</div>

	<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Percentage</label>
    <input type="text" name="per" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>   
 	</div>

	
	<div class="d-grid gap-2">	
	<input type="submit" class="btn btn-primary" value="Save">
	</div>
			
</form>

 <p>${msg} </p>





</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</body>
</html>