<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
	<title>Actores y Actrices</title>
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
		<jsp:include page="./nav.jsp"></jsp:include>
		<h1>Listado de Actores y Actrices</h1>
		<div class="mb-3">
			<a class="btn btn-secondary" href="${pageContext.request.contextPath}/actor?op=new">Crear Actor/Actriz</a>
		</div>
		
		<table class="table" id="table_actors">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${actors}">
					<tr>
						<td>
							<c:out value="${a.getActorId()}"></c:out>
						</td>
						<td><c:out value="${a.getFirstName()}"></c:out></td>
						<td><c:out value="${a.getLastName()}"></c:out></td>
						<td>
						<a href="${pageContext.request.contextPath}/actor?id=${a.getActorId()}&op=read"><i class="fa-solid fa-eye"></i></a>
						<a href="${pageContext.request.contextPath}/actor?id=${a.getActorId()}&op=edit"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="${pageContext.request.contextPath}/actor?id=${a.getActorId()}&op=delete"><i class="fa-solid fa-trash"></i></a>
						<a href="${pageContext.request.contextPath}/films?actorId=${a.getActorId()}"><i class="fa-solid fa-film"></i></a>
						
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
		    	$('#table_actors').DataTable();
			});
		</script>
		
</body>
</html>