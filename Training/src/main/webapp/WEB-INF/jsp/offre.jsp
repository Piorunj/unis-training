<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Recherche d'offre</h1>


	<form:form id="formRechercheOffre" action="/offre" method="GET"
		modelAttribute="formulaireRechercheOffre">

		<table>
			<tr>
				<td>Produit:</td>
				<td><form:input path="produit" /></td>
			</tr>
			<tr>
				<td>Quantité min:</td>
				<td><form:input path="qtMin" /></td>
				<td>Quantité max:</td>
				<td><form:input path="qtMax" /></td>
			</tr>
			<tr>
				<td>Prix min:</td>
				<td><form:input path="prixMin" /></td>
				<td>Prix max:</td>
				<td><form:input path="prixMax" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${not empty offres}">
		<c:forEach items="${offres}" var="item">
			${item}<br>
		</c:forEach>
	</c:if>
</body>
</html>