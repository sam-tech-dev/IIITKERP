<!DOCTYPE html><?php if(session_status() == PHP_SESSION_NONE)	session_start(); ?>
<?php  
      include("config.php");
?>
<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="assets/img/favicon.png" />
    <link rel="icon" type="image/png" href="assets/img/favicon.png" />
    <link href='assets/fonts/Montseratt.css' rel='stylesheet' type='text/css'>
    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="assets/css/selectize.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="assets/css/vanillabox/vanillabox.css" type="text/css">

    <link rel="stylesheet" href="assets/css/style.css" type="text/css">

    <title>News-IIIT KOTA</title>

</head>

<body class="page-sub-page page-register-sign-in">
<!-- Wrapper -->
<div class="wrapper">
<!-- Header -->
<?php include 'header.php'; ?>
<!-- Breadcrumb -->
<div class="container">
    <ol class="breadcrumb">
        <li><a href='index.php'>Home</a></li>
        <li><a href="<?php echo $_SESSION['user'];?>-home.php">Dashboard</a></li>
		<li><a href="<?php echo $_SESSION['user'];?>-home.php#tab-console">Control Panel</a></li>
		<li><a href="newslist.php">News</a></li>
        <li class="active">Add News</li>
    </ol>
</div>
<!-- end Breadcrumb -->

<!-- Page Content -->
<div id="page-content">
    <div class="container">
        <div class="row">
            <!--MAIN Content-->
            <div id="page-main">
                <div class="col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1">
                    <div class="row">
                        <div class="col-md-6">
						<div ><!--method="post" action="assets/php/submitnews.php"-->
                            <section id="account-register" class="account-block">
                                <header><h2>Submit News</h2></header>
                                <form role="form" class="clearfix" method="post" action="assets/php/submitnews.php" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="new-account-name">Title</label>
                                        <input type="text" name="title" class="form-control" id="new-account-name" placeholder="Title" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="new-account-email">Subtitle</label>
                                        <input type="text" name="subtitle" class="form-control" id="new-account-email" placeholder="Subtitle" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="new-account-password">Date</label>
                                        <input type="date" name="date" class="form-control" id="new-account-password" required>
										
                                    </div>
                                    <div class="form-group">
                                        <label for="new-account-repeat-password">Detail</label><div class="box-body pad">
              <form>
                    <textarea id="editor1" name="editor1" rows="10" cols="80">
                                            This is my textarea to be replaced with CKEditor.
                    </textarea>
              </form>
            </div>
										
                                        <textarea name="detail" class="form-control" id="new-account-repeat-password" required></textarea>
                                    </div>
									<div class="form-group">
                                        <label for="new-account-repeat-password">Attachment</label>
                                        <input type="file" name="uploadimage" class="form-control" id="new-account-repeat-password" >
										
                                    </div>
									
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" required>I Understand Terms & Conditions
                                        </label>
                                    </div>
                                    <input type="submit" name="submit" class="btn pull-right" value="Submit" />
                                </form>
                            </section><!-- /#account-block -->
							</div>
							
                        </div><!-- /.col-md-6 -->
                    </div><!-- /.row -->
                </div><!-- /.col-md-10 -->
            </div><!-- /#page-main -->

            <!-- end SIDEBAR Content-->
        </div><!-- /.row -->
    </div><!-- /.container -->
</div>
<!-- end Page Content -->

<?php include 'footer.php'; ?>
<script type="text/javascript" src="assets/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/selectize.min.js"></script>
<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.placeholder.js"></script>
<script type="text/javascript" src="assets/js/jQuery.equalHeights.js"></script>
<script type="text/javascript" src="assets/js/icheck.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.vanillabox-0.1.5.min.js"></script>
<script type="text/javascript" src="assets/js/retina-1.1.0.min.js"></script>

<script type="text/javascript" src="assets/js/custom.js"></script>

</body>
</html>