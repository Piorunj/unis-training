$(document).ready(function(){
	$('#datepicker').datepicker({
	      changeYear: true
	    });
	
	$('#sendNewAcheteur').on('click', sendAcheteur);
	$('#sendNewVendeur').on('click', sendVendeur);
	$(".cancelCreateUser").on('click', redirectHome);
});

function sendAcheteur(e){
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/user/create/acheteur",
		data: $('#formNewAcheteur').serialize(),
		success : function(resp){
			$('body').html(resp);
		}
	});
}

function sendVendeur(e){
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/user/create/vendeur",
		data: $('#formNewVendeur').serialize(),
		success : function(resp){
			$('body').html(resp);
		}
	});
}

function redirectHome(e){
	$.ajax({
		type: "GET",
		url: "/",
		success : function(resp){
			$('body').html(resp);
		}
	});
}