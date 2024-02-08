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
<title>New Inspection Actuals</title>
</head>
<body style="background-image: linear-gradient(45deg, violet, white, red); height: 650px;">
	<div class="container text-center pt-5 mt-5 w-25">
		
		<c:if test="${actuals.inspectionLot==null}">
		<h2>Add a Inspection Actuals</h2>
		</c:if>
		<c:if test="${actuals.inspectionLot!=null}">
		<h2>Update a Inspection Actuals </h2>
		</c:if>
		
		<f:form action="/actuals/add" method="post" modelAttribute="inspectionActuals">
		<c:if test="${inspectionActuals.inspectionLot==null}">
			<div class="form-group">
				<label for="inspectionLot">Inspection Lot :</label>
				<f:select class="form-control text-center" path="inspectionLot" name="inspectionLot" type="number" >
					<c:forEach var="lot" items="${lots}">
					<f:option value="${lot.lotId}" label="${lot.lotId}"></f:option>
					</c:forEach>
				</f:select>
					 
			</div>
			<div class="form-group">
				<label for="matCharId">Material Characters:</label>
	
				<f:select class="form-control text-center" path="matCharId" name="matCharId" type="number" >
					<c:forEach var="chr" items="${matChars}">
					<f:option value="${chr.characterId}" label="${chr.characterDesc}"></f:option>
					</c:forEach>
				</f:select>
			</div>
			</c:if>
			<div class="form-group mb-2">
				<label for="maximumMeasurement">maximumMeasurement:</label>
				<f:input class="form-control" path="maximumMeasurement" name="maximumMeasurement"
					required="required"></f:input>
			</div>
			<div class="form-group mb-2">
				<label for="minimumMeasurement">minimumMeasurement</label>
				<f:input class="form-control" path="minimumMeasurement" name="minimumMeasurement"
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
		<a href="/actuals/list"><button type="button"
				class="btn btn-warning">All Inspection Actuals</button></a>
					<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a>
	</div>

</body>

</html>