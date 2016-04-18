function updateStudentRegistrationDetails(){

	//var chat_name=document.getElementById('chat_message').value;
	
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
	//var xmlhttp=new XMLHttpRequest();

	if(xmlhttp){	
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			
				
				
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../addUpdateStudentRegistrationDetails",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("name="+document.getElementById('name').value
				+"&first_name="+document.getElementById('first_name').value
				+"&middle_name="+document.getElementById('middle_name').value
				+"&last_name="+document.getElementById('last_name').value
				+"&category="+document.getElementById('category').value
				+"&jee_main_rollno="+document.getElementById('jee_main_rollno').value
				+"&jee_adv_rollno="+document.getElementById('jee_adv_rollno').value
		+"&guardian_name="+document.getElementById('guardian_name').value
		+"&guardian_contact="+document.getElementById('guardian_contact').value
		+"&guardian_email="+document.getElementById('guardian_email').value
		+"&guardian_address="+document.getElementById('guardian_address').value
		+"&father_name="+document.getElementById('father_name').value
		+"&mother_name="+document.getElementById('mother_name').value
		+"&father_contact="+document.getElementById('father_contact').value
		+"&mother_contact="+document.getElementById('mother_contact').value
		+"&gender="+document.getElementById('gender').value
		+"&allocated_category="+document.getElementById('allocated_category').value
		+"&date_of_birth="+document.getElementById('date_of_birth').value
		+"&state_eligibility="+document.getElementById('state_eligibility').value
		+"&program_allocated="+document.getElementById('program_allocated').value
		+"&allocated_rank="+document.getElementById('allocated_rank').value
		+"&status="+document.getElementById('status').value
		+"&choice_no="+document.getElementById('choice_no').value
		+"&round="+document.getElementById('round').value
		+"&quota="+document.getElementById('quota').value
		+"&willingness="+document.getElementById('willingness').value
		+"&mobile="+document.getElementById('mobile').value
		+"&email="+document.getElementById('email').value
		+"&permanent_address="+document.getElementById('permanent_address').value
		+"&local_address="+document.getElementById('local_address').value
		+"&hosteller="+document.getElementById('hosteller').value
		+"&hostel="+document.getElementById('hostel').value);
	}
	return false;
}
