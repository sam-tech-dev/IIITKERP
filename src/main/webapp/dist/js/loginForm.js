function validate(ldap_username,ldap_password){


	if(ldap_username == ""){
		$("#error_username").html("Please fill this field.");
		return false;
	}


	else if(ldap_password == ""){
		$("#error_password").html("Please fill this field.");
		return false;
	}

	else{

		return true;
	}
}	

function authenticate(username,password) {

	if(!validate(username,password))return false;

	
	// to support all browsers
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
	        	
				try{
	        	data=JSON.parse(xmlhttp.responseText);
				if (data.redirect) {
					
					// data.redirect contains the string URL to redirect to
				
					window.location.href = data.redirect;
				}
				else {
					// data.form contains the HTML for the replacement form
					$("#error_password").html("Incorrect username or password");
				}}
				catch(exception){
					$("#error_password").html("Incorrect username or password");
				}
			}
	        if(xmlhttp.status == 404)
				$("#error_password").html("Could not connect to server");
			}
	    xmlhttp.open("POST","SignIn",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("username=" +username+"&password="+password);
	}
	
	return false;
}