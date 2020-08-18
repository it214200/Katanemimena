<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
 <style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
.button {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
<title>Προφίλ Φοιτητή</title>
</head>
<body>

<h2>Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Δημιουργία προφιλ</h2>

<div id="container">
	
	<form:form action="saveProfile" modelAttribute="profile" method="POST">
		
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
					<td><label>Τρέχων εξάμηνο:</label></td>
					<td><form:input path="currentSemester"/></td>
				</tr>
				
				<tr>
					<td><label>Κατάσταση φοίτησης:</label></td>
					<td><form:input path="status"/></td>
				</tr>
				
				<tr>
					<td><label>Ενεργός:</label></td>
					<td><form:input path="active"/></td>
				</tr>
				
				<tr>
					<td><label>Εγγεγραμένος απο:</label></td>
					<td><form:input path="registeredFrom"/></td>
				</tr>
				
				<tr>
					<td><label>Όνομα μητέρας:</label></td>
					<td><form:input path="mName"/></td>
				</tr>
				
				<tr>
					<td><label>Όνομα Πατέρα:</label></td>
					<td><form:input path="fName"/></td>
				</tr>
				
				<tr>
					<td><label>Ημερομηνία γέννησης:</label></td>
					<td><form:input path="birthDate"/></td>
				</tr>
				
				<tr>
					<td><label>Τηλέφωνο:</label></td>
					<td><form:input path="phone"/></td>
				</tr>
				
			</tbody>
		</table>
		<input type="submit" class="button" value="Αποθήκευση"/>
	</form:form>
	
	<div style="clear; both;"></div>
	
	
</div>
</body>
</html>