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
  <script src="../dist/js/feeBreakup.js"></script>
	<style>
		.hideBorder{
			border:none;
		}
	</style>
	<script>
		
		var tableA = new Array(3);
		var tableB = new Array(3);
		var tableC = new Array(3);
		var table = new Array(3);
		var col_col=0;
		
		
		
		function changes(){
			
				 for(var i=0;i<2;i++){
					 tableA[i] = new Array(3);
					 for(var j=0;j<3;j++){
						 tableA[i][j] = parseInt(document.getElementById("tableA["+i+"]["+j+"]").value);
					 					 }
				 		  			 }
				 
				 for(var i=0;i<7;i++){
					 tableB[i] = new Array(3);
					 for(var j=0;j<3;j++)
						 tableB[i][j] = parseInt(document.getElementById("tableB["+i+"]["+j+"]").value);
				 		   			}
			
			 	tableC[0] = new Array(3);
				for(var j=0;j<3;j++){
					tableC[0][j] = parseInt(document.getElementById("tableC[0]["+j+"]").value);
								    }
			
				 for(var i=0;i<3;i++){
					 var sum = 0; 
					 for(var j=0;j<2;j++){
				 	 	 sum += tableA[j][i];
					 					}
					 
					 a = sum;
					 document.getElementById("table["+col_col+"]["+i+"]").value = a;
					 col_col++;
					 
					 var sum = 0;
					 for(var j=0;j<7;j++){
				 	 	 sum += tableB[j][i];
					 					}
					 
					 b = sum;
					 document.getElementById("table["+col_col+"]["+i+"]").value = b;
					 col_col++;
					 
					 var sum = 0;
					 for(var j=0;j<1;j++){
				 	 	 sum += tableC[j][i];
					 					}
					 
					 c = sum;
					 document.getElementById("table["+col_col+"]["+i+"]").value = c;
					 col_col++;
					 
					 z = a+b+c;
					 document.getElementById("table["+col_col+"]["+i+"]").value = z;
					 col_col = 0;
					 
				 					}
			
						        }
	</script>	
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

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
            <!-- /.box-header -->
            <div class="box-body">
            <form method="post" action="../FeeBreakup">
              <div class="form-group">
                  <label>Semester</label>
                  <select class="form-control" id="drop_semester">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                  </select>
          </div>
          <div class="form-group">
                  <label>Year</label>
                  <select class="form-control" id="year">
                    <option>2013</option>
                    <option>2014</option>
                    <option>2015</option>
                    <option>2016</option>
                    <option>2017</option>
                    <option>2018</option>
                    <option>2019</option>
                    <option>2020</option>
                  </select>
          </div>
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th style="">S No.</th>
                  <th>Head of Fees</th>
                  <th>For General Category Student</th>
                  <th>For SC/ST Category Student</th>
                  <th>For OBC Student</th>
                </tr>
			   	</thead>
			   <thead>
				<tr>
					<th>A.</th> 
					<th>Admission/Tuition Fees</th>	
				</tr>
			   </thead>  
                <tbody class="fee_breakup_field">
                <tr>
                  <td>1.</td>
                  <td>Admission Processing Fee</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[0][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[0][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[0][2]" value="0"/></td>	
                </tr>
                <tr>
                  <td>2.</td>
                  <td>Tuition Fee</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[1][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[1][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableA[1][2]" value="0"/></td>
                </tr>
			    </tbody>
				<thead>  
                <tr>
                  <th></th>
                  <th>Total(A)</th>
                  <th><input class="hideBorder" id="table[0][0]" value="0" disabled /></th>
                  <th><input class="hideBorder" id="table[0][1]" value="0" disabled /></th>
				  <th><input class="hideBorder" id="table[0][2]" value="0" disabled /></th>	
                </tr>
               </thead>
			   <thead>
				<tr>
					<th>B.</th>
					<th>Institute Fees(Common for all students)</th>
				</tr>
			   </thead>	
			   <tbody class="fee_breakup_field">
			     <tr>
				  <td>3.</td>
                  <td>Development</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[0][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[0][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[0][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>4.</td>
                  <td>Library & Book Bank</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[1][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[1][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[1][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>5.</td>
                  <td>Computer/Internet</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[2][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[2][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[2][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>6.</td>
                  <td>Sports & Creative Arts Society</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[3][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[3][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[3][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>7.</td>
                  <td>Students Welfare</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[4][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[4][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[4][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>8.</td>
                  <td>Industrial Training & Placement</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[5][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[5][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[5][2]" value="0"/></td>
				 </tr>
				 <tr>
				  <td>9.</td>
                  <td>Examination</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[6][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[6][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableB[6][2]" value="0"/></td>
				 </tr>  
			    </tbody>
				<thead>  
                <tr>
                  <th></th>
                  <th>Total(B)</th>
                 <th><input class="hideBorder" id="table[1][0]" value="0" disabled /></th>
                  <th><input class="hideBorder" id="table[1][1]" value="0" disabled /></th>
				  <th><input class="hideBorder" id="table[1][2]" value="0" disabled /></th>
                </tr>
               </thead>
			   <thead>  
                <tr>
					<th>C.</th> 
					<th>Group Insurance **</th>
                </tr>
               </thead>
			   <tbody class="fee_breakup_field">
				<tr>
				  <td>10.</td>
                  <td>Insurance Fees (Annual)</td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableC[0][0]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableC[0][1]" value="0"/></td>
                  <td><input class="hideBorder" onkeyup="changes()" id="tableC[0][2]" value="0"/></td>	
                </tr>
			   </tbody>
			   <thead>
				 <tr>
                  <th></th>
                  <th>Total (C)</th>
				  <th><input class="hideBorder" id="table[2][0]" value="0" disabled /></th>
                  <th><input class="hideBorder" id="table[2][1]" value="0" disabled /></th>
				  <th><input class="hideBorder" id="table[2][2]" value="0" disabled /></th>
                </tr>
               </thead>   
			   <thead>
				 <tr>
                  <th></th>
                  <th>Total (A+B+C)</th>
                  <th><input class="hideBorder" id="table[3][0]" value="0" disabled /></th>
                  <th><input class="hideBorder" id="table[3][1]" value="0" disabled /></th>
				  <th><input class="hideBorder" id="table[3][2]" value="0" disabled /></th>
                </tr>
               </thead>	  
              </table>
            
              	<input type="hidden" id="year" name="year" >
              	<input type="hidden" id="sem" name="semester">
              <input type=hidden id="gen" name="fee_breakup_general">
              <input type=hidden id="sc" name="fee_breakup_sc">
              <input type=hidden id="obc" name="fee_breakup_obc">
              <input type="submit" value="button" onClick="createFeeBreakUpJson()"/>
              </form>
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
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": false,
      "lengthChange": false,
      "searching": false,
      "ordering": false,
      "info": false,
      "autoWidth": false
    });
  });
</script>
</body>
</html>
