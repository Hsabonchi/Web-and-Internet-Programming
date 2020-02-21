<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h2></h2>

<p> <span> <a>[</a></span> <a href="addFiles?id=0">NewFolder</a>  <span>]</span></p>


<table border="1">
 
  <c:forEach items="${entries}" var="entry">
  <tr>
  
  
    <td>
  
  <c:choose>
  <%--because its boolean  without condition --%>
      <c:when test = "${entry.is_folder}">
      
         
    			<a href="SubFolder?id=${entry.id}&n=${entry.name}"> <span>/</span>${entry.name}</a>

           
           
            
         </c:when> 
         
         
         
         <c:otherwise>
       		${entry.name}
         </c:otherwise>
      
     </c:choose>
       
     
       </td>
       
      <td><a href="DeleteF?id=${entry.id}">Delete </a></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>