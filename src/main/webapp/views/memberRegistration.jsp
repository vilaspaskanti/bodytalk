<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Member registration <small>Save member registration</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href=""><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Member registration</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-6">
			<div class="box box-success">
				<div class="box-header">
                     <h3 class="box-title">Fetch Member Enquiry details</h3>
                 </div>
                 <form id="memberDataForm" action="">
                 	<div class="box-body">
                 		<div class="row">
						    <div class="col-xs-3">
						    	<div class="form-group">
						     	<label>Phone No.</label>
						        <input id="phnNoForSearch" name="phnNoForSearch" type="text" class="form-control required" placeholder="Phone no." />
						       </div>
						    </div>
						</div>
                 	</div>
                 	<div class="box-footer">
	                     <button type="submit" class="btn btn-primary">Fetch Data</button>
	                 </div>
                 </form>
                 <div id="searchResult">
                 
                 </div>
			</div>
			<div id="memberRegistrationData">
				<jsp:include page="memberRegistrationForm.jsp"></jsp:include>
			</div>	
		</div>
	</div>
</section>
<!-- /.content -->