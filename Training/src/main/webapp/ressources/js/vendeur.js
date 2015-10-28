$(document).ready(function(){
	$('#newOffre').on('click', redirectNewOffre);
	$('table').on('click', '.deleteButton', deleteOffre);
});


function redirectNewOffre(){
	$.ajax({
		type: "GET",
		url: "/offre/new",
		success: function(resp){
			$('body').html(resp);
		}
	});
}

function deleteOffre(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/user/vendeur/delete"+$(this).data("id-offre"),
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
			toastr.success("offre supprimée");
		}
	});
}
