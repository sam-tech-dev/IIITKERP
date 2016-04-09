var jArray=[];
function submit(){

	var JObject={};
	JObject["id"]=question_db_id;
	if(document.getElementById("answer").getElementsByClassName('radio').length!=0)
		{
		var options=[];
		var radio_buttons=document.getElementById("answer").getElementsByClassName('radio');
		for(var i=0;i<radio_buttons.length;i++){
			
			if(radio_buttons[i].getElementsByClassName('optionsRadio')[0].checked==true)
				options.push(radio_buttons[i].getElementsByClassName("options_label")[0].innerHTML);
			}
		JObject["answer"]=options;
		jArray.push(JObject);
		
		}
	else if(document.getElementById("answer").getElementsByClassName('checkbox').length!=0){
		
	
		var checkboxes=document.getElementById("answer").getElementsByClassName('checkbox');;
		var options=[];
		for(var i=0;i< checkboxes.length;i++){
		if(checkboxes[i].getElementsByClassName('checkbox_value')[0].checked==true)
			options.push(checkboxes[i].getElementsByClassName("checkbox_text")[0].innerHTML);
		}
		JObject["answer"]=options;
		jArray.push(JObject);
		
	}
	else if(document.getElementById("answer").getElementsByClassName('form-group long').length!=0){
		var options=[];
		
			options.push(document.getElementById("answer").getElementsByClassName('form-group long')[0].getElementsByClassName('form-control')[0].value);
			JObject["answer"]=options;
			jArray.push(JObject);
		
	}
	else if(document.getElementById("answer").getElementsByClassName('form-group short').length!=0){
		var options=[];
		options.push(document.getElementById("answer").getElementsByClassName('form-group short')[0].getElementsByClassName('form-control')[0].value);
		JObject["answer"]=options;
		jArray.push(JObject);
	
	
	}
	else{
		//alert("no");
	}
}
function createAnswerSheet(){
	var status="submitted";
	var answers=escape(JSON.stringify(jArray));
	//alert(JSON.stringify(jArray));
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			if(xmlhttp.responseText.length!=0) alert(xmlhttp.responseText);
		}
	}
	xmlhttp.open("POST","../CreateAnswerSheet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("status="+status+"&test_paper="+test_paper_number+"&answers="+answers);
}