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
  <script src="../https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="../https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
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
        <li><a href="../#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="../#">Examples</a></li>
        <li class="active">Invoice</li>
      </ol>
    </section>
	
    <section class="content invoice">
		<div class="row">
			<div class="table-responsive">
							<table class="table">
							<div class="table-responsive">
								<table class="table">	
									<tbody>
										<tr>
											<td>
												<div class="table-responsive">
													<table class="table">
														<tbody>
															<tr>
																<td><br><span style="font-size:10px">Category: SC<br>Gender(M/F): M</span></td>
																<td><span class="text-center">(Bank Copy)</span></td>
																<td><img src="../image/sbi.jpg" class="image pull-right"></td>
															</tr>
															<tr>
																<td><img src="../image/iiitkota.jpg"><br><span style="font-size:10px;text-decoration:underline;"></span></td>
																<td><span style="font-size:12px;font-weight:bold;margin-left:-15px;">Indian Institute  Of Information Technology, Kota</span><br><span style="font-size:10px;margin-left:60px;">Mentored By</span><br><span style="font-size:12px;font-weight:bold;margin-left:-35px;">Indian Institute  Of Information Technology, Kota</span></td>
																<td></td>
															</tr>
															<tr>
																<td>Student ID:</td>
																<td>2013KUCP1011</td>
																<td></td>
															</tr>
															<tr>
																<td>Branch Name:</td>
																<td><input type="text" name="branchname"/></td>
																<td></td>
															</tr>
															<tr>
																<td>Date of Challan:</td>
																<td>5/12/2015</td>
																<td></td>
															</tr>
															<tr>
																<td><span style="font-size:10px">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</span></td>
															</tr>
														</tbody>
													</table>
												</div>
											</td>
											<td>
												<div class="table-responsive">
													<table class="table">
														<tbody>
															<tr>
																<td><br><span style="font-size:10px">Category: SC<br>Gender(M/F): M</span></td>
																<td><span class="text-center">(Bank Copy)</span></td>
																<td><img src="../image/sbi.jpg" class="image pull-right"></td>
															</tr>
															<tr>
																<td><img src="../image/iiitkota.jpg"><br><span style="font-size:10px;text-decoration:underline;"></span></td>
																<td><span style="font-size:12px;font-weight:bold;margin-left:-15px;">Indian Institute  Of Information Technology, Kota</span><br><span style="font-size:10px;margin-left:60px;">Mentored By</span><br><span style="font-size:12px;font-weight:bold;margin-left:-35px;">Indian Institute  Of Information Technology, Kota</span></td>
																<td></td>
															</tr>
															<tr>
																<td>Student ID:</td>
																<td>2013KUCP1011</td>
																<td></td>
															</tr>
															<tr>
																<td>Branch Name:</td>
																<td><input type="text" name="branchname"/></td>
																<td></td>
															</tr>
															<tr>
																<td>Date of Challan:</td>
																<td>5/12/2015</td>
																<td></td>
															</tr>
															<tr>
																<td><span style="font-size:10px">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</span></td>
															</tr>
														</tbody>
													</table>
												</div>
											</td>
											<td>
												<div class="table-responsive">
													<table class="table">
														<tbody>
															<tr>
																<td><br><span style="font-size:10px">Category: SC<br>Gender(M/F): M</span></td>
																<td><span class="text-center">(Bank Copy)</span></td>
																<td><img src="../image/sbi.jpg" class="image pull-right"></td>
															</tr>
															<tr>
																<td><img src="../image/iiitkota.jpg"><br><span style="font-size:10px;text-decoration:underline;"></span></td>
																<td><span style="font-size:12px;font-weight:bold;margin-left:-15px;">Indian Institute  Of Information Technology, Kota</span><br><span style="font-size:10px;margin-left:60px;">Mentored By</span><br><span style="font-size:12px;font-weight:bold;margin-left:-35px;">Indian Institute  Of Information Technology, Kota</span></td>
																<td></td>
															</tr>
															<tr>
																<td>Student ID:</td>
																<td>2013KUCP1011</td>
																<td></td>
															</tr>
															<tr>
																<td>Branch Name:</td>
																<td><input type="text" name="branchname"/></td>
																<td></td>
															</tr>
															<tr>
																<td>Date of Challan:</td>
																<td>5/12/2015</td>
																<td></td>
															</tr>
															<tr>
																<td><span style="font-size:10px">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</span></td>
															</tr>
														</tbody>
													</table>
												</div>
											</td>
										</tr>
									</tbody>
							</table>
						</div>
					  </table>
					</div>
				</div>
		<div class="row">
			<a href="../pages/examples/print.html" target="_blank" class="btn btn-primary"><i class="fa fa-print"></i> Print</a>
		</div>
	</section>
								
    <div class="clearfix"></div>
  </div>
  <%@ include file="footer.jsp" %>

  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
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