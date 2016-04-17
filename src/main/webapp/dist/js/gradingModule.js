function getSemester(){
	  var span=document.getElementById('subject_id');
      span.innerHTML=' <option value="0">--Select--</option>';
		var ajax_request;
	var semester_value=document.getElementById("semester").value;
	try{
		ajax_request = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			ajax_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				ajax_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
			//Browser doesn't support ajax	
				alert("Your browser is unsupported");
			
			}
		}
	}
	
	if(ajax_request){
	ajax_request.onreadystatechange=function() {
        if (ajax_request.readyState==4 && ajax_request.status==200) {
       //  alert(ajax_request.responseText);
      //   document.getElementById("semester_info").innerHTML=ajax_request.responseText;
         var data=JSON.parse(ajax_request.responseText);
       
         for(i=0;i<data.length;i++){
        	 span.innerHTML+='<option value="'+data[i].code+'"><strong>'+data[i].code+'</strong>'+data[i].name+'</option>';
         }
		}
        if(ajax_request.status == 404)
        	{
        	 //could not connect to server
        	}
        
	}
    ajax_request.open("POST","../RetrieveSubjects",true);
	ajax_request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    ajax_request.send("semester_name="+semester_value);
	}
	
	
	
}

function getGrades(){
	var course_code=document.getElementById('subject_id').value;
	var year=document.getElementById('year').value;
	if(course_code!=0){
		window.location.href="GradingModule.jsp?course_code="+course_code+"&year="+year;
	}
}


