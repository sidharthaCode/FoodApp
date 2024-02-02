<%@page import="com.sid.foodapp.enities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products to order</title>
</head>
<body>

<% List<Product> product=(List) request.getAttribute("productslist"); 
%>
<table cellPadding="20px" border="1">
       <th>id</th>
        <th>name</th>
        <th>type</th>
     <th>cost</th>
      <th>addItem</th>

<%
    for(Product p:product){
 %>
<tr>

     <td><%=p.getId() %> </td>
     <td><%=p.getName() %> </td>
     <td><%=p.getType() %> </td>
     <td><%=p.getCost() %> </td>
     
     <td>  <a href="additem?id=<%=p.getId()%>">add</a> </td>
     
      
      </tr>
	
	<%
	}
	
	
	%>
	



</table>

<h1>

<a href="submitfoodorder">submit Order</a>
 
 </h1>
<br>

</body>
</html>