    var count=0;
		var insChat = new Array(); 
		var listofpeople = new Array();

		$(document).ready(function(){
			$("#person-1").hide();
			$("#person-2").hide();
			$("#person-3").hide();
			$("#listPeople").hide();
		});
  var refresh=0;
		
		function showChat(id){
				id = id.substring(9);
				var found = $.inArray(id,insChat);
				
				if(found==-1){
					if(count==0){
						$("#person-1").show();insChat.push(id);
								}
					if(count==1){
						$("#person-2").show();insChat.push(id);
						retrieveMessages(); //retrieve all the messages so far
						readMessage();
						refresh=1;
								}
					
					if(count>=2){
						$("#listPeople").show();
						var found1 = $.inArray(id,listofpeople);
						if(found1==-1){
							listofpeople.push(id);
							document.getElementById("LOP").innerHTML+='<div class="direct-chat-msg"><a onClick="orderChat('+'\'overflow-'+id+'\''+')">'+id+'</a></div>';
								}
							}	
					count += 1;
					        }
				
		}

		function orderChat(id){
				id = id.substring(9);
				a = listofpeople.shift();
				b = listofpeople.shift();
				alert(insChat.unshift(a));
				alert(listofpeople.unshift(b));
		}


function retrieveMessages(){
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
			document.getElementById("chat").innerHTML="";
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				data=JSON.parse(xmlhttp.responseText);
				if(xmlhttp.responseText=="") return;
				//alert(xmlhttp.responseText);
				var	message;
				for(var i=0;i<data.length;i++){
					if(data[i].author=="2"){
						message=document.getElementById("left_message");

						message.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						document.getElementById("chat").insertAdjacentHTML("beforeend",message.innerHTML);

					}
					else
					{
						message=document.getElementById("right_message");
						message.getElementsByClassName("direct-chat-name pull-right username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-left timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						document.getElementById("chat").insertAdjacentHTML("beforeend",message.innerHTML);
					}
				}
				document.getElementById("chat_box").scrollTop=9999999;
				//$('#chat_box').animate({scrollTop: $('#chat_box').get(0).scrollHeight});
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../RetrieveAllMessages",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send();
	}
	return false;
}
function unreadMessages(){
	//alert("unreadMessages");
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
				if(xmlhttp.responseText=="") return;
				data=JSON.parse(xmlhttp.responseText);
				
				//alert(xmlhttp.responseText);
				var	message;
				for(var i=0;i<data.length;i++){
					if(data[i].author=="2"){
						message=document.getElementById("left_message");

						message.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						document.getElementById("chat").insertAdjacentHTML("beforeend",message.innerHTML);

					}
					else
					{
						message=document.getElementById("right_message");
						message.getElementsByClassName("direct-chat-name pull-right username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-left timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						document.getElementById("chat").insertAdjacentHTML("beforeend",message.innerHTML);
					}
				}
				document.getElementById("chat_box").scrollTop=9999999;
				readMessage();
				//$('#chat_box').animate({scrollTop: $('#chat_box').get(0).scrollHeight});
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
	//alert("sendMessages");
	var message=document.getElementById('chat_message').value;
	message_div=document.getElementById("left_message");

	message_div.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML="joeypinto";
	message_div.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML="Just Now";
	message_div.getElementsByClassName("direct-chat-text text")[0].innerHTML=message;
	document.getElementById("chat").insertAdjacentHTML("beforeend",message_div.innerHTML);
	document.getElementById("chat_box").scrollTop=9999999;
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
function readMessage(){
	//alert("readMessages");
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
	//			document.getElementById('chat_message').value="";
   //retrieveMessages();
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../ReadAllMessages",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send();
	}
	return false;
}
window.setInterval(function(){
	if (refresh==1)
	unreadMessages();

},4000);
	
	

