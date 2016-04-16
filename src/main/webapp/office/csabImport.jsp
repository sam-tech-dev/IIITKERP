<!DOCTYPE html>
<%@page import="postgreSQLDatabase.registration.Query"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IIITK | ERP</title>
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
  .myModal {
      position: relative;
      top: auto;
      bottom: auto;
      right: auto;
      left: auto;
      display: block;
      z-index: 1;
    }

   .myModal {
      background: transparent !important;
    }
  </style>

  
  
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
        CSAB 
        <small>Student Registration List</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>
	
	
        
      <!-- Modal -->
      
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Student Details</h4>
      </div>
      <div class="modal-body">
        
                <table id="modal_table" class="table table-bordered table-striped">
                	<tbody>
                		<tr>
                			<td>Name</td>
                		</tr>
                		<tr>
                			<td>Student ID</td>
                		</tr>
                		<tr>
                			<td>Category</td>
                		</tr>
                		<tr>
                			<td>JEE Main Roll No.</td>
                		</tr>
                		<tr>
                			<td>JEE Advanced Roll No.</td>
                		</tr>
                		<tr>
                			<td>State</td>
                		</tr>
                		<tr>
                			<td>Phone Number</td>
                		</tr>
                		<tr>
                			<td>Email</td>
                		</tr>
                		<tr>
                			<td>Date Of Birth</td>
                		</tr>
                		<tr>
                			<td>Program Allocated</td>
                		</tr>
                		<tr>
                			<td>Allocated Category</td>
                		</tr>
                		<tr>
                			<td>Allocated Rank</td>
                		</tr>
                		<tr>
                			<td>Status</td>
                		</tr>
                		<tr>
                			<td>Choice Number</td>
                		</tr>
                		<tr>
                			<td>Physically Disabled</td>
                		</tr>
                		<tr>
                			<td>Gender</td>
                		</tr>
                		<tr>
                			<td>Quota</td>
                		</tr>
                		<tr>
                			<td>Round</td>
                		</tr>
                		<tr>
                			<td>Willingness</td>
                		</tr>
                		<tr>
                			<td>Address</td>
                		</tr>
                		<tr>
                			<td>RC Name</td>
                		</tr>
                		<tr>
                			<td>Nationality</td>
                		</tr>
                		<tr>
                			<td>ID</td>
                		</tr>
                		<tr>
                			<td>Entry Date</td>
                		</tr>
                		<tr>
                			<td>Reported</td>
                		</tr>
                	</tbody>
                </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
	
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
                  <th>Report</th>
                  <th>View</th>	
                  <th>Name</th>
                  <th>Category</th>
                  <th>JEE Main Roll No.</th>
                  <th>JEE Advanced Roll No.</th>
                  <th>State</th>
                  <th>Phone Number</th>
                  <th>Email</th>
                  <th>Date Of Birth</th>
                  <th>Program Allocated</th>
                  <th>Allocated Category</th>
                  <th>Allocated Rank</th>
                  <th>Status</th>
                  <th>Choice Number</th>
                  <th>Physically Disabled</th>
                  <th>Gender</th>
                  <th>Quota</th>
                  <th>Round</th>
                  <th>Willingness</th>
                  <th>Address</th>
                  <th>RC Name</th>
                  <th>Nationality</th>
                  <th>Entry Date</th>
                  <th>Reported</th>
                </thead>
                <tbody>
                <%
                ArrayList<Student> csab_list=Query.getCsabStudentList();
                Iterator<Student> iterator=csab_list.iterator();
                while(iterator.hasNext()){
    				Student current=iterator.next();
                %>
                <tr>
                  <td><div class="btn-group"><button type="button" class="btn btn-block btn-primary" onclick="report(<%=current.getCsab_id()%>)">Report</button></div></td>
                  <td><button type="button" class="btn btn-block btn-danger" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-eye-open"></i></button></td>
                  <td><%=current.getName() %></td>
                  <td><%=current.getCategory() %></td>
                  <td><%=current.getJee_main_rollno() %></td>
                  <td><%=current.getJee_adv_rollno() %></td>
                  <td><%=current.getState_eligibility()%></td>
                  <td><%=current.getMobile()%></td>
                  <td><%=current.getEmail() %></td>
                  <td><%=current.getDate_of_birth()%></td>
                  <td><%=current.getProgram_allocated()%></td>
                  <td><%=current.getAllocated_category()%></td>
                  <td><%=current.getAllocated_rank()%></td>
                  <td><%=current.getStatus() %></td>
                  <td><%=current.getChoice_no() %></td>
                  <td><%=current.isPwd()%></td>
                  <td><%=current.getGender() %></td>
                  <td><%=current.getQuota() %></td>
                  <td><%=current.getRound() %></td>
                  <td><%=current.getWillingness() %></td>
                  <td><%=current.getPermanent_address() %></td>
                  <td><%=current.getRc_name() %></td>
                  <td><%=current.getNationality() %></td>
                  <td><%=current.getEntry_time() %></td>
                  <td><%=current.isReported() %></td>
                </tr>
				<%
                }
				%>
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
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
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
<script>
$('#myModal').modal();

	function rowValue(string){
		string = string.substring(8);
		alert("Student No is "+string);
		$("#myModal").modal('show');
	}
  </script>
</body>
</html>