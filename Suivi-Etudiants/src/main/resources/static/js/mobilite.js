const apiURL = location.origin + '/Suivi-Etudiants/ecole';

$(document).ready(function() 
		{
	var $select = $("#opt");
	$.ajax({
		type : "GET",
		url : apiURL + '/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			$.each(data, function (index, value) {
			    // APPEND OR INSERT DATA TO SELECT ELEMENT.
			    $('#ecole').append('<option value="' + value.id + '">' + value.nom + '</option>');
			});
		    
		},
		error : function (request, status, error) {
		      console.log(request.responseText);
		      console.log(error);
		}
	});
	
	


});
   

