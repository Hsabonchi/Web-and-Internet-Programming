<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<tr> <th>id</th>  <th>Name</th>  <th> Specialties</th>  <th> Presentation</th> <th>Rating</th>  <th>Operation </th> </tr>

<!-- items="${list}"   -->
     <c:forEach items="${candidates}" var="candidates"> 
	   <tr>  
	   <td>${candidates.id}</td>  
	   <td><a href="DisplayFeedback?id=${candidates.id}"> ${candidates.name}</a></td>   
	   <td>${candidates.specialties}</td>    
	   <td> ${candidates.presentation}</td> 
	   <td>
  
              
  				<c:if test="${candidates.getRating()==0}">
  						N/A
  						
  						</c:if>
		 
		 
		 
		 				<c:if test="${candidates.getRating()>0}">
  						<fmt:formatNumber value="${candidates.getRating()}" pattern="0.##" />
  						
  						</c:if>
						
		
		   
		   
         </td>
		
	    <td> <a href="Edit?id=${candidates.id}"> edit </a></td>
	   </tr>
		  </c:forEach>

</table>
<p><a href="AddCandidate"> ADD candidates</a> </p>


</body>
</html>