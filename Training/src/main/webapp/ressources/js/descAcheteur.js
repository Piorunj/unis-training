$(document).ready(function(){
	$('#retour').on('click', redirect);
});

function redirect(){
	$.ajax({
		type: "GET",
		url: "/user/acheteur",
		success: function(resp){
			$('body').html(resp);
		}
	});
}