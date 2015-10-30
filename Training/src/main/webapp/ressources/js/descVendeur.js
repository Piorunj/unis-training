$(document).ready(function(){
	$('#retourVendeur').on('click', redirect);
});

function redirect(){
	$.ajax({
		type: "GET",
		url: "/user/vendeur",
		success: function(resp){
			$('body').html(resp);
		}
	});
}