<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>

</head>
<body>

<h3>Login</h3>

   <form action="${pageContext.request.contextPath}/authUser" method="POST">
	<c:if test="${param.error != null}">
           <i>Sorry! Invalid username/password!</i>
   </c:if>   
 		<p>
 			First Name:<input type="text" name="username"/>
 		</p>
 		<p>
 			Password:<input type="password" name="password"/>
 		</p>
        
        <input type="submit" name="Login" value="Login"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        
   </form>
   


</body>
</html>