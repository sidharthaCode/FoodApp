<%@page import="com.sid.foodapp.enities.Product"%>
<%@page import="org.springframework.web.bind.annotation.RequestAttribute"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>

<%  Product product=(Product)request.getAttribute("productdata") ;%>

<form action="updateprod" method="post">
     Enter the id: <input type="number" name="id" value=<%=product.getId() %> readonly="true"> <br>
     Enter name:<input type="text" name="name" value=<%=product.getName() %>> <br>
     Enter type:<input type="text" name="type" value=<%=product.getType()%>> <br>
     Enter Cost:<input type="number" name="cost" value=<%=product.getCost()%>> <br>
      
      <input type="submit">
     
    

</form>

</body>
</html>