<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />

<title>Material Characteristics Form</title>
</head>
<body style="background-image: linear-gradient(45deg, violet, white, red); height: 650px;">
	<div class="container text-center p-2 mt-4 w-25">
		
		<c:if test="${chactr.characterId==null}">
		<h2>Add a Material Character</h2>
		</c:if>
		<c:if test="${chactr.characterId!=null}">
		<h2>Update a Material Character</h2>
		</c:if>
		
		<f:form action="/matChars/add" method="post" modelAttribute="chactr">
			<div class="form-group">
				
				<f:hidden class="form-control" path="characterId" name="characterId"
					required="required" autofocus="autofocus" />
			</div>
			<div class="form-group">
				<label for="characterDesc">Character Description:</label>
				<f:input class="form-control" path="characterDesc" name="characterDesc"
					required="required"></f:input>
			</div>
			
			<div class="form-group mb-2">
				<label for="materialType">Material Type:</label>
				<f:select path="material" class="form-control text-center">
					<c:forEach var="mat" items="${materials}">
					<f:option value="${mat.materialId}" label="${mat.materialDesc}"></f:option>
					</c:forEach>
				</f:select>
			</div>
			
			
			<div class="form-group mb-2">
				<label for="lowerTolerance">Lower tolerance:</label>
				<f:input class="form-control" path="toleranceLowerLimit" name="lowerTolerance"
					required="required"></f:input>
			</div>
			<div class="form-group mb-2">
				<label for="toleranceUpperLimit">Upper tolerance:</label>
				<f:input class="form-control" path="toleranceUpperLimit" name="toleranceUpperLimit"
					required="required"></f:input>
			</div>
			<div class="form-group mb-2">
				<label for="unitOfMeasurement">Unit Of Measurements:</label>
				<f:input class="form-control" path="unitOfMeasurement" name="unitOfMeasurement"
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
		<a href="/matChars/list"><button type="button"
				class="btn btn-warning">All Material Characteristics</button></a>
					<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a>
	</div>

</body>

</html>