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
	
	<i>Τα πεδία με αστερίσκο(*) ειναι υποχρεωτικά!!</i>
	<p>Η ημερομηνία συμπληρώνεται σε αυτή τη μορφή <b>dd/MM/yyyy</b> πχ 21/12/2012</p>
	<br></br>
	<form:form action="saveProfile" modelAttribute="profile" method="POST">
		
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr> 
					<td><label>Τρέχων εξάμηνο(*):</label></td>
					<td>
						<form:select path="currentSemester">
							<form:option value="1" label="1"/>
							<form:option value="2" label="2"/>
							<form:option value="3" label="3"/>
							<form:option value="4" label="4"/>
							<form:option value="5" label="5"/>
							<form:option value="6" label="6"/>
							<form:option value="7" label="7"/>
							<form:option value="8" label="8"/>
							<form:option value="9" label="9"/>
							<form:option value="10" label="10"/>
							<form:option value="11" label="11"/>
							<form:option value="12" label="12"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><label>Κατάσταση φοίτησης(*):</label></td>
					<td>
						<form:select path="status">
							<form:option value="Undergraduate studies" label="Προπτυχιακ΄ές Σπουδές"/>
							<form:option value="Postgraduate studies" label="Μεταπτυχιακές Σπουδές"/>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td><label>Ενεργός(*):</label></td>
					<td>
						<form:select path="active">
							<form:option value="Active" label="Ενεργός"/>
							<form:option value="Inactive" label="Μη ενεργός"/>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td><label>Εγγεγραμένος απο(*):</label></td>
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