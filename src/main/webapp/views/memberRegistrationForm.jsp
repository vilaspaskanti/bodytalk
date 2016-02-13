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
	
	<!-- package fields -->
	<jsp:include page="packageFields.jsp"></jsp:include>
            	
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
    
    <jsp:include page="registrationResult.jsp" />
</div><!-- /.box -->