<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.*"%>
<%@page import="postgreSQLDatabase.attendance.Allocation"%>
<%@page import="postgreSQLDatabase.attendance.Query"%>
<%@page import="java.util.Iterator"%>
<%@page import="postgreSQLDatabase.attendance.Attendance"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<script type="text/javascript" src="js/jquery-1.12.1.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#semester_selected').change(function() {
			var semester_selected = $('#semester_selected').val();
			$.ajax({
				type : 'Post',
				data : {
					faculty : 'EC101',
					semester : semester_selected,
					action : 'getBranchList'
				},
				url : '../AjaxController',
				success : function(result) {
					$('#branch_selected').html(result);
				}
			});
		});
		$('#branch_selected').change(function() {
			var semester_selected = $('#semester_selected').val();
			var branch_selected = $('#branch_selected').val();
			$.ajax({
				type : 'Post',
				data : {
					faculty : 'EC101',
					semester : semester_selected,
					branch : branch_selected,
					action : 'getCourseList'
				},
				url : '../AjaxController',
				success : function(result) {
					$('#course_list').html(result);
				}
			});
		});
		$('#course_list').change(function() {
			var course = $('#course_list').val();
			var branch_selected = $('#branch_selected').val();
			$.ajax({
				type : 'Post',
				data : {
					course_code : course,
					branch : branch_selected,
					action : 'getStudentList'
				},
				url : '../AjaxController',
				success : function(result) {
					$('#attendance_table').html(result);
				}
			});
		});
	});
</script>
<script type="text/javascript">
	function genAttendanceList() {
		var table = document.getElementById('attendance_table');
		var j_array = [];
		for (var i = 0, row; row = table.rows[i]; i++) {
			//iterate through rows
			//rows would be accessed using the "row" variable assigned in the for loop

			//iterate through columns
			//columns would be accessed using the "col" variable assigned in the for loop
			var j_object = {};

			j_object["student_id"] = table.rows[i].cells[0].innerHTML;
			if (table.rows[i].cells[2].getElementsByTagName("input")[0].checked)
				j_object["attendance_status"] = "present";
			else if (table.rows[i].cells[3].getElementsByTagName("input")[0].checked)
				j_object["attendance_status"] = "absent";
			else
				j_object["attendance_status"] = "leave";
			j_array.push(j_object);

		}
		JSONToCSVConvertor(j_array, "Attendance Report", true);
	}

	function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
		//If JSONData is not an object then JSON.parse will parse the JSON string in an Object
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;

		var CSV = '';
		//Set Report title in first row or line

		CSV += ReportTitle + '\r\n\n';

		//This condition will generate the Label/Header
		if (ShowLabel) {
			var row = "";

			//This loop will extract the label from 1st index of on array
			for ( var index in arrData[0]) {

				//Now convert each value to string and comma-seprated
				row += index + ',';
			}

			row = row.slice(0, -1);

			//append Label row with line break
			CSV += row + '\r\n';
		}

		//1st loop is to extract each row
		for (var i = 0; i < arrData.length; i++) {
			var row = "";

			//2nd loop will extract each column and convert it in string comma-seprated
			for ( var index in arrData[i]) {
				row += '"' + arrData[i][index] + '",';
			}

			row.slice(0, row.length - 1);

			//add a line break after each row
			CSV += row + '\r\n';
		}

		if (CSV == '') {
			alert("Invalid data");
			return;
		}

		//Generate a file name
		var fileName = "MyReport_";
		//this will remove the blank-spaces from the title and replace it with an underscore
		fileName += ReportTitle.replace(/ /g, "_");

		//Initialize file format you want csv or xls
		var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);

		// Now the little tricky part.
		// you can use either>> window.open(uri);
		// but this will not work in some browsers
		// or you will not get the correct file extension    

		//this trick will generate a temp <a /> tag
		var link = document.createElement("a");
		link.href = uri;

		//set the visibility hidden so it will not effect on your web-layout
		link.style = "visibility:hidden";
		link.download = fileName + ".csv";

		//this part will append the anchor tag and remove it after automatic click
		document.body.appendChild(link);
		link.click();
		document.body.removeChild(link);
	}
