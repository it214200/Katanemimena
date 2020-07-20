<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
</head>
<body>
	<div id="header">
		<h2>Students</h2>
	</div>

	<div id="content">

		<!--  put new button Add Student -->
		<input type="button" value="Add Student"
			onclick="window.location.href='showFormForAdd'; return false;" />
		<!--  add our html table here -->
		<br> <br>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<!-- loop over and print our students -->
			<c:forEach var="tempStudent" items="${students}">

				<!-- Construct an update link with student id -->
				<c:url var="editLink" value="/student/showFormForEdit">
					<c:param name="studentId" value="${tempStudent.id}" />
				</c:url>

				<!-- Construct an delete link with student id -->
				<c:url var="deleteLink" value="/student/delete">
					<c:param name="studentId" value="${tempStudent.id}" />
				</c:url>

				<tr>
					<td>${tempStudent.firstName}</td>
					<td>${tempStudent.lastName}</td>
					<td>${tempStudent.email}</td>
					<td>
						<!-- display the edit link --> <a href="${editLink}">Edit</a> | <a
						href="${deleteLink}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>