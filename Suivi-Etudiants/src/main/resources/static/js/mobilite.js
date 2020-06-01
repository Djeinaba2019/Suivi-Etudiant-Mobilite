const apiURL = location.origin + '/Suivi-Etudiants/';

function getPatientJson() {
	  var formData = {
	    typeMobilite:$('#type_mobilite').val(),
	    annee:$('#annee').val(),	    
	    departement:$('#departement').val(),  
	    ecole:$('#ecole').val(),
	  };
	  return JSON.stringify(formData);
	}

function hideAlert() {
	  if ($(".alert").is(":visible")){
	    $(".alert").fadeOut("fast");
	  }
	}

$(document).ready(function() 
		{
	$.ajax({
		type : "GET",
		url : apiURL + 'ecole/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			$.each(data, function (index, value) {
			    // APPEND OR INSERT DATA TO SELECT ELEMENT.
			    $('#ecole').append('<option value="' + value.nom + '">' + value.nom + '</option>');
			});
		    
		},
		error : function (request, status, error) {
		      console.log(request.responseText);
		      console.log(error);
		}
	});
	
	


});
   
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


$("#enregistrer").on("click", function(event) {

	  event.preventDefault();
	  var sJSON = getPatientJson();

$.ajax({
    type : "POST",
    url : apiURL + 'mobilite/add',
    data : sJSON,
    contentType: "application/json",
    dataType: "json",
    success : function(msg) {
              $("#MobiliteFormBanner").html('Data Submitted successfully');
              $("#MobiliteFormBanner").attr('class', 'alert alert-success');
              setTimeout(function() { $("#MobiliteFormBanner").addClass('d-none'); }, 10000);
              console.log(msg);
            },
            error: function (request, status, error) {
              $("#MobiliteFormBanner").html('Error!');
              $("#MobiliteFormBanner").attr('class', 'alert alert-danger');
              setTimeout(function() { $("#MobiliteFormBanner").addClass('d-none'); }, 10000);
              console.log(request.responseText);
              console.log(error);
            }
         });
      
    
  });

   

