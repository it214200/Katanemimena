<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<div id="container">
	<form:form action="saveSelection" modelAttribute="student" method="POST" >
		
		<!-- need to associate this data with student id -->
		<form:hidden path="id" />
		
		<table>
        <tr>
            <td><b>Φοιτητής:</b></td>
        
            <td>
            	<form:select path="codeNumber">
                    <form:option value="-" label="-Παρακαλώ Επιλέξτε-"/>
                    <form:options items="${codeNumbersOptions}"/>            
                </form:select>
            </td>
        </tr>
        
        <tr>
            <td><input type="submit" value="Επόμενο"></td>
        </tr>
    </table>
	</form:form>
</div>

</body>
</html>