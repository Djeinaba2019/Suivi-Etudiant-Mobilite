const apiURL = location.origin + '/Suivi-Etudiants/';

$(document).ready(function() 
		{
	$.ajax({
		type : "GET",
		url : apiURL + 'departement/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			$.each(data, function (index, value) {
			    // APPEND OR INSERT DATA TO SELECT ELEMENT.
			    $('#departement').append('<option value="' + value.codeDep + '">' + value.codeDep + '</option>');
			});
		    
		},
		error : function (request, status, error) {
		      console.log(request.responseText);
		      console.log(error);
		}
	});
	
	


});