const apiURL = location.origin + '/Suivi-Etudiants/';
var matricule;

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
			    $('#etudiant').append('<option value="' + value.matricule + '">' + value.matricule + '</option>');
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


$(function()
		{$('#etudiant').change(function(){
			 matricule = $('#etudiant').val();	
			
					$.ajax({
						type : "GET",
						url : apiURL + 'choix/choix/'+matricule,
						cache:false,
						dataType: "json",
						success : function(data) {
							console.log(data);
							$('#mobilite').empty();
							$('#mobilite').append(' <option  selected value="">Mobilité</option>')
							   $('#mobilite').append('<option value="' + data.mobilite1.id + '">'  +data.mobilite1.ecoles.nom +'  '+ data.mobilite1.typeMobilite+'</option>');
							    $('#mobilite').append('<option value="' + data.mobilite2.id + '">' +data.mobilite2.ecoles.nom +'  '+ data.mobilite2.typeMobilite  + '</option>');
							    $('#mobilite').append('<option value="' + data.mobilite3.id + '">' +data.mobilite3.ecoles.nom +'  '+ data.mobilite3.typeMobilite  + '</option>');

						},
						error : function (request, status, error) {
						      console.log(request.responseText);
						      console.log(error);
						}
					});
					
				});

		});
		
	



