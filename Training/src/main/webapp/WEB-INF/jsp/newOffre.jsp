<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="header.jsp"%>
<div class="page-content" style="min-height: 1190px">
	<div class="container">
		<div class="page-container">
			<div class="page-side-wrapper">
				<div class="page-content" style="min-height: 1190px">

					<div class="page-bar col-md-12">
						<ul class="page-breadcrumb">
							<li><i class="fa fa-home"></i> <a href="/user/vendeur">Home</a> <i class="fa fa-angle-right"></i></li>
							<li><a href="/offre/new/">Création offre</a></li>
						</ul>
						<div class="top-menu">
							<ul class="nav navbar-nav pull-right">

								<li class="dropdown dropdown-user"><a href="javascript:;"
									class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-close-others="true"
									aria-expanded="false"> <span
										class="username username-hide-on-mobile"> ${usrName} </span> <i
										class="fa fa-angle-down"></i>
								</a>
									<ul class="dropdown-menu dropdown-menu-default">
										<li><a id="descVendeur"> <i
												class="icon-user"></i> My Profile
										</a></li>

										<li><a href="/logout"> <i class="icon-key"></i> Log
												Out
										</a></li>
									</ul></li>

							</ul>
						</div>
					</div>

					<form:form class="form-horizontal form-row-seperated"
						id="formNewOffre" modelAttribute="formulaireCreationOffre">
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption">
									<span class="caption-subject font-green-sharp bold uppercase">
										Création d'offre </span>
								</div>
								<div class="actions btn-set">
									<button id="backButton" type="button" name="back"
										class="btn btn-default btn-circle">
										<i class="fa fa-angle-left"></i> Back
									</button>
									<!-- <button id="saveButton" class="btn green-haze btn-circle">
						<i class="fa fa-check"></i> Save
					</button> -->
								</div>
							</div>
							<div class="portlet-body">
								<div class="tabbable">

									<div class="tab-content no-space">
										<div class="tab-pane active" id="tab_general">
											<div class="form-body">
												<div class="form-group">
													<label class="col-md-3 control-label">Produit: <span
														class="required"> * </span>
													</label>
													<div class="col-md-3">
														<form:input path="produit" type="text"
															class="form-control" placeholder="Nom du produit"
															name="produit" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Quantité: <span
														class="required"> * </span>
													</label>
													<div class="col-md-3">
														<form:input type="text" class="form-control"
															path="quantite" placeholder="Quantité" required="true" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Unité: <span
														class="required"> * </span>
													</label>
													<div class="col-md-3">
														<form:input type="text" class="form-control" path="unite"
															placeholder="Unité" required="true" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Prix à
														l'unité: <span class="required"> * </span>
													</label>
													<div class="col-md-3">
														<form:input type="text" class="form-control"
															path="prixUnite" placeholder="Prix" required="true" />
													</div>
												</div>
												<form:button id="save"
													class="submit btn green-haze btn-circle" value="Valider">
													<i class="fa fa-check"></i> Save</form:button>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>


					<c:if test="${not empty recap}">
						<div class="col-md-3 col-sm-12">
							<div class="portlet green-meadow box">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-cogs"></i>Récapitulatif de l'offre ajoutée
									</div>
								</div>
								<div class="portlet-body">
									<div class="row static-info">
										<div class="col-md-12 value">
											Produit : ${recap.produit.nom}<br> Quantité :
											${recap.quantite}<br> Unité : ${recap.unite}<br>
											PrixUnité : ${recap.prixUnite}<br> Date de création :
											${recap.dateCreation} <br>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- <script src="../../assets/global/plugins/jquery-2.1.4.min.js" 	type="text/javascript"></script> -->
<!-- <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script> -->

<!-- <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script> -->
<!-- <script src="../../ressources/js/jquery.validate.js" type="text/javascript"></script>  -->

<!-- <script src="../../ressources/js/newOffre.js" type="text/javascript"></script> -->


<%@include file="footer.jsp"%>