$(document).ready(function(){
	$('#loginBtn').on('click', redirectLogin);
	$('#createUserBtn').on('click', redirectCreationCompte);
});


function redirectLogin(){
	$.ajax({
		type: "GET",
		url: "/login",
		success: function(resp){
			$('body').html(resp);
		}
	});
}

function redirectCreationCompte(){
	$.ajax({
		type: "GET",
		url: "/user/create",
		success: function(resp){
			$('body').html(resp);
		}
	});
}
