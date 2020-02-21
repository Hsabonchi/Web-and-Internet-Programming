<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</head>
<body>

<p> addCandidate </p>
<div class="form-group">
<form  action="AddCandidate"  method="post">
   
		<label > Name:</label> <input    type='text'            style='margin-right:30px'   name="name"> <br>
		 <label > Specialties:</label> <input    type='text'    style='margin-right:30px'   name="specialties"> <br>
		 <label > Presentation:</label> <input    type='text'    style='margin-right:30px'  name="presentation"><br>
	 	<button class="btn btn-default"> Add</button>
 	
</form>
</div>
</body>
</html>