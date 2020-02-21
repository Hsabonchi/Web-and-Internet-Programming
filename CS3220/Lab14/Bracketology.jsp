<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Team" method="post">

		<c:forEach items="${Teams}" var="Teams" varStatus="i" >
		
		<p>

		<span>  Match ${i.index+1}</span>  
		<label> ${Teams.team1}</label> <input type="radio" name="Match${Teams.id}" value="${Teams.team1}"/> 
		<label> ${Teams.team2}</label> <input type="radio" name="Match${Teams.id}" value="${Teams.team2}" >
		
		</p>
		
				
		</c:forEach>
		<button >Next</button>
</form>

</body>
</html>