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

<form action="CurrencyConverter" method="post">
		<input type="text"  name="amount">
		<!-- Returns a Set view of the keys contained in this map -->
		<select name="c1">
			<c:forEach items="${data.keySet()}" var="c"> 
			<option>${c}</option>
		
		
		</c:forEach>
		</select>=?
			
		<select name="c2">
			<c:forEach items="${data.keySet()}" var="c"> 
			<option>${c}</option>
		
		
		</c:forEach>
		</select>
		
		<button name ="convert"> Submit </button>

</form>
</body>
</html>