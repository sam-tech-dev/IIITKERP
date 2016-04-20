<!DOCTYPE html>

<%@page import="actions.gradingModule.StudentWrapper"%>
<%@page import="actions.gradingModule.ImportCSV"%>
<%@page import="java.util.Iterator"%>
<%@page import="postgreSQLDatabase.gradingModule.Grade"%>
<%@ page import="postgreSQLDatabase.gradingModule.Query"%> 
<%@ page import="postgreSQLDatabase.gradingModule.Subject"%>
<%@ page import="actions.gradingModule.RetrieveSubjects" %>
<%@ page import="java.util.ArrayList"%>

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
        Student
        <small>Home</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#" class="active"><i class="fa fa-dashboard"></i>Home</a></li>
        
      </ol>
    </section>

    <!-- Main content -->
	
	<!DOCTYPE html>
<html>
<body>
<table>
<tr>

<td>
<h4>Admission Year</h4>
&nbsp;
 <select name="AdmissionYear" onchange="this.form.submit()" id="year">
  <option value="0">--Select--</option>
  <option value="2013">2013</option>
  <option value="2014">2014</option>
  <option value="2015">2015</option>
  <option value="2016">2016</option>
</select>
</td>



&nbsp;&nbsp;
<td>
<h4>&nbsp; &nbsp;&nbsp; &nbsp; Semester</h4>





 <select name="Semester" onchange="getSemester()" id="semester">
  <option value="0">--Select--</option>
  <option value="1">I</option>
  <option value="2">II</option>
  <option value="3">III</option>
  <option value="4">IV</option>
  <option value="5">V</option>
  <option value="6">VI</option>
  <option value="7">VII</option>
  <option value="8">VIII</option>
</select>
</td>




&nbsp;
<td>
<h4>&nbsp;&nbsp; &nbsp; &nbsp;Subject ID</h4>
 <select id="subject_id" onchange="getGrades()">
  <option value="0">--Select--</option>
 
</select>
</td>
<span id="semester_info"></span>
&nbsp;&nbsp;
</tr>
</table>


      <div class="row">
        <div class="col-xs-12">
          
		  <div class="box">
            <div class="box-header">
              <h3 class="box-title">Student List</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="overflow-x:scroll;">
              <table id="tableToExport" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Student ID</th>
                  <th>Name</th>
                  <th>Grade</th>
                  
                </tr>
                </thead>
                <tbody>
                <%
              
                if(request.getParameter("course_code")!=null)
                {
               	ArrayList<Grade> list = Query.retrieveGradeList(request.getParameter("course_code"),Integer.parseInt(request.getParameter("year")));
                Iterator<Grade> iterator = list.iterator();
                while(iterator.hasNext()){
                	Grade current = iterator.next();
                	
               
                %>
                <tr >
                  <td><%=current.getStudent_id() %></td>
                  <td><%=current.getStudent_name() %></td>
				  <td><%=current.getStudent_grade() %></td>
                  
                </tr>
				
				
		<%} }%>		
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
  


<a href="../ExportGradesheet?course_code=<%=request.getParameter("course_code") %>&year=<%=request.getParameter("year") %>"><button  value="Export"  >Export</button></a>

<a href="../ImportGradesheet?course_code=<%=request.getParameter("course_code") %>"><button  value="Import"  >Import</button></a>



      <div class="row">
        <div class="col-xs-12">
          
		  <div class="box">
            <div class="box-header">
              <h3 class="box-title">Imported Student List</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="overflow-x:scroll;">
              <table id="tableToExport" class="table table-bordered table-striped">
                <thead>
                <tr>
                  <th>Student ID</th>
                  <th>Name</th>
                  <th>Grade</th>
                  
                </tr>
                </thead>
                <tbody>
                <%
              
                if(request.getParameter("course_code")!=null)
                {
               	ArrayList<StudentWrapper> list = new ImportCSV().getCSV("id" , "name" , "grade");
                Iterator<StudentWrapper> iterator = list.iterator();
                while(iterator.hasNext()){
                	StudentWrapper current = iterator.next();
                	
               
                %>
                <tr >
                  <td><%=current.getStudent_id() %></td>
                  <td><%=current.getStudent_name() %></td>
				  <td><%=current.getStudent_grade() %></td>
                  
                </tr>
				
				
		<%} }%>		
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



</body>
</html>

	
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@ include file="footer.jsp" %>
  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
 
<!-- ./wrapper -->

<!-- jQuery 2.1.4 -->
<script src="../plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/app.min.js"></script>
<script src="../dist/js/gradingModule.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>