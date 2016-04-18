
 <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><% out.print(request.getSession().getAttribute("name")); %></p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
          
       
        <li class="treeview">
           <li class="treeview">
          <a href="#">
            <i class="fa fa-cogs"></i> <span>Registration</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="csabImport.jsp"><i class="fa fa-circle-o"></i>CSAB Reporting</a></li>
            <li><a href="registration.jsp"><i class="fa fa-circle-o"></i>Registration/Verification</a></li>
            <li><a href="feePaymentStatusList.jsp"><i class="fa fa-circle-o"></i>Fee Payment</a></li>
            <li><a href="registrationStatus.jsp"><i class="fa fa-circle-o"></i>Status</a></li>
          </ul>
          
        </li>
         <li class="treeview">
          <a href="#">
            <i class="fa fa-cogs"></i> <span>My Account</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="../changePassword.jsp"><i class="fa fa-circle-o"></i>Change Password</a></li>
          </ul>
        </li>
      
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

