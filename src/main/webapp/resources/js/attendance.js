$( document ).ready(function() {
	$("#attendanceForm").validate({
		highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).next('label.error').remove();
        }
	});
});