<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit feedback</title>
<style>
table {
    border-collapse: collapse;
}
</style>
</head>
<body>

	<h3>
		<a href="Logout"> Logout </a> Welcome ${ userName }
	</h3>

	<form action='EditFeedback?feedId=${feedId}&candidateId=${candidateId}' method='post'>
		<table border='1'>
			<tr>
				<th>Rating</th>
				<td>1 <c:choose>
						<c:when test="${ feedRating == 1 } ">
							<input type="radio" name="rating" value="1" checked />
						</c:when>
						<c:otherwise>
							<input type="radio" name="rating" value="1" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${ feedRating == 2 }">
							<input type="radio" name="rating" value="2" checked />
						</c:when>
						<c:otherwise>
							<input type="radio" name="rating" value="2" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${feedRating == 3 }">
							<input type="radio" name="rating" value="3" checked />
						</c:when>
						<c:otherwise>
							<input type="radio" name="rating" value="3" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${ feedRating == 4 }">
							<input type="radio" name="rating" value="4" checked />
						</c:when>
						<c:otherwise>
							<input type="radio" name="rating" value="4" />
						</c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${ feedRating == 5 }">
							<input type="radio" name="rating" value="5" checked />
						</c:when>
						<c:otherwise>
							<input type="radio" name="rating" value="5" />
						</c:otherwise>
					</c:choose> 5
				</td>
			</tr>
			<!-- <tr>
				<th>Name</th>
				<td><input style="width: 99%" type="text" name='name'
					value='test' /></td>
			</tr> -->
			<tr>
				<th>Comments</th>
				<td><textarea name="comment" cols="60" rows="4">${ feedComment }</textarea></td>
			</tr>
			<tr>
				<td colspan='2'><button>Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>