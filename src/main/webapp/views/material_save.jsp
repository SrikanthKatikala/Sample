<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Material Form</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
</head>
<body style="background-image: linear-gradient(45deg, violet, white, red); height: 650px;">
	<div class="container text-center p-2 mt-4 w-25">
		
		<c:if test="${material.materialId==null}">
		<h2>Add a Material</h2>
		</c:if>
		<c:if test="${material.materialId!=null}">
		<h2>Update a Material</h2>
		</c:if>
		
		<f:form action="/materials/add" method="post" modelAttribute="material">
		<c:if test="${material.materialId==null}">
			<div class="form-group">
				<label for="materialId">Material id:</label>
				<f:input class="form-control" path="materialId" value="${materialId}" name="materialId"
					required="required" autofocus="autofocus" />
			</div>
		</c:if>
			<div class="form-group">
				<label for="materialDesc">Material Description:</label>
				<f:input class="form-control" path="materialDesc" name="materialDesc"
					required="required"></f:input>
			</div>
			<div class="form-group mb-2">
				<label for="materialType">Material Type:</label>
				<f:input class="form-control" path="materialType" name="materialType"
					required="required"></f:input>
			</div>
			<div class="form-group">
				<f:hidden class="form-control" path="active" name="active"
					value="active" required="required"></f:hidden>
			</div>
			<button type="submit" class="btn btn-primary"> Submit</button>
		</f:form>


		<h2>${msg}</h2>
	</div>
	<div class="container mx-auto text-center">
		<a href="/materials/list"><button type="button"
				class="btn btn-warning">All Materials</button></a>
					<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a>
	</div>

</body>
</html>