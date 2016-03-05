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
  <script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
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

  <script>
  	    
    $(document).ready(function(){
    	$("#hiddenDetails").hide();
    });
    
    function prompt(view){
    	temp = new Array();
        len = 0;
    	x = view.parentNode.parentNode.parentNode.rowIndex;
    	y = view.parentNode.parentNode.parentNode.parentNode.parentNode.rows[x];
    	
    	for(i=2;i<27;i++){    	
    	    temp[len] = y.cells[i].innerHTML;
    	    len += 1;
    					 }
    	
    	z = document.getElementById("hiddenDetails").getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[1].getElementsByTagName("table")[0].getElementsByTagName("tbody")[0];
		
    	for(i=0;i<len;i++){
			z.getElementsByTagName("tr")[i].insertAdjacentHTML('beforeend',"<td>"+temp[i]+"</td>");
						  }
    	$("#list").css({position:'fixed'});
    	$("#list *").attr("disabled", true).off('click');
    	$("#list").fadeTo(100,0.1);
    	$("#hiddenDetails").show();
    }
	function againShow(){
		
		z = document.getElementById("hiddenDetails").getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[0].getElementsByTagName("div")[1].getElementsByTagName("table")[0].getElementsByTagName("tbody")[0];
		len = $("#example1 tbody tr").length;
		//get TBODY
		
    	for(i=0;i<=len;i++){
    		del = z.getElementsByTagName("tr")[i];
			alert(del.parentNode.nodeName);
						  }
		$("#hiddenDetails").hide();
		$("#list").css({position:'static'});
		$("#list *").attr("disabled", false).css({cursor:'auto'});
    	$("#list").fadeTo(100,10);
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
       
      	<div class="col-md-12">
      		<div class="col-md-4"></div>
      		<div class="col-md-4">
      			<span id="hiddenDetails" style="position:fixed;z-index:10;margin-top:-30px;">
		<div class="example-modal">
        <div class="modal">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" onclick="againShow()" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">x</span></button>
                <h4 class="modal-title">Student Details</h4>
              </div>
              <div class="modal-body" style="height:600px;overflow-y:scroll;">
                <table id="example1" class="table table-bordered table-striped">
                	<tbody>
                		<tr>
                			<td style="width:100px;">Name</td>
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
            </div>
          </div>
        </div>
      </div>
	</span>
      		</div>
      		<div class="col-md-4"></div>
      	</div>
      </div>
      
      
      <div class="row">
        <div class="col-xs-12">
         <span id="list"> 
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
                  <th>Student ID</th>
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
                  <th>ID</th>
                  <th>Entry Date</th>
                  <th>Reported</th>
                </thead>
                <tbody>
                <tr>
                  <td>
                  	  <div class="btn-group">
                  	  	   <button type="button" class="btn btn-block btn-primary">Report</button>
                  	  </div>
                  </td>
                  <td><span class="pointerShow">
                  	  <button type="button" onclick="prompt(this)" class="btn btn-block btn-danger">
                  	  	      <i class="glyphicon glyphicon-eye-open"></i>
                  	  </button>
                  	  </span>
                  </td>
                  <td>Sumit</td>
                  <td>2013KUCP1001</td>
                  <td>Sumit1</td>
                  <td>Sumit2</td>
                  <td>Sumit3</td>
                  <td>Sumit4</td>
                  <td>Sumit5</td>
                  <td>Sumit6</td>
                  <td>Sumit7</td>
                  <td>Sumit8</td>
                  <td>Sumit9</td>
                  <td>Sumit0</td>
                  <td>SumitA</td>
                  <td>SumitB</td>
                  <td>SumitC</td>
                  <td>SumitD</td>
                  <td>SumitE</td>
                  <td>SumitF</td>
                  <td>SumitG</td>
                  <td>SumitH</td>
                  <td>SumitI</td>
                  <td>SumitJ</td>
                  <td>SumitK</td>
                  <td>SumitL</td>
                  <td>Timus</td>
                </tr>
				
                <tr>
                  <td>
                  	  <div class="btn-group">
                  	  	   <button type="button" class="btn btn-block btn-primary">Report</button>
                  	  </div>
                  </td>
                  <td><span class="pointerShow">
                  	  <button type="button" onclick="prompt(this)" class="btn btn-block btn-danger">
                  	  	      <i class="glyphicon glyphicon-eye-open"></i>
                  	  </button>
                  	  </span>
                  </td>
                  <td>Sumit</td>
                  <td>2013KUCP1002</td>
                  <td>Sumit1</td>
                  <td>Sumit2</td>
                  <td>Sumit3</td>
                  <td>Sumit4</td>
                  <td>Sumit5</td>
                  <td>Sumit6</td>
                  <td>Sumit7</td>
                  <td>Sumit8</td>
                  <td>Sumit9</td>
                  <td>Sumit0</td>
                  <td>SumitA</td>
                  <td>SumitB</td>
                  <td>SumitC</td>
                  <td>SumitD</td>
                  <td>SumitE</td>
                  <td>SumitF</td>
                  <td>SumitG</td>
                  <td>SumitH</td>
                  <td>SumitI</td>
                  <td>SumitJ</td>
                  <td>SumitK</td>
                  <td>SumitL</td>
                  <td>Timus</td>
                </tr>
				
				
                <tr>
                  <td>
                  	  <div class="btn-group">
                  	  	   <button type="button" class="btn btn-block btn-primary">Report</button>
                  	  </div>
                  </td>
                  <td><span class="pointerShow">
                  	  <button type="button" onclick="prompt(this)" class="btn btn-block btn-danger">
                  	  	      <i class="glyphicon glyphicon-eye-open"></i>
                  	  </button>
                  	  </span>
                  </td>
                  <td>Sumit</td>
                  <td>2013KUCP1003</td>
                  <td>Sumit1</td>
                  <td>Sumit2</td>
                  <td>Sumit3</td>
                  <td>Sumit4</td>
                  <td>Sumit5</td>
                  <td>Sumit6</td>
                  <td>Sumit7</td>
                  <td>Sumit8</td>
                  <td>Sumit9</td>
                  <td>Sumit0</td>
                  <td>SumitA</td>
                  <td>SumitB</td>
                  <td>SumitC</td>
                  <td>SumitD</td>
                  <td>SumitE</td>
                  <td>SumitF</td>
                  <td>SumitG</td>
                  <td>SumitH</td>
                  <td>SumitI</td>
                  <td>SumitJ</td>
                  <td>SumitK</td>
                  <td>SumitL</td>
                  <td>Timus</td>
                </tr>
				
				</tbody>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
         </span> 
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