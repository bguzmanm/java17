<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Películas</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
		crossorigin="anonymous">
		
	<link href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="https://kit.fontawesome.com/81a2ed02b0.js" crossorigin="anonymous"></script>
		
</head>
<body>
	<div class="container">
		<h1>Listado de Películas</h1>
		<table class="table" id="table_films">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Descripción</th>
					<th>Lanzamiento</th>
					<th>Duración</th>
					<th>Censura</th>
					<th>Características</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="film" items="${films}">
					<tr>
						<td>
							<c:out value="${film.getFilmId()}"></c:out>
						</td>
						<td><c:out value="${film.getTitle()}"></c:out></td>
						<td><c:out value="${film.getDescription()}"></c:out></td>
						<td><c:out value="${film.getYear()}"></c:out></td>
						<td><c:out value="${film.getLength()}"></c:out></td>
						<td><c:out value="${film.getRating()}"></c:out></td>
						<td><c:out value="${film.getSpecialFeatures()}"></c:out></td>
						<td>
							<a href="${pageContext.request.contextPath}/film?id=${film.getFilmId()}&op=read"><i class="fa-solid fa-eye"></i></a>
					<%-- 		<a href="${pageContext.request.contextPath}/actor?id=${a.getActorId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/actor?id=${a.getActorId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
						<a href="${pageContext.request.contextPath}/films?actorId=${a.getActorId()}"><i class="fa-solid fa-film"></i></a> --%>
						
						</td>
					</tr> 
				</c:forEach>
			</tbody>
		</table>
	
	
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
		
		<script>
			$(document).ready( function () {
		    	$('#table_films').DataTable();
			});
		</script>
</body>
</html>