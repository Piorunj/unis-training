<div class="page-content" style="min-height: 1190px">
	<div class="container">
		<div class="page-container">
			<div class="page-side-wrapper">
				<div class="page-content" style="min-height: 1190px">




					<div class="portlet light col-md-4 col-md-offset-4">
						<div class="portlet-title">
							<div class="caption font-red-sunglo">
								<i class="icon-settings font-red-sunglo"></i> <span
									class="caption-subject bold uppercase"> Profil</span>
							</div>
								<div class="top-menu">
							<ul class="nav navbar-nav pull-right">

								<li class="dropdown dropdown-user"><a href="javascript:;"
									class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-close-others="true"
									aria-expanded="false">
										<span class="username username-hide-on-mobile">
											${user.login} </span> <i class="fa fa-angle-down"></i>
								</a>
									<ul class="dropdown-menu dropdown-menu-default">
										<li><a> <i
												class="icon-user"></i> My Profile
										</a></li>

										<li><a href="/logout"> <i class="icon-key"></i> Log
												Out
										</a></li>
									</ul></li>

							</ul>
						</div>
						</div>


						<div class="form-group form-md-line-input">
							<div class="form-control form-control-static">
								${user.login}</div>
							<label for="form_control_1">Login</label>
						</div>
						<div class="form-group form-md-line-input">
							<div class="form-control form-control-static">
								${user.telephone}</div>
							<label for="form_control_1">Telephone</label>
						</div>
						<div class="form-group form-md-line-input">
							<div class="form-control form-control-static">
								${acheteur.nom}</div>
							<label for="form_control_1">Nom</label>
						</div>
						
						<div class="form-group form-md-line-input">
							<div class="form-control form-control-static">
								${acheteur.prenom}</div>
							<label for="form_control_1">Prenom</label>
						</div>
						<div class="form-group form-md-line-input">
							<div class="form-control form-control-static">
								${acheteur.dateNaissance}</div>
							<label for="form_control_1">Date de naissance</label>
						</div>
						

						<div class="form-actions noborder">
							<button id="retour" type="button" class="btn default">retour</button>
						</div>


					</div>


				</div>
			</div>
		</div>
	</div>
</div>


 <script src="../../ressources/js/descAcheteur.js" type="text/javascript"></script> 