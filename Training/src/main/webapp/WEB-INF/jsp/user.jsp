<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilisateur connecte !</title>
</head>
<body>
	<div id=bandeau>
		<h1>Utilisateur connect� !</h1>
	</div>
	<div id="menu">
		<ul>
			<li>
				<FORM ACTION="offre">
					<INPUT TYPE="SUBMIT" VALUE="Nouvelle transaction">
				</FORM>
			</li>
		</ul>
	</div>
	<c:forEach items="${transactionList}" var="item">
   		${item}<br>
	</c:forEach>
</body>
</html>