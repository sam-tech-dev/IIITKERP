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
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">
 
 <script>

   var array = new Array();
   
    function addRadio(option,control){
	control.parentNode.parentNode.parentNode.insertAdjacentHTML('beforeend',document.getElementById(option).innerHTML);
		
	}
    
	function add(type){
						
			document.getElementById("testPaper").insertAdjacentHTML('beforeend',document.getElementById(type).innerHTML);
						
		}
	function generate(){
	  var question_array=[];
			
			 var x=document.getElementById("testPaper").getElementsByClassName("box box-solid bg-teal-gradient");
			
			for(var i = 0;i<x.length;i++){
			
				if(x[i].style.display!="none")
				{
			
		
			
				var question={};
				switch (x[i].getAttribute("data-type"))
				{
				case  "short_answer":
				question["type"]="short_answer";
				question["statement"]=x[i].getElementsByClassName("form-control question")[0].value;
				var answer_array=[];
				answer_array.push(x[i].getElementsByClassName("form-control answer")[0].value);
				question["answer"]=answer_array;
				break;
				
				
				case  "long_answer":
				question["type"]="long_answer";
				var answer_array=[];
				question["statement"]=x[i].getElementsByClassName("form-control question")[0].value;
				answer_array.push(x[i].getElementsByClassName("form-control answer")[0].value);
				question["answer"]=answer_array;
				break;
				
				
				case  "radio_answer":
				question["type"]="radio_answer";
				question["statement"]=x[i].getElementsByClassName("form-control question")[0].value;
				var options=x[i].getElementsByClassName("option");
				var option_array=[];
				var answer_array=[];
				
				for(var j = 0;j<options.length;j++){
				//	alert(options[j].parentNode.getElementsByClassName("radio_option"));
					if(options[j].parentNode.getElementsByClassName("radio_option")[0].checked)
						answer_array.push(options[j].value);
				option_array.push(options[j].value);
				}
				question["options"]=option_array;
				question["answer"]=answer_array;
				break;
				
				
				case  "checkbox_answer":
					var answer_array=[];
					var option_array=[];
					
				question["type"]="checkbox_answer";
				question["statement"]=x[i].getElementsByClassName("form-control question")[0].value;
				var options=x[i].getElementsByClassName("option");
				for(var j = 0;j<options.length;j++){
					if(options[j].parentNode.getElementsByClassName("checkbox_option")[0].checked)
						answer_array.push(options[j].value);
					option_array.push(options[j].value);
					}
				question["options"]=option_array;
				question["answer"]=answer_array;
				break;
				}
				question_array.push(question);
				}
				
			}
			
	    return JSON.stringify(question_array);
	} 	
	
	function createTestPaper(){
		alert(generate());
		var questions=escape(generate());
		var subject=document.getElementById("subject").value;
		var status=document.getElementById("status").value;
		var duration=document.getElementById("duration").value;
		var xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				if(xmlhttp.responseText.length!=0) alert(xmlhttp.responseText);
			}
		}
		xmlhttp.open("POST","../CreateTestPaper",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("subject="+subject+"&status="+status+"&duration="+duration+"&questions="+questions);
	}
  </script>
 
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<button onCLick="createTestPaper()">Generate</button>
	<div style="display: none;">
		<span id="add_radio">
			<div class="form-group">
				<div class="radio">
					<button type="button" class="btn bg-teal btn-sm"
						data-widget="remove">
						<i class="fa fa-times"></i>
					</button>
					<label style="color: black;"><input type="radio"
						name="radio" class="radio_option"> <input type="text"
						placeholder="Type Option..." class="option" /> </label>
				</div>
			</div>
		</span> <span id="add_checkbox">
			<div class="form-group">


				<div class="checkbox">
					<button type="button" class="btn bg-teal btn-sm">
						<i class="fa fa-times"></i>
					</button>
					<label style="color: black;"><input type="checkbox"
						name="checkbox" class="checkbox_option"> <input
						type="text" placeholder="Type Option..." class="option" /> </label>
				</div>
			</div>
		</span> <span id="file_answer">
			<div class="box box-solid bg-teal-gradient" data-type="short_answer">
				<div class="box-header">
					<h3 class="box-title col-xs-10">Upload your file</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>

				<div class="box-footer no-border">
					<div class="box-body chat" id="chat">
						<div class="form-group">
							<input type="file" class="form-control answer" />
						</div>
					</div>
				</div>
			</div>
		</span> <span id="short_answer">
			<div class="box box-solid bg-teal-gradient" data-type="short_answer">
				<div class="box-header">
					<h3 class="box-title col-xs-10">
						<textarea type="text" class="form-control question" cols="130"
							placeholder="Your Question"></textarea>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>

				<div class="box-footer no-border">
					<div class="box-body chat" id="chat">
						<div class="form-group">
							<label style="color: black;">Short Answer</label> <input
								type="text" class="form-control answer"
								placeholder="Short Answer...">
						</div>
					</div>
				</div>
			</div>
		</span> <span id="radio_answer">
			<div class="box box-solid bg-teal-gradient" data-type="radio_answer">
				<div class="box-header">
					<h3 class="box-title col-xs-10">
						<textarea type="text" class="form-control question" cols="130"
							placeholder="Your Question"></textarea>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
                  <form>
				<div class="box-footer no-border">
					<div class="box-body chat">

						<div class="btn-group" onclick="addRadio('add_radio',this)">
							<button type="button" class="btn btn-success btn-sm ">
								<i class="fa fa-plus" data-type="sbjscbh"></i>
							</button>
						</div>
					</div>
				</div>
				</form>
			</div>
		</span> <span id="long_answer">
			<div class="box box-solid bg-teal-gradient" data-type="long_answer">
				<div class="box-header">
					<h3 class="box-title col-xs-10">
						<textarea type="text" class="form-control question" cols="130"
							placeholder="Your Question"></textarea>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>

				<div class="box-footer no-border">
					<div class="box-body chat" id="chat">
						<div class="form-group">
							<label style="color: black;">Long Answer</label>
							<textarea type="text" class="form-control answer" id=""
								cols="130" placeholder="Long Answer"></textarea>
						</div>
					</div>
				</div>
			</div>
		</span> <span id="checkbox_answer">
			<div class="box box-solid bg-teal-gradient"
				data-type="checkbox_answer">
				<div class="box-header">
					<h3 class="box-title col-xs-10">
						<textarea type="text" class="form-control question" cols="130"
							placeholder="Your Question"></textarea>
					</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn bg-teal btn-sm"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>

				<div class="box-footer no-border">
					<div class="form-group">
						<div class="btn-group" onclick="addRadio('add_checkbox',this)">
							<button type="button" class="btn btn-success btn-sm ">
								<i class="fa fa-plus" data-type="sbjscbh"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</span>

	</div>

