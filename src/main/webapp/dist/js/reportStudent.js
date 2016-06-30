function report(csab_id){
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
	        	data=JSON.parse(xmlhttp.responseText);
	        	alert("Student Registration ID is "+data.reg);
	        	location.reload();	
			}
	        
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    xmlhttp.open("POST","../ReportStudent",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("csab_id="+csab_id);
	}
   }	