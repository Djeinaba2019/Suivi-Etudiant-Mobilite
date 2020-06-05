const apiURL = location.origin + '/Suivi-Etudiants/';
var year = new Date().getFullYear();



function getChoixMobiliteJson() {
	  var formData = {
			  etudiantId:$('#etudiantId').val(),
			  mobilite1Id:$('#mobilite1Id').val(),
			  mobilite2Id:$('#mobilite2Id').val(),
			  mobilite3Id:$('#mobilite3Id').val(),
			  
	  };
	  return JSON.stringify(formData);
	}


function hideAlert() {
	  if ($(".alert").is(":visible")){
	    $(".alert").fadeOut("fast");
	  }
	}

$(".custom-file-input").on("change", function() {
	  var fileName = $(this).val().split("\\").pop();
	  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});


$("#enregistrer").on("click", function(event) {
	  event.preventDefault();
	  var sJSON = getChoixMobiliteJson();

	  $.ajax({
	    type : "POST",
	    url : apiURL + 'choix/add',
	    data : sJSON,
	    contentType: "application/json",
	    dataType: "json",
	    success : function(msg) {
	      $("#choixFormBanner").html('Data Submitted successfully');
	      $("#choixFormBanner").attr('class', 'alert alert-success');
	      setTimeout(function() { $("#choixFormBanner").addClass('d-none'); }, 10000);
	      console.log(msg);
	    },
	    error : function (request, status, error) {
	      $("#choixFormBanner").html('Error!');
	      $("#choixFormBanner").attr('class', 'alert alert-danger');
	      setTimeout(function() { $("#choixFormBanner").addClass('d-none'); }, 10000);
	      console.log(request.responseText);
	      console.log(error);
	    }
	  });
	});






	
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
				    $('#etudiantId').append('<option value="' + value.matricule + '">' + value.matricule + '</option>');
				});
			    
			},
			error : function (request, status, error) {
			      console.log(request.responseText);
			      console.log(error);
			}
		});
	});
	

	


	$(function()
	{$('#etudiantId').change(function(){
		var matricule = $('#etudiantId').val();
		$.ajax({
			type : "GET",
			url : apiURL + 'etudiant/'+matricule,
			cache:false,
			dataType: "json",
			success : function(data) {
				console.log(data);
				var dep = data.departement.codeDep;
				
				$.ajax({
					type : "GET",
					url : apiURL + 'mobilite/mobilite_'+year+'/'+dep,
					cache:false,
					dataType: "json",
					success : function(data) {
						console.log(data);
						$.each(data, function (index, value) {
						    // APPEND OR INSERT DATA TO SELECT ELEMENT.
							$('#mobilite1Id').append('<option value="' + value.id + '">'+value.ecoles.nom+'  '+ value.typeMobilite+  '</option>');
							$('#mobilite2Id').append('<option value="' + value.id + '">'+value.ecoles.nom+'  '+ value.typeMobilite+  '</option>');
							$('#mobilite3Id').append('<option value="' + value.id + '">'+value.ecoles.nom+'  '+ value.typeMobilite+  '</option>');
						});
						
					},
					error : function (request, status, error) {
					      console.log(request.responseText);
					      console.log(error);
					}
				}); 

			},
			error : function (request, status, error) {
			      console.log(request.responseText);
			      console.log(error);
			}
		}); 
			
	})
	});
