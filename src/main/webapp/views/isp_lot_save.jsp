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

<title>Inspection Lot Form</title>
</head>
<body
	style="background-image: linear-gradient(145deg, gray, white, green); height: 120%;">
	<div class="container text-center py-5 mt-4 w-25">

		<c:if test="${lot.lotId==null}">
			<h2>Add a Inspection Lot</h2>
		</c:if>
		<c:if test="${lot.lotId!=null}">
			<h2>Update a Inspection Lot</h2>
		</c:if>



		<div class="container mt-4 w-80 justify-content-center">
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="card" style="width: 30rem; margin-left:-100px">
						<div class="card-header">
							<h4>Inspection Lot</h4>
						</div>
						<div class="card-body">
							<f:form action="/lots/add" method="post" modelAttribute="lot">
								<table class="table">
									<tr>
										<td></td>
										<td><f:hidden class="form-control" path="lotId"
												name="lotId" /></td>
									</tr>
									<tr>
										<td><label for="materialType">Material Type:</label></td>
										<td><f:select path="material"
												class="form-control text-center">
												<c:forEach var="mat" items="${materials}">
													<f:option value="${mat.materialId}"
														label="${mat.materialId}"></f:option>
												</c:forEach>
											</f:select></td>
									</tr>
									<tr>
										<td><label for="vendor">Vendor :</label></td>
										<td><f:select path="vendor"
												class="form-control text-center">
												<c:forEach var="vend" items="${vendors}">
													<f:option value="${vend.vendorId}"
														label="${vend.vendorName}"></f:option>
												</c:forEach>
											</f:select></td>
									</tr>
									<tr>
										<td><label for="name">Plant:</label></td>
										<td><f:select path="plant"
												class="form-control text-center">
												<c:forEach var="plnt" items="${plants}">
													<f:option value="${plnt.plantId}" label="${plnt.plantId}"></f:option>
												</c:forEach>
											</f:select></td>
									</tr>
									<tr>
										<td><label>Created On:</label></td>
										<td><f:input class="form-control text-center"
												value="${createdOn}" path="createdOn" type="date" /></td>
									</tr>
									<tr>
										<td><label>Start Date:</label></td>
										<td><f:input class="form-control text-center"
												value="${ispStartDate}" path="ispStartDate" type="date" /></td>
									</tr>
									<tr>
										<td><label>End Date:</label></td>
										<td><f:input class="form-control text-center"
												value="${ispEndDate}" path="ispEndDate" type="date" /></td>
									</tr>
									<tr>
										<td><label>Result:</label></td>
										<td><f:select path="result"
												class="form-control text-center">
												<f:option value="select"
													label="   --------  Select  ------  "></f:option>
												<f:option value="PASS" label="PASS"></f:option>
												<f:option value="FAIL" label="FAIL"></f:option>
											</f:select></td>
									</tr>
									<tr>
										<td><label>Remarks:</label></td>
										<td><f:input class="form-control text-center"
												path="remarks" /></td>
									</tr>
									<tr>
										<td><label for="user">User:</label></td>
										<td><f:select path="user"
												class="form-control text-center">
												<c:forEach var="usr" items="${users}">
													<f:option value="${usr.userId}" label="${usr.userName}"></f:option>
												</c:forEach>
											</f:select></td>
									</tr>
									<tr>
										<td colspan="2"><f:hidden class="form-control" path="active"
												name="active" value="active" required="required"></f:hidden></td>
									</tr>
									<tr>
										
										<td colspan="2"><button type="submit" class="btn btn-primary">Submit</button></td>
									</tr>
								</table>

							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<h2>${msg}</h2>
	</div>
	<div class="container mx-auto text-center mb-5">
		<a href="/lots/list"><button type="button" class="btn btn-warning">All
				Inspection Lots</button></a> <a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a> <a href="/lots/search"><button
				type="button" class="btn btn-dark">Search</button></a>
	</div>

</body>

</html>