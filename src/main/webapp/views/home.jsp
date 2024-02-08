<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Your Home Page</title>
<!-- Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 50px;
}
</style>
</head>
<body style="background-color:cyan; ">
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
    
        <div class="container mt-5">

        <h1 class="mb-4">Welcome to the Zettamine</h1>

        <div class="row">

            <div class="col-md-4">
                <a href="/vendors/list" class="btn btn-primary btn-lg btn-block mb-3 py-2">Vendors</a>
            </div>

            <div class="col-md-4">
                <a href="/materials/list" class="btn btn-success btn-lg btn-block mb-3">Materials</a>
            </div>

            <div class="col-md-4">
                <a href="/plants/list" class="btn btn-warning btn-lg btn-block mb-3">Plants</a>
            </div>
            
            <div class="col-md-4">
                <a href="/matChars/list" class="btn btn-info btn-lg btn-block mb-3">Material characteristics</a>
            </div>

            <div class="col-md-4">
                <a href="/actuals/list" class="btn btn-danger btn-lg btn-block mb-3">Inspection Actuals</a>
            </div>

            <div class="col-md-4">
                <a href="/lots/list" class="btn btn-secondary btn-lg btn-block mb-3">Inspection Lot</a>
            </div>

        </div>

       </div>

    </div>
</body>
</html>