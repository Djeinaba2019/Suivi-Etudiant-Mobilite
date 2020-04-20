<<<<<<< HEAD
const apiURL = location.origin + '/Suivi-Etudiants/ecole';
function getPatientJson() {
  var formData = {
    pays:$('#pays').val(),
    adresse:$('#adresse').val(),
    email:$('#email').val()
    nom:$('#nom').val()
    quotas:$('#quotas').val()
    site_web:$('#site_web').val()
    telephone:$('#telephone').val()
    type_accords:$('#type_accords').val(),
    ville:$('#ville').val(),
    specialite:$('#specialite').val(),
    
=======
const apiURL = location.origin + '/esp-template-spring/student';
function getPatientJson() {
  var formData = {
    name:$('#name').val(),
    surname:$('#surname').val(),
    dateOfBirth:$('#dateOfBirth').val()
>>>>>>> 5cce158688d76488fc9445f95a81aa9fbdbdc5af
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
<<<<<<< HEAD
    success : function(msg) {   
              $("#EcoleFormBanner").html('Data Submitted successfully');
              $("#EcoleFormBanner").attr('class', 'alert alert-success');
              setTimeout(function() { $("#EcoleFormBanner").addClass('d-none'); }, 10000);
              console.log(msg);
            },
            error: function (request, status, error) {
              $("#EcoleFormBanner").html('Error!');
              $("#EcoleFormBanner").attr('class', 'alert alert-danger');
              setTimeout(function() { $("#EcoleFormBanner").addClass('d-none'); }, 10000);
              console.log(request.responseText);
              console.log(error);
            }
         });
      }

$("#listEcoles").ready(function() {
=======
    success : function(msg) {
      $("#studentFormBanner").html('Data Submitted successfully');
      $("#studentFormBanner").attr('class', 'alert alert-success');
      setTimeout(function() { $("#studentFormBanner").addClass('d-none'); }, 10000);
      console.log(msg);
    },
    error : function (request, status, error) {
      $("#studentFormBanner").html('Error!');
      $("#studentFormBanner").attr('class', 'alert alert-danger');
      setTimeout(function() { $("#studentFormBanner").addClass('d-none'); }, 10000);
      console.log(request.responseText);
      console.log(error);
    }
  });
});

function showStudents(data) {
	var content = '';
    for (var i = 0; i < data.length; i++) {
	    content += '<tr id="' + data[i].id + '">';
	    content += '<td>' + data[i].name + '</td>';
	    content += '<td>' + data[i].surname + '</td>';
	    content += '<td>' + data[i].dateOfBirth + '</td>';
	    content += '<th scope="row"> <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteModal" data-studentid="' + data[i].id + '">&times;</button></th>';
	    content += '</tr>';
    }
    $('#listEtudiants tbody').html(content);
}

$("#listEtudiants").ready(function() {
>>>>>>> 5cce158688d76488fc9445f95a81aa9fbdbdc5af
	
	$.ajax({
		type : "GET",
		url : apiURL + '/all',
		cache:false,
		dataType: "json",
		success : function(data) {
<<<<<<< HEAD
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
			    
			    content += '<th scope="row">' + data[i].id + '</th>';
			    content += '</tr>';
		    }
		    $('#listEcoles tbody').html(content);
=======
			showStudents(data);
>>>>>>> 5cce158688d76488fc9445f95a81aa9fbdbdc5af
		},
		error : function (request, status, error) {
		      console.log(request.responseText);
		      console.log(error);
		}
	});
	  

});

<<<<<<< HEAD
=======
$('#deleteModal').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var studentid = button.data('studentid') 
	var modal = $(this)
	modal.find('.modal-title').text('Supprimer Etudiant ' + studentid)
	modal.find('#doDeleteButton').data('studentid', studentid)
});

$("#doDeleteButton").on("click", function(event) {
	event.preventDefault();
	var studentid = $(this).data('studentid')
	$.ajax({
		type : "DELETE",
		url : apiURL + '/' + studentid,
		success : function(msg) {
			console.log("deleted " + studentid);
			$("#"+studentid).hide();
		},
		error : function (request, status, error) {
			console.log(request.responseText);
		    console.log(error);
		}
	});
});

>>>>>>> 5cce158688d76488fc9445f95a81aa9fbdbdc5af
