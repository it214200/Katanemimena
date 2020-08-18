<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Νέα Αίτση</title>
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
  		<a class="navbar-brand" href="#">
    		<img src="<c:url value="/resources/dit-logo.png" />" alt="" width="150" height="50" class="d-inline-block align-top" loading="lazy">
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Δημιουργία νέας Αίτησης
  		</a>
	</nav>

<div id="container">
	<h3>Επιλογή Αριθμού μητρώου</h3>
	
	<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>AM</th>
					<th>Ενέργεια</th>
				</tr>
			</thead>
			<!-- loop over and print our students -->
			<c:forEach var="temp" items="${students}">

				<!-- Construct an update link with student id -->
				<c:url var="selectLink" value="/application/createApplication">
					<c:param name="codeNumber" value="${temp.codeNumber}" />
				</c:url>
				<tbody>
					<tr>
						<td>${temp.codeNumber}</td>
						<td>
							<!-- display the edit link --> 
							<a href="${selectLink}">Select</a>
						</td>
					</tr>
					
				</tbody>
			</c:forEach>
		</table>
		<input type="button" value="Άκυρο" class="btn btn-danger" onclick="window.location.href='/Esoteriko/application/list';"/>
	
</div>

</body>
</html>