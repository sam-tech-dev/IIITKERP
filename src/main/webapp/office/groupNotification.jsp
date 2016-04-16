<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IIIT KOTA | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../plugins/select2/select2.min.css">
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script>
    function autoSuggest(str){
    	
    		alert(str);
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
    		
    		if(xmlhttp){
    		    xmlhttp.onreadystatechange=function() {
    		    	
    		        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
    					
    		        	a = JSON.parse(xmlhttp.responseText);
    		        	document.getElementsByClassName("form-control select2 select2-hidden-accessible")[0].innerHTML="";
    		        	
    		        	for(var i=0;i<a.length;i++){
    		        		document.getElementsByClassName("form-control select2 select2-hidden-accessible")[0].innerHTML+="<option>"+a[i].name+"</option>";
    		        		
    		        	}
    					
    				   
    					
    				}
    		        if(xmlhttp.status == 404)
    					alert("Could not connect to server");
    				}
    		    xmlhttp.open("POST","../AutoSuggest?string="+str,true);
    			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    		    xmlhttp.send();
    		}
    	   
    }	
  </script>
  
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
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Enter Title</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form">
              <div class="box-body">
                <div class="form-group">
                  <label>Notification Type</label>
                  <select class="form-control">
                    <option value="">Select any One</option>
                    <option value="Grades">Grades</option>
                    <option value="Tests">Tests</option>
                    <option value="Fees">Fees</option>
                    <option value="attendance">Attendance</option>
                    <option value="miscellaneous">Miscellaneous</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Message</label>
                  <textarea class="form-control" rows="3" placeholder="Type your message..."></textarea>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Link</label>
                  <input type="text" class="form-control" value="link">
                </div>
                <div class="form-group">
                     <label>Expiry Date</label>
                     <input type="datetime" class="form-control">
                </div>
                <div class="form-group">
                  <label>Users</label>
                  <select class="form-control select2" multiple="multiple" data-placeholder="Select a State" style="width: 100%;">
                  </select>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
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
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!-- Bootstrap 3.3.5 -->
<script src="../bootstrap/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="../plugins/select2/suggestion.js"></script>
<script src="../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<script>
  $.widget.bridge('uibutton', $.ui.button);
  //$(function(){$(".select2").select2();});
  $(".select2").select2({
	  ajax: {
	    url: "../AutoSuggest",
	    dataType: 'json',
	    delay: 250,
	    data: function (params) {
	    	alert(JSON.stringify(params));
	      return {
	        string: params.name, // search term
	        page: 1
	      };
	    },
	    processResults: function (data, params) {
	      // parse the results into the format expected by Select2
	      // since we are using custom formatting functions we do not need to
	      // alter the remote JSON data, except to indicate that infinite
	      // scrolling can be used
	      params.page = params.page || 1;

	      return {
	        results: data.items,
	        pagination: {
	          more: (params.page * 30) < data.total_count
	        }
	      };
	    },
	    cache: true
	  },
	  escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
	  minimumInputLength: 1
	  //templateResult: formatRepo, // omitted for brevity, see the source of this page
	  //templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
	});
</script>
</body>
</html>