function authenticateRegId(){

    var reg_id=document.getElementById("login_reg_id").value;
    alert(reg_id);
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
	        	
				alert(xmlhttp.responseText);
	        	data=JSON.parse(xmlhttp.responseText);
				if (data.redirect) {
					// data.redirect contains the string URL to redirect to
				
					window.location.href = data.redirect;
				}
				else {
					// data.form contains the HTML for the replacement form
					alert("Incorrect registration id");
				}
				
			}
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    xmlhttp.open("POST","../RegistrationLogin",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("reg_id=" +reg_id);
	}
	
	return false;
	}
