<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
</head>
<body>

	<form:form action="editFilm.do" method="POST" modelAttribute="film">
		<form:label path="id" default="${film.id}">
			<strong>Editing Film ID: ${film.id }</strong>
		</form:label>

		<form:label path="title">Title: </form:label>
		<br>
		<form:input class="input" path="title" default="${film.title }"
			placeholder="${film.title }" />
		<form:errors path="title" />

	</form:form>

</body>
</html>