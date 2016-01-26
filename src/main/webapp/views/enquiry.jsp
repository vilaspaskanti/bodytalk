<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Enquiry <small>Save enquiries</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href=""><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Enquiry</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-6">
			<div class="box box-success">
                 <div class="box-header">
                     <h3 class="box-title">Enquiry Details</h3>
                 </div>
                 <form:form id="enquiryForm" action="saveEnquiry" method="post" modelAttribute="enquiryForm">
	                 <div class="box-body">
	                     <jsp:include page="enquiryForm.jsp"></jsp:include>
	                 </div><!-- /.box-body -->
	                 <div class="box-footer">
	                     <button type="submit" class="btn btn-primary">Save</button>
	                 </div>
	             </form:form>    
                 <c:if test="${success == 'success' }">
	                 <div class="form-group has-success">
	                     <label class="control-label"><i class="fa fa-check"></i> Gym enquirer added successfully !</label>
	                 </div>
                 </c:if>
             </div><!-- /.box -->
		</div>
	</div>
</section>
<!-- /.content -->