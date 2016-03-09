<!DOCTYPE html>
<%@page import="postgreSQLDatabase.registration.Query"%>

<%@page import="org.json.JSONObject"%>


<%@ page import="users.Student"%>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ERP IIITK</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="../plugins/iCheck/flat/blue.css">
<link rel="stylesheet"
	href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<link rel="stylesheet"
	href="../plugins/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet"
	href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<script type="text/javascript">
	var a;
	$(document).ready(function() {
		$("#step-2").hide();
		$("#step-3").hide();
		$("#step-4").hide();
		$("#step-5").hide();
		$("#step-6").hide();
		$("#step-7").hide();
		$("#error").hide();

		$("#step1").click(function() {
			$("#step-1").hide();
			$("#step-2").toggle('slide', 'right', 500);
		});

		$("#step_2").click(function() {
			$("#step-2").hide();
			$("#step-1").toggle("slide", "left", 500);
		});

	});

	function showPayment() {
		a = $('input[name=payment]:checked').val();
		if (a == null) {
			$("#error").show();
		} else {
			$("#step-2").hide();
			$("#" + a).toggle('slide', 'right', 500);
		}
	}

	function back() {
		$("#" + a).hide();
		$("#step-2").toggle('slide', 'right', 500);
	}
</script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini"
	style="background: url('../image/image.jpg'); background-size: cover;">
	<div class="wrapper">
		<%@ include file="../student/header.jsp"%>


		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar col-xs-6">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<br>
				<div class="small-box bg-aqua" id="title-1">
					<div class="inner">
						<h3>Step 1</h3>

						<p>Title 1</p>
					</div>
					<div class="icon">
						<i class="ion ion-bag"></i>
					</div>
					<a href="#" class="small-box-footer">More info <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>

				<div class="small-box bg-green" id="title-2">
					<div class="inner">
						<h3>Step 2</h3>

						<p>Title 2</p>
					</div>
					<div class="icon">
						<i class="ion ion-bag"></i>
					</div>
					<a href="#" class="small-box-footer">More info <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>

				<div class="small-box bg-yellow" id="title-3">
					<div class="inner">
						<h3>Step 3</h3>

						<p>Title 3</p>
					</div>
					<div class="icon">
						<i class="ion ion-bag"></i>
					</div>
					<a href="#" class="small-box-footer">More info <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>

				<div class="small-box bg-red" id="title-4">
					<div class="inner">
						<h3>Step 4</h3>

						<p>Title 4</p>
					</div>
					<div class="icon">
						<i class="ion ion-bag"></i>
					</div>
					<a href="#" class="small-box-footer">More info <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>

			</section>
			<!-- /.sidebar -->
		</aside>

		<div class="content-wrapper" style="min-height: 901px;">
			<!-- Content Header (Page header) -->
			<section class="content-header"></section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-3"></div>

						<div class="col-md-6">
							<%
							    int reg_id=1;
								//String reg_id = (String) request.getSession().getAttribute("reg_id");
								Student current = Query.getRegistrationStudentData(1);
								//String fee = Query.getFeeBreakup(Integer.parseInt(reg_id));
							
							%>
							<div id="step-1">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 1</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<label for="exampleInputPassword1">Registration ID :
													<%=reg_id %>	</label>
												</div>
												
												<div class="form-group">
													<label for="exampleInputPassword1">Student Name :
														<%=current.getName() %></label>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Category :
														<%=current.getCategory() %></label>
												</div>
												
												<div class="form-group">
													<label for="exampleInputPassword1">Fee Breakup :
														<%=postgreSQLDatabase.feePayment.Query.retrieveFeeJson(reg_id) %></label>
												</div>

												<div class="row">
													<div class="col-xs-4 pull-right">
														<input type="button" name="step-1" id="step1" value="Next"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>
							</div>

							<div id="step-2">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 2</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post" id="payment_method">
												<div class="form-group">
													<label for="exampleInputPassword1">Registration ID :
													<%=reg_id %>	</label>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Student Name :
														<%=current.getName() %></label>
												</div>
												<span id="error">
													<div class="form-group">
														<label style="color: red;">Please select any one
															of the payment method</label>
													</div>
												</span>
												<div class="form-group">
													<div class="radio">
														<label> <input type="radio" name="payment"
															onChange="$('#error').html('')" value="step-6">
															Net Banking
														</label>
													</div>

													<div class="radio">
														<label> <input type="radio" name="payment"
															onChange="$('#error').html('')" id="optionsRadios1"
															value="step-3"> Demand Draft
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="payment"
															onChange="$('#error').html('')" id="optionsRadios1"
															value="step-4"> Challan
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="payment"
															onChange="$('#error').html('')" id="optionsRadios1"
															value="step-7"> NEFT
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="payment"
															onChange="$('#error').html('')" id="optionsRadios3"
															value="step-5"> Cheque
														</label>
													</div>
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" name="step_2" id="step_2"
															value="Prev" class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" name="step-2" id="step2"
															onclick="showPayment()" value="Next"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>

							<div id="step-3">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 3</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<h3>Demand Draft</h3>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="dd" class="form-control"
														placeholder="DD Number">
												</div>

												<div class="form-group has-feedback">
													<select class="form-control" name="bank_list" id="dd_bank">
														<option value="">----Choose Bank----</option>
														<option value="">ICICI</option>
														<option value="">SBI</option>
														<option value="">Bank Of Baroda</option>
														<option value="AllahabadBank">Allahabad Bank</option>
														<option value="AndhraBank">Andhra Bank</option>
														<option value="AxisBank">Axis Bank</option>
														<option value="BankOfIndia">Bank of India</option>
														<option value="BankOfMaharashtra">Bank of
															Maharashtra</option>
														<option value="CanaraBank">Canara Bank</option>
														<option value="IndianBank">Indian Bank</option>
														<option value="UCOBank">UCO Bank</option>
														<option value="YesBankLtd">Yes Bank Ltd</option>
														<option value="KotakBank">Kotak Bank</option>
														<option value="UnionBankOfIndia">Union Bank of
															India</option>
														<option value="UnitedBankOfIndia">United Bank of
															India</option>
													</select>
												</div>



												<div class="form-group has-feedback">
													<label for="exampleInputPassword1">Payable To :
														Registrar, IIIT Kota</label>
												</div>

												<div class="form-group has-feedback">
													<label for="exampleInputPassword1">Payable At :
														Jaipur</label>
												</div>

												<div class="form-group">
													<div class="input-group">
														<input type="text" name="dateofDD" id="dd_date" class="form-control"
															data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="">
													</div>
													<!-- /.input group -->
												</div>

												<div class="form-group has-feedback">
													<input type="text" id="dd_amount" name="amountDD" class="form-control"
														placeholder="Amount">
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" onclick="back()" value="Prev"
															class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" onclick="makePayment('dd')"name="submitDD" value="Submit"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>

							<div id="step-4">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 3</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<h3>Challan</h3>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Date :
														12July,2016</label>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Challan Number :
														123456789</label>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Challan Amount :
														123456789</label>
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" onclick="back()" value="Prev"
															class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" name="submitChallan" value="Submit"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>


							<div id="step-5">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 3</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<h3>Cheque</h3>
												</div>

													<div class="form-group has-feedback">
													<input type="text" id="cheque_amount" name="amountDD" class="form-control"
														placeholder="Amount">
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Payee : abcde</label>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Payable At :
														Jaipur</label>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="cheque" class="form-control"
														placeholder="Cheque No." id="cheque_no">
												</div>

												<div class="form-group has-feedback">
													<div class="input-group">
														<input type="text" name="dateofCheque" id="cheque_date"
															class="form-control"
															data-inputmask="'alias': 'dd/mm/yyyy'" data-mask="">
													</div>
												</div>

												<div class="form-group has-feedback">
													<select class="form-control" name="bank_list" id="cheque_bank">
														<option value="">----Choose Bank----</option>
														<option value="">ICICI</option>
														<option value="">SBI</option>
														<option value="">Bank Of Baroda</option>
														<option value="AllahabadBank">Allahabad Bank</option>
														<option value="AndhraBank">Andhra Bank</option>
														<option value="AxisBank">Axis Bank</option>
														<option value="BankOfIndia">Bank of India</option>
														<option value="BankOfMaharashtra">Bank of
															Maharashtra</option>
														<option value="CanaraBank">Canara Bank</option>
														<option value="IndianBank">Indian Bank</option>
														<option value="UCOBank">UCO Bank</option>
														<option value="YesBankLtd">Yes Bank Ltd</option>
														<option value="KotakBank">Kotak Bank</option>
														<option value="UnionBankOfIndia">Union Bank of
															India</option>
														<option value="UnitedBankOfIndia">United Bank of
															India</option>
													</select>
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" onclick="back()" value="Prev"
															class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" name="submitCheque" onclick="makePayment('cheque')" value="Submit"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>


							<div id="step-6">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 3</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<h3>Net Banking</h3>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Beneficiary
														Account : 120000</label>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="ifsc" class="form-control"
														placeholder="IFSC Code">
												</div>

												<div class="form-group has-feedback">
													<div class="input-group">
														<input type="text" name="tid" class="form-control"
															placeholder="Transaction ID">
													</div>
												</div>

												<div class="form-group has-feedback">
													<select class="form-control" name="bank_list">
														<option value="">----Choose Bank----</option>
														<option value="">ICICI</option>
														<option value="">SBI</option>
														<option value="">Bank Of Baroda</option>
														<option value="AllahabadBank">Allahabad Bank</option>
														<option value="AndhraBank">Andhra Bank</option>
														<option value="AxisBank">Axis Bank</option>
														<option value="BankOfIndia">Bank of India</option>
														<option value="BankOfMaharashtra">Bank of
															Maharashtra</option>
														<option value="CanaraBank">Canara Bank</option>
														<option value="IndianBank">Indian Bank</option>
														<option value="UCOBank">UCO Bank</option>
														<option value="YesBankLtd">Yes Bank Ltd</option>
														<option value="KotakBank">Kotak Bank</option>
														<option value="UnionBankOfIndia">Union Bank of
															India</option>
														<option value="UnitedBankOfIndia">United Bank of
															India</option>
													</select>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="amountNetBanking"
														class="form-control" placeholder="Amount">
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" onclick="back()" value="Prev"
															class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" name="submitCheque" value="Submit"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>



							<div id="step-7">
								<div class="box box-primary">
									<!-- /.register-box -->
									<div class="register-logo">
										<a href="#"><b>ERP</b></a>
										<h4>Update your profile</h4>
										<h3>Step 3</h3>
									</div>
									<div class="register-box">
										<div class="register-box-body">
											<form action="" method="post">
												<div class="form-group">
													<h3>NEFT</h3>
												</div>

												<div class="form-group">
													<label for="exampleInputPassword1">Beneficiary
														Account : 120000</label>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="ifsc" class="form-control"
														placeholder="IFSC Code">
												</div>

												<div class="form-group has-feedback">
													<div class="input-group">
														<input type="text" name="tid" class="form-control"
															placeholder="Transaction ID">
													</div>
												</div>

												<div class="form-group has-feedback">
													<select class="form-control" name="bank_list">
														<option value="">----Choose Bank----</option>
														<option value="">ICICI</option>
														<option value="">SBI</option>
														<option value="">Bank Of Baroda</option>
														<option value="AllahabadBank">Allahabad Bank</option>
														<option value="AndhraBank">Andhra Bank</option>
														<option value="AxisBank">Axis Bank</option>
														<option value="BankOfIndia">Bank of India</option>
														<option value="BankOfMaharashtra">Bank of
															Maharashtra</option>
														<option value="CanaraBank">Canara Bank</option>
														<option value="IndianBank">Indian Bank</option>
														<option value="UCOBank">UCO Bank</option>
														<option value="YesBankLtd">Yes Bank Ltd</option>
														<option value="KotakBank">Kotak Bank</option>
														<option value="UnionBankOfIndia">Union Bank of
															India</option>
														<option value="UnitedBankOfIndia">United Bank of
															India</option>
													</select>
												</div>

												<div class="form-group has-feedback">
													<input type="text" name="amountNEFT" class="form-control"
														placeholder="Amount">
												</div>

												<div class="row">
													<div class="col-xs-4">
														<input type="button" onclick="back()" value="Prev"
															class="btn btn-warning btn-block btn-flat" />
													</div>
													<div class="col-xs-4 pull-right">
														<input type="button" name="submitCheque" value="Submit"
															class="btn btn-primary btn-block btn-flat" />
													</div>
													<!-- /.col -->
												</div>

											</form>
										</div>
										<!-- /.form-box -->
									</div>


								</div>

							</div>


						</div>
						<div class="col-md-3"></div>

					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
	</div>


	<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script>
		$(function() {
			//Datemask dd/mm/yyyy
			$("#datemask").inputmask("dd/mm/yyyy", {
				"placeholder" : "dd/mm/yyyy"
			});
			//Datemask2 mm/dd/yyyy
			$("#datemask2").inputmask("mm/dd/yyyy", {
				"placeholder" : "mm/dd/yyyy"
			});
			//Money Euro
			$("[data-mask]").inputmask();
		});
	</script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="../plugins/morris/morris.min.js"></script>
	<script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="../plugins/knob/jquery.knob.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="../plugins/daterangepicker/daterangepicker.js"></script>
	<script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="../plugins/fastclick/fastclick.min.js"></script>
	<script src="../dist/js/app.min.js"></script>
	<script src="../dist/js/pages/dashboard.js"></script>
	<script src="../dist/js/demo.js"></script>
	<script src="../dist/js/payment.js"></script>
</body>

</html>