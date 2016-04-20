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
  * Deployment Descriptor
  * Java Resources
	  *  sources/main
		  * actions -contains all servlets
			  * attendance -sevlets pertaining to attendance module
				  * AjaxController.java
				  * GetSubjectAllocation.java -retreive students  registered for various course
				  * InsertAttendance.java //inserts attendance sheet into the database
				  * StudentsList.java //retrives list of of students registerd in a particular course
			  * authentication    //sevlets pertaining to authentication module
				  *  AutoSuggest.java //retrives autosuggestions for user names
				  * ResetPassword.java //resets the password of the current user
				  * Session.java //filter to check weather session of the current user has expired
				  * SignIn.java //signs the user into the portal and takes him to the respective home page
				  * SignOut.java //signs the user out by expiring the session
				  * UpdateLastSeen.java //updates the last seen of the user in the database
			  * chats //sevlets pertaining to chat module
				  * Conversation.java //wrapper class for a conversation
				  * NewMessage.java //ceates anew message and adds the respective user inbox
				  * Query.java //consist of all the queries pertaining to chats module
				  * ReadAllMessages.java //marks all tha messages of a conversation as read
				  * RetrieveAllMessages.java //retrive all messages of conversation
				  * RetrieveConversationsInfo.java //retrive list of all conversation of the user
				  * RetrieveMessage.java //retrieve unread messages
			  * feepayment //sevlets pertaining to fee payment module
				  * AddPaymentInfo.java //adds payment details of a transaction in the database
				  * FeeBreakup.java //insert breakup of fees of a particular year and sem
				  * VerifyFeePayment.java //mark a transaction as verified
			  * files  //sevlets pertaining to file upload module
				  * FileUpload.java //uploads a single file into the specified directory
				  * UploadMultipleFiles.java //uoloads the multiple files into the specified data
			  * forms //sevlets pertaining to form module
				  * RetrieveForms.java //retrives list of form templates
			  * gradingModule //sevlets pertaining to grading module
				  * RetrieveSubjects.java //retrive list of subjects in a particula semester
			  * notifications ////sevlets pertaining to notifications module
				  *  MarkAsRead.java //mark a notification as read
				  * RetriveNotifications.java //retrive notification of a particular user
				  * sendGroupNotification.java //send a notification to more than one user
			  * registration //sevlets pertaining to registration module
				  * AddLdapUser.java 
				  * CsabStudentProfile.java //get entire csab info of a single user
				  * RegisterStudent.java
				  * GenerateStudentId.java //generates student id for the new student
				  * RegistrationLogin.java //logs the user in into registration module
				  * ReportStudent.java //marks a student as reported
				  * RetrieveRegistrationData.java //retrives registration data of a particular student
				  * RetrieveRegistrationStudentData.java
				  * StudentServletTemplate.java
				  * UpdateStudentRegistrationData.java //update student registraton data of a particular student
				  * VerifyStudent.java //mark a student's data as verified
				  *  addUpdateStudentRegistrationDetails.java
			  * testpaper //sevlets pertaining to test paper module
				  * CreateAnswerSheet.java //create a new answer sheet
				  * CreateTestPaper.java //create a new test sheet
				  * GetQuestion.java //get question of a test paper
				  * GetSolutionSheet.java //get solution of a test paper
		  * csv  //sevlets pertaining to parse csv data module
			  * Parser.java //parse a csv file
		  * email //sevlets pertaining to send verification email  module
			  * SendEmail.java //send an email to a particular user
		  * exceptions // contains user defined exceptions
			  * ConfigException.java 
			  * IncorrectFormatException.java
			  * SessionException.java
		  * fileExplorer  //sevlets contains file/folder utilities
			  * File.java
			  * FileExploree.java
			  * FileSystemObject.java
			  * test.java
			  * sheet2.config
		  * ldap //login authentication module for user
			  * AddUsers.java
			  * SimpleLdapAuthentication.java
			  * User.java
		  * postgreSQLDatabase //contains all database queries
			  * attendance 
				  * Allocation.java
				  * Attendance.java
				  * Query.java
			  * authentication
				  * Query.java
			  * chats
				  * Message.java
				  * Query.java
			  * feePayment
				  * ChallanQuery.java
				  * FeeBreakup.java
				  * FeePaymentDetails.java
				  * Payment.java
				  * Query.java
				  * package-info.java
			  * forms
				  * Query.java
			  * gradingModule
				  * Grade.java
				  * Query.java
				  * Subject.java
			  * notifications
				  * Notifications.java
				  * Query.java
			  * onlineTest
				  * Answer.java
				  * AnswerSheet.java
				  * Query.java
				  * Question.java
				  * Solution.java
				  * TestPaper.java
			  * registration
				  * ImportCSAB.java
				  * Query.java
				  * UsernameGeneration.java
			  * database.backup
		  * settings
			  * database
				  * PostgreSQLConnection.java
			  * propertySheet
				  * PropertiesFile.java
				  * PropertySheet.java
			  * Execution.java
		  * timeTable
			  * Lecture.java
			  * Slot.java
			  * TimeTableGenerator.java
		  * users
			  * Student.java
		  * utilities
			  * MD5.java
			  * StringFormatter.java
			  * StringPermutation.java
			  * StudenIdGeneration.java
		 