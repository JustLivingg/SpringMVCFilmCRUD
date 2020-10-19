<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Edit Film:</title>
</head>
<body>
<body>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li><strong>Film ID:</strong> ${film.id}</li>
				<li><strong>Title:</strong> ${film.title}</li>
				<li><strong>Film Description:</strong> ${film.description}</li>
				<li><strong>Release Date:</strong> ${film.releaseYear}</li>
				<li><strong>Language ID:</strong> ${film.languageId}</li>
				<li><strong>Rental Duration:</strong> ${film.rentalDuration}</li>
				<li><strong>Rental Rate:</strong> ${film.rentalRate}</li>
				<li><strong>Film Duration:</strong> ${film.length}</li>
				<li><strong>Replacement Cost:</strong> ${film.replacementCost}</li>
				<li><strong>Rating:</strong> ${film.rating}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film found with that ID.</p>
		</c:otherwise>
	</c:choose>
	<form action="editFilmForm.do" method="POST">
		<input type="hidden" name="film" value="${film}">
		<label for="columnName"><strong>Please enter column name to edit:</strong></label><br>
		<input class="input" type="text" name="columnName">
		<br>
		<label for="columnName"><strong>Please enter new value for column:</strong></label><br>
		<input class="input" type="text" name="columnValue">
		<input class="submit" type="submit" value="Edit Film" />
	</form>
	<br>
	<br>
	<button type="button" onclick="document.location='index.html'">Return to Main Menu</button>


</body>
</html>