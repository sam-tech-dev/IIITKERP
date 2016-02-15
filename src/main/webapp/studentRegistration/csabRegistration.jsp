<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>ERP IIITK</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
		<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
		<link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">
		<link rel="stylesheet" href="../plugins/iCheck/flat/blue.css">
		<link rel="stylesheet" href="../plugins/morris/morris.css">
		<link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
		<link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
		<link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker-bs3.css">
		<link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	
    <body class="hold-transition skin-blue sidebar-mini" style="background:url('../image/image.jpg');background-size:cover;">
        <div class="wrapper">
            <%@ include file="../student/header.jsp" %>
 			
 			
 <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar col-xs-6">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <br>
      <div class="small-box bg-aqua">
            <div class="inner">
              <h3>150</h3>

              <p>New Orders</p>
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
       
       <div class="small-box bg-green">
            <div class="inner">
              <h3>53<sup style="font-size: 20px">%</sup></h3>

              <p>Bounce Rate</p>
            </div>
            <div class="icon">
              <i class="ion ion-stats-bars"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
      
       <div class="small-box bg-yellow">
            <div class="inner">
              <h3>44</h3>

              <p>User Registrations</p>
            </div>
            <div class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
          
       <div class="small-box bg-red">
            <div class="inner">
              <h3>65</h3>

              <p>Unique Visitors</p>
            </div>
            <div class="icon">
              <i class="ion ion-pie-graph"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>          
      
    </section>
    <!-- /.sidebar -->
  </aside> 			 			
			
			<div class="content-wrapper" style="min-height: 901px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
      	<div class="col-md-12">
      	    <div class="col-md-3"></div>
      	    <div class="col-md-6">
      	    
      	    	<div class="box box-primary">
      			<!-- /.register-box -->
		<div class="register-logo">
                <a href="#"><b>ERP</b></a>
                 <h4>Update your profile</h4>
            </div>
        <div class="register-box">
            <div class="register-box-body">
               	<form action="" method="post">
					<div class="form-group has-feedback">
						<input type="text" name="std_id" class="form-control" placeholder="Sudent ID">
					</div>
					
					<div class="form-group has-feedback">
						<input type="text" name="name" class="form-control" placeholder="Sudent Name">
					</div>
					
					<div class="form-group has-feedback">
						<select class="form-control" name="category">
							<option value="">Category</option>
							<option value="General">General</option>
							<option value="OBC">OBC</option>
							<option value="SC">SC</option>
							<option value="ST">ST</option>
						</select>
					</div>
					
					<div class="form-group has-feedback">
						<input type="date" name="dob" class="form-control" placeholder="Date of Birth">
					</div>
      
					<div class="form-group has-feedback">
						<input type="text" name="state" class="form-control" placeholder="State">
					</div>
					
					<div class="form-group has-feedback">
						<select class="form-control" name="p_category">
							<option value="">Program Allocated</option>
							<option value="CSE">Computer Science & Engineering</option>
							<option value="ECE">Electronice & Communication Engineering</option>
						</select>
					</div>
					
					<div class="form-group has-feedback">
						<select class="form-control" name="a_category">
							<option value="">Allocated Category</option>
							<option value="Open">Open</option>
							<option value="Close">Close</option>
						</select>
					</div>
					
					<div class="form-group has-feedback">
						<input type="text" name="mobile" class="form-control" placeholder="Mobile">
					</div>
					
					<div class="form-group has-feedback">
						<input type="email" name="email" class="form-control" placeholder="Email">
					</div>
					
					<div class="form-group has-feedback">
						<input type="text" name="state" class="form-control" placeholder="State">
					</div>
					
					<div class="form-group has-feedback">
						<textarea name="address" placeholder="Address..." class="form-control"/></textarea>
					</div>
					
					<div class="row">
						<div class="col-xs-4 pull-right">
							<input type="submit" name="login" value="SignIn" class="btn btn-primary btn-block btn-flat"/>
						</div>
						<!-- /.col -->
					</div>
					
				</form>
					</div>
			<!-- /.form-box -->
        </div>
        
        
      		</div>
      	    
      	    </div>
      	    <div class="col-md-3"></div>
      		
      	</div>
      </div>
    </section>
    <!-- /.content -->
  </div>
		</div>
        
				
		<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
		<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script src="../bootstrap/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="../plugins/morris/morris.min.js"></script>
		<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
		<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<script src="../plugins/knob/jquery.knob.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
		<script src="../plugins/daterangepicker/daterangepicker.js"></script>
		<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
		<script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<script src="../plugins/fastclick/fastclick.min.js"></script>
		<script src="../dist/js/app.min.js"></script>
		<script src="../dist/js/pages/dashboard.js"></script>
		<script src="../dist/js/demo.js"></script>
	</body>
	
</html>