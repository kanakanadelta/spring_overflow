<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<style>
	* {
		font-family: Comic Sans MS;
	}
</style>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<div>
		<form:form action="/questions" method="POST" modelAttribute="question">
			<form:textarea path="questionText" name="questionText" id="questionText" cols="60" rows="10"></form:textarea>
			<br />
			<label for="tagStr">Tags:</label>
			<input name="tagStr" type="text" />
		</form:form>
	</div>
</body>
</html>