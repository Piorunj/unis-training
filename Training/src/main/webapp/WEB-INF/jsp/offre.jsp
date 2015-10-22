<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="header.jsp"%>

	<h1>Recherche d'offre</h1>


	<form:form id="formRechercheOffre"
		modelAttribute="formulaireRechercheOffre">
		<div class="col-md-8">
			<div class="booking-search">
				<div class="row form-group">
					<div class="col-md-6">
						<label class="control-label">Produit: </label>
						<form:input path="produit" class="form-control" type="text" />
					</div>
					<div class="col-md-6">
						<label class="control-label">Quantité min: </label>
						<form:input path="qtMin" class="form-control" type="text" />
					</div>
					<div class="col-md-6">
						<label class="control-label">Quantité max: </label>
						<form:input path="qtMax" class="form-control" type="text" />
					</div>
					<div class="col-md-6">
						<label class="control-label">Prix min: </label>
						<form:input path="prixMin" class="form-control" type="text" />
					</div>
					<div class="col-md-6">
						<label class="control-label">Prix max: </label>
						<form:input path="prixMax" class="form-control" type="text" />
					</div>
					<div class="col-md-6">
						<button id=searchButton class="btn blue btn-block margin-top-20">
							SEARCH <i class="m-icon-swapright m-icon-white"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>


	<c:if test="${not empty offres}">
		<table
			class="table table-striped table-bordered table-advance table-hover">
			<thead>
				<tr>
					<th>Produit</th>
					<th>Vendeur</th>
					<th>Quantité</th>
					<th>Unité</th>
					<th>Prix unité</th>
					<th>Date création</th>
					<th>Réserver</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${offres}" var="item">
					<tr>
						<td>${item.produit.nom}<br>
						</td>
						<td>${item.vendeur.nomEntreprise}<br>
						</td>
						<td>${item.quantite}<br>
						</td>
						<td>${item.unite}<br>
						</td>
						<td>${item.prixUnite}<br>
						</td>
						<td>${item.dateCreation}<br>
						</td>
						<td><a name="buyButton" class="btn btn-circle default red-stripe" data-id-offre="${item.id}"> Acheter </a><br></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	
	<script src="../../assets/global/plugins/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="../../ressources/js/offre.js" type="text/javascript"></script>
	

<%@include file="footer.jsp"%>