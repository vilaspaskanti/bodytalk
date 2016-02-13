<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Content Header (Page header) -->

<span><c:if test="${not empty message}">
		<div class="form-group has-success">
			<label class="control-label" for="inputSuccess"><i
				class="fa fa-check"></i> <c:out value="${message}" /> </label>
		</div>
	</c:if></span>
<section class="content">
	<div class="row">
		<div class="col-md-6">
			<div class="box box-success">
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
				<form:form id="createPaymentForm" action="createPayment"
					method="post" modelAttribute="createPaymentForm">
					<c:if test="${not empty registrationList}">
						<div class="box-body table-responsive">

							<table id="registrationData"
								class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>Edit</th>
										<th>Packages</th>
										<th>Start Date</th>
										<th>Expire Date</th>
										<th>Total Cost</th>
										<th>Balance Due</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${registrationList}" var="current">
										<tr id="registration_<c:out value="${current.id}" />">
											<td><input type="radio" name="registrationId"
												value="<c:out value="${current.id}" />"></td>
											<td><c:out value="${current.packages}" />
												</td>
											<td><c:out value="${formatter.format(current.startDate)}" /></td>
											<td><c:out value="${formatter.format(current.expiryDate)}" /></td>
											<td><c:out value="${current.packageCost}" /></td>
											<td><c:out value="${current.balanceDue}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<label>Amount : </label>
										<form:input class="form-control required" placeholder="Amount"
											path="amount" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>From Date : </label>
								<form:input id="payDate" class="form-control required"
									placeholder="Payment Date" path="payDate" />
							</div>
							<form:textarea path="comments" />
							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Create
									Payment</button>
							</div>

						</div>
					</c:if>
					<!-- /.box-body -->
				</form:form>
			</div>
		</div>
	</div>

</section>
<script type="text/javascript">
	$(function() {
		$("#registrationData").dataTable();

	});
</script>
<!-- /.content -->