function getQuestion(test_paper_id,question_id){
	var ajax_request;
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
        	
			try{
        	data=JSON.parse(ajax_request.responseText);
			var question_stmt=document.getElementById("question_stmt");
			question_stmt.innerHTML=data.question;
			var ques_type=data.type;
			if(ques_type=="short_answer"){
				var id=document.getElementById(ques_type).innerHTML;
				var answer_div=document.getElementById("answer");
				answer_div.innerHTML=id;
			}
			if(ques_type=="long_answer"){
				var id=document.getElementById(ques_type).innerHTML;
				var answer_div=document.getElementById("answer");
				answer_div.innerHTML=id;
				
			}
            if(ques_type=="radio_answer"){
            	var id;
            	var answer_div="";
            	var no_options=data.options.length;
            	for (var i = 0; i < no_options; i++) {
            		id=document.getElementById(ques_type);
            	id.getElementsByClassName("optionsRadio")[0].value=data.options[i];
            		id.getElementsByClassName("options_label")[0].innerHTML=data.options[i];
            		answer_div+=id.innerHTML;
            		
				}
            	document.getElementById("answer").innerHTML=answer_div;
			}
            if(ques_type=="checkbox_answer"){
            	var answer_div="";
            	var no_options=data.options.length;
            	for (var i = 0; i < no_options; i++) {
            		id=document.getElementById(ques_type);
            	id.getElementsByClassName("checkbox_test")[0].value=data.options[i];
            	id.getElementsByClassName("checkbox_test")[0].innerHTML=data.options[i];
            		answer_div+=id.innerHTML;
            		
				}
            	document.getElementById("answer").innerHTML=answer_div;
            }
			}
			catch(exception){
				
			}
		}
        if(ajax_request.status == 404)
        	{
        	 //could not connect to server
        	}
        
	}
    ajax_request.open("POST","../GetQuestion",true);
	ajax_request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    ajax_request.send("test_paper_id=" +test_paper_id+"&question_id="+question_id);
	}
}