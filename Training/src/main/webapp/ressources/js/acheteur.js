$(document).ready(function(){
	$('#newTransaction').on('click', redirectNewTransaction);
	$('#descAch').on('click', redirectDescription);
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