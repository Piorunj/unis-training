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
		<h1>Utilisateur connecté !</h1>
	</div>
	<p>
		<a id=newTransaction class="btn default blue-stripe">Nouvelle
			transaction </a>
	<table
		class="table table-striped table-bordered table-advance table-hover">
		<thead>
			<tr>
				<th>Transaction ID</th>
				<th>Offre</th>
				<th>Vendeur</th>
				<th>Quantité</th>
				<th>Unité</th>
				<th>Prix unité</th>
				<th>Date création offre</th>
				<th>Date transaction</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactionList}" var="item">
				<tr>
					<td>
  			 			${item.id}<br>
					</td>
					<td>
  			 			${item.offre.id}<br>
					</td>
					<td>
  			 			${item.offre.vendeur.nomEntreprise}<br>
					</td>
					<td>
  			 			${item.offre.quantite}<br>
					</td>
					<td>
  			 			${item.offre.unite}<br>
					</td>
					<td>
  			 			${item.offre.prixUnite}<br>
					</td>
					<td>
  			 			${item.offre.dateCreation}<br>
					</td>
					<td>
  			 			${item.date}<br>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script src="../../ressources/js/user.js" type="text/javascript"></script>

</body>
</html>