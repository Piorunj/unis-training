$(document).ready(function(){
	$('#envoieLogin').on('submit', sendLogin);
	$('body').attr("class", "login");
});


function sendLogin(e){
	e.preventDefault();
	$.ajax({
		type: "POST",
		url: "/user",
		data: $('[name="loginForm"]').serialize(),
		success : function(resp){
			$('body').attr("class", "page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo");
			$('body').html(resp);
		}
	});
}
