<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Student application</title>

<body>
<h2>Student Application</h2>
<table>
		<tr>
			<th scope="row">Date Created:</th>
			<td>${application.created}</td>
		</tr>
		<tr>
			<th scope="row">Income:</th>
			<td>${application.income}</td>
		</tr>
		<tr>
			<th scope="row">Brothers:</th>
			<td>${application.brotherss}</td>
		</tr>
		<tr>
			<th scope="row">Unemployed Parents:</th>
			<td>${application.created}</td>
		</tr>
		<tr>
			<th scope="row">Points:</th>
			<td>${application.points}</td>
		</tr>
		<tr>
			<th scope="row">Validated:</th>
			<td>${application.validated}</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="Back" onclick="window.location.href='/Esoteriko/application/list';" />	
			</td>
		</tr>
</table>

</body>
</html>