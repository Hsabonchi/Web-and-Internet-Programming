<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- name of the parent folder -->
<p> ${name}  <span>[<a href="addFiles?id=${id}">NewFolder</a>] </a></span></p>

<table border="1">
 
  <c:forEach items="${entries2}" var="entry2">
  <tr>
  
  
    <td>
  
 
           	<c:if test="${empty entry2.name}">
    			<c:out value="emptyFolder">emptyFolder</c:out>
		</c:if>
           
           
           	<c:if test="${not empty entry2.name}">
    			<a href="SubFolder?id=${entry2.id}&n=${entry2.name}">${entry2.name}</a>
		</c:if>
           
           
            
     
       
      <%--  <c:redirect url = "http://www.photofuntoos.com"/> --%>
       </td>
       
       
       <td><a href="DeleteF?id=${entry2.id}">Delete </a></td>
       
  </tr>
  </c:forEach>
</table>



</body>
</html>