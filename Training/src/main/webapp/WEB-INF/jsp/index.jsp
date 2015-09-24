<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<section class="loginform">
	<form:form id="formTest" action="/index" method="POST" modelAttribute="monForm">
		login <form:input path="login"/><br>
		password <form:input path="password" type="password"/><br>
		<input type="submit" value="Submit"/>
	</form:form>
</section>

</html>