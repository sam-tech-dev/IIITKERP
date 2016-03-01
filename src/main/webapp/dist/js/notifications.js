		
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
	        	var	notification;
	        	document.getElementById("notifications").innerHTML="You have "+data.length+" notifications";
	        	document.getElementById("notif_list").innerHTML="";
				for(var i=0;i<data.length;i++){
					    var notif_temp=document.getElementById("notif_template");
					    notif_temp.getElementsByClassName("notif_msg")[0].innerHTML=data[i].message;
						document.getElementById("notif_list").innerHTML+=notif_temp.innerHTML;
						
					}
			   }
				catch(exception){

				}
			}
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    var uid=1;
	    xmlhttp.open("POST","../RetriveNotifications",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("userid="+uid);
	}
	
	
