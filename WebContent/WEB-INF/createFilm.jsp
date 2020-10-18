<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Add New Film</title>
</head>

<h1>Add A New Film</h1>
<form:form action="addFilmToDatabase.do" method="POST" modelAttribute="film">
		<form:label path="title">Title:</form:label><br>
		<form:input class="input" path="title" required="required" placeholder="Enter Title"/>
		<form:errors path="title" />
		<br />
		<form:label path="description" >Description:</form:label><br>
		<form:input class="input" path="description" required="required" placeholder="Enter Description"/>
		<form:errors path="description" />
		<br />

		<form:label path="releaseYear">Release Year:</form:label><br>
		<form:input class="input" path="releaseYear" min="0" max="2029" type="number" required="required" placeholder="Year" />
		<form:errors path="releaseYear" />
		<br />
		<form:label path="languageId">Language: </form:label><br>
		<form:select path="languageId"> 
			<form:option value="1" >English</form:option>
		</form:select>
		<br>
		<form:label path="rentalDuration">Rental Duration:</form:label><br>
		<form:input class="input" path="rentalDuration" min="0" type="number" required="required" placeholder="Enter Days"/>
		<form:errors path="rentalDuration" />
		<br>
		<form:label path="length">Length:</form:label><br>
		<form:input class="input" path="length" min="0" type="number" required="required" placeholder="Enter Length In Minutes"/>
		<form:errors path="length" />
		<br>
		<form:label path="replacementCost">Replacement Cost:</form:label><br>
		<form:input class="input" path="replacementCost" type="number" min="0" step="0.01" required="required" placeholder="Enter Cost"/>
		<br>
	
		<form:label path="rating">Rating:</form:label><br>
		<form:input class="input" path="rating" required="required" placeholder="Enter Rating"/>
		<form:errors path="rating" />
		<br>
		
	    <input class="submit" type="submit" value="Submit" />
	</form:form>

</body>
</html>