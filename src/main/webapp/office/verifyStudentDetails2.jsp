<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="postgreSQLDatabase.feePayment.*"%>
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
  <link rel="stylesheet" href="../plugins/iCheck/minimal/_all.css">
  <link rel="stylesheet" href="../plugins/iCheck/all.css">
  <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
 
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
        Fee Payment
        <small>Verification</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#" class="active"><i class="fa fa-dashboard"></i>Home</a></li>
        
      </ol>
    </section>

    <!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Payment Information</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <%
            System.out.println(request.getParameter("reg_id"));
            long reg_id=Long.parseLong(request.getParameter("reg_id").toString());
       
            FeePaymentDetails payment_details=Query.getFeePaymentDetails(reg_id);
            %>
            
            <form role="form" action="../VerifyFeePayment" method="POST">
            <span><input type="hidden" name="ref_no" value="<%=payment_details.getId()%>"></span>
             <span><input type="hidden" name="reg_id" value="<%=reg_id%>"></span>
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1"> Registration ID</label>
                  <input type="text" class="form-control" value="<%=reg_id %>" disabled>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1"> Name</label>
                  <input type="text" class="form-control" value="<%=payment_details.getName() %>" disabled>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1"> Mode of Payment</label>
                  <input type="text" class="form-control" value="<%=payment_details.getPayment_method() %>" disabled>
                </div>
                <div class="form-group">
                  <label> Payment Details</label>
                  <table disabled><tbody><%
                 JSONObject details=  new JSONObject(payment_details.getDetails());
                		 Iterator<String> iterator= details.keys();
                		  while(iterator.hasNext()){
                			  String key=iterator.next();
                			 out.print("<tr><td><strong>"+key.toUpperCase()+"</strong></td><td>"+details.getString(key)+"</td></tr>");
                		 }
                		  
                  
                  %></tbody>
                  </table>
                </div>
              </div>
              <!-- /.box-body -->

              
            </form>
          </div>
				</div>
				<div class="col-md-3"></div>
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
  $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
  $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass: 'iradio_minimal-red'
    });
  $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass: 'iradio_flat-green'
    });
//Colorpicker
  $(".my-colorpicker1").colorpicker();
  //color picker with addon
  $(".my-colorpicker2").colorpicker();
</script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/iCheck/icheck.min.js"></script>
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>