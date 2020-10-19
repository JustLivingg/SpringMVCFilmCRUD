<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Search:</title>
</head>
<body>


	<c:choose>
		<c:when test="${! empty film}">
			<c:forEach items="${film}" var="film">
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
			</c:forEach>
		</c:when>
		
			<c:otherwise>
			<p>No film found with that search parameter.</p>
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