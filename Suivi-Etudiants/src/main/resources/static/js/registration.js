const apiURL = location.origin + '/Suivi-Etudiants/';

function getUserJson() {
	  var formData = {	    
	    username:$('#username').val(),
	    email:$('#email').val(),
	    password:$('#password').val(),
	   	    
	  };
	  return JSON.stringify(formData);
	};
	
	function hideAlert() {
		  if ($(".alert").is(":visible")){
		    $(".alert").fadeOut("fast");
		  }
		}
	
$("#enregistrer").on("click", function(event) {

	  event.preventDefault();
	  var sJSON = getUserJson();
	  //$("#myModal").modal("hide");

$.ajax({
  type : "POST",
  url : apiURL + 'user/register',
  data : sJSON,
  contentType: "application/json",
  dataType: "json",
  success : function(msg) {
	  $("#EcoleFormBanner").html('Votre inscription est validé cliquez ici ');
      $("#EcoleFormBanner").attr('class', 'alert alert-success');
      setTimeout(function() { $("#EcoleFormBanner").addClass('d-none'); }, 10000);
            console.log(msg);
          },
          error: function (request, status, error) {
           
            console.log(request.responseText);
            console.log(error);
          }
       });
    
  
});
