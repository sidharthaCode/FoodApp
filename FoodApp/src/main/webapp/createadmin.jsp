<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Admin page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    .form-box {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: block;
        font-weight: bold;
    }
    .form-group input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .submit-button {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    .submit-button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="form-box">
        <h2>Create Admin</h2>
        <form:form action="saveadmin" modelAttribute="admin">
            <div class="form-group">
                <label for="name">Enter name:</label>
                <form:input path="name" id="name"/>
            </div>
            <div class="form-group">
                <label for="email">Enter email:</label>
                <form:input path="email" id="email"/>
            </div>
            <div class="form-group">
                <label for="password">Enter password:</label>
                <form:input type="password" path="password" id="password"/>
            </div>
            <button type="submit" class="submit-button">Submit</button>
        </form:form>
    </div>
</body>
</html>
