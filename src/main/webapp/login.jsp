<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SignIn</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
  
  <script src="dist/js/loginForm.js"></script>
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page" style="background:url('image/image.jpg');background-size:cover;">
<div class="login-box">
  <div class="login-logo">
    <a href=""><b>IIIT </b>Kota</a>
  </div>
  
  <div class="login-box-body">
    <p class="login-box-msg">Login Account</p>

    <form method="post" onSubmit="return authenticate(this.ldap_username.value,this.ldap_password.value)">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" name="ldap_username" onclick="$('#error_username').html('')" id="ldap_username" placeholder="Username">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		<div class="form-group has-error">
            <label class="control-label" for="inputError"><span id="error_username"></span></label>
        </div>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="ldap_password" onclick="$('#error_password').html('')" id="ldap_password" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		<div class="form-group has-error">
            <label class="control-label" for="inputError"><span id="error_password"></span></label>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-5 pull-right">
          <button type="submit" name="ldap_submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
      </div>
    </form>

    <a href="forgotPassword.jsp">I forgot my password</a><br>

  </div>
  
</div>

<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>