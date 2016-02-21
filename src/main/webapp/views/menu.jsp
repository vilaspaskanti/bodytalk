<%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
    
    <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
        	
            <li class="treeview ${page == 'gymPackage' ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>Utilities</span>
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/"><i class="fa fa-angle-double-right"></i>Add Enquiry</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/gymPackageHome"><i class="fa fa-angle-double-right"></i>Add/Edit Package</a></li>
                </ul>
            </li>
            <li class="treeview ${page == 'registration' ? 'active' : ''}">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Registration</span> 
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/memberRegisterHome"><i class="fa fa-angle-double-right"></i>Member Enrollment</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/addPackageRegistration"><i class="fa fa-angle-double-right"></i> Add Package Registration</a></li>
                </ul>
            </li>
			<li class="${page == 'payments' ? 'active' : ''}">
                <a href="pages/widgets.html">
                    <i class="fa fa-money"></i> <span>Payments</span> 
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/showRegistrationsHome"><i class="fa fa-angle-double-right"></i> Add Payments</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/viewPaymentsHome"><i class="fa fa-angle-double-right"></i> View Payments</a></li>
                </ul>
                
            </li>
			<li class="${page == 'attendance' ? 'active' : ''}">
                <a href="pages/widgets.html">
                    <i class="fa fa-th"></i> <span>Attendance</span> 
                </a>
                <ul style="display: block;" class="treeview-menu">
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/showAttendance"><i class="fa fa-angle-double-right"></i>Submit Attendance</a></li>
                   <li><a style="margin-left: 10px;" href="${pageContext.request.contextPath}/viewAttendancePage"><i class="fa fa-angle-double-right"></i>View Attendance</a></li>
                </ul>
            </li>
                                   
        </ul>
    </section>
    <!-- /.sidebar -->