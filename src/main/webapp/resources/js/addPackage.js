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
        	        if($("#gymUserId").val() !== '') {
        	        	$("#searchResult").html('');
        	        	$("#searchResult").html('<div class="form-group has-success"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-check"></i> Enquiry data found! </label></div>');
        	        } else {
        	        	$("#searchResult").html('');
        	        	$("#searchResult").html('<div class="form-group has-warning"><label class="control-label">&nbsp;&nbsp;<i class="fa fa-warning"></i> Enquiry data not found! Please fill in the registration form below! </label></div>');
        	        }
        	    }
        	});
        }
	});
	
});

