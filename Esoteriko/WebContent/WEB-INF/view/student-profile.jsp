<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Προφίλ Φοιτητή</title>
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
  background-color: #f44336;
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
</head>
<body>
<h2>Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Προφίλ Φοιτητή</h2>	
<table>
		<tr>
			<th scope="row">AM:</th>
			<td>${student.codeNumber}</td>
		</tr>
		<tr>
			<th scope="row">Όνομα Φοιτητή:</th>
			<td>${student.firstName} ${student.lastName}</td>
		</tr>
		<tr>
			<th scope="row">Email:</th>
			<td>${student.email}</td>
		</tr>
		
		<tr>
			<th scope="row">Τρέχων εξάμηνο:</th>
			<td>${profile.currentSemester}</td>
		</tr>
		<tr>
			<th scope="row">Κατάσταση φοίτησης:</th>
			<td>${profile.status}</td>
		</tr>
		<tr>
			<th scope="row">Ενεργός:</th>
			<td>${profile.active}</td>
		</tr>
		<tr>
			<th scope="row">Εγγεγραμένος απο:</th>
			<td>${profile.registeredFrom}</td>
		</tr>
		<tr>
			<th scope="row">Όνομα μητέρας:</th>
			<td>${profile.mName}</td>
		</tr>
		<tr>
			<th scope="row">Όνομα Πατέρα:</th>
			<td>${profile.fName}</td>
		</tr>
		<tr>
			<th scope="row">Ημερομηνία γέννησης:</th>
			<td>${profile.birthDate}</td>
		</tr>
		<tr>
			<th scope="row">Τηλέφωνο:</th>
			<td>${profile.phone}</td>
		</tr>
		
</table>
	<input type="button" class="button" value="Επιστροφή" onclick="window.location.href='/Esoteriko/student/list';" />	

</body>
</html>