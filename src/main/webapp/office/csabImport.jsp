<!DOCTYPE html>
<%@page import="postgreSQLDatabase.registration.Query"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>IIITK | ERP</title>
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
.myModal {
	position: relative;
	top: auto;
	bottom: auto;
	right: auto;
	left: auto;
	display: block;
	z-index: 1;
}

.myModal {
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
					CSAB <small>Student Registration List</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Tables</a></li>
					<li class="active">Data tables</li>
				</ol>
			</section>



			<!-- Modal -->

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
										<td>Category</td>
										<td id="category"></td>
									</tr>
									<tr>
										<td>JEE Main Roll No.</td>
										<td id="jee_main_roll_no"></td>
									</tr>
									<tr>
										<td>JEE Advanced Roll No.</td>
										<td id="jee_advanced_roll_no"></td>
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
										<td>Allocated Category</td>
										<td id="allocated_category"></td>
									</tr>
									<tr>
										<td>Allocated Rank</td>
										<td id="allocated_rank"></td>
									</tr>
									<tr>
										<td>Status</td>
										<td id="status"></td>
									</tr>
									<tr>
										<td>Choice Number</td>
										<td id="choice_number"></td>
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
										<td>Quota</td>
										<td id="quota"></td>
									</tr>
									<tr>
										<td>Round</td>
										<td id="round"></td>
									</tr>
									<tr>
										<td>Willingness</td>
										<td id="willingness"></td>
									</tr>
									<tr>
										<td>Address</td>
										<td id="address"></td>
									</tr>
									<tr>
										<td>RC Name</td>
										<td id="rc_name"></td>
									</tr>
									<tr>
										<td>Nationality</td>
										<td id="nationality"></td>
									</tr>
									<tr>
										<td>ID</td>
										<td id="id"></td>
									</tr>
									<tr>
										<td>Entry Date</td>
										<td id="entry_date"></td>
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

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">

						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Student List</h3>
								<form action="../FileUpload" method="post"
									enctype="multipart/form-data">
									<input type="file" name="file" /> <input type="submit"
										value="upload" />
								</form>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="overflow-x: scroll;">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Report</th>
											<th>View</th>
											<th>Name</th>
											<th>JEE Main Roll No.</th>
											<th>State</th>
											<th>Phone Number</th>
											<th>Email</th>
											<th>Program Allocated</th>
											<th>Allocated Category</th>
											<th>Physically Disabled</th>
											<th>Entry Date</th>
											<th>Reported</th>
									</thead>
									<tbody>
										<%
                	ArrayList<Student> csab_list=postgreSQLDatabase.registration.Query.getCsabStudentList();
                                Iterator<Student> iterator=csab_list.iterator();
                                while(iterator.hasNext()){
                    				Student current=iterator.next();
                %>
										<tr>
											<td>
												<% if(current.isReported()==false){ %><div class="btn-group">
													<button type="button" class="btn btn-block btn-primary"
														onclick="report(<%=current.getCsab_id()%>)">Report</button>
												</div> <% }else{ %>
												<div class="btn-group">
													<%=current.getRegistration_id() %>
												</div> <% } %>
											</td>
											<td><button type="button"
													class="btn btn-block btn-danger" data-toggle="modal"
													data-target="#myModal"
													onclick="displayProfile(<%=current.getCsab_id() %>)">
													<i class="glyphicon glyphicon-eye-open"></i>
												</button></td>
											<td><%=current.getName() %></td>
											<td><%=current.getJee_main_rollno() %></td>
											<td><%=current.getState_eligibility()%></td>
											<td><%=current.getMobile()%></td>
											<td><%=current.getEmail() %></td>
											<td><%=current.getProgram_allocated()%></td>
											<td><%=current.getAllocated_category()%></td>
											<td><%=current.isPwd()%></td>
											<td><%=current.getEntry_time() %></td>
											<td><%=current.isReported() %></td>
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
	<script>
//$('#myModal').modal();

	function rowValue(string){
		string = string.substring(8);
		alert("Student No is "+string);
		$("#myModal").modal('show');
	}
	
	function displayProfile(csab_id){
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
					document.getElementById("category").innerHTML=data.category;
					document.getElementById("jee_main_roll_no").innerHTML=data.jee_main_rollno;
					document.getElementById("jee_advanced_roll_no").innerHTML=data.jee_adv_rollno;
					document.getElementById("state").innerHTML=data.state;
					document.getElementById("phone_no").innerHTML=data.phone_number;
					document.getElementById("email").innerHTML=data.email;
					document.getElementById("date_of_birth").innerHTML=data.date_of_birth;
					document.getElementById("program_allocated").innerHTML=data.program_allocated;
					document.getElementById("allocated_category").innerHTML=data.allocated_category;
					document.getElementById("allocated_rank").innerHTML=data.allocated_rank;
					document.getElementById("status").innerHTML=data.status;
					document.getElementById("choice_number").innerHTML=data.choice_no;
					if(data.physically_disabled==true)
					document.getElementById("physically_disabled").innerHTML="Yes";
					else
						document.getElementById("physically_disabled").innerHTML="No";
					
					document.getElementById("gender").innerHTML=data.gender;
					document.getElementById("quota").innerHTML=data.quota;
					document.getElementById("round").innerHTML=data.round;
					document.getElementById("willingness").innerHTML=data.willingness;
					document.getElementById("address").innerHTML=data.address;
					document.getElementById("rc_name").innerHTML=data.rc_name;
					document.getElementById("nationality").innerHTML=data.nationality;
					document.getElementById("id").innerHTML=data.id;
					document.getElementById("entry_date").innerHTML=data.entry_date;
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
			xmlhttp.open("POST","../CsabStudentProfile",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("csab_id="+csab_id);
		}
		return false;

	}
	
  </script>


</body>
</html>