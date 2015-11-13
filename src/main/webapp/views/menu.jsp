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
        	
            <li class="${page == 'enquiry' ? 'active' : ''}">
                <a href="${pageContext.request.contextPath}/enquiry">
                    <i class="fa fa-dashboard"></i> <span>Enquiry</span>
                </a>
            </li>
            <li class="${page == 'registration' ? 'active' : ''}">
                <a href="pages/widgets.html">
                    <i class="fa fa-edit"></i> <span>Registration</span> 
                </a>
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