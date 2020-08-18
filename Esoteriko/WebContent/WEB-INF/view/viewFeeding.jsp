<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Σίτιση</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/javascript/example.js" />"></script>
<body>
	<nav class="navbar navbar-light bg-light">
  		<a class="navbar-brand" href="/Esoteriko/">
    		<img src="<c:url value="/resources/dit-logo.png" />" alt="" width="150" height="50" class="d-inline-block align-top" loading="lazy">
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Φοιτητές
  		</a>
	</nav>
	
	<div id="container">
		
		<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Τμήμα</th>
					<th>Όνομα</th>
					<th>Επίθετο</th>
					<th>AM</th>
					<th>Email</th>
					<th>Περίοδος Σίτισης</th>
				</tr>
			</thead>
			<!-- loop over and print our students -->
			<c:forEach var="temp" items="${students}" >
				
				<tbody>
					<tr>
						<td>${dName}</td>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.codeNumber}</td>
						<td>${temp.email}</td>
						<td>${feedingPeriod}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
			
		<input type="button" class="btn btn-danger" value="Επιστροφή"
			onclick="window.location.href='/Esoteriko';" />
			
	</div>
	
</body>
</html>