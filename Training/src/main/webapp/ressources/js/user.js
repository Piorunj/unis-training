$(document).ready(function(){
	$('#newTransaction').on('click', redirectNewTransaction);
});


function redirectNewTransaction(){
	$.ajax({
		type: "GET",
		url: "/offre",
		success: function(resp){
			$('body').html(resp);
		}
	});
}
