<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Options</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    .options-box {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .option-link {
        display: block;
        margin-bottom: 10px;
        color: #007bff;
        text-decoration: none;
    }
    .option-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="options-box">
        <h1 style="color:green">{Welcome to Food app}</h1><br>
        <a href="addproduct" class="option-link">Add product</a>
        <a href="viewallproduct" class="option-link">View all Products</a>
    </div>
</body>
</html>
