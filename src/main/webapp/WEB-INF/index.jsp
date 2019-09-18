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
<title>Questions Dashboard</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<div>
		<table>
			<thead>
				<tr>
					<th>Questions</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<!-- c:out and map info from questions and their tags -->
			</tbody>
		</table>
	</div>
</body>
</html>