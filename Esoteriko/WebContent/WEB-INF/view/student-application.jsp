<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Αίτηση Φοιτητή</title>
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
  background-color: #f44336; /* red */
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
<h2>Αίτηση Φοιτητή</h2>
<table>
	<tbody>
		<tr>
			<th scope="row">AM:</th>
			<td>${student.codeNumber}</td>
		</tr>
		<tr>
			<th scope="row">Όνομα Φοιτητή:</th>
			<td>${student.firstName} ${student.lastName}</td>
		</tr>
		<tr>
			<th scope="row">Ημερομηνία Δημιουργίας:</th>
			<td>${application.created}</td>
		</tr>
		<tr>
			<th scope="row">Εισόδημα:</th>
			<td>${application.income}</td>
		</tr>
		<tr>
			<th scope="row">Άνεργοι γονείς:</th>
			<td>${application.unemployed}</td>
		</tr>
		<tr>
			<th scope="row">Αδέρφια που σπουδάζουν:</th>
			<td>${application.brotherss}</td>
		</tr>
		<tr>
			<th scope="row">Σπουδάζει σε διαφορετική πόλη:</th>
			<td>${application.diffCity}</td>
		</tr>
		<tr>
			<th scope="row">Πόντοι:</th>
			<td>${application.points}</td>
		</tr>
		<tr>
			<th scope="row">Εγκρίθηκε:</th>
			<td>${application.validated}</td>
		</tr>
		
	</tbody>
	
</table>
	<input type="button" class="button" value="Back" onclick="window.location.href='/Esoteriko/application/list';" />	
	
</body>
</html>