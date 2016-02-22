function authenticate(username,password) {
	
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
	
	if(xmlhttp){	
	    xmlhttp.onreadystatechange=function() {
	        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	        	
				try{
	        	data=JSON.parse(xmlhttp.responseText);
	        	///
			   }
				catch(exception){

				}
			}
	        if(xmlhttp.status == 404)
				$("#error_password").html("Could not connect to server");
			}
	    xmlhttp.open("POST","RetriveNotifications",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("userid=" +userid);
	}
	
	return false;
}