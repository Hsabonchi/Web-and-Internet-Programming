<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<style>
table {
	    border-collapse: collapse;
	    width: 35%;
	    font-weight: bolder;
    }
td+td{
        width: 90%;
     }
input {
        width: 99%;
    }
input[type='number'] {border:none;}
</style>
</head>
<body>
    <h3><a href="Logout"> Logout </a> Welcome ${ userName } </h3>
    
    <form action='EditCandidate' method='post'> <table border='1' >
        <%-- Add the <c:out> inside value =          
        <tr><td>ID</td><td> <input type='number' name='id' readonly value="${candidateEntry.mID}" /></td></tr>
        <tr><td>Name</td><td> <input border='none' type='text' name='name' value="${candidateEntry.mName}"/></td></tr>
        <tr><td>Specialties</td><td> <input type='text' name='specialties' value="${candidateEntry.mSpecialties}" /></td></tr>
        <tr><td>Presentation</td><td> <input type='text' name='presentation' value="${candidateEntry.mPresentation}" /></td></tr>
        <tr><td colspan='2'><button> Save </button></td></tr></table></form>
        --%>
        
        <tr><td>ID</td><td> <input type='number' name='id' readonly value="<c:out value="${candidateEntry.mID}"/>" /></td></tr>
        <tr><td>Name</td><td> <input border='none' type='text' name='name' value="<c:out value="${candidateEntry.mName}"/>"/></td></tr>
        <tr><td>Specialties</td><td> <input type='text' name='specialties' value="<c:out value="${candidateEntry.mSpecialties}"/>" /></td></tr>
        <tr><td>Presentation</td><td> <input type='text' name='presentation' value="${candidateEntry.mPresentation}" /></td></tr>
        <tr><td colspan='2'><button> Save </button></td></tr></table></form>
</body>
</html>