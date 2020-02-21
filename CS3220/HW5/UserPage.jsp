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


<br>   
<br> 
		<c:choose>
					         
					         <c:when test ="${not empty username}">
					         				<p><a href="LogOutServ">Logout</a></p>
					             
					         </c:when>
					        
					         
					         <c:otherwise>
					         
					         
					         <form action="mainLogin" method="post">		  
									  <div class="form-row">
										    <div class="form-group col-md-4">
										      <label for="inputEmail4">Name</label>
										      <input type="email" class="form-control" id="inputEmail4" placeholder="Username" name="name">
										    </div>
										    <div class="form-group col-md-4">
										      <label for="inputPassword4">Password</label>
										      <input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="passwd">
										    </div>
										     
										  </div>
									        <button class="ml-6">Login</button> 
									 
									
									</form>
														         					        									
					         </c:otherwise>
					      </c:choose>
	  	







  

<br>
<br>   
<br> 









<table border="1" class="table table-bordered table-striped table-hover">
	<tr> <th>id</th>  <th>Name</th>  <th> Specialties</th>  <th> Presentation</th> <th>Rating</th> <th>Operation </th> </tr>

<!-- items="${list}"   -->
 <c:forEach items="${candidates}" var="candidates" varStatus="loop"> 
 
		
  
	   <tr>  
	   <td>${candidates.id}</td>  
	   <td><a href="DisplayFeedback?id=${candidates.id}"> ${candidates.name}</a></td>   
	   <td>${candidates.specialties}</td>    
	   <td> ${candidates.presentation}</td> 
	 
 
              

	  			
	  	<td>        
	  		
						  	<c:choose>
					         
					         <c:when test ="${AvgRate[loop.index]>0}">
					               <fmt:formatNumber value="${AvgRate[loop.index]}" type="number" pattern="###.##" /><br> 
					         </c:when>
					        
					         
					         <c:otherwise>
					        
					           N/A
					           
					         </c:otherwise>
					      </c:choose>
	  	
	  	
	  	
	  	
	  	
	  	
	  	       
	 		         
	         </td> 
	         
	    
	         <c:choose>
					    <c:when test="${admin==1}">
					    
					      <td> <a href="Edit?id=${candidates.id}"> edit </a></td>
					    </c:when>
					    
					    <c:otherwise>
					        
					        
					        <td> </td>
					    </c:otherwise>
					</c:choose>
	         
	    
			
		   <%--  <td> <a href="Edit?id=${candidates.id}"> edit </a></td> --%>
		
		   
	 </c:forEach> 
		   </tr>
		   

		



 
</table>




	<c:choose>
					    <c:when test="${admin==1}">
					    
					     <p><a href="AddCandidate"> ADD candidates</a> </p> 
					    </c:when>
					    
					    <c:otherwise>
					        
					 
					    </c:otherwise>
					</c:choose>
	         







</body>
</html>