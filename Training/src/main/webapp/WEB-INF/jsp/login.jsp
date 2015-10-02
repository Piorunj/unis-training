<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<h1>Spring Security Custom Login Form</h1>

<div id="login-box">

	<h2>Login with Username and Password</h2>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>

	<%-- 	<section class="loginform">
		<form:form id="formTest" action="/index" method="POST"
			modelAttribute="monForm">
		login <form:input path="login" />
			<br>
		password <form:input path="password" type="password" />
			<br>
			<input type="submit" value="Submit" />
		</form:form>
	</section> --%>

	<form name='loginForm'
		 action="/user" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='user' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		</table>

	</form>

</div>

</html>