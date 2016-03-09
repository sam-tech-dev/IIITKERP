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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="../plugins/select2/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
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
        Attendance(Page-1)
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
			 <div class="col-md-12"> 
			  <div class="col-md-3">
			    <div class="form-group">
                  <select class="form-control">
                    <option>Academic Year</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
			  </div>
			  <div class="col-md-3">		
				<div class="form-group">
                  <select class="form-control">
                    <option>Semester</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
			  </div>
			  <div class="col-md-3">
				<div class="form-group">
                  <select class="form-control">
                    <option>Subcode</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
			  </div>
			  <div class="col-md-3">
				<div class="form-group">
					<input type="date"/>
				</div>
			  </div>
			 </div>
			 <div class="col-xs-12">
			  <div class="col-md-3">
				<div class="form-group">
					<label>From</label>
					<input type="time" name="fromTime"/>
				</div>
			  </div>
			  <div class="col-md-3">
				<div class="form-group">
					<label>To</label>
					<input type="time" name="toTime"/>
				</div>
			  </div>
			  <div class="col-md-3">
				<div class="form-group">
                  <select class="form-control">
                    <option>Choose One</option>
                    <option>Laboratory</option>
                    <option>Theory</option>
                  </select>
                </div>
			  </div>
			  <div class="col-md-3">
			  	<div class="form-group">
			  		<div class="form-group">
		                <select class="form-control select2" multiple="multiple" data-placeholder="Select Batch" style="width: 100%;">
		                  <option>Batch-A</option>
		                  <option>Batch-B</option>
		                  <option>Batch-C</option>
		                  <option>Batch-D</option>
		                  <option>Batch-E</option>
		                  <option>Batch-F</option>
		                  <option>Batch-G</option>
                		</select>
              		</div>
			  	</div>
			  </div>
			  <br><br>
			  <div class="btn-group pull-right">
				<button type="button" class="btn btn-block btn-danger">Submit</button>
			  </div>
			</div>
            
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Student Id</th>
                  <th>Student Name</th>
                  <th>Present</th>
                  <th>Absent</th>
                  <th>Leave</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>Std-1</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-2</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-3</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-4</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-5</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-6</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-7</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-8</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-9</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-10</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-11</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-12</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-13</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-14</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-15</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				<tr>
                  <td>Std-16</td>
                  <td>Student-Name</td>
                  <td>80</td>
                  <td>10</td>
                  <td>10</td>
                </tr>
				</tbody>
              </table>
           </div>
            <!-- /.box-body -->
          </div>
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
  <!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstr../bootstrap.min.js"></script>
<script src="../plugins/select2/select2.full.min.js"></script>
<!-- DataTables -->
<script src="../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../di../app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../di../demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
<script>
  $(function () {
    $(".select2").select2();
  });
</script>
</body>
</html>