<!DOCTYPE html>
<%@page import="postgreSQLDatabase.forms.Query"%>
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
	
  <%
  String form=request.getParameter("id1");

  
  String allFields=Query.getFields(form);
  
     String[] fields=new String[15];
       int k=0;
       int flag=0;
     for(int i=0;i<allFields.length();i++){
    	       
    	 if(allFields.charAt(i)==','){
    		 fields[++k]=allFields.substring(flag,i);
    		 flag=i+1;
    	  }
     }
     
      
  if(form.equals("Bonafide Form")){
    %>
    
    
 <form method="post"  name="form1" action="../createpdf">
<label style="font-size:25px; color:red;margin:0px 0px 0px 300px">Please enter following Fields to get the Certificate</label><br>
<br>
<fieldset>
<legend style="color:#3399FF;font-size:20px">Details for <%out.print(form); %></legend>
    
    
    <input type="text" id="d1" name="no" value="<%=k%>" style="display:none;" />
    <input type="text" id="d1" name="formname" value="<%=form%>" style="display:none;" />
    
   <%   
     for(int j=1;j<=k;j++){
    	 
    	%>  
    
  <label style="font-size:17px; color:black;margin:0px 0px 0px 50px"><%out.print(fields[j]); %>:</label>
 <input type="text" id="d1" name="<%=j%>" value="" style="font-size:16px;margin:0px 0px 0px 0px; background-color:#F0FFFF; width:220px; height:25px;color:#006666;"> 
     
    <% if(j%2==0){%>
        	<br><br>
      <% }} %>

  </fieldset>
  
	<br>
 <input name="submit" type="submit" id="submit" value="Submit"  onClick="checkform(this.form)"  style="width:170px;height:35px;color:white;background-color:#333399;font-size:20px;margin:0px 0px 0px 350px">
</form>	

<%
  }else{
	%>  
	 <form method="post"  name="form1" action="../Bonafide">
	 
	  <label style="font-size:17px; color:black;margin:0px 0px 0px 50px">Enter Your College ID:</label>
 <input type="text" id="d1" name="id" value="" style="font-size:16px;margin:0px 0px 0px 0px; background-color:#F0FFFF; width:220px; height:25px;color:#006666;"> 
     
      <input name="submit" type="submit" id="submit" value="Submit"   style="width:170px;height:35px;color:white;background-color:#333399;font-size:20px;margin:0px 0px 0px 350px">
     
   
	 </form>	
	
	
<% 	  
  }
%>

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