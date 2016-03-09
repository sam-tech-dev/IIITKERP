<!DOCTYPE html>
<%@page import="postgreSQLDatabase.registration.Query"%>
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

  <style>
    .example-modal .modal {
      position: relative;
      top: auto;
      bottom: auto;
      right: auto;
      left: auto;
      display: block;
      z-index: 1;
    }

    .example-modal .modal {
      background: transparent !important;
    }
  </style>

  <script>
	function rowValue(string){
		string = string.substring(8);
		alert("Student No is "+string);
	}
  </script>
  
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <%@ include file="header.jsp" %>
 <!-- Left side column. contains the logo and sidebar -->
 <%@ include file="main-sidebar.jsp" %>
<script src="../dist/js/reportStudent.js"></script>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="java.util.Iterator" %>
 <%@ page import="users.Student" %>



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
	
	<span id="hiddenDetails">
		<div class="example-modal">
        <div class="modal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">x</span></button>
                <h4 class="modal-title"></h4>
              </div>
              <div class="modal-body">
                <table id="example1" class="table table-bordered table-striped">
                	<tbody>
                		<tr>
                			<td>Name</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Student ID</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Category</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>JEE Main Roll No.</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>JEE Advanced Roll No.</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>State</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Phone Number</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Email</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Date Of Birth</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Program Allocated</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Allocated Category</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Allocated Rank</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Status</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Choice Number</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Physically Disabled</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Gender</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Quota</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Round</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Willingness</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Address</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>RC Name</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Nationality</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>ID</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Entry Date</td>
                			<td></td>
                		</tr>
                		<tr>
                			<td>Reported</td>
                			<td></td>
                		</tr>
                	</tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
	</span>
	
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
              <table >
                <thead>
                <tr>
                  <th>Verify</th>
                  <th>View</th>	
                  <th>Name</th>
                  <th>first name</th>
                  <th>middle name</th>
                  <th>last name</th>
                  <th>Category</th>
                 <!--  <th>JEE Main Roll No.</th>   -->
                 <!--  <th>JEE Advanced Roll No.</th> -->
                  <th>State</th>
                  <th>Phone Number</th>
                  <th>Email</th>
                  <th>Date Of Birth</th>
                  <th>Program Allocated</th>
                 <!--   <th>Allocated Category</th>
                  <th>Allocated Rank</th>-->
                    <th>Status</th>
                 <!-- <th>Choice Number</th>-->
                  <th>Physically Disabled</th>
                  <th>Gender</th>
                  <!-- <th>Quota</th>
                  <th>Round</th>
                  <th>Willingness</th>
                  <th>Address</th>
                  <th>RC Name</th>  -->
                  <th>Nationality</th>
                    <th>Entry Date</th>
                  <th>Verified</th>
                  </tr>
                </thead>
                <tbody id="reg_table">
               
                
				
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
  <!-- Control Sidebar -->
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
<!--<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
 <script src="../plugins/datatables/dataTables.bootstrap.min.js"></script> -->
<!-- SlimScroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<script src="../dist/js/verifyStudent.js"></script>
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