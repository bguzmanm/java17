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
		<h1>Detalle de Actor/Actriz</h1>
		
		<form class="form" action="${pageContext.request.contextPath}/actor" method="POST">
			<input type="hidden" name="id" id="id" value="${actor.getActorId()}">
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre:</label>
				<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Pedro" value="${actor.getFirstName()}">
			</div>
			<div class="mb-3">
				<label for="apellido" class="form-label">Apellido:</label>
				<input type="text" class="form-control" name="apellido" id="apellido" placeholder="Pascal" value="${actor.getLastName()}">
			</div>
			<button class="btn btn-primary" type="submit">Guardar</button>
		</form>
	</div>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
		
</body>
</html>