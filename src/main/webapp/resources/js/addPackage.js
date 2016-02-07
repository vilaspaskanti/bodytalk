function memberRegistrationInit() {
	$("#addPackageForm").validate({
		ignore: ':hidden:not("#packages")',
		highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).next('label.error').remove();
        },
        errorPlacement: function(error, element) {
            if (element.attr("name") == "packages") {
              error.insertAfter(".pClass");
            } else {
              error.insertAfter(element);
            }
          },
          submitHandler: function(form) {
        	  var formData = $("#addPackageForm").serialize();
        	  $.ajax({
          		method: "POST",
          		data:formData,
          		url: "saveAddPackage",
          		dataType: "json",
          		success: function(data) {
          			if(data.status == 'SUCCESS') {
          				$.ajax({
          	        		method: "GET",
          	        		url: "addPackage?phoneno="+data.identifier,
          	        		success: function(data) {
          	        	        $('#addRegistrationData').html(data);
          	        	        $("input[type='checkbox'], input[type='radio']").iCheck({
          	        	            checkboxClass: 'icheckbox_minimal',
          	        	            radioClass: 'iradio_minimal'
          	        	        });
          	        	        memberRegistrationInit();
          	        	        if($("#gymUserId").val()) {
          	        	        	$("#searchResult").html('');
          	        	        	$("#searchResult").html('<div class="form-group has-success"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-check"></i> Below Registrations found! </label></div>');
          	        	        } else {
          	        	        	$("#searchResult").html('');
          	        	        	$("#searchResult").html('<div class="form-group has-warning"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-warning"></i> No such member found! </label></div>');
          	        	        }
          	        	    }
          	        	});
          			}
          	    }
          	});
          }
	});
	
	$('#packages').multiselect({
		nonSelectedText: 'Select Packages',
		onChange : function(option, checked) {
			if (checked) {
				$(".pClass").closest('.form-group').removeClass('has-error');
	            $(".pClass").next('label.error').remove();
            }
        }
	});
	
	$.validator.addMethod("needsSelection", function (value, element) {
	    var count = $(element).find('option:selected').length;
	    return count > 0;
	});
	
	$.validator.messages.needsSelection = 'Select atleast one package';
	
	$('#startDate').datepicker({
	    format: "dd/mm/yyyy"
	});
	
	$('#expiryDate').datepicker({
	    format: "dd/mm/yyyy"
	});
}

$( document ).ready(function() {
	
	$("#memberDataForm").validate({
		highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).next('label.error').remove();
        },
        submitHandler: function(form) {
        	$.ajax({
        		method: "GET",
        		url: "addPackage?phoneno="+$("#phnNoForSearch").val(),
        		success: function(data) {
        	        $('#addRegistrationData').html(data);
        	        $("input[type='checkbox'], input[type='radio']").iCheck({
        	            checkboxClass: 'icheckbox_minimal',
        	            radioClass: 'iradio_minimal'
        	        });
        	        memberRegistrationInit();
        	        if($("#gymUserId").val()) {
        	        	$("#searchResult").html('');
        	        	$("#searchResult").html('<div class="form-group has-success"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-check"></i> Below Registrations found! </label></div>');
        	        } else {
        	        	$("#searchResult").html('');
        	        	$("#searchResult").html('<div class="form-group has-warning"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-warning"></i> No such member found! </label></div>');
        	        }
        	    }
        	});
        }
	});
	
});

