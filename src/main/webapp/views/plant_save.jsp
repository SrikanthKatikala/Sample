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
<title>New Plant</title>
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
	
	<div class="container text-center p-2 mt-4 w-25">
		<c:if test="${plant.plantId==null}">
		<h2>Add a Plant</h2>
		</c:if>
		<c:if test="${plant.plantId!=null}">
		<h2>Update a Plant</h2>
		</c:if>
		<f:form action="/plants/add" method="post" modelAttribute="plant">
		<c:if test="${plant.plantId==null}">
			<div class="form-group">
				<label for="plantiD">Plant id:</label>
				<f:input class="form-control" path="plantId" name="plantId"
					required="required" autofocus="autofocus" />
			</div>
			</c:if>
			<div class="form-group">
				<label for="plantName">Plant Name:</label>
				<f:input class="form-control" path="plantName" name="plantName"
					required="required"></f:input>
			</div>
			<div class="form-group mb-2">
				<label for="plantLoc">Plant Location:</label>
				<f:input class="form-control" path="plantLoc" name="plantLoc"
					required="required"></f:input>
			</div>
			<div class="form-group">
				<f:hidden class="form-control" path="active" name="active"
					value="active" required="required"></f:hidden>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</f:form>


		<h2>${msg}</h2>
	</div>
	<div class="container mx-auto text-center">
		<a href="/plants/list"><button type="button"
				class="btn btn-warning">All Plants</button></a>
					<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a>
	</div>

</body>
</html>