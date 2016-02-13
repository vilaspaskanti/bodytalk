<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<style>
#ajaxSearch .autocomplete-suggestions {
	border: 1px solid #999;
	background: #FFF;
	overflow: auto;
}

#ajaxSearch .autocomplete-suggestion {
	padding: 5px 5px;
	white-space: nowrap;
	overflow: hidden;
	font-size: 22px
}

#ajaxSearch .autocomplete-selected {
	background: #F0F0F0;
}

#ajaxSearch .autocomplete-suggestions strong {
	font-weight: bold;
	color: #3399FF;
}
</style>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Add/Edit Packages <small> to add packages come here</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href=""><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Utilities</li>
		<li class="active">Packages</li>
	</ol>
</section>
<span><c:if test="${not empty message}">
		<div class="form-group has-success">
			<label class="control-label" for="inputSuccess"><i
				class="fa fa-check"></i> <c:out value="${message}" /> </label>
		</div>
	</c:if></span>
<!-- Main content -->
<section class="content">
	<!-- 	<div class="input-group" id="ajaxSearch">
		<input type="text" name="packageNameAjax" id="packageNameAjax" class="form-control"
			placeholder="Search..." /> <span class="input-group-btn">
			<button type='submit' name='seach' id='search-btn'
				class="btn btn-flat">
				<i class="fa fa-search"></i>
			</button>
		</span>
	</div>
 -->
	<div class="row">
		<div class="col-md-6">
			<div class="box box-success">
			<div class="box-header">
                     <h3 class="box-title">Add/Edit Package</h3>
                 </div>
				
				<f:form action="addEditPackages" method="post"
					modelAttribute="gymPackage" id="addEditPackages">
					<div class="body bg-gray">
						<div class="form-group">
							<f:errors path="code" class="control-label fa fa-times-circle-o" />
							<input type="text" name="code" class="form-control"
								placeholder="Package Code" />
						</div>
						<div class="form-group">
							<f:errors path="name" class="control-label fa fa-times-circle-o" />

							<input type="text" name="name" class="form-control"
								placeholder="Package Name" />
						</div>
						<div class="form-group">
							<f:errors path="description"
								class="control-label fa fa-times-circle-o" />

							<input type="text" name="description" class="form-control"
								placeholder="Package Description" />
						</div>
					</div>
					<div class="footer">
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</f:form>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->