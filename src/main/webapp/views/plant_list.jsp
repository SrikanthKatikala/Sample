<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>All Plants</title>
</head>
<body style="background-image: linear-gradient(160deg, yellow, white, gray); height: 650px;">
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top mb-5">
		<ul class="navbar-nav mx-auto">
			<li class="nav-item active">
				<a class="nav-link" href="/user/home">Home</a>		
			</li>
			<li>
				<a class="nav-link active" href="/vendors/list">Vendors</a>
			</li>
			<li>
				<a class="nav-link active" href="/materials/list">Materials</a>
			</li>
			
			<li>
				<a class="nav-link active" href="/plants/list">Plants</a>
			</li>
			<li>
				<a class="nav-link active" href="/matChars/list">Material characteristics</a>
			</li>
			<li>
				<a class="nav-link active" href="/actuals/list">Inspection Actuals</a>
			</li>
			<li>
				<a class="nav-link active" href="/lots/list">Inspection Lot</a>
			</li>
			
		</ul>
	</nav>	

	
	<div class="container pt-5 mt-5 ml-4 text-center">
		<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a> <a href="/plants/add"><button
				type="button" class="btn btn-primary">+Add Plant Vendor</button></a>

	</div>
	<div class="container mx-auto pt-4">

		<h2>All Plants</h2>
		<%
		int slno = 1;
		%>
		<table class="table table-hover table-stripped mx:auto table-bordered">
			<thead class="table-dark text-center">
				<tr>
					<th>Sl.No</th>
					<th>Plant Id</th>
					<th>Plant Name</th>
					<th>Plant Location</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="plant" items="${plants}">
					<tr>
						<td><%=slno++%></td>
						<td>${plant.plantId}</td>
						<td>${plant.plantName}</td>
						<td>${plant.plantLoc}</td>
						<td class="text-center mx-auto"><a
							href="update?plantId=${plant.plantId}"> <i class="bi bi-pen"></i>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
  <path
										d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001m-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708z" />
</svg>
						</a> &nbsp&nbsp&nbsp&nbsp <a href="delete?plantId=${plant.plantId}"
							onclick="return confirmDeletion()"> <i class="bi bi-trash"></i>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path
										d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z" />
  <path
										d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z" />
</svg>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		  confirmDeletion = ()=>{
			  return confirm("Do you want to delete Plant?");
		  }
		</script>
</body>
</html>