</script>
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
				<h1>Attendance(Page-1)</h1>
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
							<div class="box-header">
								<div class="col-md-12">
									<div class="col-md-3">
										<div class="form-group">
											<label>Academic Year:</label><select class="form-control"
												disabled>
												<option selected>2016</option>
												<option>2017</option>
												<option>2018</option>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Semester:</label><select class="form-control"
												id="semester_selected">
												<option>Semester</option>
												<%
													ArrayList<Allocation> db_list = Query.getAllocationList("EC101");
													/*			ArrayList<String>list=new ArrayList<String>();
													db_list.sort(new Comparator<Allocation>(){
													    
													    
													    public int compare(Allocation o1, Allocation o2) {
													    	if(o1.getSemester()>o2.getSemester())
													        return -1;
													    	else return 0;
													    }
													
													});
													
													Iterator<Allocation>db_iterator=db_list.iterator();
													while(db_iterator.hasNext()){
														Allocation db_current=db_iterator.next();
														if(!list.contains(db_current)){list.add(db_current);
														System.out.println(db_current);}
													}*/
													Iterator<Allocation> iterator = db_list.iterator();
													while (iterator.hasNext()) {
														Allocation current = iterator.next();
												%>
												<option value="<%=current.getSemester()%>"><%=current.getSemester()%></option>

												<%
													}
												%>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Branch Name:</label><select class="form-control"
												id="branch_selected">

											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Course-code:</label><select class="form-control"
												id="course_list">

											</select>
										</div>
									</div>
									<%
										
										SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
										String mydate=dt.format(new Date());
									%>
									<div class="col-md-3">
										<div class="form-group">
											<label>Date</label> <input type="date" value="<%=mydate%>" />
										</div>
									</div>
								</div>
								<div class="col-xs-12">
									<div class="col-md-4">
										<div class="form-group">
											<label>From</label> <input type="time" name="fromTime" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>To</label> <input type="time" name="toTime" />
										</div>
									</div>

								</div>
							</div>

							<div class="box-body">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>Student Id</th>
											<th>Student Name</th>
											<th>Present</th>
											<th>Absent</th>
											<th>Leave</th>
										</tr>
									</thead>
									<tbody id="attendance_table">

									</tbody>
									<%-- Comment 

											<%
												ArrayList<Attendance> student_list = Query.getAttendanceList("CST-301");
												Iterator<Attendance> student_iterator = student_list.iterator();
												while (student_iterator.hasNext()) {
													Attendance current = student_iterator.next();
											%>
											<tr>
												<td><%=current.getStudent_id()%></td>
												<td><%=current.getStudent_name()%></td>

												<td><label> <input type="radio"
														name="attendance_<%=current.getStudent_id()%>"
														id="optionsRadios1" value="op1">
												</label></td>
												<td><label> <input type="radio"
														name="attendance_<%=current.getStudent_id()%>"
														id="optionsRadios2" value="op2">
												</label></td>
												<td><label> <input type="radio"
														name="attendance_<%=current.getStudent_id()%>"
														id="optionsRadios3" value="op3">
												</label></td>

											</tr>
											<%
												}
											%>
--%>



								</table>

								<br> <br>
								<div class="btn-group pull-right">
									<button type="submitButton" class="btn btn-block btn-success"
										onclick="getAttendanceList()">Submit</button>
									<button id="genFileButton"
										onclick="genAttendanceList()"
										class="btn btn-block btn-warning gen_btn">Generate
										File</button>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>

									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>

									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>

									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right" checked>
							</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked>
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript::;" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
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
	<script src="../dist/js/attendanceList.js"></script>
	<!-- page script -->
	<script>
		$(function() {

			$('#example1').DataTable({
				"paging" : false,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : false,
				"info" : true,
				"autoWidth" : true
			});
		});
	</script>
</body>
</html>