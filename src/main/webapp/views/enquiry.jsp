<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
<span><c:if test="${not empty message}">
User registered succesfully with member Id : <c:out value="${memberId}" />
	</c:if></span>
<!-- Main content -->
<section class="content">
	<div class="form-box" id="login-box">
		<div class="header">Register New Membership</div>
		<f:form action="memberRegisterSubmit" method="post"
			 modelAttribute="memberRegister"
			id="memberRegisterSubmit">
			<div class="body bg-gray">
				<div class="form-group">

					<f:errors path="firstName" class="control-label fa fa-times-circle-o"/> 
					<input type="text" name="firstName" class="form-control"
						placeholder="First Name" />
				</div>
				<div class="form-group">
				<f:errors path="lastName" class="control-label fa fa-times-circle-o"/> 
					
					<input type="text" name="lastName" class="form-control"
						placeholder="Last Name" />
				</div>
				<div class="form-group">
					<label> <input type="radio" name="sex" class="radio"
						value="M" checked />Male
					</label> <label> <input type="radio" name="sex" class="radio"
						value="F" />Female
					</label>
				</div>
				<div class="form-group">
					<input type="text" name="age" class="form-control"
						placeholder="Age" />
				</div>
				<div class="form-group">
					<textarea name="address" class="form-control"
						placeholder="Address..." form="memberRegisterSubmit">
                    </textarea>
				</div>
				<div class="form-group">
					<f:errors path="email" class="control-label fa fa-times-circle-o"/> 
					<input type="text" name="email" class="form-control"
						placeholder="Email" />
				</div>
			</div>
			<div class="footer">
				<button type="submit" class="btn bg-olive btn-block">Sign
					me up</button>
			</div>
		</f:form>

		<div class="margin text-center">
			<span>Register using social networks</span> <br />
			<button class="btn bg-light-blue btn-circle">
				<i class="fa fa-facebook"></i>
			</button>
			<button class="btn bg-aqua btn-circle">
				<i class="fa fa-twitter"></i>
			</button>
			<button class="btn bg-red btn-circle">
				<i class="fa fa-google-plus"></i>
			</button>
		</div>
	</div>

</section>
<!-- /.content -->