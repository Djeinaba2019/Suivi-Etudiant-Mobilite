const apiURL = location.origin + '/esp-template-spring/student';

function getPatientJson() {
  var formData = {
    name:$('#name').val(),
    surname:$('#surname').val(),
    dateOfBirth:$('#dateOfBirth').val()
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
			    content += '<td>' + data[i].name + '</td>';
			    content += '<td>' + data[i].surname + '</td>';
			    content += '<td>' + data[i].dateOfBirth + '</td>';
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
