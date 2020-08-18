<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Λίστα Τμημάτων</title>
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
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Τμήματα
  		</a>
	</nav>

	<div id="content">

		<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Τμήμα</th>
					<th>Δημιουργήθηκε</th>
					<th>Φοιτητές</th>
					<th>Ενέργεια</th>
				</tr>
			</thead>
			<!-- loop over and print our students -->
			<c:forEach var="temp" items="${departments}" varStatus="status">

				<!-- Construct an update link with student id -->
				<c:url var="editLink" value="/department/editDepartment">
					<c:param name="departmentId" value="${temp.id}" />
				</c:url>
				
				<!-- Construct an profile link with student id -->
				<c:url var="viewLink" value="/department/view">
					<c:param name="departmentId" value="${temp.id}" />
				</c:url>
				
				<tbody>
					<tr>
						<td>${temp.dName}</td>
						<td>${temp.dCreated}</td>
						<td>${years[status.index]}</td>
						<td>
							<!-- display the edit link --> 
							<a href="${editLink}">Επεξεργασία</a> | 
							<a href="${viewLink}">Σύνοψη</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<input type="button" class="btn btn-danger" value="Επιστροφή"
			onclick="window.location.href='/Esoteriko';" />
	</div>

</body>
</html>