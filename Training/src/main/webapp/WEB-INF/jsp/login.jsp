<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<div id="login-box">

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

	<div class="menu-toggler sidebar-toggler important"></div>

	<div class="content important">
		<form id=envoieLogin name='loginForm' class='login-form' method='POST'>

			<h3 class="form-title">Login to your account</h3>
			User:
			<div class="input-icon important">
				<input class="form-control placeholder-no-fix" type='text' name='user' value=''>

			Password: <input class="form-control" type='password' name='password' />
			 <input	id=envoieLogin name="submit" type="submit" value="submit" />
						</div>
		</form>
	</div>

</div>

<div style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 728px; width: 1920px; z-index: -999999; position: fixed;" class="backstretch important"><img src="../../assets/admin/pages/media/bg/1.jpg" style="position: absolute; margin: 0px; padding: 0px; border: medium none; width: 1920px; height: 1440.51px; max-height: none; max-width: none; z-index: -999999; left: 0px; top: -356.255px;"></div>


<script src="../../assets/global/plugins/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/login.js" type="text/javascript"></script>
</html>