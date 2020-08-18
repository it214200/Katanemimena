<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Επεξεργασία Τμήματος</title>
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
  background-color:#708090;
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

a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
}
#addStudent{
  background-color: #4CAF50;
}
</style>

</head>
<body>

<h2>Τμήμα: ${department.dName}</h2>

<c:url var="addLink" value="/department/addStudent">
	<c:param name="departmentId" value="${department.id}" />
</c:url>

		
<a href="${addLink}" id="addStudent">Προσθήκη Φοιτητή</a>
<br> <br>

<table>
		<tr>
			<th>Φοιτητής</th>
			<th>AM</th>
			<th>Ενέργεια</th>
		</tr>
		<c:forEach var="allStudents" items="${depStudents}">
		<!-- Construct an update link with student id -->
		<c:url var="removeLink" value="/department/deleteStudent">
			<c:param name="studentId" value="${allStudents.id}" />
		</c:url>
		<tbody>
			<tr>
				<td>${allStudents.firstName} ${allStudents.lastName}</td>
				<td>${allStudents.codeNumber}</td>
				<td><a href="${removeLink}">Διαγραφή</a></td>
			</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td>
				<input type="button" value="Επιστροφή" class="button" onclick="window.location.href='/Esoteriko/department/list';" />	
			</td>
		</tr>
</table>

</body>
</html>