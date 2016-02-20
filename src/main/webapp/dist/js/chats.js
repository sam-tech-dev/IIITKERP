function newChat(){

}

function retrieveMessages(){
	alert("reached");
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
	//var xmlhttp=new XMLHttpRequest();

	if(xmlhttp){	
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {



				data=JSON.parse(xmlhttp.responseText);
				alert(xmlhttp.responseText);
				var	message;
				for(var i=0;i<data.length;i++){
					if(data[i].author=="2"){
						message=document.getElementById("left_message");

						message.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;

						document.getElementById("chat").insertAdjacentHTML("beforebegin",message.innerHTML);

					}
					else
					{
						message=document.getElementById("right_message");
						message.getElementsByClassName("direct-chat-name pull-right username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-left timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						document.getElementById("chat").insertAdjacentHTML("beforebegin",message.innerHTML);
					}
				}

			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../RetrieveMessage",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send();
	}
	return false;
}
function sendMessage(){
	var message=document.getElementById('chat_message').value;
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
	//var xmlhttp=new XMLHttpRequest();

	if(xmlhttp){	
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				document.getElementById('chat_message').value="";

			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../NewMessage",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("text="+message);
	}
	return false;
}