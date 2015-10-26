<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="header.jsp"%>

<div class="col-md-12">
	<form:form class="form-horizontal form-row-seperated" id="formNewOffre" modelAttribute="formulaireCreationOffre">
		<div class="portlet light">
			<div class="portlet-title">
				<div class="caption">
					 <span
						class="caption-subject font-green-sharp bold uppercase">
						Création d'offre </span> 
				</div>
				<div class="actions btn-set">
					<button type="button" name="back"
						class="btn btn-default btn-circle">
						<i class="fa fa-angle-left"></i> Back
					</button>
					<button id="saveButton" class="btn green-haze btn-circle">
						<i class="fa fa-check"></i> Save
					</button>
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
										<form:input path="produit" type="text" class="form-control" 
											placeholder="Nom du produit"/>
									</div>
								</div>
									<div class="form-group">
									<label class="col-md-3 control-label">Quantité: <span
										class="required"> * </span>
									</label>
									<div class="col-md-3">
										<form:input type="text" class="form-control" path="quantite"
											placeholder="Quantité"/>
									</div>
								</div>
									<div class="form-group">
									<label class="col-md-3 control-label">Unité: <span
										class="required"> * </span>
									</label>
									<div class="col-md-3">
										<form:input type="text" class="form-control" path="unite"
											placeholder="Unité"/>
									</div>
								</div>
									<div class="form-group">
									<label class="col-md-3 control-label">Prix: <span
										class="required"> * </span>
									</label>
									<div class="col-md-3">
										<form:input type="text" class="form-control" path="prixUnite"
											placeholder="Prix"/>
									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

<script src="../../assets/global/plugins/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script src="../../ressources/js/newOffre.js" type="text/javascript"></script>


<%@include file="footer.jsp"%>