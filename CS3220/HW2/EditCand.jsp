<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="form-group">
	<form  action="Edit"  method="post">
	      
		     <label > id   :</label> <input  readonly type='text'   value="${c.id}"                 style='margin-right:30px' ><br>
			 <label > Name:</label> <input    type='text'           value="${c.name}"             style='margin-right:30px'   name="name"><br>
			 <label > Specialties:</label> <input    type='text'    value="${c.specialties}"      style='margin-right:30px'   name="specialties"><br>
			 <label > Presentation:</label> <input    type='text'   value="${c.presentation}"     style='margin-right:30px'   name="presentation"><br>
	 	   <button class="btn btn-default"> Add</button>
	 	 
	</form>

</div>
</body>
</html>