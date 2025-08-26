<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: url('https://images.unsplash.com/photo-1523580846011-d3a5bc25702b') no-repeat center center fixed;
        background-size: cover;
        font-family: 'Segoe UI', sans-serif;
    }
    .form-container {
        background: rgba(255, 255, 255, 0.9);
        border-radius: 20px;
        padding: 30px;
        margin-top: 50px;
        box-shadow: 0px 4px 15px rgba(0,0,0,0.3);
    }
    .form-container h1 {
        font-weight: bold;
    }
    .form-img {
        max-width: 150px;
        margin: 0 auto 20px;
        display: block;
    }
    .btn-primary {
        border-radius: 50px;
        font-weight: bold;
        transition: 0.3s;
    }
    .btn-primary:hover {
        background-color: #004080;
        transform: scale(1.05);
    }
    p {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>

<div class="container" style="max-width: 600px;">
    <div class="form-container">
        
        <!-- Student Icon Image -->
        <img src="https://cdn-icons-png.flaticon.com/512/3135/3135755.png" alt="Student Icon" class="form-img">

        <h1 class="text-center text-primary">Student Registration</h1>
        
        <form method="POST" action="./addstudent">
        
            <div class="mb-3">
                <label class="form-label">Roll No</label>
                <input type="text" name="rno" class="form-control" required>   
            </div>
        
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>   
            </div>
        
            <div class="mb-3">
                <label class="form-label">Percentage</label>
                <input type="text" name="per" class="form-control" required>   
            </div>
        
            <div class="d-grid gap-2">    
                <input type="submit" class="btn btn-primary" value="Save">
            </div>
                    
        </form>
        
        <!-- Message -->
        <p class="text-center">${msg}</p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
