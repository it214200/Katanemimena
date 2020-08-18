<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Αίτηση Σιτισης</title>
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
  background-color: #4CAF50; /* Green */
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
</head>

<body>
<h2>Σύστημα Διαχείρισης Αιτήσεων Σίτισης - Αίτηση Σιτισης</h2>

<div id="container">
	
	<i>Τα πεδία με αστερίσκο(*) ειναι υποχρεωτικά!!</i>
	
	<br><br>
	<form:form action="saveApplication" modelAttribute="application" method="POST" >
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				
				<tr> 
					<td><label>Εισόδημα(*):</label></td>
					<td><form:input path="income"/></td>
				</tr>
				
				<tr> 
					<td><label>Αδέρφια που σπουδάζουν σε άλλη πόλη(*):</label></td>
					<td>
						<form:select path="brotherss">
							<form:option value="0" label="0"/>
							<form:option value="1" label="1"/>
							<form:option value="2" label="2"/>
							<form:option value="3" label="3"/>
							<form:option value="4" label="4"/>
							<form:option value="5" label="5"/>
						</form:select>
					</td>
				</tr>
				
				<tr> 
					<td><label>Άνεργοι γονείς(*):</label></td>
					<td>
						Yes<form:radiobutton path="unemployed" value="Yes"/>
						No<form:radiobutton path="unemployed" value="No"/>
					</td>
				</tr>
				
				<tr>
					<td><label>Σπουδάζει σε διαφορετική πόλη(*):</label></td>
					<td>
						Yes<form:radiobutton path="diffCity" value="Yes"/>
						No<form:radiobutton path="diffCity" value="No"/>
					</td>
				</tr>
				
			</tbody>
		</table>
		<input type="submit" value="Επόμενο" class="button"/>
				
	</form:form>
	
</div>

</body>
</html>