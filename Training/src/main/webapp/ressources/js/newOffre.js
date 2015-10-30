//(function($,W,D)
//{
//    var JQUERY4U = {};
//
//    JQUERY4U.UTIL =
//    {
//        setupFormValidation: function()
//        {
//            //form validation rules
//            $("#formNewOffre").validate({
//                rules: {
//                    produit: "required",
//                },
//                messages: {
//                    produit: "Please enter your firstname",
//                },
//                submitHandler: function(form) {
//                    form.submit();
//                }
//            });
//        }
//    }
//
//    //when the dom has loaded setup form validation rules
//    $(D).ready(function($) {
//        JQUERY4U.UTIL.setupFormValidation();
//    });
//
//})(jQuery, window, document);



$(document).ready(function(){
//	$('#saveButton').on('click', offreCreate);
	$('#backButton').on('click', backPage);
//	$('#save').on('click', offreCreate);
	$('#descVendeur').on('click', redirectDesc);
	
	 $("#formNewOffre").validate({
       rules: {
           produit: "required",
           quantite:{ required: true,
        	   		  number: true
           },
	 		unite: "required",
	 		prixUnite: {
	 			required: true,
	 			number: true
	 		}
       },
       messages: {
           produit: "Veuillez renseigner le nom du produit",
           quantite:{
        	   required: "Veuillez renseigner la quantité",
        	   number: "La quantité doit être un numbre"
           },
       		unite: "Veuillez préciser le système métrique",
       		prixUnite:{
       			required : "Veuillez indiquer le prix",
       			number:"Le prix doit être un nombre"
       		}
       },
       submitHandler: function(form) {
    	   $.ajax({
    			type: "POST",
    			url: "/offre/new",
    			data: $('#formNewOffre').serialize(),
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
    				toastr.success("Offre ajoutée");
    			}
    		});
       }
   });
});

function redirectDesc(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/user/vendeur/desc",
		success: function(resp){
			$('body').html(resp);
		}
	});
}


function offreCreate(e){
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/offre/new",
		data: $('#formNewOffre').serialize(),
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
			toastr.success("Offre ajoutée");
		}
	});
}

function backPage(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/user/vendeur",
		success : function(resp){
			$('body').html(resp);
		}
	});
}
