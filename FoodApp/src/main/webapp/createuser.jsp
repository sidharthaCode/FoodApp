<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="saveuser"  modelAttribute="user">

Enter name: <form:input path="name"/><br>

Enter email: <form:input path="email"/><br>
 Enter password: <form:input type="password" path="password"/><br>
 Enter mobilenumber:<form:input path="mobilenumber"/>
 
   
   <input type="submit">
   
   </form:form>

</body>
</html>