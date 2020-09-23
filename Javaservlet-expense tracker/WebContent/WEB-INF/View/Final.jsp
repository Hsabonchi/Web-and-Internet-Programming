
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final</title>
<style>
table {
	border-collapse: collapse;
}
</style>
</head>
<body>

	<h3>
		Total:
		<fmt:formatNumber value="${ total }" pattern="0.##" />
	</h3>
	<table border="1">
		<tr>
			<th>Month</th>
			<th>Amount</th>
			<th>Tags</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${ eList }" var="e" varStatus="status">
			<tr>
				<td><a href="Month?month=${e.month}"> ${ e.month }</a></td>
				<td><fmt:formatNumber value="${ e.amount }" pattern="0.##" /></td>
				<td><c:forEach items="${ e.tags }" var="t" varStatus="status">
						<a href="Tag?">${t }</a>
						<c:if test="${ !status.last }">
                ,</c:if>
					</c:forEach></td>
				<td><a href="Delete?index=${e.id}">Delete </a></td>
			</tr>
		</c:forEach>
		<form action='Final' method='post'>
		<tr>

			<td><input type="text" name="month" /></td>
			<td><input type="number" step="0.01" name="amount"
				required="required" /></td>
			<td><input type="text" name="tags" required="required" /></td>
			<td><button>Add</button></td>

		</tr>
		</form>
	</table>

</body>
</html>