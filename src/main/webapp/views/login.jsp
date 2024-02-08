<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" />
<style>
body {
	background-color: #f8f9fa;
}

.login-container {
	width: 300px;
	margin: 100px auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body class="bg-info">
	<div class="container m-auto align-items-center">
	<h2 class="text-center" style="font-weight: bold; color: green">Zettamine Labs private Limited</h2>
		<div class="w-50 bg-secondary text-center m-auto mt-5 py-4" style="border-radius: 15px; box-shadow: 10px 10px 10px black">
			<h2 class="text-center">User login</h2>

			<f:form action="loginToApp" method="post" modelAttribute="user"
				class="w-75 mx-auto">
				<table>
					<tr>
						<th style="color:lightgray;"><h4>Username:</h4></th>
						<td>
							<div class="form-group w-60" >
								<f:input class="form-control text-center m-3" name="userName"
									path="userName" required="required" autofocus="autofocus" />
							</div>
						</td>
					</tr>
					<tr>
						<th style="color:lightgray;"><h4>Password:</h4></th>
						<td>
							<div class="form-group w-60">
								<f:input class="form-control text-center m-3" name="userPassword"
									path="userPassword" type="password" required="required" />
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group text-center mt-3">
								<button type="submit" class="btn btn-primary ">Login</button>
							</div>
						</td>
					</tr>
				</table>
			</f:form>
			<c:if test="${user.userId!=null}">
				<h4 style="color: red;">${msg}${uname}</h4>
			</c:if>
		</div>
	</div>
</body>
</html>