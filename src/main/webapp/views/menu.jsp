<%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
    
    <!-- search form -->
    <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
            <input type="text" name="q" class="form-control" placeholder="Search..."/>
            <span class="input-group-btn">
                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
            </span>
        </div>
    </form>
    <!-- /.search form -->
    <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
        	
            <li class="treeview ${page == 'gymPackage' ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Utilities</span>
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/addEnquiryPackages"><i class="fa fa-angle-double-right"></i>Add Enquiry</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/gymPackageHome"><i class="fa fa-angle-double-right"></i>Add/Edit Package</a></li>
                </ul>
            </li>
            <li class="treeview ${page == 'registration' ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Registration</span> 
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/memberRegisterHome"><i class="fa fa-angle-double-right"></i> Member Registration</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/packageRegisterHome"><i class="fa fa-angle-double-right"></i> Package Registration</a></li>
                </ul>
            </li>
			<li class="${page == 'payments' ? 'active' : ''}">
                <a href="pages/widgets.html">
                    <i class="fa fa-money"></i> <span>Payments</span> 
                </a>
            </li>
			<li class="${page == 'attendance' ? 'active' : ''}">
                <a href="pages/widgets.html">
                    <i class="fa fa-th"></i> <span>Attendance</span> 
                </a>
            </li>
                                   
        </ul>
    </section>
    <!-- /.sidebar -->