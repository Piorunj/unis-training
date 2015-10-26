<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<div id=bandeau>
	<h1>Bienvenue ${usrName}</h1>
</div>
<p>
	<a id=newTransaction class="btn default blue-stripe">Nouvelle
		transaction </a>
<div class="portlet box grey-cascade">
	<div class="portlet-title">
		<div class="caption">Mes transactions</div>
	</div>

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
					<td>${item.id}<br>
					</td>
					<td>${item.offre.id}<br>
					</td>
					<td>${item.offre.vendeur.nomEntreprise}<br>
					</td>
					<td>${item.offre.quantite}<br>
					</td>
					<td>${item.offre.unite}<br>
					</td>
					<td>${item.offre.prixUnite}<br>
					</td>
					<td>${item.offre.dateCreation}<br>
					</td>
					<td>${item.date}<br>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script src="../../assets/global/plugins/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/acheteur.js" type="text/javascript"></script>

<%@include file="footer.jsp"%>