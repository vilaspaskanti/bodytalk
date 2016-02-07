<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Attendance <small> Register/View attendance</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href=""><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Attendance</li>
	</ol>
</section>
<span><c:if test="${not empty message}">
		<div class="form-group has-success">
			<label class="control-label" for="inputSuccess"><i
				class="fa fa-check"></i>
			<c:out value="${message}" /> </label>
		</div>
</c:if></span>
<section class="content">
	<div class="row">
		<div class="col-md-6">
			<div class="box box-success">
                 <div class="box-header">
                     <h3 class="box-title">Register Attendance</h3>
                 </div>
                 <form:form id="attendanceForm" action="registerAttendance" method="post" modelAttribute="attendanceForm">
	                 <div class="box-body">
	                     <div class="row">
						    <div class="col-xs-6">
    							<div class="form-group">
     								<label>Phone No : </label>
        								<form:input class="form-control required" placeholder="Phone no." path="phoneNo" />
       							</div>
    						</div>
						</div>
	                 </div><!-- /.box-body -->
	                 <div class="box-footer">
	                     <button type="submit" class="btn btn-primary">Register</button>
	                 </div>
	             </form:form>    
    </div><!-- /.box -->
		</div>
	</div>
</section>
<!-- /.content -->