function validate(){
	//18 field
	var validated=true;
	var incorrect_fields=[];
	if(document.getElementById('first_name').value==""){validated=false;incorrect_fields.push("First Name");}
	if(document.getElementById('middle_name').value==""){validated=false;incorrect_fields.push("Middle Name");}
	if(document.getElementById('last_name').value==""){validated=false;incorrect_fields.push("Last Name");}
	if(document.getElementById('guardian_name').value==""){validated=false;incorrect_fields.push("Guardian Name");}
	if(document.getElementById('guardian_contact').value==""){validated=false;incorrect_fields.push("Guardian Contact");}
	if(document.getElementById('guardian_email').value==""){validated=false;incorrect_fields.push("Guardian Email");}
	if(document.getElementById('guardian_address').innerHTML==""){validated=false;incorrect_fields.push("Guardian Address");}
	if(document.getElementById('father_name').value==""){validated=false;incorrect_fields.push("Father Name");}
	if(document.getElementById('mother_name').value==""){validated=false;incorrect_fields.push("Mother Name");}
	if(document.getElementById('father_contact').value==""){validated=false;incorrect_fields.push("Father Conatct");}
	if(document.getElementById('mother_contact').value==""){validated=false;incorrect_fields.push("Mother Conatct");}
	if(document.getElementById('date_of_birth').value==""){validated=false;incorrect_fields.push("Date Of Birth");}
	if(document.getElementById('mobile').value==""){validated=false;incorrect_fields.push("Mobile");}
	if(document.getElementById('email').value==""){validated=false;incorrect_fields.push("Email");}
	if(document.getElementById('permanent_address').innerHTML==""){validated=false;incorrect_fields.push("Permanent Address");}
	if(document.getElementById('local_address').innerHTML==""){validated=false;incorrect_fields.push("Local Address");}
	if(document.getElementById('hosteller').value==""){validated=false;incorrect_fields.push("Hosteller");}
	if(document.getElementById('hostel').value==""){validated=false;incorrect_fields.push("Hostel");}
	if(document.getElementById('hostel_room').value==""){validated=false;incorrect_fields.push("Hostel Room");}
	if(validated==false)alert("Please check values in "+incorrect_fields);
return validated;
}


function updateStudentRegistrationDetails(){
	
	if(!validate())return false;

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
		xmlhttp.send(//"name="+document.getElementById('name').value
				+"&first_name="+document.getElementById('first_name').value
				+"&middle_name="+document.getElementById('middle_name').value
				+"&last_name="+document.getElementById('last_name').value
				//+"&category="+document.getElementById('category').value
			+"&guardian_name="+document.getElementById('guardian_name').value
			+"&guardian_contact="+document.getElementById('guardian_contact').value
			+"&guardian_email="+document.getElementById('guardian_email').value
			+"&guardian_address="+document.getElementById('guardian_address').innerHTML
			+"&father_name="+document.getElementById('father_name').value
			+"&mother_name="+document.getElementById('mother_name').value
			+"&father_contact="+document.getElementById('father_contact').value
			+"&mother_contact="+document.getElementById('mother_contact').value
			//+"&gender="+document.getElementById('gender').value
			+"&date_of_birth="+document.getElementById('date_of_birth').value
			//+"&state_eligibility="+document.getElementById('state_eligibility').value
			//+"&program_allocated="+document.getElementById('program_allocated').value
			+"&mobile="+document.getElementById('mobile').value
			+"&email="+document.getElementById('email').value
			+"&permanent_address="+document.getElementById('permanent_address').innerHTML
			+"&local_address="+document.getElementById('local_address').innerHTML
			+"&hosteller="+document.getElementById('hosteller').value
			+"&hostel="+document.getElementById('hostel').value
			+"&room="+document.getElementById('hostel_room').value);

	
	}
	return false;
}
