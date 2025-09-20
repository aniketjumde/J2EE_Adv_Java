<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agriculture Registration</title>
    <link rel="stylesheet" href="register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    background: url(asest/registerbg.jpg);
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding: 20px;
}

.register-container {
    background: #fff;
    padding: 25px;
    border-radius: 15px;
    box-shadow: 0 8px 25px rgba(0,0,0,0.3);
    max-width: 420px;
    width: 100%;
    text-align: center;
    animation: fadeIn 1s ease-in-out;
    border-top: 5px solid #4CAF50;
}

@keyframes fadeIn {
    from {opacity: 0; transform: translateY(-20px);}
    to {opacity: 1; transform: translateY(0);}
}

h2 {
    color: #2E7D32;
    margin-bottom: 20px;
    font-weight: 600;
}

.input-group {
    position: relative;
    margin-bottom: 20px;
}

.input-group input {
    width: 100%;
    padding: 12px 40px 12px 15px;
    border-radius: 8px;
    border: 1px solid #ccc;
    outline: none;
    transition: 0.3s;
    background: #f9f9f9;
}

.input-group input:focus {
    border-color: #4CAF50;
    box-shadow: 0 0 10px rgba(76, 175, 80, 0.5);
    background: #fff;
}

.input-group i {
    position: absolute;
    right: 15px;
    top: 50%;
    transform: translateY(-50%);
    color: #4CAF50;
    font-size: 16px;
}

button {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 8px;
    background: linear-gradient(to right, #4CAF50, #388E3C);
    color: white;
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background: linear-gradient(to right, #43A047, #2E7D32);
    transform: scale(1.02);
}

p {
    margin-top: 15px;
    font-size: 14px;
}

p a {
    color: #2E7D32;
    text-decoration: none;
    font-weight: bold;
}

p a:hover {
    text-decoration: underline;
}</style>
</head>
<body>

<div class="register-container">
    <h2>🌱 Agriculture Registration</h2>
    <form method="POST" action="./RegisterServlet">
    
        <div class="input-group">
            <input type="text" placeholder="Full Name" required>
            <i class="fa fa-user"></i>
        </div>
        <div class="input-group">
            <input type="email" placeholder="Email Address" required>
            <i class="fa fa-envelope"></i>
        </div>
        <div class="input-group">
            <input type="text" placeholder="Mobile Number" required>
            <i class="fa fa-phone"></i>
        </div>
        <div class="input-group">
            <input type="password" placeholder="Password" required>
            <i class="fa fa-lock"></i>
        </div>
        <div class="input-group">
            <input type="password" placeholder="Confirm Password" required>
            <i class="fa fa-lock"></i>
        </div>
        <button type="submit">Register</button>
    </form>
    <p>Already have an account? <a href="login.jsp">Login</a></p>
</div>

</body>
</html>