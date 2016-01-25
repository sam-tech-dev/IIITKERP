<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Starter</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker-bs3.css">
  <link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">

  
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the messages -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <!-- User Image -->
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <!-- Message title and timestamp -->
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <!-- The message -->
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                </ul>
                <!-- /.menu -->
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- /.messages-menu -->

          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- Inner Menu: contains the notifications -->
                <ul class="menu">
                  <li><!-- start notification -->
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <!-- end notification -->
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks Menu -->
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- Inner menu: contains the tasks -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <!-- Task title and progress text -->
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <!-- The progress bar -->
                      <div class="progress xs">
                        <!-- Change the css width attribute to simulate progress -->
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">Alexander Pierce</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <aside class="main-sidebar">

    <section class="sidebar">

      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      
      <ul class="sidebar-menu">
        <li class="header">HEADER</li>
        <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Link</span></a></li>
        <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
            <li><a href="#">Link in level 2</a></li>
            <li><a href="#">Link in level 2</a></li>
          </ul>
        </li>
      </ul>
          </section>
  </aside>

  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
		<section class="content">
			<div class="box box-primary">
            <div class="box-header with-border">
				<div class="form-group col-xs-5">
					<input type="text" class="form-control" placeholder="Untitled form"/>
				</div>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form">
              <div class="box-body">
                <div class="form-group">
                  <label>Your Question</label>
                  <input type="text" class="form-control" id="" placeholder="Your Question">
                </div>
                <div class="form-group">
                  <div class="input-group-btn">
					<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Question Type<span class="fa fa-caret-down"></span>
					</button>
						<ul class="dropdown-menu">
							<li>Short answers</li>
							<li>Long answers</li>
							<li>Multiple choice</li>
							<li>Checkboxes</li>
							<li>Dropdown</li>
							<li>Date Picker</li>
							<li>Time Picker</li>
							<li>Number</li>
							<li>Range</li>
							<li>File Input</li>
						</ul>	
				  </div>
                </div>
				
				<div class="form-group">
                  <label>Answer</label>
                  <input type="text" class="form-control" id="" placeholder="Short Answer...">
                </div>
				
				<div class="form-group">
                  <label>Answer</label>
                  <textarea class="form-control" rows="3" placeholder="Long Answer..." style="margin: 0px -0.5px 0px 0px; height: 74px; width: 510px;"></textarea>
                </div>
				
				<div class="form-group">
                  <div class="radio">
                    <label><input type="radio" name="" id="optionsRadios1" value="option1">Option1</label>
                  </div>
                  <div class="radio">
                    <label><input type="radio" name="" id="optionsRadios2" value="option2">Option2</label>
                  </div>
                  <div class="radio">
                    <label><input type="radio" name="" id="optionsRadios3" value="option3">Option3</label>
                  </div>
                </div>
				
				<div class="form-group">
                  <div class="checkbox">
                    <label><input type="checkbox">Checkbox 1</label>
                  </div>

                  <div class="checkbox">
                    <label><input type="checkbox">Checkbox 2</label>
                  </div>

                  <div class="checkbox">
                    <label><input type="checkbox">checkbox 3</label>
                  </div>
                </div>
				
				<div class="form-group">
                  <select class="form-control">
                    <option value="">Select Any One</option>
                    <option>option 1</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>
                </div>
				
				<div class="form-group">
					<label>Date</label>
					<input type="date" class="form-control">
				</div>
				
				<div class="form-group">
					<label>Time</label>
					<input type="time" id="">
			    </div>
				
				<div class="form-group">
					<label>Number</label>
					<input type="number" id="">
			    </div>
				
				<div class="form-group">
					<label>Range: </label> from
					<input type="number" id=""> to
					<input type="number" id="">
				</div>
				
				<div class="form-group">
                  <input type="file" id="exampleInputFile">
                </div>
				
				
				
              </div>
              
			  <div class="box-footer">
                <button type="submit" class="btn btn-primary">Add new question</button>
                <button type="submit" class="btn btn-danger pull-right">That's enough</button>
              </div>
            </form>
          </div>
		</section>
  </div>
  
  
  <aside class="control-sidebar control-sidebar-dark">
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <div class="tab-content">
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript::;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        
        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript::;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        
      </div>
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
        </form>
      </div>
    </div>
  </aside>
  <div class="control-sidebar-bg"></div>
