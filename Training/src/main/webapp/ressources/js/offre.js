$(document).ready(function(){
	$('#searchButton').on('click', offreSearch);
	$('table').on('click','.buyButton', achatOffre);
	$('#descAch').on('click', redirectDescription);

});


function offreSearch(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/offre",
		data: $('#formRechercheOffre').serialize(),
		success : function(resp){
			$('body').html(resp);
		}
	});
}

function achatOffre(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/offre/"+$(this).attr("data-id-offre"),
//		data : {done : true},
		success : function(resp){
			$('body').html(resp);
			toastr.options = {
					  "closeButton": true,
					  "debug": false,
					  "positionClass": "toast-top-center",
					  "onclick": null,
					  "showDuration": "1000",
					  "hideDuration": "1000",
					  "timeOut": "5000",
					  "extendedTimeOut": "1000",
					  "showEasing": "swing",
					  "hideEasing": "linear",
					  "showMethod": "fadeIn",
					  "hideMethod": "fadeOut"
					}
			toastr.success("transaction validée");
		}
	});
}

function redirectDescription(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/user/acheteur/desc",
		success: function(resp){
			$('body').html(resp);
		}
	});
}
