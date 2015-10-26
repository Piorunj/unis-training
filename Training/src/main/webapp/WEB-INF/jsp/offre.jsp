<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="header.jsp"%>








<div class="portlet box grey-cascade">
	<div class="portlet-title">
		<div class="caption">Recherche d'offre</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
		<form:form id="formRechercheOffre"
			modelAttribute="formulaireRechercheOffre" class="form-horizontal">
			<div class="form-body">
				<div class="form-group">
					<label class="col-md-3 control-label">Produit</label>
					<div class="col-md-4">
						<form:input path="produit" class="form-control input-circle"
							type="text" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Quantité min</label>
					<div class="col-md-4">

						<form:input path="qtMin" class="form-control input-circle"
							type="text" />

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Quantité max</label>
					<div class="col-md-4">

						<form:input path="qtMax" class="form-control input-circle"
							type="text" />

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Prix min</label>
					<div class="col-md-4">
						<div class="input-icon">
							<form:input path="prixMin" class="form-control input-circle"
								type="text" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Prix max</label>
					<div class="col-md-4">
						<div class="input-icon right">
							</i>
							<form:input path="prixMax" class="form-control input-circle"
								type="text" />
						</div>
					</div>
				</div>

			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-offset-3 col-md-9">
						<button id=searchButton
									class="btn blue btn-circle margin-top-20">
									SEARCH <i class="m-icon-swapright m-icon-white"></i>
								</button>

					</div>
				</div>
			</div>
		</form:form>
		<!-- END FORM-->
	</div>
</div>





<c:if test="${not empty offres}">
	<div class="portlet box grey-cascade">
	<div class="portlet-title">
		<div class="caption">Offres correspondantes</div>
	</div>
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
					<td><a name="buyButton"
						class="btn btn-circle default red-stripe"
						data-id-offre="${item.id}"> Acheter </a><br></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</c:if>

<script src="../../assets/global/plugins/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/offre.js" type="text/javascript"></script>


<%@include file="footer.jsp"%>