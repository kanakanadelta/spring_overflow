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
	<!-- RENDER QUESTION -->
	<a href="/questions">Go back</a>
	<h2>
		<c:out value="${qObj.questionText}"/>
	</h2>
	
	<!-- RENDER TAGS -->
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
	<br />
	<!-- RENDER ANSWERS -->
	<div id="answers_div">
		<table>
			<thead>
				<tr>
					<th style="text-align:left;">Answers:</th>
				</tr>
			</thead>
			<tbody style="border:1px solid #000; display: inline-block; min-width: 400px;">
				<c:forEach items="${answers}" var="aObj">
					<tr>
						<td>
							<c:out value="${aObj.answerText}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<!-- FORM FOR ANSWER -->
	<div>
		<form:form action="/questions/${qObj.id}/answer" method="POST" modelAttribute="answer">
			<form:errors path="answerText">Error with answer length</form:errors>		
			<form:label path="answerText">Share an answer:</form:label>
			<br />
			<form:textarea path="answerText" cols="60" rows="10"></form:textarea>
			<br />
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
	
	<!-- END BODY -->
</body>
</html>