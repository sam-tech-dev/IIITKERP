

var current_question=0;

var testpaper=[];
var testpaper_length=0;


function nextQuestion(){
	
	
	submit();
	
	if(current_question <testpaper_length-1){
		
		current_question++;
		getQuestion(current_question);
			
	}
	
	
}

function previousQuestion(){
	
	submit();
	
	if(current_question !=0){
		
	
	current_question--;
	getQuestion(current_question);
	}
	
	
}

function getQuestion(question_id){
	
	if(question_id==0){
		document.getElementById("previous_btn").className="btn btn-default btn-sm disabled";
	    document.getElementById("previous_btn").disable=true;
			
		
	}
	
	else if(question_id >testpaper_length-1){
		
		document.getElementById("next_btn").className="btn btn-default btn-sm disabled";
	    document.getElementById("next_btn").disable=true;
	}
	
	
	else {
        document.getElementById("previous_btn").className="btn btn-default btn-sm ";
        document.getElementById("previous_btn").disable=false;
		document.getElementById("next_btn").className="btn btn-default btn-sm";
		document.getElementById("next_btn").disable=false;
		
		
		
	}
	
	
        var	data={};
        data=testpaper[question_id];
       
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
            	var id;
            	var answer_div="";
            	var no_options=data.options.length;
            	for (var i = 0; i < no_options; i++) {
            		id=document.getElementById(ques_type);
            		alert(id.innerHTML);
            	id.getElementsByClassName("checkbox_text")[0].value=data.options[i];
            	id.getElementsByClassName("checkbox_text")[0].innerHTML=data.options[i];
            		answer_div+=id.innerHTML;
            		
				}
            	document.getElementById("answer").innerHTML=answer_div;
            }
			
        
	
}
function getTestpaper(test_paper_id){
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
        	
			testpaper=JSON.parse(ajax_request.responseText);
			testpaper_length=testpaper.length;
			getQuestion(0);
		}
        if(ajax_request.status == 404)
        	{
        	 //could not connect to server
        	}
        
	}
    ajax_request.open("POST","../GetQuestion",true);
	ajax_request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    ajax_request.send("test_paper_id=" +test_paper_id);
	}
}