		
 var notif_temp;
 function getNotifications(){
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
	        	document.getElementById("notif_count").innerHTML=data.length;
	        	document.getElementById("notifications").innerHTML="You have "+data.length+" notifications";
	        	document.getElementById("notif_list").innerHTML="";
				for(var i=0;i<data.length;i++){
					   
					    notif_temp=document.getElementById("notif_template");
					    notif_temp.getElementsByClassName("notif_msg")[0].innerHTML=data[i].message;
					    notif_temp.getElementsByClassName("notif_link")[0].setAttribute("href","http://"+data[i].link);
					   notif_temp.getElementsByClassName("notif_row")[0].setAttribute("id",data[i].notif_id);
						document.getElementById("notif_list").innerHTML+=notif_temp.innerHTML;
						
						
					}
				}
			   
				catch(exception){
					document.getElementById("notif_count").innerHTML="";
					document.getElementById("notifications").innerHTML="You have no new notifications";
					document.getElementById("notif_list").innerHTML="";
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
   }	
function updateLastSeen(){
	//alert("update");
	var xmlhttp_obj;
	try{
		xmlhttp_obj = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			xmlhttp_obj = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				xmlhttp_obj = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
			//Browser doesn't support ajax	
				alert("Your browser is unsupported");
			}
		}
	}
	
	if(xmlhttp_obj){
	   
	    xmlhttp_obj.open("POST","../UpdateLastSeen",true);
		xmlhttp_obj.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp_obj.send();
	}
   }	
	


function markAsRead(notif){
	
	
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
	        	
						
					}
			   
				catch(exception){
					
				}
	        }
			
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
	    }
	    var uid=1;
	    var notif_id=notif.id;
	    xmlhttp.open("POST","../MarkAsRead",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("userid="+uid+"&notif_id="+notif_id);
	    return false;
	
	}

}

	   

window.setInterval(function(){getNotifications();}(),5000);
window.setInterval(function(){updateLastSeen();}(),7000);
