<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expenses</title>
</head>
<body>
<h2>Expenses</h2>


<p><span>Total:</span>  <fmt:formatNumber value="${total}" pattern="0.0" /> </p>
<table border="1">
  <tr><th>Month</th><th>Amount</th><th>Tags</th> <th>Operation</th> </tr>
  <c:forEach items="${entries2}" var="entry">

  <tr>
    <td><a href="FilterDisp?id=${entry.id}&m=${entry.month}">${entry.month} </a></td>
    <td><span>$</span>${entry.amount}</td>
    
    
    <td><a href="">${entry.tags}</a></td>
   
   <td><a href="Delete?id=${entry.id}"> Delete</a></td>
  </tr>
  </c:forEach>
  
  
  <tr>
  <form action="MainPaga"  method="post">
  <td> <input  type='text'  name="m"></td>
  <td> <input  type='text'  name="a"> </td> 
  <td> <input  type='text'  name="t"></td>
  
    <td> <button class="btn btn-default"> Add</button></td>
  </tr>
  </form>
</table>

</body>
</html>
