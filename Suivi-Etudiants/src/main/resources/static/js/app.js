const apiURL = location.origin + '/Suivi-Etudiants/ecole';
function getPatientJson() {
  var formData = {
    pays:$('#pays').val(),
    adresse:$('#adresse').val(),
    email:$('#email').val(),
    nom:$('#nom').val(),
    quotas:$('#quotas').val(),
    site_web:$('#site_web').val(),
    telephone:$('#telephone').val(),
    type_accords:$('#type_accords').val(),
    ville:$('#ville').val(),
    specialite:$('#Specialite').val(),
    
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

$("#doCreateButton").on("click", function(event) {

  event.preventDefault();
  var sJSON = getPatientJson();

  $.ajax({
    type : "POST",
    url : apiURL + '/add',
    data : sJSON,
    contentType: "application/json",
    dataType: "json",
    success : function(msg) {   
              $("#EcoleFormBanner").html('Data Submitted successfully');
              $("#EcoleFormBanner").attr('class', 'alert alert-success');
              setTimeout(function() { $("#EcoleFormBanner").addClass('d-none'); }, 10000);
              console.log(msg);
            },
            error: function (request, status, error) {
              $("#EcoleFormBanner").html('Tout les champs sont obligatoires !');
              $("#EcoleFormBanner").attr('class', 'alert alert-danger');
              setTimeout(function() { $("#EcoleFormBanner").addClass('d-none'); }, 10000);
              console.log(request.responseText);
              console.log(error);
            }
         });
      });

	  $.ajax({
	    type : "POST",
	    url : apiURL + '/add',
	    data : sJSON,
	    contentType: "application/json",
	    dataType: "json",
	    success : function(msg) {
	      console.log(msg);
	      var fileSelect = document.getElementById("photo");
	      if(fileSelect.files && fileSelect.files.length == 1){
	         var file = fileSelect.files[0];
	         var formData = new FormData();
	         formData.append("photo", file);
	         $.ajax({
	            url: apiURL + '/upload',
	            type: "POST",
	            data: formData,
	            enctype: 'multipart/form-data',
	            processData: false,
	            contentType: false,
	            cache: false,
	            success: function (res) {
	              $("#patientFormBanner").html('Data Submitted successfully');
	              $("#patientFormBanner").attr('class', 'alert alert-success');
	              setTimeout(function() { $("#patientFormBanner").addClass('d-none'); }, 10000);
	              console.log(msg);
	            },
	            error: function (request, status, error) {
	              $("#patientFormBanner").html('Error!');
	              $("#patientFormBanner").attr('class', 'alert alert-danger');
	              setTimeout(function() { $("#patientFormBanner").addClass('d-none'); }, 10000);
	              console.log(request.responseText);
	              console.log(error);
	            }
	         });
	      }
	    },
	    error : function (request, status, error) {
	      $("#patientFormBanner").html('Error!');
	      $("#patientFormBanner").attr('class', 'alert alert-danger');
	      setTimeout(function() { $("#patientFormBanner").addClass('d-none'); }, 10000);
	      console.log(request.responseText);
	      console.log(error);
	    }
	  });
	});
$("#listEcoles").ready(function() {
	
	$.ajax({
		type : "GET",
		url : apiURL + '/all',
		cache:false,
		dataType: "json",
		success : function(data) {
			console.log(data);
			var content = '';
		    for (var i = 0; i < data.length; i++) {
			    content += '<tr>';
			    content += '<td>' + data[i].pays + '</td>';
			    content += '<td>' + data[i].adresse + '</td>';
			    content += '<td>' + data[i].email + '</td>';
			    content += '<td>' + data[i].nom + '</td>';
			    content += '<td>' + data[i].quotas + '</td>';
			    content += '<td>' + data[i].site_web + '</td>';
			    content += '<td>' + data[i].telephone + '</td>';
			    content += '<td>' + data[i].type_accords + '</td>';
			    content += '<td>' + data[i].ville + '</td>';
			    content += '<td>' + data[i].specialite + '</td>';
			    content += '<td>' + data[i].photo + '</td>';	    
			    content += '<th scope="row">' + data[i].id + '</th>';
			    content += '</tr>';
		    }
		    $('#listEcoles tbody').html(content);
		},
		error : function (request, status, error) {
		      console.log(request.responseText);
		      console.log(error);
		}
	});
	  

});

