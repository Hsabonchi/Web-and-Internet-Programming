<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidates</title>
<style>
#rating {
	text-align: center;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
    <c:choose>
        <c:when test="${ not empty userName }">
                    <h3><a href="Logout"> Logout </a> Welcome ${ userName } </h3>
        </c:when>
        <c:otherwise>
            <h3>
                <a href="Login"> Login </a>
            </h3>
        </c:otherwise>
    </c:choose>
	<c:choose>
		<c:when test="${ is_admin == true }">
		
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Specialties</th>
			<th>Presentation</th>
			<th>Rating</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${candidatesList}" var="candidate"
			varStatus="status">
			<tr>
				<td>${candidate.mID}</td>
				<td><a href="CandidateFeedback?index=${candidate.mID}">
						${candidate.mName} </a></td>
				<td>${candidate.mSpecialties}</td>
				<td>${candidate.mPresentation}</td>
				<td id="rating"><c:choose>
						<c:when test="${candidate.mRating  < 0}"> N/A </c:when>
						<c:otherwise>
							<fmt:formatNumber value="${candidate.mRating}" pattern="0.0" />
						</c:otherwise>

					</c:choose></td>
				<td><a href="EditCandidate?index=${candidate.mID}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3>
		<a href="AddCandidate"> Add Candidate </a>
	</h3>
	</c:when>
	
        <c:otherwise>
            
            
            <table border='1'>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Specialties</th>
            <th>Presentation</th>
            <th>Rating</th>
        </tr>
        <c:forEach items="${candidatesList}" var="candidate"
            varStatus="status">
            <tr>
                <td>${candidate.mID}</td>
                <td><a href="CandidateFeedback?index=${candidate.mID}">
                        ${candidate.mName} </a></td>
                <td>${candidate.mSpecialties}</td>
                <td>${candidate.mPresentation}</td>
                <td id="rating"><c:choose>
                        <c:when test="${candidate.mRating  < 0}"> N/A </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${candidate.mRating}" pattern="0.0" />
                        </c:otherwise>

                    </c:choose></td>
            </tr>
        </c:forEach>
    </table>
        </c:otherwise>
    </c:choose>
</body>
</html>