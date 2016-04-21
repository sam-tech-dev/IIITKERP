<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IIITK | ERP</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
  

  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page" style="background:url('../image/image.jpg');background-size:cover;">
<div class="login-box">
  <div class="login-logo">
    <a href=""><b>IIIT </b>Kota</a>
  </div>
  
  <div class="login-box-body">
    <p class="login-box-msg">Welcome Joey!</p>

     <div class="form-group has-feedback">
      <label class="control-label" >Your Student ID is</label>
        <input type="text" class="form-control success" name="old_password" value="<%=session.getAttribute("student_id")%>">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
		
      </div>
      <div class="form-group has-feedback">
      <label class="control-label success" >Your username is</label>
        <input type="text" class="form-control" name="old_password" value="<%=session.getAttribute("username")%>">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
		
      </div>
      <div class="row">
        <div class="col-xs-5 pull-right">
          <button type="button"  onClick="window.location.href='../login.jsp'" class="btn btn-primary btn-block btn-flat">Continue</button>
        </div>
      </div>

  </div>
  
</div>
<%session.invalidate(); %>
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../plugins/iCheck/icheck.min.js"></script>
</body>
</html>