</div>
<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="dist/js/app.min.js"></script>
<script src="plugins/input-mask/jquery.inputmask.js"></script>
<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<script src="plugins/timepicker/bootstrap-timepicker.min.js"></script>
<div class="daterangepicker dropdown-menu show-calendar opensleft" style="top: 491px; right: 25.5px; left: auto; display: none;"><div class="calendar first left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">27</td><td class="available off" data-title="r0c1">28</td><td class="available off" data-title="r0c2">29</td><td class="available off" data-title="r0c3">30</td><td class="available off" data-title="r0c4">31</td><td class="available" data-title="r0c5">1</td><td class="available" data-title="r0c6">2</td></tr><tr><td class="available" data-title="r1c0">3</td><td class="available" data-title="r1c1">4</td><td class="available" data-title="r1c2">5</td><td class="available" data-title="r1c3">6</td><td class="available" data-title="r1c4">7</td><td class="available" data-title="r1c5">8</td><td class="available" data-title="r1c6">9</td></tr><tr><td class="available" data-title="r2c0">10</td><td class="available" data-title="r2c1">11</td><td class="available" data-title="r2c2">12</td><td class="available" data-title="r2c3">13</td><td class="available" data-title="r2c4">14</td><td class="available" data-title="r2c5">15</td><td class="available" data-title="r2c6">16</td></tr><tr><td class="available" data-title="r3c0">17</td><td class="available" data-title="r3c1">18</td><td class="available" data-title="r3c2">19</td><td class="available" data-title="r3c3">20</td><td class="available active start-date end-date" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="available" data-title="r3c6">23</td></tr><tr><td class="available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="available" data-title="r4c6">30</td></tr><tr><td class="available" data-title="r5c0">31</td><td class="available off" data-title="r5c1">1</td><td class="available off" data-title="r5c2">2</td><td class="available off" data-title="r5c3">3</td><td class="available off" data-title="r5c4">4</td><td class="available off" data-title="r5c5">5</td><td class="available off" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="calendar second right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">27</td><td class="off disabled" data-title="r0c1">28</td><td class="off disabled" data-title="r0c2">29</td><td class="off disabled" data-title="r0c3">30</td><td class="off disabled" data-title="r0c4">31</td><td class="off disabled" data-title="r0c5">1</td><td class="off disabled" data-title="r0c6">2</td></tr><tr><td class="off disabled" data-title="r1c0">3</td><td class="off disabled" data-title="r1c1">4</td><td class="off disabled" data-title="r1c2">5</td><td class="off disabled" data-title="r1c3">6</td><td class="off disabled" data-title="r1c4">7</td><td class="off disabled" data-title="r1c5">8</td><td class="off disabled" data-title="r1c6">9</td></tr><tr><td class="off disabled" data-title="r2c0">10</td><td class="off disabled" data-title="r2c1">11</td><td class="off disabled" data-title="r2c2">12</td><td class="off disabled" data-title="r2c3">13</td><td class="off disabled" data-title="r2c4">14</td><td class="off disabled" data-title="r2c5">15</td><td class="off disabled" data-title="r2c6">16</td></tr><tr><td class="off disabled" data-title="r3c0">17</td><td class="off disabled" data-title="r3c1">18</td><td class="off disabled" data-title="r3c2">19</td><td class="off disabled" data-title="r3c3">20</td><td class="available active start-date end-date" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="available" data-title="r3c6">23</td></tr><tr><td class="available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="available" data-title="r4c6">30</td></tr><tr><td class="available" data-title="r5c0">31</td><td class="available off" data-title="r5c1">1</td><td class="available off" data-title="r5c2">2</td><td class="available off" data-title="r5c3">3</td><td class="available off" data-title="r5c4">4</td><td class="available off" data-title="r5c5">5</td><td class="available off" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">From</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">To</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">Apply</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">Cancel</button></div></div></div>
<div class="daterangepicker dropdown-menu show-calendar opensleft" style="top: 565px; right: 25.5px; left: auto;"><div class="calendar first left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">27</td><td class="available off" data-title="r0c1">28</td><td class="available off" data-title="r0c2">29</td><td class="available off" data-title="r0c3">30</td><td class="available off" data-title="r0c4">31</td><td class="available" data-title="r0c5">1</td><td class="available" data-title="r0c6">2</td></tr><tr><td class="available" data-title="r1c0">3</td><td class="available" data-title="r1c1">4</td><td class="available" data-title="r1c2">5</td><td class="available" data-title="r1c3">6</td><td class="available" data-title="r1c4">7</td><td class="available" data-title="r1c5">8</td><td class="available" data-title="r1c6">9</td></tr><tr><td class="available" data-title="r2c0">10</td><td class="available" data-title="r2c1">11</td><td class="available" data-title="r2c2">12</td><td class="available" data-title="r2c3">13</td><td class="available" data-title="r2c4">14</td><td class="available" data-title="r2c5">15</td><td class="available" data-title="r2c6">16</td></tr><tr><td class="available" data-title="r3c0">17</td><td class="available" data-title="r3c1">18</td><td class="available" data-title="r3c2">19</td><td class="available" data-title="r3c3">20</td><td class="available active start-date end-date" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="available" data-title="r3c6">23</td></tr><tr><td class="available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="available" data-title="r4c6">30</td></tr><tr><td class="available" data-title="r5c0">31</td><td class="available off" data-title="r5c1">1</td><td class="available off" data-title="r5c2">2</td><td class="available off" data-title="r5c3">3</td><td class="available off" data-title="r5c4">4</td><td class="available off" data-title="r5c5">5</td><td class="available off" data-title="r5c6">6</td></tr></tbody></table></div><div class="calendar-time"><select class="hourselect"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12" selected="selected">12</option></select> : <select class="minuteselect"><option value="0" selected="selected">00</option><option value="30">30</option></select> <select class="ampmselect"><option value="AM" selected="selected">AM</option><option value="PM">PM</option></select></div></div><div class="calendar second right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">27</td><td class="off disabled" data-title="r0c1">28</td><td class="off disabled" data-title="r0c2">29</td><td class="off disabled" data-title="r0c3">30</td><td class="off disabled" data-title="r0c4">31</td><td class="off disabled" data-title="r0c5">1</td><td class="off disabled" data-title="r0c6">2</td></tr><tr><td class="off disabled" data-title="r1c0">3</td><td class="off disabled" data-title="r1c1">4</td><td class="off disabled" data-title="r1c2">5</td><td class="off disabled" data-title="r1c3">6</td><td class="off disabled" data-title="r1c4">7</td><td class="off disabled" data-title="r1c5">8</td><td class="off disabled" data-title="r1c6">9</td></tr><tr><td class="off disabled" data-title="r2c0">10</td><td class="off disabled" data-title="r2c1">11</td><td class="off disabled" data-title="r2c2">12</td><td class="off disabled" data-title="r2c3">13</td><td class="off disabled" data-title="r2c4">14</td><td class="off disabled" data-title="r2c5">15</td><td class="off disabled" data-title="r2c6">16</td></tr><tr><td class="off disabled" data-title="r3c0">17</td><td class="off disabled" data-title="r3c1">18</td><td class="off disabled" data-title="r3c2">19</td><td class="off disabled" data-title="r3c3">20</td><td class="available active start-date end-date" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="available" data-title="r3c6">23</td></tr><tr><td class="available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="available" data-title="r4c6">30</td></tr><tr><td class="available" data-title="r5c0">31</td><td class="available off" data-title="r5c1">1</td><td class="available off" data-title="r5c2">2</td><td class="available off" data-title="r5c3">3</td><td class="available off" data-title="r5c4">4</td><td class="available off" data-title="r5c5">5</td><td class="available off" data-title="r5c6">6</td></tr></tbody></table></div><div class="calendar-time"><select class="hourselect"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11" selected="selected">11</option><option value="12">12</option></select> : <select class="minuteselect"><option value="0">00</option><option value="30">30</option></select> <select class="ampmselect"><option value="AM">AM</option><option value="PM" selected="selected">PM</option></select></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">From</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">To</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">Apply</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">Cancel</button></div></div></div>
<div class="daterangepicker dropdown-menu opensleft" style="display: none; top: 639px; right: 378.281px; left: auto;"><div class="calendar first left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">Dec 2015</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">29</td><td class="available off" data-title="r0c1">30</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="available" data-title="r0c6">5</td></tr><tr><td class="available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="available" data-title="r1c6">12</td></tr><tr><td class="available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="available" data-title="r2c6">19</td></tr><tr><td class="available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available active start-date" data-title="r3c3">23</td><td class="available in-range" data-title="r3c4">24</td><td class="available in-range" data-title="r3c5">25</td><td class="available in-range" data-title="r3c6">26</td></tr><tr><td class="available in-range" data-title="r4c0">27</td><td class="available in-range" data-title="r4c1">28</td><td class="available in-range" data-title="r4c2">29</td><td class="available in-range" data-title="r4c3">30</td><td class="available in-range" data-title="r4c4">31</td><td class="available off in-range" data-title="r4c5">1</td><td class="available off in-range" data-title="r4c6">2</td></tr><tr><td class="available off in-range" data-title="r5c0">3</td><td class="available off in-range" data-title="r5c1">4</td><td class="available off in-range" data-title="r5c2">5</td><td class="available off in-range" data-title="r5c3">6</td><td class="available off in-range" data-title="r5c4">7</td><td class="available off in-range" data-title="r5c5">8</td><td class="available off in-range" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar second right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">Jan 2016</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="available off in-range" data-title="r0c0">27</td><td class="available off in-range" data-title="r0c1">28</td><td class="available off in-range" data-title="r0c2">29</td><td class="available off in-range" data-title="r0c3">30</td><td class="available off in-range" data-title="r0c4">31</td><td class="available in-range" data-title="r0c5">1</td><td class="available in-range" data-title="r0c6">2</td></tr><tr><td class="available in-range" data-title="r1c0">3</td><td class="available in-range" data-title="r1c1">4</td><td class="available in-range" data-title="r1c2">5</td><td class="available in-range" data-title="r1c3">6</td><td class="available in-range" data-title="r1c4">7</td><td class="available in-range" data-title="r1c5">8</td><td class="available in-range" data-title="r1c6">9</td></tr><tr><td class="available in-range" data-title="r2c0">10</td><td class="available in-range" data-title="r2c1">11</td><td class="available in-range" data-title="r2c2">12</td><td class="available in-range" data-title="r2c3">13</td><td class="available in-range" data-title="r2c4">14</td><td class="available in-range" data-title="r2c5">15</td><td class="available in-range" data-title="r2c6">16</td></tr><tr><td class="available in-range" data-title="r3c0">17</td><td class="available in-range" data-title="r3c1">18</td><td class="available in-range" data-title="r3c2">19</td><td class="available in-range" data-title="r3c3">20</td><td class="available active end-date" data-title="r3c4">21</td><td class="available" data-title="r3c5">22</td><td class="available" data-title="r3c6">23</td></tr><tr><td class="available" data-title="r4c0">24</td><td class="available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="available" data-title="r4c6">30</td></tr><tr><td class="available" data-title="r5c0">31</td><td class="available off" data-title="r5c1">1</td><td class="available off" data-title="r5c2">2</td><td class="available off" data-title="r5c3">3</td><td class="available off" data-title="r5c4">4</td><td class="available off" data-title="r5c5">5</td><td class="available off" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="ranges"><ul><li>Today</li><li>Yesterday</li><li>Last 7 Days</li><li class="active">Last 30 Days</li><li>This Month</li><li>Last Month</li><li>Custom Range</li></ul><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">From</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">To</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">Apply</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">Cancel</button></div></div></div>
</body>
</html>