$( document ).ready(function() {
	$("#viewPaymentsForm").validate({
		highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).next('label.error').remove();
        }
	});
	$('#fromDate').datepicker({
	    format: "dd/mm/yyyy"
	});
	
	$('#toDate').datepicker({
	    format: "dd/mm/yyyy"
	});

});