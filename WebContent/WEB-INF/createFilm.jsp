<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Film Added</title>
</head>

<body>
	<c:choose>
		<c:when test="${! empty newFilm}">
			<ul>
				<li><strong>Film ID:</strong> ${newFilm.id}</li>
				<li><strong>Title:</strong> ${newFilm.title}</li>
				<li><strong>Film Description:</strong> ${newFilm.description}</li>
				<li><strong>Release Date:</strong> ${newFilm.releaseYear}</li>
				<li><strong>Language ID:</strong> ${newFilm.languageId}</li>
				<li><strong>Rental Duration:</strong> ${newFilm.rentalDuration}</li>
				<li><strong>Rental Rate:</strong> ${newFilm.rentalRate}</li>
				<li><strong>Film Duration:</strong> ${newFilm.length}</li>
				<li><strong>Replacement Cost:</strong> ${newFilm.replacementCost}</li>
				<li><strong>Rating:</strong> ${newFilm.rating}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film found with that ID.</p>
		</c:otherwise>
	</c:choose>

	<br>
	<br>
	<form action="deleteFilm.do" method="POST">
		Please enter film ID of the film you would like to delete:<br> <input
			class="input" type="number" required="required" name="id"> <input
			class="submit" type="submit" value="Delete Film" />
	</form>
	<br>

<button type="button" onclick="document.location='index.html'">Return to Main Menu</button>

</body>
</html>