<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
        table {
            border-collapse: collapse;
            width: 35%;
            font-weight: bolder;
        }
        td+td{ width: 90%;}
        input {
            width: 99%;
        }
    </style>
    <title>Add candidate</title>
</head>

<body>
    <h3><a href="Logout"> Logout </a> Welcome ${ userName } </h3>
    
    <form action="AddCandidate" method="post">
        <table border="1" cell-padding="2">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Specialties</td>
                <td><input type="text" name="specialties" /></td>
            </tr>
            <tr>
                <td>Presentation</td>
                <td><input type="text" name="presentation" /></td>
            </tr>
            <tr>
                <td colspan="2"><button>Add</button></td>
            </tr>
        </table>
        <br />
        <br />
        <br />
    </form>
</body></html>