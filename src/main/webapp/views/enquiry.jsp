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
	                     <div class="row">
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>Firstname</label>
		                            <form:input class="form-control required" placeholder="Firstname" path="firstName"/>
	                            </div>
	                         </div>
	                         <div class="col-xs-6">
	     	                    <div class="form-group">
		    	                   	<label>Lastname</label>
	                             	<form:input class="form-control required" placeholder="Lastname" path="lastName" />
	                             </div>
	                         </div>
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-12">
	                     		<div class="form-group">
		                         	<label>Address</label>
	                     			<form:textarea rows="3" class="form-control" placeholder="Address" path="address" cols=""></form:textarea>
	                     		</div>	
	                     	</div>
	                     </div>
	                     <div class="row">
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>Phone number</label>
	                             	<form:input class="form-control required" placeholder="Phone no." path="phoneNo" />
	                            </div>
	                         </div>
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>e-mail Id</label>
	                             	<form:input class="form-control email" path="emailId" placeholder="E-mail Id"/>
	                            </div> 	
	                         </div>
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-6">
	                     		<div class="form-group ${requestScope['org.springframework.validation.BindingResult.enquiryForm'].hasFieldErrors('age') ? 'has-error' : ''}">
		                         	<label>Age</label>
	                             	<form:input class="form-control number" path="age" placeholder="Age"/>
	                             	<label id="-error" class="error"><form:errors path="age" /></label>
	                            </div> 	
	                         </div>
	                         	
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-6">
		                     	<div class="form-group">
		                     		<label>Sex</label>
		                     		<div class="">
				                     	<form:radiobutton path="sex" class="radio"
												value="M" />Male
									</div>
									<div class="">
										<form:radiobutton path="sex" class="radio"
											value="F" />Female
									</div>	
								</div>
							</div>		
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-6">
		                     	<div class="form-group">
		                     		<label>How you came to know about us?</label>
		                     		<div class="">
				                     	<form:radiobutton path="wayOfContact" class="radio"
												value="Newspaper"/>Newspaper
									</div>
									<div class="">
										<form:radiobutton path="wayOfContact" class="radio"
											value="Facebook" />Facebook
									</div>
									<div class="">
										<form:radiobutton path="wayOfContact" class="radio"
											value="Friend" />Friend
									</div>
									<div class="">
										<form:radiobutton path="wayOfContact" class="radio"
											value="Other" />Other
									</div>	
								</div>
							</div>		
	                     </div>
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