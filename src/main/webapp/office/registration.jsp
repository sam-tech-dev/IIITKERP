<!DOCTYPE html>
<%@page import="postgreSQLDatabase.registration.Query"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="../plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

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



<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="header.jsp"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@ include file="main-sidebar.jsp"%>
		<script src="../dist/js/reportStudent.js"></script>
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="java.util.Iterator"%>
		<%@ page import="users.Student"%>



		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Data Tables <small>advanced tables</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Tables</a></li>
					<li class="active">Data tables</li>
				</ol>
			</section>
			<!--MODAL-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Student Details</h4>
						</div>
						<div class="modal-body">

							<table id="modal_table"
								class="table table-bordered table-striped">
								<tbody>

									<tr>
										<td>Registration Id</td>
										<td id="registration_id"></td>
									</tr>


									<tr>
										<td>Name</td>
										<td id="name"></td>
									</tr>

									<tr>
										<td>First Name</td>
										<td id="first_name"></td>
									</tr>
									
									<tr>
										<td>Middle Name</td>
										<td id="middle_name"></td>
									</tr>
									
									<tr>
										<td>Last Name</td>
										<td id="last_name"></td>
									</tr>

									<tr>
										<td>Category</td>
										<td id="category"></td>
									</tr>
									
									<tr>
										<td>State</td>
										<td id="state"></td>
									</tr>
									<tr>
										<td>Phone Number</td>
										<td id="phone_no"></td>
									</tr>
									<tr>
										<td>Email</td>
										<td id="email"></td>
									</tr>
									<tr>
										<td>Date Of Birth</td>
										<td id="date_of_birth"></td>
									</tr>
									<tr>
										<td>Program Allocated</td>
										<td id="program_allocated"></td>
									</tr>
									
									<tr>
										<td>Status</td>
										<td id="status"></td>
									</tr>
									
									<tr>
										<td>Physically Disabled</td>
										<td id="physically_disabled"></td>
									</tr>
									
									<tr>
										<td>Gender</td>
										<td id="gender"></td>
									</tr>
									
									<tr>
										<td>Guardian Name</td>
										<td id="guardian_name"></td>
									</tr>
									
									<tr>
										<td>Guardian Contact</td>
										<td id="guardian_contact"></td>
									</tr>
									
									<tr>
										<td>Guardian Email</td>
										<td id="guardian_email"></td>
									</tr>
									
									<tr>
										<td>Guardian Address</td>
										<td id="guardian_address"></td>
									</tr>
									
									<tr>
										<td>Father Name</td>
										<td id="father_name"></td>
									</tr>
									
									<tr>
										<td>Father Contact</td>
										<td id="father_contact"></td>
									</tr>
									
									<tr>
										<td>Mother Name</td>
										<td id="mother_name"></td>
									</tr>
									
									<tr>
										<td>Mother Contact</td>
										<td id="mother_contact"></td>
									</tr>
									
									<tr>
										<td>Nationality</td>
										<td id="nationality"></td>
									</tr>
									
									<tr>
										<td>Permanent Address</td>
										<td id="permanent_address"></td>
									</tr>
									<tr>
										<td>Local Address</td>
										<td id="local_address"></td>
									</tr>
									
									<tr>
										<td>Hosteller</td>
										<td id="hosteller"></td>
									</tr>
									
									<tr>
										<td>Hostel Address</td>
										<td id="hostel_address"></td>
									</tr>
									
									<tr>
										<td>Payment</td>
										<td id="payment"></td>
									</tr>
									
									<tr>
										<td>Semester</td>
										<td id="semester"></td>
									</tr>
								</tbody>
							</table>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>

						</div>
					</div>
				</div>
			</div>

			<!--MODAL-->


			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">

						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Student List</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="overflow-x: scroll;">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Verify</th>
											<th>View</th>
											<th>Name</th>
											<th>First Name</th>
											<th>Middle Name</th>
											<th>Last Name</th>
											<th>Category</th>
											<th>State</th>
											<th>Phone Number</th>
											<th>Email</th>
											<th>Date Of Birth</th>
											<th>Program Allocated</th>
											<th>Status</th>
											<th>Physically Disabled</th>
											<th>Gender</th>
											<th>Nationality</th>
										</tr>
									</thead>
									<tbody>
										<%
										ArrayList<Student> registration_list=Query.displayRegistrationData();
										Iterator<Student> iterator=registration_list.iterator();
                 while(iterator.hasNext()){
    				Student current=iterator.next();
                %>
										<tr>
											<td><div class="btn-group">
													<button type="button" class="btn btn-block btn-primary"
														onclick="verify(<%=current.getRegistration_id()%>)">Verify</button>
												</div></td>
											<td><button type="button" class="btn btn-block btn-danger" data-toggle="modal" data-target="#myModal" onclick="displayProfile(<%=current.getRegistration_id()%>)">
													<i class="glyphicon glyphicon-eye-open"></i>
												</button></td>
											<td><%=current.getName() %></td>
											<td><%=current.getFirst_name() %></td>
											<td><%=current.getMiddle_name() %></td>
											<td><%=current.getLast_name() %></td>
											<td><%=current.getCategory() %></td>

											<td><%=current.getState_eligibility()%></td>
											<td><%=current.getMobile()%></td>
											<td><%=current.getEmail() %></td>
											<td><%=current.getDate_of_birth()%></td>
											<td><%=current.getProgram_allocated()%></td>

											<td><%=current.getStatus() %></td>

											<td><%=current.isPwd()%></td>
											<td><%=current.getGender() %></td>

											<td><%=current.getNationality() %></td>
											<td><%=current.getEntry_time() %></td>
											<td><%=current.getVerified() %></td>
										</tr>
										<%
                }
				%>
									</tbody>
								</table>
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

		<%@ include file="footer.jsp"%>
		<!-- Control Sidebar -->
		<%@ include file="control-sidebar.jsp"%>
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
	<script src="../dist/js/payment.js"></script>
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
  
  function displayProfile(registration_id){alert(registration_id);
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
					//alert(xmlhttp.responseText);
					var data=JSON.parse(xmlhttp.responseText);
					
					document.getElementById("name").innerHTML=data.name;
					document.getElementById("first_name").innerHTML=data.first_name;
					document.getElementById("middle_name").innerHTML=data.middle_name;
					document.getElementById("last_name").innerHTML=data.last_name;
					document.getElementById("category").innerHTML=data.category;
					document.getElementById("state").innerHTML=data.state;
					document.getElementById("phone_no").innerHTML=data.phone_number;
					document.getElementById("email").innerHTML=data.email;
					document.getElementById("date_of_birth").innerHTML=data.date_of_birth;
					document.getElementById("program_allocated").innerHTML=data.program_allocated;
					document.getElementById("status").innerHTML=data.status;
					if(data.physically_disabled==true)
					document.getElementById("physically_disabled").innerHTML="Yes";
					else
						document.getElementById("physically_disabled").innerHTML="No";
					
					if(data.hosteller==true)
						document.getElementById("hosteller").innerHTML="Yes";
						else
							document.getElementById("hosteller").innerHTML="No";
					
					docuyment.getElementById("hostel_address").innerHTML=data.hostel_address;
					docuyment.getElementById("payment").innerHTML=data.payment;
					docuyment.getElementById("semester").innerHTML=data.semester;
					document.getElementById("gender").innerHTML=data.gender;
					document.getElementById("guardian_name").innerHTML=data.guardian_name;
					document.getElementById("guardian_contact").innerHTML=data.guardian_contact;
					document.getElementById("guardian_email").innerHTML=data.guardian_email;
					document.getElementById("guardian_address").innerHTML=data.guardian_address;
					document.getElementById("father_name").innerHTML=data.father_name;
					document.getElementById("father_contact").innerHTML=data.father_contact;
					document.getElementById("mother_name").innerHTML=data.father_name;
					document.getElementById("mother_contact").innerHTML=data.mother_contact;
					document.getElementById("permanent_address").innerHTML=data.permanent_address;
					document.getElementById("local_address").innerHTML=data.local_address;
					document.getElementById("registration_id").innerHTML=data.id;
					document.getElementById("address").innerHTML=data.address;
					document.getElementById("nationality").innerHTML=data.nationality;
					document.getElementById("id").innerHTML=data.id;
					//document.getElementById("reported").innerHTML=data.reported;
					if(data.reported==false){
						document.getElementById("registration_id").innerHTML="Student has not yet reported";
					}
					else{
						document.getElementById("registration_id").innerHTML="Registration ID- "+data.registration_id;
					}
									
				}
				if(xmlhttp.status == 404)
					alert("Could not connect to server");
			}
			xmlhttp.open("POST","../RetrieveRegistrationStudentData",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("registration_id="+registration_id);
		}
		return false;

	}
</script>

</body>
</html>