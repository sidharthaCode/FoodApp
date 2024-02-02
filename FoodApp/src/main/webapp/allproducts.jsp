<%@page import="com.sid.foodapp.enities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Products</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    a {
        color: #007bff;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    .logout-button {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
    }
    .logout-button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<% List<Product> products=(List) request.getAttribute("productslist"); %>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>type</th>
            <th>cost</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody>
        <%
        for(Product p:products){
        %>
        <tr>
            <td><%=p.getId() %></td>
            <td><%=p.getName() %></td>
            <td><%=p.getType() %></td>
            <td><%=p.getCost() %></td>
            <td><a href="editproduct?id=<%=p.getId()%>">edit</a></td>
            <td><a href="deleteproducts?id=<%=p.getId()%>">delete</a></td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>

<button class="logout-button" onclick="location.href='Adminmenu.jsp';">Logout</button>

</body>
</html>

