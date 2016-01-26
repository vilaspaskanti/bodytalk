<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="box box-success">
<div class="box-header">
    <h3 class="box-title">Member Registration Details</h3>
</div>
<form:form id="memberRegistrationForm" action="saveMemberRegistration" method="post" modelAttribute="memberRegistrationForm">
 <div class="box-body">
 	<jsp:include page="enquiryForm.jsp"></jsp:include>
	
	<!-- Extra field for registration -->
	<form:hidden path="gymUserId" />
	<div class="row">
   	<div class="col-xs-6">
     	<div class="form-group">
     		<label>Packages</label>
     		<div class="pClass">
       	<form:select id="packages" path="packages" class="needsSelection" items="${packageList}" multiple="true" />
			</div>
		</div>
	</div>		
              	</div>
              	
              	<%-- <div class="row">
    <div class="col-xs-3">
    	<div class="form-group">
     	<label>Fees</label>
        <form:input class="form-control required" placeholder="Amount" path="fees"/>
       </div>
    </div>
</div> --%>

<div class="row">
    <div class="col-xs-6">
    	<div class="form-group">
     	<label>Start date</label>
        <form:input id="startDate" class="form-control required" placeholder="Start date" path="startDate"/>
       </div>
    </div>
    <div class="col-xs-6">
     <div class="form-group">
    	<label>Expiry date</label>
        	<form:input id="expiryDate" class="form-control required" placeholder="Expiry date" path="expiryDate"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-xs-6">
    	<div class="form-group">
     	<label>Fees</label>
        <form:input class="form-control required" placeholder="Total amount" path="fees"/>
       </div>
    </div>
    <div class="col-xs-6">
     <div class="form-group">
    	<label>Amount Paid</label>
        	<form:input class="form-control required" placeholder="Amount paid" path="amountPaid"/>
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
         <label class="control-label"><i class="fa fa-check"></i> Gym registration added successfully !</label>
     </div>
    </c:if>
</div><!-- /.box -->