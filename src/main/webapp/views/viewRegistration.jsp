<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<div class="box-header">
		<h3 class="box-title">View Registrations</h3>
	</div>
	<div>

		<form:form id="memberDataForm" action="showRegistrations"
			method="post" modelAttribute="memberDataForm">
			<div class="box-body">
				<div class="row">
					<div class="col-xs-3">
						<div class="form-group">
							<label>Phone No.</label>
							<form:input id="phnNoForSearch" name="phoneNo" path="phoneNo"
								type="text" class="form-control required"
								placeholder="Phone no." />
						</div>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">Fetch Data</button>
			</div>
		</form:form>
	</div>
</section>
<c:if test="${not empty result && result }">
<jsp:include page="registrationResult.jsp" />
</c:if>
