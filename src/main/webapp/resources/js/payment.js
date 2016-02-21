$( document ).ready(function() {
	$("#createPaymentForm").validate({
		highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
            $(element).next('label.error').remove();
        }
	});
	$("#memberDataForm").validate({
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

});
function initRegistrationId(registrationId)
{
	$("#registrationId").value = registrationId;
}