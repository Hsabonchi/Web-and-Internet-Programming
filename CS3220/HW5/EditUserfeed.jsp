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
<title>Edit UserFeedBack</title>
</head>
<body>






	<p>Edit your feedback:</p>
	<table border="1"  class="table table-bordered table-striped table-hover">
		<form action="" method="post">

			<tr>
			
				<td>Rating</td>
				<td><span> 1</span> <input type="radio" name="rate1" value="1">
					<input type="radio" name="rate2" value="2"> 
					<input type="radio" name="rate3" value="3"> 
					<input type="radio" name="rate4" value="4">
					 <input type="radio" name="rate5" value="5"> <span> 5</span></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${Userfeed.name}"></td>
			</tr>

			<tr>
				<td>Comments</td>
				<td><textarea name="comments"> ${Userfeed.message}</textarea></td>
			</tr>

			<tr>
				<td><button type="submit">submit</button></td>
			</tr>

		</form>
	</table>
	
	
	





</body>
</html>