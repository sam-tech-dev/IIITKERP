<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@page import="postgreSQLDatabase.forms.Query"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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
    
    
    
     <style type="text/css">
    
    #sm:link{

       color:#00cc00;margin:0px 0px 0px 90px;font-size:22px; text-decoration:underline
	    }
	
	#sm:hover{
	
	    color:blue; margin:0px 0px 0px 90px; font-size:26px;text-decoration:underline
	
	     }
		 
	
     #sm:visited{	
      color:#6666FF;margin:0px 0px 0px 90px; text-decoration:none
        }
        
      </style>  
    
    
     <label  style="color:blue; font-size:30px; margin:0px 0px 0px 380px;text-decoration:underline">Forms</label>
	    <br> <br>
	   <br> <br>
	<%
	
	
	
	
	    PrintWriter writer=response.getWriter();
	
	try{
		
	
	
	   
		 ArrayList<String> list = Query.getFormNames();
		
		 Iterator<String> iterator = list.iterator();
		 
		 while(iterator.hasNext()){
			 
			String formname=iterator.next();
			
			%>
			 <a href="fillFields.jsp?id1=<%=formname %>" id="sm"><%out.print(formname); %></a><br> <br> 
			<% 
		   }
		
	}catch(NullPointerException e){
		e.printStackTrace();
	}
	   %>
	
	
       <br>
       <a  id="sm" href="selectFields.jsp" >Create new Form</a>
	
	
	
	
	
	
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@ include file="footer.jsp" %>
  <!-- Control Sidebar -->
  <%@ include file="control-sidebar.jsp" %>
 </div>
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

<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
</body>
</html>