<div class="wrapper">
<%@ include file="header.jsp" %>
 <!-- Left side column. contains the logo and sidebar -->
 <%@ include file="main-sidebar.jsp" %>

<div class="content-wrapper">
			<!-- Content Header (Page header) -->


			<!-- Main content -->
			<section class="content">

				<!-- Main row -->
				<div class="row">
					<input type="text" placeholder="subject" id="subject" /><br />
					<br /> <input type="text" placeholder="status" id="status" /><br />
					<br /> <input type="text" placeholder="duration" id="duration" /><br />
					<div class="btn-group pull-right">

						<button type="button"
							class="btn btn-success btn-sm dropdown-toggle"
							data-toggle="dropdown">
							<i class="fa fa-plus"></i>
						</button>
						<ul class="dropdown-menu pull-right" role="menu">
							<li><a href="#" onclick="add('short_answer')">Short
									answers</a></li>
							<li><a href="#" onclick="add('long_answer')">Long
									answers</a></li>
							<li><a href="#" onclick="add('radio_answer')">Single
									choice</a></li>
							<li><a href="#" onclick="add('checkbox_answer')">Checkboxes</a></li>
							<li><a href="#" onclick="add('file_answer')">File Input</a></li>
						</ul>
					</div>
					<br>
					<!-- right col (We are only adding the ID to make the widgets sortable)-->
					<section class="col-lg-12 connectedSortable" id="testPaper"></section>

					<!-- right col -->
				</div>
				<!-- /.row (main row) -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

 
  
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

<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<script>
$(function () {

	  "use strict";

	  //Make the dashboard widgets sortable Using jquery UI
	  $(".connectedSortable").sortable({
	    placeholder: "sort-highlight",
	    connectWith: ".connectedSortable",
	    handle: ".box-header, .nav-tabs",
	    forcePlaceholderSize: true,
	    zIndex: 999999
	  });
	  $(".connectedSortable .box-header, .connectedSortable .nav-tabs-custom").css("cursor", "move");

	  //jQuery UI sortable for the todo list
	  $(".todo-list").sortable({
	    placeholder: "sort-highlight",
	    handle: ".handle",
	    forcePlaceholderSize: true,
	    zIndex: 999999
	  });
});
</script>
</body>
</html>