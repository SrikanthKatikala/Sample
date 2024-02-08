<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor save</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<style type="text/css">
	.error{
		color:red;
		font-size:20px;
	}
	th{
		width: 25%;
		margin: 15px;
		font-size: 22px;
	}
	td{
		width:30%;
		margin:20px;	
	}
</style>
</head>
<body
	style="background-image: linear-gradient(140deg, orange, white, blue); height: 650px;">
	
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
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
	
	<div class="container text-center mt-5 w-70 container-border">
		<c:if test="${vendor.vendorId==null}">
			<h2>Add a Vendor</h2>
		</c:if>
		<c:if test="${vendor.vendorId!=null}">
			<h2>Update a Vendor</h2>
		</c:if>
		<f:form action="/vendors/add" method="post" modelAttribute="vendor" >


			<table class="w-70 text-center mx-auto">
				<tr>
					<td colspan="3">
						<div class="form-group">
							<f:hidden class="form-control" path="vendorId" name="vendorId" />
						</div>
					</td>
				</tr>
				<tr>
					<th><label for="vendorName">Vendor Name:</label></th>
					<td>
						<div class="form-group mt-4">
							<f:input class="form-control" path="vendorName" name="vendorName"
								required="required" autofocus="autofocus"></f:input>
						</div>
					</td>
					<td><f:errors cssClass="error" path="vendorName">
						</f:errors></td>
				</tr>
				<tr>
					<th><label for="contact">Contact:</label></th>
					<td>
						<div class="form-group mb-5 mt-4">

							<f:input class="form-control text-center" path="vendorContact" name="contact"
								required="required" id="contact" onkeyup="validContact()"></f:input>
						</div>
					</td>
					<td><h6><f:errors cssClass="error" path="vendorContact">
						</f:errors></h6>
					</td>
				</tr>
				<tr>
					
					<td colspan="3">
						<div class="form-group">

							<f:hidden class="form-control" path="active" name="active"
								value="active" required="required"></f:hidden>
						</div>
					</td>
				
				</tr>
				<tr>
					<td colspan="3">
					<div class="form-group">
						<button type="submit" class="btn btn-primary" style="margin-left:-100px;">Submit</button>
						</div>
					</td>
				</tr>
			</table>
		</f:form>

		<h2>${msg}</h2>
	</div>
	<div class="container mx-5 my-4 text-center ">
		<a href="/vendors/list">
			<button type="button" class="btn btn-warning mx-4">All Vendors</button>
		</a> 
				
		<a href="/user/home">
			<button	type="button" class="btn btn-secondary mx-5">Home</button>
		</a>
	</div>
	<script type="text/javascript">
		function validContact() {
			var con = document.getElementById("contact").value
			for (let i = 0; i < con.length; i++) {
				if (i > '9' && i < '0') {
					alert("contact have only digits");
				}
			}
		}
	</script>
</body>
</html>