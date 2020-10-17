<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film info:</title>
</head>

<body>
	<c:choose>
		<c:when test="${! empty films}">
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
				<li><strong>Special Features:</strong> ${film.speicalFeatures}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film found with that ID.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>