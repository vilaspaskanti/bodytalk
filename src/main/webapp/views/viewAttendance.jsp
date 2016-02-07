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
		<li class="active">View Attendance</li>
	</ol>
</section>
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
					<h3 class="box-title">View Attendance</h3>
				</div>
				<form:form id="viewAttendanceForm" action="viewAttendance"
					method="post" modelAttribute="viewAttendanceForm">
					<div class="box-body">
						<div class="row">
							<div class="col-xs-6">
								<div class="form-group">
									<label>Phone No : </label>
									<form:input class="form-control"
										placeholder="Phone no." path="phoneNo" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">
								<div class="form-group">
									<label>From Date : </label>
									<form:input id="fromDate" class="form-control required" placeholder="Start date" path="fromDate"/>	
								</div>
							</div>
							<div class="col-xs-6">	
								<div class="form-group">
									<label>To Date : </label>
									<form:input id="toDate" class="form-control required" placeholder="To Date"
										path="toDate" />
								</div>
							</div>
						</div>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">View</button>
					</div>
				</form:form>
			</div>
			<!-- /.box -->
			<div class="box-header">
		</div>
		<!-- /.box-header -->
		<c:if test="${not empty attendanceList}">
			<div class="box-body table-responsive">
			
				<table id="attendanceData" class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Phone</th>
							<th>In-Time</th>
						</tr>
					</thead>
					<tbody>
	<c:forEach items="${attendanceList}" var="current">
        <tr>
          <td><c:out value="${current.gymUser.firstName}" /></td>
          <td><c:out value="${current.gymUser.lastName}" /></td>
          <td><c:out value="${current.gymUser.phoneNo}" /></td>
          <td><c:out value="${current.date}" /></td>
        </tr>
      </c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		</div>
		</div>
		
</section>
        <script type="text/javascript">
            $(function() {
                $("#attendanceData").dataTable();
                
            });
        </script>
<!-- /.content -->