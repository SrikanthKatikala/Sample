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

<title>Search in lot by Date</title>
</head>
<body>
<h1></h1>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h4>Search</h4>
                </div>
                <div class="card-body">
                    <f:form action="submit.jsp" method="post">
                        <table class="table">
                            <tr>
                                <td><label for="name">Name:</label></td>
                                <td><input type="text" class="form-control" id="name" name="name" required></td>
                            </tr>
                            <tr>
                                <td><label for="email">Email:</label></td>
                                <td><input type="email" class="form-control" id="email" name="email" required></td>
                            </tr>
                            <tr>
                                <td><label for="message">Message:</label></td>
                                <td><textarea class="form-control" id="message" name="message" rows="4" required></textarea></td>
                            </tr>
                        </table>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </f:form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>