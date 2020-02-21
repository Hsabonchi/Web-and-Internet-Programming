<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DMV Test Question</title>
</head>
<body>
<p>${Q.description}</p>
<p>1.${Q.answerA}</p>
<p>2.${Q.answerB}</p>
<p>3.${Q.answerC}</p>
<p>correctAnswer ${Q.correctAnswer}</p>
<!-- ?index="${pram.index} -->
<p> <a href="DrivingTestBrowser?index=${index}" style="text-decoration:none"> Next</a></p>

</body>
</html>