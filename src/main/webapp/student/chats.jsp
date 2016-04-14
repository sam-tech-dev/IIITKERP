<!-- Direct Chat -->
	  <div style="display:none">
<span id="left_message">
                <div class="direct-chat-msg" >
                  <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left username">Alexander Pierce</span>
                    <span class="direct-chat-timestamp pull-right timestamp">23 Jan 2:00 pm</span>
                  </div>
                  <!-- /.direct-chat-info -->
                  <img class="direct-chat-img" src="../dist/img/user1-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                  <div class="direct-chat-text text">
                    Is this template really for free? That's unbelievable!
                  </div>
                  <!-- /.direct-chat-text -->
                </div>
                </span>
<span id="right_message">
                <div class="direct-chat-msg right">
                  <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-right username">Sarah Bullock</span>
                    <span class="direct-chat-timestamp pull-left timestamp">23 Jan 2:05 pm</span>
                  </div>
                  <!-- /.direct-chat-info -->
                  <img class="direct-chat-img" src="../dist/img/user3-128x128.jpg" alt="Message User Image"><!-- /.direct-chat-img -->
                  <div class="direct-chat-text text">
                    You better believe it!
                  </div>
                  <!-- /.direct-chat-text -->
                </div>
                </span>                
</div>
		<div  style="display:none;">
			<span id="chatBox">
				<span class="chatWindow" >
				<div >
					<div class="col-md-3" >
						<div class="box box-danger direct-chat direct-chat-danger">
							<div class="box-header with-border">
								<h3 class="box-title">
									<span class="chatHeader">x</span>
								</h3>
								<div class="box-tools pull-right">
									<span data-toggle="tooltip" title="3 New Messages" class="badge bg-red">3</span>
									<button type="button" class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool" >
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body">
								<div class="direct-chat-messages">
									<div class="direct-chat-msg">
										<div class="direct-chat-info clearfix">
											<span class="direct-chat-name pull-left">Alexander Pierce</span>
											<span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span>
										</div>
										<img class="direct-chat-img" src="../dist/img/user1-128x128.jpg" alt="Message User Image">
										<div class="direct-chat-text">Is this template really for free? That's unbelievable!</div>
									</div>
									<div class="direct-chat-msg right">
										<div class="direct-chat-info clearfix">
											<span class="direct-chat-name pull-right">Sarah Bullock</span>
											<span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
										</div>
										<img class="direct-chat-img" src="../dist/img/user3-128x128.jpg" alt="Message User Image">
										<div class="direct-chat-text">You better believe it!</div>
									</div>
								</div>
							</div>
							<div class="box-footer">
								
									<div class="input-group">
										<input type="text" name="message" placeholder="Type Message ..." class="form-control message">
										<span class="input-group-btn">
											<button  class="btn btn-danger btn-flat">Send</button>
										</span>
									</div>
								
							</div>
						</div>
					</div>
					</div>
				</span>
			</span>
			
		</div>
		
     
	   <div id="chatDiv" style="position:fixed;z-index:10;bottom:0;!important;"> 
	   </div> 	
      
	  
      <!-- =========================================================== -->
      <script>
      var session_user_name="<%=request.getSession().getAttribute("name").toString()%>";
      </script></script>