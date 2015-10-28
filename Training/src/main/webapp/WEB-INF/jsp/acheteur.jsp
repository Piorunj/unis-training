<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<div class="page-content" style="min-height: 1190px">
	<div class="container">
		<div class="page-container">
			<div class="page-side-wrapper">
				<!-- BEGIN CONTENT -->


				<div class="page-content" style="min-height: 1190px">

					<div class="page-bar">
						<ul class="page-breadcrumb">
							<li><i class="fa fa-home"></i> <a href="/user/acheteur">Home ${usrName}</a> </li>
						</ul>
					</div>
										<a id=newTransaction class="btn default blue-stripe"> <i class="fa fa-plus-square-o"></i> Nouvelle
							transaction </a>


					
					<div class="row">
						<div class="col-md-12">
							<!-- BEGIN EXAMPLE TABLE PORTLET-->
							<div class="portlet box blue">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-globe"></i>Mes transactions
									</div>
								</div>
								<div class="portlet-body">

									<div id="sample_1_wrapper" class="dataTables_wrapper no-footer">

										<div class="table-scrollable">
											<table
												class="table table-striped table-bordered table-hover dataTable no-footer"
												id="sample_1" role="grid" aria-describedby="sample_1_info">
												<thead>
													<tr role="row">
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1" aria-sort="ascending"
															aria-label="
										 Transaction ID
									: activate to sort column ascending"
															style="width: 163px;">Trandaction ID</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Email
									"
															style="width: 100px;">Offre</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Points
									"
															style="width: 100px;">Produit</th>
														<th class="sorting" tabindex="0" aria-controls="sample_1"
															rowspan="1" colspan="1"
															aria-label="
										 Joined
									: activate to sort column ascending"
															style="width: 142px;">Vendeur</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Status
									"
															style="width: 158px;">Quantité</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Status
									"
															style="width: 158px;">Unité</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Status
									"
															style="width: 158px;">Prix unité</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Status
									"
															style="width: 158px;">Date création offre</th>
														<th class="sorting_disabled" rowspan="1" colspan="1"
															aria-label="
										 Status
									"
															style="width: 158px;">Date transaction</th>
													</tr>
												</thead>
												<tbody>




													<c:forEach items="${transactionList}" var="item">
														<tr class="gradeX odd" role="row">

															<td class="sorting_1">${item.id}</td>
															<td>${item.offre.id}</td>
															<td>${item.offre.produit.nom}<br>
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

									</div>
								</div>
							</div>
							<!-- END EXAMPLE TABLE PORTLET-->
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<script src="../../assets/global/plugins/jquery.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/acheteur.js" type="text/javascript"></script>
<script type="text/javascript"
	src="../../assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>

<script>
	$('#sample_1').DataTable();
</script>
<script type="text/javascript"
	src="../../assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>



<%@include file="footer.jsp"%>