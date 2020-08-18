<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
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
  background-color:#4CAF50;
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

.button3 {background-color: #f44336;} /* Red */ 
</style>
<title>Επεξεργασία Στοιχείων Φοιτητή</title>
</head>

<body>
<h2>Σύστημα Διαχείρισης Αιτήσεων Σίτισης</h2>
  
<div id="container">
	
	<form:form action="showFormProfileEdit" modelAttribute="student" method="POST" >
		
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
					<td><label>AM:</label></td>
					<td><form:input path="codeNumber"/></td>
				</tr>
				<tr>
					<td><label>Όνομα:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				
				<tr>
					<td><label>Επίθετο:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				
				
			</tbody>
		</table>
		<input type="button" value="Aκύρωση" class="button button3" onclick="window.location.href='/Esoteriko/student/list';"/>
		<input type="submit" value="Επόμενο" class="button"/>
	</form:form>
	
</div>

</body>
</html>