<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<center>
			<b> <font size="3">
					<h1 style="background-color: Orange;">Customers Entrolled</h1>
			</font>
			</b>
		</center>
		<hr>

		<p class="h4 mb-4">Save Customer</p>

		<form action="/CustomerRelationshipManagement/customers/save"
			method="POST">


			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customers.id}" />



			<div class="form-inline">
				<input type="text" name="name" value="${Customers.f_name}"
					class="form-control mb-4 col-4" placeholder="First Name">


			</div>

			<div class="form-inline">

				<input type="text" name="department" value="${Customers.l_name}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="country" value="${Customers.email}"
					class="form-control mb-4 col-4" placeholder="E-Mail">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CustomerRelationshipManagement/customers/list">Back to List</a>

	</div>
</body>

</html>