<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestBook</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
	
	
   $(".delete").click(function(){
       var row = $(this).closest("tr");
       $.ajax({
           url: "AjaxDeleteEntry",
           data: {
               "id" : row.attr("data-entry-id")
           },
           success: function(){
               row.remove();
           }
       });
   });
   
   
   
   
   $("#add").click(function(){
      var name = $("#name").val();
      var message = $("#message").val();
      if( name != "" && message != "" )
          $.ajax({
              url: "AjaxAddEntry",
              data: {
                  "name": name,
                  "message": message
              },
             
                 success: function(data){
                      var row = $("<tr data-entry-id='" + data + "'></tr>" );
                      row.append("<td>" + name + "</td>")
                        //.append("<td>" + name + "</td>")
                         .append("<td>" + message + "</td>")
                         .append("<td><button>Delete</button></td>");
                      $("#form").before(row);
                      $("#name").val(" ");
                      $("#message").val(" ");
                      
                  }
            	  
       });   
   });
   

   
   $( "td" ).dblclick(function() {
	   
	   	  var x;
	   	  var name;
	   	  var message;
	    
	   var row = $(this).closest("tr")
	   var parent = $(this).parent();
	 
       var elem=$( this ).html("<input  id='a'>")      
         $("#a").blur(function(){
               x= $(this).val()
               $(this).remove()
               $( elem ).html(x)
           
               name=parent.children(':first-child').html()
               message=parent.children().eq(1).html()
               
              
       
  
     
       $.ajax({
           url: "Edit",
           data: {
        	   "id" : row.attr("data-entry-id"),
                "name":name ,
               	"message":message
                
        	   
           },
           success: function(){  
        	   
        	   
        	    	   
           }
        
           
       });
         });
	   
	   
	   
   });
   
   
   
  
});
</script>
</head>
<body>
<h2>GuestBook</h2>
<table border="1">
  <tr><th>Name</th><th>Message</th> <th>Operation</th></tr>
				  <c:forEach items="${entries}" var="entry">
				  
				  <tr data-entry-id="${entry.id}">
				   <%-- <td >${entry.id}</td></td> --%>
				    <td id="n">${entry.name}</td>
				    <td id="m">${entry.message}</td>
				    <td><button class="delete">Delete</button></td>
				  </tr>
				  </c:forEach>
				  
				  
  <tr id="form">
  <td>  </td>
   <td><input id="name" type="text" /></td>
    <td><input id="message" type="text" /></td>
    <td><button id="add">Add</button></td>
</table>
</body>
</html>