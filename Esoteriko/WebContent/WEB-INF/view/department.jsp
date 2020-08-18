<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<title>Τμήμα</title>
<style>
.button <span class="glyphicon glyphicon-arrow-left"></span> Left
</style>
</head>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/javascript/example.js" />"></script>
<body>
	<nav class="navbar navbar-light bg-light">
  		<a class="navbar-brand" href="#">
    		<img src="<c:url value="/resources/dit-logo.png" />" alt="" width="150" height="50" class="d-inline-block align-top" loading="lazy">
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Τμήμα: ${department.dName}
  		</a>
	</nav>
<div id="container">
	<table  class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Όνομα</th>
					<th>Επίθετο</th>
					<th>AM</th>
					<th>Email</th>
				</tr>
			</thead>
			<c:forEach var="allStudents" items="${students}">
			<tbody>
				<tr>
					<td>${allStudents.firstName}</td>
					<td>${allStudents.lastName}</td>
					<td>${allStudents.codeNumber}</td>
					<td>${allStudents.email}</td>
				</tr>
			</tbody>
			</c:forEach>
			<tr>
				<td>
					<input type="button" class="btn btn-info" value="Επιστροφή" onclick="window.location.href='/Esoteriko/department/list';" />	
				</td>
			</tr>
			
	</table>
</div>
</body>
</html>