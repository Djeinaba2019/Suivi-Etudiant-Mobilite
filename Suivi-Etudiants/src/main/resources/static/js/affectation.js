const apiURL = location.origin + '/Suivi-Etudiants/';


function getAffectationJson() {
	  var formData = {
	    etudiant:$('#etudiant').val(),
	    mobilite:$('#mobilite').val(),
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
		url : apiURL + 'etudiant/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			$.each(data, function (index, value) {
			    // APPEND OR INSERT DATA TO SELECT ELEMENT.
			    $('#etudiant').append('<option value="' + value.email + '">' + value.email + '</option>');
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
		url : apiURL + 'mobilite/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			$.each(data, function (index, value) {
			    // APPEND OR INSERT DATA TO SELECT ELEMENT.
			    $('#mobilite').append('<option value="' + value.id + '">' + value.id + '</option>');
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
	  var sJSON = getAffectationJson();

$.ajax({
  type : "POST",
  url : apiURL + 'affectation/add',
  data : sJSON,
  contentType: "application/json",
  dataType: "json",
  success : function(msg) {
            $("#AffectationFormBanner").html('Data Submitted successfully');
            $("#AffectationFormBanner").attr('class', 'alert alert-success');
            setTimeout(function() { $("#AffectationFormBanner").addClass('d-none'); }, 10000);
            console.log(msg);
          },
          error: function (request, status, error) {
            $("#AffectationFormBanner").html('Error!');
            $("#AffectationFormBanner").attr('class', 'alert alert-danger');
            setTimeout(function() { $("#AffectationFormBanner").addClass('d-none'); }, 10000);
            console.log(request.responseText);
            console.log(error);
          }
       });
    
  
});


