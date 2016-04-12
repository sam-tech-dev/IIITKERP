<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Generate Challan</title>
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
  @media all{
     #page{display:none;}
  }
  @media print{
     #page{display:block;page-break-before:always;}
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
        Invoice
        <small>#007612</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">Invoice</li>
      </ol>
    </section>
	
    <section class="content invoice">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-4">
				
					<div class="row">
						<img src="image/sbi.jpg" class="image pull-right">
						<h4 class="text-center"><b>(Bank Copy)</b></h4>
					</div>
					
					<div class="row invoice-info">
						<div class="invoice-col">
							Category: SC<br>
							Gender(M/F): M
							<address>
								<strong><img src="image/iiitkota.jpg">Indian Institute Of Information Technology</strong><br>
								<p class="text-center"><b>Kota(Rajasthan)</b></p>
                            </address>
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br>
							Student ID: 2013KUCP1011<br>
							<br>
							<br>
							<br>
							Branch Name:<input type="text" name="branchname"/><br><br>
							Date of Challan: 15/1/2016<br><br>
							<h6><b>IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</b></h6>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td>2013KUCP1011</td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science & Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row">
						<h4 class="text-center">(To be filled by bank)</h4><br><br>
						Branch SOL ID <span class="pull-right">____________________</span><br>
						Branch Transaction ID <span class="pull-right">____________________</span><br><br><br>
						Seal & Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						<hr>
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
				
				<div class="col-md-4">
				
					<div class="row">
						<img src="image/sbi.jpg" class="image pull-right">
						<h4 class="text-center"><b>(Institute Copy)</b></h4>
					</div>
					
					<div class="row invoice-info">
						<div class="invoice-col">
							Category: SC<br>
							Gender(M/F): M
							<address>
								<strong><img src="image/iiitkota.jpg">Indian Institute Of Information Technology</strong><br>
								<p class="text-center"><b>Kota(Rajasthan)</b></p>
                            </address>
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br>
							Student ID: 2013KUCP1011<br>
							<br>
							<br>
							<br>
							Branch Name:<input type="text" name="branchname"/><br><br>
							Date of Challan: 15/1/2016<br><br>
							<h6><b>IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</b></h6>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td>2013KUCP1011</td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science & Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row">
						<h4 class="text-center">(To be filled by bank)</h4><br><br>
						Branch SOL ID <span class="pull-right">____________________</span><br>
						Branch Transaction ID <span class="pull-right">____________________</span><br><br><br>
						Seal & Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						<hr>
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
				
				<div class="col-md-4">
				
					<div class="row">
						<img src="image/sbi.jpg" class="image pull-right">
						<h4 class="text-center"><b>(Student Copy)</b></h4>
					</div>
					
					<div class="row invoice-info">
						<div class="invoice-col">
							Category: SC<br>
							Gender(M/F): M
							<address>
								<strong><img src="image/iiitkota.jpg">Indian Institute Of Information Technology</strong><br>
								<p class="text-center"><b>Kota(Rajasthan)</b></p>
                            </address>
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br>
							Student ID: 2013KUCP1011<br>
							<br>
							<br>
							<br>
							Branch Name:<input type="text" name="branchname"/><br><br>
							Date of Challan: 15/1/2016<br><br>
							<h6><b>IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</b></h6>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td>2013KUCP1011</td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science & Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row">
						<h4 class="text-center">(To be filled by bank)</h4><br><br>
						Branch SOL ID <span class="pull-right">____________________</span><br>
						Branch Transaction ID <span class="pull-right">____________________</span><br><br><br>
						Seal & Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						<hr>
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<a href="pages/examples/invoice-print.html" target="_blank" class="btn btn-primary"><i class="fa fa-print"></i> Print</a>
		</div>
	</section>
    
    <div class="clearfix"></div>
  </div>
  
  <%@ include file="footer.jsp" %>
  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
  
</div>
<!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>
