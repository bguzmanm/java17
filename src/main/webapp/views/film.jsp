<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Actor o Actríz</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
		crossorigin="anonymous">
		
</head>
<body>

	<div class="container">
		<h1>Detalle de Película</h1>
		
		<form class="form" action="${pageContext.request.contextPath}/film" method="POST">
			<input type="hidden" name="id" id="id" value="${film.getFilmId()}">
			<div class="mb-3">
				<label for="title" class="form-label">Titulo:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="title" id="title" placeholder="Pedro" value="${film.getTitle()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="title" id="title" placeholder="Pedro" value="${film.getTitle()}">
				</c:if>
				
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Descripción:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="description" id="description" placeholder="Pascal" value="${film.getDescription()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="description" id="description" placeholder="Pascal" value="${film.getDescription()}">
				</c:if>
			</div>
			<div class="mb-3">
				<label for="year" class="form-label">Lanzamiento:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="year" id="year" value="${film.getYear()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="year" id="year" value="${film.getYear()}">
				</c:if>
			</div>
			<div class="mb-3">
				<label for="rentalDuration" class="form-label">Duración de Arriendo:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="rentalDuration" id="rentalDuration" value="${film.getRentalDuration()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="rentalDuration" id="rentalDuration" value="${film.getRentalDuration()}">
				</c:if>
			</div>			
			<div class="mb-3">
				<label for="length" class="form-label">Duración:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="length" id="length" value="${film.getLength()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="length" id="length" value="${film.getLength()}">
				</c:if>
			</div>		
			<div class="mb-3">
				<label for="rating" class="form-label">Censura:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="rating" id="rating" value="${film.getRating()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="rating" id="rating" value="${film.getRating()}">
				</c:if>
			</div>	
			<div class="mb-3">
				<label for="specialFeatures" class="form-label">Características Especiales:</label>
				<c:if test="${op.equals('read')}">
					<input type="text" class="form-control" name="specialFeatures" id="specialFeatures" value="${film.getSpecialFeatures()}" disabled>
				</c:if>
				<c:if test="${op.equals('edit') || op.equals('new')}">
					<input type="text" class="form-control" name="specialFeatures" id="specialFeatures" value="${film.getSpecialFeatures()}">
				</c:if>
			</div>			
			<a href="${pageContext.request.contextPath}/actors" class="btn btn-info">Volver</a>
			<c:if test="${op.equals('edit') || op.equals('new')}">
				<button class="btn btn-primary" type="submit">Guardar</button>
			</c:if>
		</form>
	</div>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
		
</body>
</html>