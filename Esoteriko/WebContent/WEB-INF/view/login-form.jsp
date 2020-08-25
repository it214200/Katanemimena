<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-light bg-light">
  		<a class="navbar-brand" href="/Esoteriko/">
    		<img src="<c:url value="/resources/dit-logo.png" />" alt="" width="150" height="50" class="d-inline-block align-top" loading="lazy">
    		Σύστημα Διαχείρισης Αιτήσεων Σίτισης
  		</a>
	</nav>
	
	<br></br>
	<div>
		<h4>Login</h4>
		
	   <form action="${pageContext.request.contextPath}/authUser" method="POST">
		   <div class="form-group" style="width: 300px">
			<c:if test="${param.error != null}">
		           <i>Sorry! Invalid username/password!</i>
		   </c:if> 
		   		<label for="username">Username</label>  
		   		<input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username"/>
		 
		  </div>	
		 <div class="form-group" style="width: 300px" >
			 	<label for="username">Password</label>  
			   	<input type="password" name="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Password"/>
		 </div>
		 		
		       <input type="submit" name="Login" value="Login" class="btn btn-primary"/>
		       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		   
	   </form>
   </div>


</body>
</html>