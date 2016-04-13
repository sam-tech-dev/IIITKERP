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
 
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Quiz
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>
    <span id="checkbox_answer" style="display:none">
    <div class="checkbox">
                    <label>
                      <input type="checkbox" class="checkbox_value">
                      <div  class="checkbox_text" value="option">Option</div>
                    </label>
                  </div>
    </span>
    <span id="radio_answer" style="display:none">
     <div class="radio">
                    <label>
                      <input type="radio" name="optionsRadio" class="optionsRadio" value="option">
                     <span class="options_label">Option 2</span> 
                    </label>
                  </div>
    </span>
    <span id="short_answer" style="display:none">
    <div class="form-group short">
                  <input type="text" class="form-control given_answer" placeholder="Enter ...">
                  <div class="form-group has-success">
                  <input type="text" class="form-control correct_answer" placeholder="Enter ...">
                  </div>
                </div>
    </span>
    <span id="long_answer" style="display:none">
    <div class="form-group long">
                  <textarea class="form-control given_answer" rows="3" placeholder="Enter ..."></textarea>
                   <div class="form-group has-success">
                  <textarea class="form-control correct_answer" rows="3" placeholder="Enter ..."></textarea>
                  </div>
                </div>
    </span>
    <div class="form-group" style="display:none">
                  <label for="exampleInputFile">File input</label>
                  <input type="file" id="exampleInputFile">
                </div>
    <!-- Main content -->
    <script >
    var answer_sheet_id=<%=request.getParameter("answer_sheet_id")%>;
    </script>
    <span style="display:none" id="question_template">
                  <div class="box">
            <div class="box-body">
			     <div id="question_header" >
                <h3>Question: <span class="question_number">1</span></h3><br>
				
				<h4 class="question_stmt">Retrieve Question</h4><br>
					</div>
				<div class="form-group" >
				<span class="answer">
				
                  
				
				</span>	
				</div>		
				
					
            </div>
			
		  </div>
       </span>
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
         <span id="solution"></span>
        </div>
      </div>
    </section>
  </div>
 <%@ include file="footer.jsp" %>
  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
 
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

  <script src="../dist/js/solutions.js"></script>
  <script>
getTestpaper(<%=request.getParameter("answer_sheet_id") %>);
</script>
</body>
</html>