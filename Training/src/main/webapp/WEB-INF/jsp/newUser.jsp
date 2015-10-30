<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container ">
	<div class="page-container ">



		<div class="portlet box blue containerQuiDepasse">
			<div class="portlet-title">
				<div class="caption">Création d'utilisateur</div>
			</div>

			<div class="portlet-body">

				<div class="tabbable-line">
					<ul class="nav nav-tabs ">
						<li class="active"><a href="#tab_15_1" data-toggle="tab"
							aria-expanded="false"> Section 1 </a></li>
						<li><a href="#tab_15_2" data-toggle="tab"
							aria-expanded="true"> Section 2 </a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_15_1">
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption font-green">
										<i class="icon-pin font-green"></i> <span
											class="caption-subject bold uppercase"> Création
											acheteur</span>
									</div>
								</div>
								<div class="portlet-body form">
									<form:form id="formNewAcheteur" modelAttribute="formulaireCreationAcheteur" role="form">
										<div class="form-body">
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="login" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Login</label> <span
													class="help-block">Ce login vous servira lors de
													votre connexion</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="password" type="password" class="form-control"
													id="form_control_1"/> <label for="form_control_1">Mot
													de passe</label> <span class="help-block">Ne divulguez à
													personne votre mot de passe</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<input type="password" class="form-control"
													id="form_control_1"> <label for="form_control_1">Confirmation
													de mot de passe</label> <span class="help-block">Veuillez
													réecrire votre mot de passe</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="telephone" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Téléphone</label> <span
													class="help-block">Ce numéro sera visible par les
													personnes avec qui vous effectuez des transactions</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="nom" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Nom</label> <span
													class="help-block">Votre nom sera visible par les
													personnes avec qui vous effectuez des transactions</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="prenom" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Prénom</label> <span
													class="help-block">Votre prénom sera visible par les
													personnes avec qui vous effectuez des transactions</span>
											</div>
											<div class="form-group">
											<label class="control-label col-md-3">Default Datepicker</label>
											<div class="col-md-3">
												<form:input path="dateNaissance" id="datepicker" class="form-control form-control-inline input-medium date-picker" size="16" value="" type="text"/>
												<span class="help-block">
												Select date </span>
											</div>
										</div>
										</div>
										<div class="form-actions noborder">
											<button id="sendNewAcheteur" type="button" class="btn blue">Submit</button>
											<button type="button" class="btn default cancelCreateUser">Cancel</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="tab_15_2">
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption font-green">
										<i class="icon-pin font-green"></i> <span
											class="caption-subject bold uppercase"> Création
											vendeur</span>
									</div>
								</div>
								<div class="portlet-body form">
									<form:form  id="formNewVendeur" role="form" modelAttribute="formulaireCreationVendeur">
										<div class="form-body">
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="login" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Login</label> <span
													class="help-block">Ce login vous servira lors de
													votre connexion</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="password" type="password" class="form-control"
													id="form_control_1"/> <label for="form_control_1">Mot
													de passe</label> <span class="help-block">Ne divulguez à
													personne votre mot de passe</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<input type="password" class="form-control"
													id="form_control_1"> <label for="form_control_1">Confirmation
													de mot de passe</label> <span class="help-block">Veuillez
													réecrire votre mot de passe</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="telephone" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Téléphone</label> <span
													class="help-block">Ce numéro sera visible dans les
													offres que vous postez</span>
											</div>
											<div
												class="form-group form-md-line-input form-md-floating-label">
												<form:input path="entreprise" type="text" class="form-control" id="form_control_1"/>
												<label for="form_control_1">Nom de votre entreprise</label>
												<span class="help-block">Votre nom sera visible par
													les personnes qui effectuent des transactions avec vous</span>
											</div>

										</div>
										<div class="form-actions noborder">
											<button id="sendNewVendeur" type="button" class="btn blue">Submit</button>
											<button type="button" class="btn default cancelCreateUser">Cancel</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


<script src="../../ressources/js/newUser.js" type="text/javascript"></script> 

	</div>
</div>