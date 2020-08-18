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
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης
  		</a>
	</nav>
	
	<div id="container">
		
		<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Τμήμα</th>
					<th>Συν.Φοιτητών</th>
					<th>Δικαούχοι</th>
					<th>Περίοδος Σίτισης</th>
					<th>Περίοδος Αιτήσεων</th>
					<th>Ενέργεια</th>
				</tr>
			</thead>
			<!-- loop over and print our students -->
			<c:forEach var="temp" items="${feedList}" varStatus="status">

				<!-- Construct an update link with student id -->
				<c:url var="viewLink" value="/feeding/view">
					<c:param name="feedingId" value="${temp.id}" />
				</c:url>

				<!-- Construct an delete link with student id -->
				<c:url var="deleteLink" value="/student/delete">
					<c:param name="studentId" value="${temp.id}" />
				</c:url>
				
				
				<tbody>
					<tr>
						<td>${depName[status.index]}</td>
						<td>${years[status.index]}/${maxStudents[status.index]}</td>
						<td>${winners[status.index]}/${temp.maxStudents}</td>
						<td>${temp.feedStart}-${temp.feedEnd}</td>
						<td>${temp.appStart}-${temp.appEnd}</td>
						<td>
							<!-- display the edit link --> 
							<a href="${viewLink}">Λίστα Φοιτητών</a> | 
							<a href="${editLink}">Επεξεργασία</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
			
		<input type="button" class="btn btn-danger" value="Επιστροφή"
			onclick="window.location.href='/Esoteriko';" />
			
		<input type="button" class="btn btn-success" value="Προσθήκη Φοιτητή"
			onclick="window.location.href='showFormForAdd'; return false;" />
	</div>
	
</body>
</html>