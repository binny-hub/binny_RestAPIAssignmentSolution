<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
 <h1>Employee Management</h1>
 
 <ul>
 <c:forEach items= "${employee}" var = "employee">
   <li> ${employee}</li>
   
   </c:forEach>
 </ul>

</body>
</html>