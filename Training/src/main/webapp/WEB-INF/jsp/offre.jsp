<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							<li><i class="fa fa-home"></i> <a href="/user/acheteur">Home</a> <i class="fa fa-angle-right"></i></li>
							<li><a href="/offre">Recherche offre</a></li>
						</ul>
						<div class="top-menu">
							<ul class="nav navbar-nav pull-right">

								<li class="dropdown dropdown-user"><a href="javascript:;"
									class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-close-others="true"
									aria-expanded="false">
										<span class="username username-hide-on-mobile">
											${usrName} </span> <i class="fa fa-angle-down"></i>
								</a>
									<ul class="dropdown-menu dropdown-menu-default">
										<li><a id="descAch"> <i
												class="icon-user"></i> My Profile
										</a></li>

										<li><a href="/logout"> <i class="icon-key"></i> Log
												Out
										</a></li>
									</ul></li>

							</ul>
						</div>
					</div>

					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">Recherche d'offre</div>
						</div>
						<div class="portlet-body form">
							<!-- BEGIN FORM-->
							<form:form id="formRechercheOffre"
								modelAttribute="formulaireRechercheOffre"
								class="form-horizontal">
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
						<div class="row">
							<div class="col-md-12">
								<!-- BEGIN EXAMPLE TABLE PORTLET-->
								<div class="portlet box blue">
									<div class="portlet-title">
										<div class="caption">
											<i class="fa fa-globe"></i>Offres correspondantes
										</div>
									</div>
									<div class="portlet-body">

										<div id="sample_1_wrapper"
											class="dataTables_wrapper no-footer">

											<div class="table-scrollable">
												<table
													class="table table-striped table-bordered table-hover dataTable no-footer"
													id="sample_1" role="grid" aria-describedby="sample_1_info">
													<thead>
														<tr role="row">
															<th class="sorting" tabindex="0" aria-controls="sample_1"
																rowspan="1" colspan="1" aria-sort="ascending"
																aria-label="
										 Produit
									: activate to sort column ascending"
																style="width: 100px;">Produit</th>
															<th class="sorting_disabled" rowspan="1" colspan="1"
																aria-label="
										 Email
									"
																style="width: 100px;">Vendeur</th>
															<th class="sorting_disabled" rowspan="1" colspan="1"
																aria-label="
										 Points
									"
																style="width: 100px;">Quantité</th>
															<th class="sorting" tabindex="0" aria-controls="sample_1"
																rowspan="1" colspan="1"
																aria-label="
										 Joined
									: activate to sort column ascending"
																style="width: 142px;">Unité</th>
															<th class="sorting_disabled" rowspan="1" colspan="1"
																aria-label="
										 Status
									"
																style="width: 158px;">Prix unité</th>
															<th class="sorting_disabled" rowspan="1" colspan="1"
																aria-label="
										 Status
									"
																style="width: 158px;">Date création</th>
															<th class="sorting_disabled" rowspan="1" colspan="1"
																aria-label="
										 Status
									"
																style="width: 158px;">Réserver</th>
																</tr>
													</thead>
													<tbody>




														<c:forEach items="${offres}" var="item">
															<tr class="gradeX odd" role="row">

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
																<td class="buyButton" data-id-offre="${item.id}"><a
																	class="btn green-meadow"
																	><span aria-hidden="true" class="icon-basket-loaded"></span> Acheter </a><br></td>
															</tr>

														</c:forEach>

													</tbody>


												</table>
											</div>

										</div>
									</div>
								</div>
								<!-- END EXAMPLE TABLE PORTLET-->
							</div>
						</div>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</div>
<script src="../../assets/global/plugins/jquery.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/offre.js" type="text/javascript"></script>

<script type="text/javascript"
	src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>


<script>
	$('#sample_1').DataTable();
</script>

<script type="text/javascript"
	src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>


<%@include file="footer.jsp"%>