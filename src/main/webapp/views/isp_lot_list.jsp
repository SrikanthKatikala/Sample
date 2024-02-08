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

<title>All Inspection Lots</title>
</head>
<body style="background-image: linear-gradient(145deg, gray, white, green); height: 650px;">

<div class="container mx-left pt-1 text-center">
		<a href="/user/home"><button type="button"
				class="btn btn-secondary">Home</button></a>
            	<a href="/lots/add"><button type="button" class="btn btn-primary">+Add New Inspection Lot</button></a>
            	<a href="/lots/search"><button type="button"
				class="btn btn-dark">Search</button></a>
            </div>
	<div class="container mx-auto pt-4">

		<h2>Inspected lots</h2>
		<%
		int slno = 1;
		%>
		<table class="table table-hover table-stripped mx:auto table-bordered">
			<thead class="table-dark text-center">
				<tr>
					<th>Sl.No</th>
					<!--  <th>Inspection Lot id</th>-->
					<th>Material</th>
					<th>Vendor </th>
					<th>Plant</th>
					<th>Created On</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Result</th>
					<th>Remarks</th>
					<th>User</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lot" items="${lots}">
					<tr>
						<td><%=slno++%></td>
						<!--  <td>${lot.lotId}</td>-->
						<td>${lot.material.materialId}</td>
						<td>${lot.vendor.vendorName}</td>
						<td>${lot.plant.plantId}</td>
						<td>${lot.createdOn}</td>
						<td>${lot.ispStartDate}</td>
						<td>${lot.ispEndDate}</td>
						<td>${lot.result}</td>
						<td>${lot.remarks}</td>
						<td>${lot.user.userName}</td>
						<td class="text-center mx-auto">
						<a href="update?lotId=${lot.lotId}">
						<i class="bi bi-pen"></i>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
  <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001m-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708z"/>
</svg>	
						</a>
						&nbsp&nbsp&nbsp&nbsp
						<a href="delete?lotId=${lot.lotId}" onclick="return confirmDeletion()">	
						<i class="bi bi-trash"></i>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
  <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
</svg>
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		  confirmDeletion = ()=>{
			  return confirm("Do you want to delete material inspection lot?");
		  }
		</script>
</body>

</html>