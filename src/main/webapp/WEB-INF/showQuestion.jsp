<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Profile</title>
</head>
<body>
	<h2>
		<c:out value="${qObj.questionText}"/>
	</h2>
	<div id="question_tags_div">
		<span>Tags: </span>
		<span>
			<c:forEach items="${qObj.tags}" var="tag">
				<button>
					<c:out value="${tag.subject}" />
				</button>
			</c:forEach>
		</span>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>Answers:</th>
				</tr>
			</thead>
			<tbody>
				<!-- Render questions here -->
			</tbody>
		</table>
	</div>
</body>
</html>