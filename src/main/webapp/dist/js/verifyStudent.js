function verify(csab_id){
	//alert("in verify");
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
	        	window.href="registration.jsp";
	        	//alert(xmlhttp.responseText);
				}
			   
				catch(exception){

				}
			}
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    xmlhttp.open("POST","../VerifyStudent",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("csab_id="+csab_id);
	}
   }	/**
 * 
 */


/*function updateData(){
	//alert("in verify");
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
	        	
	        	//alert(xmlhttp.responseText);
	        	var data=JSON.parse(xmlhttp.responseText);
	        	var table=document.getElementById("reg_table");
	        	//var table;
	        	table.innerHTML=" ";
	        	var i=0;
	        	//for(i=0;i<data.length;i++){
	        		table.innerHTML+="<tr>";
	        		
	        		
	        		table.innerHTML+='<td><div class="btn-group"><button type="button" class="btn btn-block btn-primary"onclick="verify('+data[i].id+')>Verify</button></div></td>';
	                  table.innerHTML+='<td><button type="button" class="btn btn-block btn-danger"><i class="glyphicon glyphicon-eye-open"></i></button></td>';
	                  table.innerHTML+="<td>"+data[i].name+"</td>";
	                  table.innerHTML+="<td>"+data[i].first_name+"</td>";
	                  table.innerHTML+="<td>"+data[i].middle_name+"</td>";
	                  table.innerHTML+="<td>"+data[i].last_name+"</td>";
	                  table.innerHTML+="<td>"+data[i].category+"</td>";
	                 
	                  table.innerHTML+="<td>"+data[i].state+"</td>";
	                  table.innerHTML+="<td>"+data[i].phone_number+"</td>";
	                  table.innerHTML+="<td>"+data[i].email+"</td>";
	                  table.innerHTML+="<td>"+data[i].date_of_birth+"</td>";
	                  table.innerHTML+="<td>"+data[i].program_allocated+"</td>";
	                  
	                  table.innerHTML+="<td>"+data[i].status+"</td>";
	                 
	                  table.innerHTML+="<td>"+data[i].physically_disabled+"</td>";
	                  table.innerHTML+="<td>"+data[i].gender+"</td>";
	                 
	                  table.innerHTML+="<td>"+data[i].nationality+"</td>";
	                  table.innerHTML+="<td>"+data[i].entry_time+"</td>";
	                  table.innerHTML+="<td>"+data[i].verified+"</td>";
	                
	                table.innerHTML+="</tr>";
	        //	}
	        	alert(table.innerHTML);
				}
			   
				catch(exception){

				}
			}
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    xmlhttp.open("POST","../RetrieveRegistrationData",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send();
	}
   }
 window.setInterval(function(){updateData();}(),10000)*/