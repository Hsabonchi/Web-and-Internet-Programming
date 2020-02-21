<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" class="table table-bordered table-striped table-hover">
	<tr> <th>id</th>  <th>name</th>  <th> Specialties</th>  <th> Specialties</th>  <th>Operation </th> </tr>

<!-- items="${list}"   -->
     <c:forEach items="${candidates}" var="candidates"> 
	   <tr>  
	   <td>${candidates.id}</td>  
	   <td>${candidates.name}</td>   
	   <td>${candidates.specialties}</td>    
	   <td> ${candidates.presentation}</td> 
	    <td> <a href="Edit?id=${candidates.id}"> edit </a></td>
	   </tr>
		
</c:forEach>
</table>
<p><a href="AddCandidate"> ADD candidates</a> </p>


</body>
</html>