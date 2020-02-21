<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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