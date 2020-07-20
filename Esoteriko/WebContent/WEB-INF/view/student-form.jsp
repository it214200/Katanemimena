<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Student</title>
</head>
<body>

<div id="header">
	<h2>Student Form</h2>
</div>

<div id="container">
	<h3>Save Student</h3>
	
	<form:form action="saveStudent" modelAttribute="student" method="POST">
		
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
					<td><label>First Name:</label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				
				<tr>
					<td><label>Last Name:</label></td>
					<td><form:input path="lastName"/></td>
				</tr>
				
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save"/></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	
	<div style="clear; both;"></div>
	
	<p>
		<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
	</p>
	
</div>

</body>
</html>