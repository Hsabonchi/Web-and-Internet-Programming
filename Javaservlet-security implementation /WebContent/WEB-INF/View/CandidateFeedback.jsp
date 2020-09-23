<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate feedback</title>
<style>
#rating {
	text-align: center;
}

#fDate {
	text-align: right;
}

#commentsTable {
	width: 60%;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${ not empty userName }">
			<h3>
				<a href="Logout"> Logout </a> Welcome ${ userName }
			</h3>
		</c:when>
		<c:otherwise>
			<h3>
				<a href="Login"> Login </a>
			</h3>
		</c:otherwise>
	</c:choose>


	<p>
		<a href="CandidateReviews">Back to Candidates</a>
	</p>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Specialties</th>
			<th>Presentation</th>
			<th>Rating</th>
		</tr>
		<tr>
			<td>${candidateEntry.mID}</td>
			<td>${candidateEntry.mName}</td>
			<td>${candidateEntry.mSpecialties}</td>
			<td>${candidateEntry.mPresentation}</td>
			<td id="rating"><c:choose>
					<c:when test="${candidateEntry.mRating < 0}"> N/A </c:when>
					<c:otherwise>
						<fmt:formatNumber value="${candidateEntry.mRating}" pattern="0.0" />
					</c:otherwise>

				</c:choose></td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${empty feedbackEntries}">
			<p>No comments yet ^-^</p>
		</c:when>
		<c:otherwise>
			<p>Comments:</p>
			<table border="1" id="commentsTable">
				<c:forEach var="mComment" items="${feedbackEntries}">
					<tr>
						<td>Rating: ${mComment.rating}</td>
						<td id="fDate">Posted by ${mComment.name} on <fmt:formatDate
								value="${mComment.date}" pattern="M/d/y" />
						</td>
						<c:if test="${ mComment.userName == userName }">
						<td rowspan="2"> <a href="EditFeedback?feedId=${ mComment.feedId }&candidateId=${candidateEntry.mID}"> Edit </a> </td>
						</c:if>
						<c:if test="${ mComment.userName != userName }">
						  <td rowspan="2">  </td>
						</c:if>
					</tr>
					<tr>
						<td colspan="2">${mComment.comment}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>

	</c:choose>

	<c:choose>
		<c:when test="${ empty userName }">
			<h4>
				 Please login in order to give feedback ^-^
			</h4>
		</c:when>
		<c:when test="${ not empty numFeedback }">
		  <h4> Sorry, you can add only one comment per candidate. </h4>
		</c:when>

		<c:otherwise>
			<p>Please give you feedback:</p>
			<form action='CandidateFeedback?index=${index}' method='post'>
				<table border='1'>
					<tr>
						<th>Rating</th>
						<td>1 <input type="radio" name="rating" value="1" /> <input
							type="radio" name="rating" value="2" /> <input type="radio"
							name="rating" value="3" /> <input type="radio" name="rating"
							value="4" /> <input type="radio" name="rating" value="5" /> 5
						</td>
					</tr>
					<!-- <tr>
						<th>Name</th>
						<td><input style="width: 99%" type="text" name='name' /></td>
					</tr> -->
					<tr>
						<th>Comments</th>
						<td><textarea name="comment" cols="60" rows="4"></textarea></td>
					</tr>
					<tr>
						<td colspan='2'><button>Submit</button></td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>


</body>
</html>