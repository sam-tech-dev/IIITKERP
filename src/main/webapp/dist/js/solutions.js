var solution_sheet=[];
var solution_sheet_length=0;
function getQuestion(question_id){
	var question_template=document.getElementById('question_template');
	question_template.getElementsByClassName("question_number")[0].innerHTML=question_id+1;
        var	data={};
        data=solution_sheet[question_id];
        question_db_id=data.id;
			var question_stmt=question_template.getElementsByClassName("question_stmt")[0];
			question_stmt.innerHTML=data.question;
			
			var ques_type=data.type;
			
			var answer_div=question_template.getElementsByClassName("answer")[0];
			answer_div.innerHTML="";
		if(ques_type=="short_answer"){
				var id=document.getElementById(ques_type);
				
				id.getElementsByClassName('form-control correct_answer')[0].setAttribute('value',data.correct_answer);
				id.getElementsByClassName('form-control given_answer')[0].setAttribute('value',data.given_answer);
				answer_div.innerHTML+=id.innerHTML;
			}
		else if(ques_type=="long_answer"){
				var id=document.getElementById(ques_type);
				id.getElementsByClassName('form-control correct_answer')[0].innerHTML=data.correct_answer;
				id.getElementsByClassName('form-control given_answer')[0].innerHTML=data.given_answer;
				answer_div.innerHTML+=id.innerHTML;
				
			}
		else   if(ques_type=="radio_answer"){
            	var id;
            	var option_div="";
            	var no_options=data.options.length;
            	for (var i = 0; i < no_options; i++) {
            		id=document.getElementById(ques_type);
            	id.getElementsByClassName("optionsRadio")[0].value=data.options[i];
            	id.getElementsByClassName("options_label")[0].innerHTML=data.options[i];
            	
            	if(data.correct_answer.indexOf(data.options[i])!=-1)
            		id.getElementsByClassName("options_label")[0].innerHTML=data.options[i].fontcolor("green");
            	if(data.given_answer.indexOf(data.options[i])!=-1)
            		id.getElementsByClassName("optionsRadio")[0].setAttribute('checked', 'checked');
          	else
            		id.getElementsByClassName("optionsRadio")[0].removeAttribute('checked');
            	option_div+=id.innerHTML;
            		
				}
           	
            	//alert(id.innerHTML);
            	answer_div.innerHTML+=option_div;
			}
		else if(ques_type=="checkbox_answer"){
            	var id;
            	var option_div="";
            	var no_options=data.options.length;
            	for (var i = 0; i < no_options; i++) {
            		id=document.getElementById(ques_type);
            		
            	id.getElementsByClassName("checkbox_text")[0].value=data.options[i];
            	id.getElementsByClassName("checkbox_text")[0].innerHTML=data.options[i];
            	if(data.correct_answer.indexOf(data.options[i])!=-1)
            		id.getElementsByClassName("checkbox_text")[0].innerHTML=data.options[i].fontcolor("green");
            	if(data.given_answer.indexOf(data.options[i])!=-1)
            		id.getElementsByClassName("checkbox_value")[0].setAttribute('checked', 'checked');
            	else
                		id.getElementsByClassName("checkbox_value")[0].removeAttribute('checked');
            	option_div+=id.innerHTML;
            		
				}
            	answer_div.innerHTML+=option_div;
            }
		else {alert("error");}
        document.getElementById('solution').innerHTML+=question_template.innerHTML;
	
}
function getTestpaper(test_paper_id){
	test_paper_number=test_paper_id;
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
        	
			solution_sheet=JSON.parse(ajax_request.responseText);
			solution_sheet_length=solution_sheet.length;
			for(var i=0;i<solution_sheet_length;i++)
			getQuestion(i);
		}
        if(ajax_request.status == 404)
        	{
        	 //could not connect to server
        	}
        
	}
    ajax_request.open("POST","../GetSolutionSheet",true);
	ajax_request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    ajax_request.send("answer_sheet_id=" +answer_sheet_id);
	}
}