<!DOCTYPE html>
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
  <link rel="stylesheet" href="../https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

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
                  <th>Student ID</th>
                  <th>Name</th>
                  <th>Category</th>
                  <th>Gender</th>
                  <th>Date Of Birth</th>
                  <th>State(Eligibility)</th>
                  <th>Program Allocated</th>
                  <th>Allocated Categoy</th>
                  <th>Mobile</th>
                  <th>Email</th>
                  <th>Address</th>
                </tr>
                </thead>
                <tbody>
                <tr onclick="return rowValue('student-1')">
                  <td>2013KUCP1001</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-2')">
                  <td>2013KUCP1002</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-3')">
                  <td>2013KUCP1003</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-4')">
                  <td>2013KUCP1004</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-5')">
                  <td>2013KUCP1005</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-6')">
                  <td>2013KUCP1006</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-7')">
                  <td>2013KUCP1007</td>
                  <td>Sumit Kumar Sagar</td>
                  <td>SC</td>
				  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-8')">
                  <td>2013KUCP1008</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-9')">
                  <td>2013KUCP1009</td>
                  <td>Sumit Kumar Sagar</td>
                  <td>SC</td>
				  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				<tr onclick="return rowValue('student-10')">
                  <td>2013KUCP1010</td>
                  <td>Sumit Kumar Sagar</td>
				  <td>SC</td>
                  <td>Male</td>
                  <td>12 July, 1996</td>
                  <td>Uttar Pradesh</td>
                  <td>Computer Science & Engineering</td>
                  <td>Open</td>
                  <td>1234567890</td>
                  <td>timus.k.sagar@gmail.com</td>
                  <td>Bareilly</td>
                </tr>
				
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
</body>
</html>