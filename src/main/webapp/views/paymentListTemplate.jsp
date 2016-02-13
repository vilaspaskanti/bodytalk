<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="content">
	<div class="row">
			
			<c:if test="${not empty paymentList}">
				<div class="box-header">
					<h3 class="box-title">Payment Details</h3>
				</div>
				<div class="box-body table-responsive">
					<table id="paymentData"
						class="table table-bordered table-hover">
						<thead>
							<tr>
							    <th>Registration Id</th>
								<th>Pay Date</th>
								<th>Pay Amount</th>
								<th>Comments</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${paymentList}" var="current">
								<tr>
									<td><c:out value="${current.registration.id}" /></td>
									<td><c:out value="${formatter.format(current.paymentDate) }" /></td>
									<td><c:out value="${current.paymentAmount}" /></td>
									<td><c:out value="${current.comment}" /></td> 
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		
		</div>
</section>
<script type="text/javascript">
	$(function() {
		$("#paymentData").dataTable();

	});
</script>
<!-- /.content -->