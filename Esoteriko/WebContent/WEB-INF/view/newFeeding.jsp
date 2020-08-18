<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		
		<i>Τα πεδία με αστερίσκο(*) ειναι υποχρεωτικά!!</i>
		<p>Η εισαγωγή της ημερομηνίας πρέπει να είναι αυτής της μορφής dd/MM/yyyy πχ 18/08/20 αλλιώς δεν γίνεται δεκτή απο το σύστημα</p>
	
		<br><br>
		
		<form:form action="saveFeeding" modelAttribute="feed" method="POST" >
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				
				<tr> 
					<td><label>Ημερομηνία που ξεκινάει η σίτιση(*):</label></td>
					<td><form:input path="feedStart"/></td>
				</tr>
				<tr> 
					<td><label>Ημερομηνία που τελειώνει η σίτιση(*):</label></td>
					<td><form:input path="feedEnd"/></td>
				</tr>
				
				<tr> 
					<td><label>Ημερομηνία που ξεκινάνε οι αιτήσεις για τη σίτιση(*):</label></td>
					<td><form:input path="appStart"/></td>
				</tr>
				<tr> 
					<td><label>Ημερομηνία που τελειώνει η προθεσμία για την υποβολή αιτήσεων(*):</label></td>
					<td><form:input path="appEnd"/></td>
				</tr>
				
			</tbody>
		</table>
			
		<input type="submit" value="Επόμενο" class="button"/>
		</form:form>
		
	</div>
	
</body>
</html>