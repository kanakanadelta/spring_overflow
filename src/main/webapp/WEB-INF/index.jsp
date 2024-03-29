<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta charset="UTF-8">
<title>Questions Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<div id="questions">
		<table>
			<thead>
				<tr>
					<th>Questions</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="qObj">
					<tr>
						<td>
							<a href="/questions/${qObj.id}">
								<c:out value="${qObj.questionText}" />
							</a>
						</td>
						<td>
							<c:forEach items="${qObj.tags}" var="tag">
								<c:out value="${tag.subject}" />
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="new_question">
		<a href="/questions/new">New Question</a>
	</div>
	
	<!-- END BODY -->
</body>
</html>