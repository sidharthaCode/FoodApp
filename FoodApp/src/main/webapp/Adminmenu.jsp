<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            text-align: center;
        }
        .option {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .option:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <!-- Header content goes here -->
        <h1>Welcome to the Admin Panel</h1>
    </header>
    <div class="container">
        <p>Please select an option:</p>
        <a href="addadmin" class="option">Create Account</a>
        <a href="loginadmin.jsp" class="option">Login</a>
    </div>
    <footer>
        <!-- Footer content goes here -->
        <p>&copy; 2024 YourCompany. All rights reserved.</p>
    </footer>
</body>
</html>


