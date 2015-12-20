$(document).ready(function() {

	$('#packageNameAjax').autocomplete({
		serviceUrl : "getPackagesAjax",
		paramName: "term",
		delimiter: ",",
	   transformResult: function(response) {
		   
		   return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
		      return { value: item.name, data: item.id };
		   })
		            
		 };
		        
          }
		    
	 });
	$('#packageNameAjax').attr('autocomplete','on');			
});
