const apiURL = location.origin + '/Suivi-Etudiants/departement';

function getDepartementJson() {
	  var formData = {	    
	    codeDep:$('#codeDep').val(),
	    nom:$('#nom').val(),
	   	    
	  };
	  return JSON.stringify(formData);
	}

	function hideAlert() {
	  if ($(".alert").is(":visible")){
	    $(".alert").fadeOut("fast");
	  }
	}
	
	
	$("#enregistrer").on("click", function(event) {

		  event.preventDefault();
		  var sJSON = getDepartementJson();

	$.ajax({
	    type : "POST",
	    url : apiURL + '/add',
	    data : sJSON,
	    contentType: "application/json",
	    dataType: "json",
	    success : function(msg) {
	              $("#DepartementFormBanner").html('Data Submitted successfully');
	              $("#DepartementBanner").attr('class', 'alert alert-success');
	              setTimeout(function() { $("#DepartementBanner").addClass('d-none'); }, 10000);
	              console.log(msg);
	            },
	            error: function (request, status, error) {
	              $("#DepartementBanner").html('Error!');
	              $("#DepartementBanner").attr('class', 'alert alert-danger');
	              setTimeout(function() { $("#DepartementBanner").addClass('d-none'); }, 10000);
	              console.log(request.responseText);
	              console.log(error);
	            }
	         });
	      
	    
	  });