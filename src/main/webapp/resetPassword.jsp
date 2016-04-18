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
    <p class="login-box-msg">Reset Password</p>

     <div class="form-group has-feedback">
        <input type="password" class="form-control" name="old_password" onclick="$('#error_username').html('')" id="old_password" placeholder="Old Password">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		<div class="form-group has-error">
            <label class="control-label" for="inputError"><span id="error_username"></span></label>
        </div>
      </div>
      
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="new_password" onclick="$('#error_username').html('')" id="new_password" placeholder="New Password">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		<div class="form-group has-error">
            <label class="control-label" for="inputError"><span id="error_username"></span></label>
        </div>
  </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="repeat_password" onclick="$('#error_password').html('')" id="repeat_password" placeholder="Repeat Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		<div class="form-group has-error">
            <label class="control-label" for="inputError"><span id="error_password"></span></label>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-5 pull-right">
          <button type="button" onclick="reset()" class="btn btn-primary btn-block btn-flat">Reset Password</button>
        </div>
      </div>

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
<script >

function reset(){
	var old_password,new_password,repeat_password;
	old_password=document.getElementById("old_password").value;
	new_password=document.getElementById("new_password").value;
	repeat_password=document.getElementById("repeat_password").value;
	
	
	var xmlhttp;
	try{
		xmlhttp = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
				//Browser doesn't support ajax	
				alert("Your browser is unsupported");
			}
		}
	}	
	//var xmlhttp=new XMLHttpRequest();

	if(xmlhttp){	
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				
			var data= JSON.parse(xmlhttp.responseText);
			if(data.reset=="success")
			window.location.href="login.jsp";
			else
				alert("Sorry there was an error");
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
			
		}
		xmlhttp.open("POST","ResetPassword",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("old_password="+old_password+"&new_password="+new_password);
	}
	return false;
}

</script>
</body>
</html>