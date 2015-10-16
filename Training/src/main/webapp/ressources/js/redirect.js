$(document).ready(function(){
	$('input[name=loginBtn]').on('click', redirectLogin);
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
