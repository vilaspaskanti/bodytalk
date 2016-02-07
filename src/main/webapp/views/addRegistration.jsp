<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${not empty userFound && userFound }">
<div class="box box-success">
<div class="box-header">
                 <h3 class="box-title">Existing registration details</h3>
             </div>
             <div class="box-body">
             	<c:forEach items="${registrations}" var="registration">
             		<c:forEach items="${registration.packages}" var="pkg" varStatus="stat">
             			<c:set var="pkgs" value="${stat.first ? '' : pkgs} ${pkg.name}"></c:set> 
             		</c:forEach>
             		<div class="row">
             		<div class="col-xs-4">
             			<div class="form-group">
					     	<label>Packages</label>
					        <input type="text" class="form-control" value="${pkgs}" readonly="readonly"/>
					       </div>
             		</div>
					    <div class="col-xs-3">
					    	<div class="form-group">
					     	<label>Start date</label>
					        <input type="text" class="form-control" value="${registration.startDate }" readonly="readonly"/>
					       </div>
					    </div>
					    <div class="col-xs-3">
					     <div class="form-group">
					    	<label>Expiry date</label>
					        	<input type="text" class="form-control" value="${registration.expiryDate }" readonly="readonly"/>
					        </div>
					    </div>
					    <div class="col-xs-2">
					     <div class="form-group">
					    	<label>Amount</label>
					        	<input type="text" class="form-control" value="${registration.packageCost }" readonly="readonly"/>
					        </div>
					    </div>
					</div> 
             	</c:forEach>
             </div>
              
</div>

<div class="box box-success">
<div class="box-header">
                 <h3 class="box-title">Add registration</h3>
             </div>
             <!-- Form -->
             <form:form id="addPackageForm" action="" method="post" modelAttribute="addPackageForm">
              <div class="box-body">
              <form:hidden path="gymUserId" />
              <div class="row">
    <div class="col-xs-6">
    	<div class="form-group">
     	<label>Firstname</label>
        <form:input class="form-control required" placeholder="Firstname" path="firstName" readonly="true"/>
       </div>
    </div>
    <div class="col-xs-6">
     <div class="form-group">
    	<label>Lastname</label>
        	<form:input class="form-control required" placeholder="Lastname" path="lastName" readonly="true"/>
        </div>
    </div>
</div>
              	<!-- package fields -->
				<jsp:include page="packageFields.jsp"></jsp:include>
              </div>
              <div class="box-footer">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
              </form:form>
             
              
</div>
</c:if>