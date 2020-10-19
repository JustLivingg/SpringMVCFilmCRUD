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

		<form:label path="description">Description: </form:label>
		<br>
		<form:input class="input" path="description"
			default="${film.description}" placeholder="${film.description }" />
		<form:errors path="description" />

		<form:label path="releaseYear">Release Year: </form:label>
		<br>
		<form:input class="input" path="releaseYear"
			default="${film.releaseYear}" placeholder="${film.releaseYEar }" />
		<form:errors path="releaseYear" />

		<form:label path="languageId">Language Id: </form:label>
		<br>
		<form:input class="input" path="languageId"
			default="${film.languageId}" placeholder="${film.releaseYear }" />
		<form:errors path="languageId" />

		<form:label path="rentalDuration">Rental Duration: </form:label>
		<br>
		<form:input class="input" path="rentalDuration"
			default="${film.rentalDuration}"
			placeholder="${film.releaseDuration}" />
		<form:errors path="rentalDuration" />

		<form:label path="rentalRate">Rental Rate: </form:label>
		<br>
		<form:input class="input" path="rentalRate"
			default="${film.rentalRate}" placeholder="${film.rentalRate}" />
		<form:errors path="rentalRate" />

		<form:label path="length">Film Length: </form:label>
		<br>
		<form:input class="input" path="length" default="${film.length}"
			placeholder="${film.length}" />
		<form:errors path="length" />

		<form:label path="replacementCost">Replacement Cost: </form:label>
		<br>
		<form:input class="input" path="replacementCost" default="${film.replacementCost}"
			placeholder="${film.replacementCost}" />
		<form:errors path="replacementCost" />
		
		<form:label path="rating">Rating: </form:label>
		<br>
		<form:input class="input" path="rating" default="${film.rating}"
			placeholder="${film.rating}" />
		<form:errors path="rating" />
		
		<form:label path="specialFeatures">Special Features: </form:label>
		<br>
		<form:input class="input" path="specialFeatures" default="${film.specialFeatures}"
			placeholder="${film.specialFeatures}" />
		<form:errors path="specialFeatures" />





	</form:form>

</body>
</html>