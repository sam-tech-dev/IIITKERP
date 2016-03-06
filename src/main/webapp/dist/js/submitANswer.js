var jArray=[];
function submit(){
	

	
	
	var JObject={};
	JObject["id"]=current_question;
	//alert(document.getElementById("answer").innerHTML);

	if(document.getElementById("answer").getElementsByClassName('radio_answer').length!=0)
		{
		//alert(document.getElementById("answer").getElementsByClassName('radio')[0].innerHTML);
		//alert(document.getElementById("answer").getElementsByClassName('radio')[0].getElementsByClassName('optionsRadio')[0].innerHTML);	
		

		JObject["answer"]=document.getElementById("answer").getElementsByClassName('radio')[0].getElementsByClassName('optionRadio')[0].value;
		jArray.push(JObject);
		//alert(JSON.stringify(jArray));
		
		}
	else if(document.getElementById("answer").getElementsByClassName('checkbox').length!=0){
		//alert(document.getElementById("answer").getElementsByClassName('checkbox')[0].innerHTML);
		//alert(document.getElementById("answer").getElementsByClassName('checkbox')[0].getElementsByClassName('checkbox_text')[0].innerHTML);	
	
		var checkboxes=document.getElementById("answer").getElementsByClassName('checkbox')[0];
		
		for(var i=0;i< checkboxes.length;i++){
		
		alert(checkboxes.getElementsByClassName('checkbox_text')[0].value);
		jArray.push(JObject);
		alert(JSON.stringify(jArray));	}
	}
	else if(document.getElementById("answer").getElementsByClassName('form-group long').length!=0){
		
		JObject["answer"]=document.getElementById("answer").getElementsByClassName('form-group long')[0].getElementsByClassName('form-control')[0].value;
		jArray.push(JObject);
		//alert(JSON.stringify(jArray));
		
	//alert(document.getElementById("answer").getElementsByClassName('form-group long')[0].getElementsByClassName('form-control')[0].value);	
	}
	else if(document.getElementById("answer").getElementsByClassName('form-group short').length!=0){
		//alert(document.getElementById("answer").getElementsByClassName('form-group short')[0].getElementsByClassName('form-control')[0].value);	
		
		JObject["answer"]=document.getElementById("answer").getElementsByClassName('form-group short')[0].getElementsByClassName('form-control')[0].value;
	jArray.push(JObject);
	//alert(JSON.stringify(jArray));
	
	
	}
	else{
		//alert("no");
	}
}
