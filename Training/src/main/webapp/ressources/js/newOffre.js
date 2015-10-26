$(document).ready(function(){
	$('#saveButton').on('click', offreSearch);
});


function offreSearch(e){
	e.preventDefault();
	$.ajax({
		type: "GET",
		url: "/offre/new",
		data: $('#formNewOffre').serialize(),
		success : function(resp){
			$('body').html(resp);
		}
	});
}
