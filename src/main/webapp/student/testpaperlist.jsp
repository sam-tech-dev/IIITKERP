<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="postgreSQLDatabase.onlineTest.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Data Tables</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

  <script>
	function rowValue(id){
		
		window.location.href="questions.jsp?testpaper="+id;
	}
  </script>
  
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <%@ include file="header.jsp"%>
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="main-sidebar.jsp" %>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Data Tables
        <small>advanced tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          
		  <div class="box">
            <div class="box-header">
              <h3 class="box-title">Student List</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="overflow-x:scroll;">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>TEST PAPER ID</th>
                  <th>SUBJECT</th>
                  <th>AUTHOR</th>
                  <th>STATUS</th>
                  <th>CREATION DATE</th>
                  <th>DURATION</th>
                 
                </tr>
                </thead>
                <tbody style="cursor:pointer;">
                 
    <%
 ArrayList<TestPaper>papers=postgreSQLDatabase.onlineTest.Query.getTestPaper();
 Iterator<TestPaper> iterator = papers.iterator();	
	while(iterator.hasNext()){
		TestPaper current=iterator.next();   
		%>
                <tr onclick="return rowValue('<%=current.getId() %>')">
                  <td><%=current.getId() %></td>
                  <td><%=current.getSubject()%></td>
				  <td><%=current.getAuthor() %></td>
                  <td><%=current.getStatus() %></td>
                  <td><%=current.getCreation_date() %></td>
                  
                   <td><%=current.getDuration().toString()%></td>
                  
                </tr>
	<% } %>
				
                </tbody>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@ include file="footer.jsp" %>
  <%@ include file="control-sidebar.jsp" %>
  <!-- /.control-sidebar -->
  
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>

<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable({
		"paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": true
	});
  });
</script>
</body>
</html>