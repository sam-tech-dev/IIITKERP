<!DOCTYPE html>
<%@page import="users.Student"%>
<%@page import="postgreSQLDatabase.registration.Query"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IIIT KOTA | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
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
        Student
        <small>Home</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#" class="active"><i class="fa fa-dashboard"></i>Home</a></li>
        
      </ol>
    </section>
<%Student student= Query.getStudentProfile(Long.parseLong(session.getAttribute("erpId").toString())); %>
    <!-- Main content -->
	<section class="content">

      <div class="row">
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" src="../dist/img/user2-160x160.jpg" alt="User profile picture">

              <h3 class="profile-username text-center"><%=student.getName() %></h3>

              <p class="text-muted text-center"><%=student.getStudent_id() %></p>

            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">About Me</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <strong><i class="fa fa-book margin-r-5"></i> Batch</strong>

              <p class="text-muted">
               <%=student.getEmail() %>
              </p>

              <hr>

              <strong><i class="fa fa-file-text-o margin-r-5"></i> ID</strong>

              <p class="text-muted"><%=student.getStudent_id() %></p>

              <hr>

              <strong><i class="fa fa-map-marker margin-r-5"></i> Address</strong>

              <p><%=student.getPermanent_address() %></p>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#setting" data-toggle="tab">Settings</a></li>
              <li><a href="#changePassword" data-toggle="tab">Change Password</a></li>
            </ul>
            <div class="tab-content">
              
              <div class="tab-pane active" id="setting">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Contact</label>

                    <div class="col-sm-10">
                      <label for="inputName" class="col-sm-2 control-label"><%=student.getMobile()%></label>
                    </div>
                    
                  </div>
                  <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Email</label>

                    <div class="col-sm-10">
                      <label for="inputName" class="col-sm-2 control-label"><%=student.getEmail()%></label>
                    </div>
                    
                  </div>
                  
                </form>
                
              </div>
              
              <div class="tab-pane" id="changePassword">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="inputSkills" class="col-sm-2 control-label">Current Password</label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputSkills" placeholder="Current Password">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputSkills" class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputSkills" placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputSkills" class="col-sm-2 control-label">Repeat Password</label>

                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputSkills" placeholder="Repeat Password">
                    </div>
                  </div>                  
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <div class="checkbox">
                        <label>
                          <input type="checkbox"> I agree to the <a href="#">terms and conditions</a>
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                  </div>
                </form>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@ include file="footer.jsp" %>
  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
 </div>
<!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>