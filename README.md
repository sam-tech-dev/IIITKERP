![IIITKota-Logo-1.png](https://bitbucket.org/repo/g66ArA/images/855199480-IIITKota-Logo-1.png)

# README #

README for IIITK ERP setup

### Specifications? ###

* Version 0.0.0.1
* Java EE dynamic web application
* Maven Project Integration
* PostgreSQL Database 9.4
* Server Location (Campus MNIT Jaipur) Local IP: 172.16.1.231

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Joey Pinto
  pintojoey@gmail.com
  +919561810254
  +918385006105
  Mumbai,India

* Indian Institute Of Information Technology, Kota
### Files ###
  >Deployment Descriptor:
  >Java Resources
	   >>sources/main
	   >>actions //contains all servlets
		     >>>attendance  //sevlets pertaining to attendance module
		                >>>>AjaxController.java
				>>>>GetSubjectAllocation.java //retrive students  registerd for various courese
				>>>>InsertAttendance.java //inserts attendance sheet into the database
				>>>>StudentsList.java //retrives list of of students registerd in a particular course
		     >>>authentication    //sevlets pertaining to authentication module
		        AutoSuggest.java //retrives autosuggestions for user names
				ResetPassword.java //resets the password of the current user
				Session.java //filter to check weather session of the current user has expired
				SignIn.java //signs the user into the portal and takes him to the respective home page
				SignOut.java //signs the user out by expiring the session
				UpdateLastSeen.java //updates the last seen of the user in the database
		     >chats //sevlets pertaining to chat module
		        Conversation.java //wrapper class for a conversation
				NewMessage.java //ceates anew message and adds the respective user inbox
				Query.java //consist of all the queries pertaining to chats module
				ReadAllMessages.java //marks all tha messages of a conversation as read
				RetrieveAllMessages.java //retrive all messages of conversation
				RetrieveConversationsInfo.java //retrive list of all conversation of the user
				RetrieveMessage.java //retrieve unread messages
		     >feepayment //sevlets pertaining to fee payment module
		     	AddPaymentInfo.java //adds payment details of a transaction in the database
				FeeBreakup.java //insert breakup of fees of a particular year and sem
				VerifyFeePayment.java //mark a transaction as verified
		     >files  //sevlets pertaining to file upload module
		        FileUpload.java //uploads a single file into the specified directory
				UploadMultipleFiles.java //uoloads the multiple files into the specified data
		     >forms //sevlets pertaining to form module
		        RetrieveForms.java //retrives list of form templates
		     
>gradingModule //sevlets pertaining to grading module
		        RetrieveSubjects.java //retrive list of subjects in a particula semester
		     >notifications ////sevlets pertaining to notifications module
		        MarkAsRead.java //mark a notification as read
				RetriveNotifications.java //retrive notification of a particular user
				sendGroupNotification.java //send a notification to more than one user
		     >registration //sevlets pertaining to registration module
		        CsabStudentProfile.java //get entire csab info of a single user
				GenerateStudentId.java //generates student id for the new student
				RegistrationLogin.java //logs the user in into registration module
				ReportStudent.java //marks a student as reported
				RetrieveRegistrationData.java //retrives registration data of a particular student
				
				UpdateStudentRegistrationData.java //update student registraton data of a particular student
				VerifyStudent.java //mark a student's data as verified
		     >testpaper //sevlets pertaining to test paper module
	           CreateAnswerSheet.java //create a new answer sheet
				CreateTestPaper.java //create a new test sheet
				GetQuestion.java //get question of a test paper
				GetSolutionSheet.java //get solution of a test paper
		 >csv  //sevlets pertaining to parse csv data module
		   >Parser.java //parse a csv file
		 >email //sevlets pertaining to send verification email  module
		   >SendEmail.java //send an email to a particular user
		 >exceptions // contains user defined exceptions
		   >ConfigException.java 
		   >IncorrectFormatException.java
		   >SessionException.java
		 >fileExplorer  //sevlets contains file/folder utilities
		   >File.java
		   >FileExploree.java
		   >FileSystemObject.java
		   >test.java
		   >sheet2.config
		 >ldap //login authentication module for user
		   >AddUsers.java
		   >SimpleLdapAuthentication.java
		   >User.java
		 >postgreSQLDatabase //contains all database queries
		   >attendance //
		   >authentication
		   >chats
		   >feePayment
		   >forms
		   >gradingModule
		   >notifications
		   >onlineTest
		   >registration
		   >database.backup
		 >settings
		   >database
		     >PostgreSQLConnection.java
		   >propertySheet
		     >PropertiesFile.java
		     >PropertySheet.java
		   >Execution.java
		 >timeTable
		   >Lecture.java
		   >Slot.java
		   >TimeTableGenerator.java
		 >users
		   >Student.java
		 >utilities
		   >MD5.java
		   >StringFormatter.java
		   >StringPermutation.java
		   >StudenIdGeneration.java
		 >TestPaper.json   
	   >src/main/java
	   >src/test/java
	   >Libraries
	     >Apache Tomcat v7.0
	     >JRE System Library
	     >Maven Dependencies
  >JavaScript Resources
    >src/main/webapp
    >target/m2e-wtp/web-resources
    >ECMAScript Built-In Library
    >ECMA 3 Browser Support Library
  >Deployed Resources
    >webapp
      >administration
        >blank.jsp
		>calendar.jsp
		>control-sidebar.jsp
		>csab.jsp
		>footer.jsp
		>header.jsp
		>home.jsp
      >bootstrap
        >css
		>fonts
		>js
      >build
        >bootstrap-less
        >less
      >dist
        >css
		>img
		>js
      >documentation
       >build
	   >docs.js
	   >index.html
	   >style.css
      >faculty
        js
         jquery-1.12.1.min.js
		attendanceList.jsp
		attendancePage1_2.jsp
		attendancePage1_3.jsp
		attendancePage1.jsp
		attendancePage2_2.jsp
		attendancePage2.jsp
		blank.jsp
	control-sidebar.jsp
		dynamicform.jsp
		dynamicform2.jsp
		footer.jsp
		form.html
		GradingModule.jsp
		header.jsp
		home.jsp
		index.jsp
		main-sidebar.jsp
		NewFile.jsp
		onlineTest.jsp
		sample.jsp
		solutionSheet.jsp
		submissions.jsp
		testpaperlist.jsp
      >image
        iiitkota.jpg
		image.jpg
		images.jpg
		sbi.jpg
		Thumbs.db
      >META-INF
        MANIFEST.MF
      >office
        blank.jsp
		calendar.jsp
		control-sidebar.jsp
	csabImport.jsp
		fee_payment.jsp
		feePaymentStatusList.jsp
		feeStructure.jsp
		footer.jsp
		groupNotification.jsp
	header.jsp
	home.jsp
		main-sidebar.jsp
	multipleFileUpload.jsp
		paymentHistory.jsp
		registration.jsp
		registrationStatus.jsp
		verifyStudentDetails1.jsp
		verifyStudentDetails2.jsp
      >plugins
        bootstrap-slider
		bootstrap-wysihtml5
		chartjs
		ckeditor
		colorpicker
		datatables
		datepicker
		daterangepicker
		iCheck
	input-mask
		ionslider
		jQuery
		jQueryUI
		jvectormap
		knob
		morris
		pace
	select2
		slimScroll
		sparkline
		timepicker
      >student
        blank.jsp
		challan.jsp
		challan-preview.jsp
		challan-print.jsp
		chats.jsp
control-sidebar.jsp
		dynamicforms.jsp
+		footer.jsp
+		forms.jsp
+		generatechallan.jsp
+		header.jsp
+		home.jsp
+		inputFormat.jsp
+		main-sidebar.jsp
+		paymentHistory.jsp
+		questions.jsp
+		register.jsp
+		selectFields.jsp
+		solutionList.jsp
+		solutionSheet.jsp
+		submissions.jsp
+		successUpload.jsp
+		testpaperlist.jsp
+		uploadDocuments.jsp
+		widgets.jsp
+		widgets2.jsp
+      >studentRegistration
+        blank.jsp
+		control-sidebar.jsp
+		csabRegistration.jsp
+		footer.jsp
+		header.jsp
+		ldapRegistration.jsp
+		lockScreen.jsp
+		main-sidebar.jsp
+		new-asidebar.jsp
+		registrationPayment.jsp
+      >WEB-INF
+         >web.xml
+	    404.jsp
+		bower.json
+		checkQuestions.jsp
+		footer.jsp
+		forgot.jsp
+		forgotPassword.jsp
+		forgotReset.jsp
+		groupNotifications.html
+		Gruntfile.js
+		login.jsp
+		register.jsp
+		resetPassword.jsp
+		SessionExpired.jsp
+		upload.jsp
+		validate.js
+		viewResults.jsp
+    >web-resources
+      >META-INF
+        >maven
+        MAINFEST.MF
+  >sources
+    >main
+       actions
+		csv
+		email
+		exceptions
+		fileExplorer
+		ldap
+		postgreSQLDatabase
+		settings
+		timeTable
+		users
+		utilities
+		TestPaper.json
+		actions
+		csv
+		email
+		exceptions
+		fileExplorer
+		ldap
+		postgreSQLDatabase
+		settings
+		timeTable
+		users
+		utilities
+  >src
+    >main
+      java
+      webapp
+        administration
+		bootstrap
+		build
+		dist
+		documentation
+		faculty
+		image
+		META-INF
+		office
+		plugins
+		student
+		studentRegistration
+		WEB-INF
+		404.jsp
+		bower.json
+		checkQuestions.jsp
+		footer.jsp
+		forgot.jsp
+		forgotPassword.jsp
+		forgotReset.jsp
+		groupNotifications.html
+		Gruntfile.js
+		login.jsp
+		register.jsp
+		resetPassword.jsp
+		SessionExpired.jsp
+		upload.jsp
+		validate.js
+		viewResults.jsp    
+    >test
+      java
+  >target
+    erp
+        bootstrap
+		build
+		dist
+		documentation
+		faculty
+		image
+		META-INF
+		office
+		plugins
+		student
+		studentRegistration
+		WEB-INF
+		bower.json
+		checkQuestions.jsp
+		csab.jsp
+		forgot.jsp
+		Gruntfile.js
+		login.jsp
+		register.jsp
+		reset.jsp
+		validate.js
+		viewResults.jsp
+	m2e-wtp
+	  web-resources
+	    META-INF
+	      maven
+	        in.ac.iiitkota.developers
+	           ERP
+	             pom.properties
+                 pom.xml
+	      MAINFEST.MF
+	maven-archiver
+	erp.war
+>faculty.csv
+>file.txt
+>pom.xml
+>README.md
+>thirdyear.csv
Add a comment to this line
+