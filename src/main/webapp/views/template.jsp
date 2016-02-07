<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bodytalk | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
        <link href="resources/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        
        <!-- Morris chart -->
        <link href="${pageContext.request.contextPath}/resources/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${pageContext.request.contextPath}/resources/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="${pageContext.request.contextPath}/resources/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="${pageContext.request.contextPath}/resources/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/resources/ajax/jquery.1.10.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/ajax/jquery.autocomplete.min.js"></script>
		<!-- jQuery validate -->
		<script src="resources/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <script src="resources/js/jquery.validate.js" type="text/javascript"></script>
		<script src="resources/ajax/custom.js"></script>
		<script src="resources/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="resources/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        
		<link href="resources/ajax/main.css" rel="stylesheet">
		
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css" />
		
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker3.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
        
        
    </head>
    <body class="skin-blue">
        
        <!-- Header -->
        <tiles:insertAttribute name="header"></tiles:insertAttribute>
        
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <tiles:insertAttribute name="menu"></tiles:insertAttribute>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                
                <tiles:insertAttribute name="body"></tiles:insertAttribute>
                
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <!-- jQuery 2.0.2 -->
<!--         <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
 -->        <!-- jQuery UI 1.10.3 -->
        <!-- <script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        
         --><!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
        
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap-multiselect.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap-multiselect-collapsible-groups.js" type="text/javascript"></script>
        
        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <!-- <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.min.js" type="text/javascript"></script> -->
        <!-- Sparkline -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- fullCalendar -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="${pageContext.request.contextPath}/resources/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
		
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js" type="text/javascript"></script>
		
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/dashboard.js" type="text/javascript"></script>
        <!-- enquiry page js  -->
        <c:if test="${page == 'enquiry' }">
        	<script src="${pageContext.request.contextPath}/resources/js/enquiry.js" type="text/javascript"></script>
        </c:if>
        <c:if test="${page == 'attendance' }">
        	<script src="resources/js/attendance.js" type="text/javascript"></script>
        </c:if>
        <c:if test="${page == 'viewAttendance' }">
        	<script src="resources/js/viewAttendance.js" type="text/javascript"></script>
        </c:if>
        <c:if test="${page == 'registration' }">
        	<script src="${pageContext.request.contextPath}/resources/js/memberRegistration.js" type="text/javascript"></script>
        </c:if>
        <c:if test="${page == 'addPackage' }">
        	<script src="${pageContext.request.contextPath}/resources/js/addPackage.js" type="text/javascript"></script>
        </c:if>
                
		
    </body>
</html>