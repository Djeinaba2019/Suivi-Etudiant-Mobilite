const apiURL = location.origin + '/Suivi-Etudiants/etudiant';
const apiURL1 = location.origin + '/Suivi-Etudiants/departement';


function getEtudiantJson() {
	  var formData = {
			  matricule:$('#matricule').val(),
			  dateDeNaissance:$('#dateDeNaissance').val(),
			  nom:$('#nom').val(),
			  prenom:$('#prenom').val(),
			  nni:$('#nni').val(),
			  email:$('#email').val(),
			  telephone:$('#telephone').val(),
			  photo:$('#photo').val(),
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
	  var sJSON = getEtudiantJson();

	  $.ajax({
	    type : "POST",
	    url : apiURL + '/add',
	    data : sJSON,
	    contentType: "application/json",
	    dataType: "json",
	    success : function(msg) {
	      $("#etudiantFormBanner").html('Data Submitted successfully');
	      $("#etudiantFormBanner").attr('class', 'alert alert-success');
	      setTimeout(function() { $("#etudiantFormBanner").addClass('d-none'); }, 10000);
	      console.log(msg);
	    },
	    error : function (request, status, error) {
	      $("#etudiantFormBanner").html('Error!');
	      $("#etudiantFormBanner").attr('class', 'alert alert-danger');
	      setTimeout(function() { $("#etudiantFormBanner").addClass('d-none'); }, 10000);
	      console.log(request.responseText);
	      console.log(error);
	    }
	  });
	});





	$("#listEtudiants").ready(function() {
		
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
				    content += '<td>' + data[i].nom + '</td>';
				    content += '<td>' + data[i].prenom + '</td>';
				    content += '<td>' + data[i].telephone + '</td>';
				    content += '<td>' + data[i].photo + '</td>';
				    content += '<td>' + data[i].matricule + '</td>';
				    content += '<td>' + data[i].nni + '</td>';
				    content += '<td>' + data[i].dateDeNaissance + '</td>';
				    content += '<th scope="row">' + data[i].id + '</th>';
				    content += '</tr>';
			    }
			    $('#listEtudiants tbody').html(content);
			},
			error : function (request, status, error) {
			      console.log(request.responseText);
			      console.log(error);
			}
		});
		  
	});
	
	

	$("#listDepartements").ready(function() {
		
		$.ajax({
			type : "GET",
			url : apiURL1 + '/all',
			cache:false,
			dataType: "json",
			success : function(data) {
				console.log(data);
				var content = '';
			    for (var i = 0; i < data.length; i++) {
				    content += '<tr>';
				    content += '<td>' + data[i].codeDep + '</td>';
				    content += '<td>' + data[i].nom + '</td>';
				    content += '<td>' + data[i].ecolesPartenaire + '</td>';
				    content += '<th scope="row">' + data[i].id + '</th>';
				    content += '</tr>';
			    }
			    $('#listDepartements tbody').html(content);
			},
			error : function (request, status, error) {
			      console.log(request.responseText);
			      console.log(error);
			}
		});
		  
	});
