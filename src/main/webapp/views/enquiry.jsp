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
                 <form id="enquiryForm" action="saveEnquiry" method="post" >
	                 <div class="box-body">
	                     <div class="row">
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>Firstname</label>
		                            <input type="text" class="form-control" placeholder="Firstname" name="firstname" required>
	                            </div>
	                         </div>
	                         <div class="col-xs-6">
	     	                    <div class="form-group">
		    	                   	<label>Lastname</label>
	                             	<input type="text" class="form-control" placeholder="Lastname" name="lastname" required>
	                             </div>
	                         </div>
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-12">
	                     		<div class="form-group">
		                         	<label>Address</label>
	                     			<textarea rows="3" class="form-control" placeholder="Address" cols=""></textarea>
	                     		</div>	
	                     	</div>
	                     </div>
	                     <div class="row">
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>Phone number</label>
	                             	<input type="text" class="form-control" placeholder="Phone no." name="phonenumber" required>
	                            </div>
	                         </div>
	                         <div class="col-xs-6">
	                         	<div class="form-group">
		                         	<label>e-mail Id</label>
	                             	<input type="text" class="form-control email" name="email" placeholder="E-mail Id">
	                            </div> 	
	                         </div>
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-6">
	                     		<div class="form-group">
		                         	<label>Age</label>
	                             	<input type="text" class="form-control number" name="age" placeholder="Age">
	                            </div> 	
	                         </div>
	                         	
	                     </div>
	                     <div class="row">
	                     	<div class="col-xs-6">
		                     	<div class="form-group">
		                     		<label>Sex</label>
		                     		<div class="">
				                     	<input type="radio" name="sex" class="radio"
												value="M" checked />Male
									</div>
									<div class="">
										<input type="radio" name="sex" class="radio"
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
				                     	<input type="radio" name="gymInfo" class="radio"
												value="M" checked />Newspaper
									</div>
									<div class="">
										<input type="radio" name="gymInfo" class="radio"
											value="F" />Facebook
									</div>
									<div class="">
										<input type="radio" name="gymInfo" class="radio"
											value="F" />Friend
									</div>
									<div class="">
										<input type="radio" name="gymInfo" class="radio"
											value="F" />Other
									</div>	
								</div>
							</div>		
	                     </div>
	                 </div><!-- /.box-body -->
	                 <div class="box-footer">
	                     <button type="submit" class="btn btn-primary">Submit</button>
	                 </div>
	             </form>    
                 
             </div><!-- /.box -->
		</div>
	</div>
</section>
<!-- /.content -->