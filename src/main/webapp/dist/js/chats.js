var count=0;
var insChat = new Array(); 
var listofpeople = new Array();
var refresh=0;
var count=0;


var visibleChat = new Array(); 
var ChatObjectArray = {}; 

  
var allChats = new Array();



function display(id){

	var visible = $.inArray(id,visibleChat);
	
if(visible==-1){
	
	visibleChat.push(id);
	var chats=document.getElementById("chatDiv").getElementsByClassName('chatWindow');
				for (i=0;i<chats.length;i++){
						if(chats[i].dataset.chatId==id){
							//alert(document.getElementById("chatDiv").getElementsByClassName('chatWindow')[i].nodeName);
							var itm = document.getElementById("chatDiv").getElementsByClassName('chatWindow')[i];

							var cln = itm.cloneNode(true);
							cln.style.display="inline";
							document.getElementById("chatDiv").appendChild(cln);
							document.getElementById("chatDiv").removeChild(document.getElementById("chatDiv").getElementsByClassName('chatWindow')[i]);
							

									break;
										}
							
							}
				if(visibleChat.length>3){
					
					var chats=document.getElementById("chatDiv").getElementsByClassName('chatWindow');
					for (i=0;i<chats.length;i++){
					if(chats[i].style.display!="none"){
						hide(chats[i].dataset.chatId);
						break;
					}
					
					}
				}		
					
				}
}
	function hide(id){
		
		var chats=document.getElementById("chatDiv").getElementsByClassName('chatWindow');
		for (i=0;i<chats.length;i++){
			
			if(chats[i].dataset.chatId==id){
				
		document.getElementById("chatDiv").getElementsByClassName('chatWindow')[i].style.display="none";
	//	alert("visible"+visibleChat);
    //    alert("removing"+id);
    //    alert("length"+visibleChat.length);
    //     alert("removing at position"+visibleChat.indexOf(id));
		visibleChat.splice(visibleChat.indexOf(id),1);
         
  //       alert(visibleChat);
		break;
			}
		
	}
//	alert(visibleChat);
	}
function addChat(id,chat_name){
		var found = $.inArray(id,allChats);
		
		if(found==-1){
			
			var current=document.getElementById("chatBox");  /*Always do */
				current.getElementsByClassName('chatHeader')[0].innerHTML=chat_name;
				current.getElementsByClassName('chatWindow')[0].style.display="none";
				current.getElementsByClassName('chatWindow')[0].dataset.chatId=id;
				current.getElementsByClassName('btn btn-danger btn-flat')[0].setAttribute( "onClick", "javascript: sendMessage('"+id+"');" );
				current.getElementsByClassName('btn btn-box-tool')[1].setAttribute( "onClick", "javascript: hide('"+id+"');" );
			allChats.push(id);
			
			count++;
			//	alert(document.getElementById("chatDiv").innerHTML);
			document.getElementById("chatDiv").innerHTML+=document.getElementById("chatBox").innerHTML;
		//	alert(document.getElementById("chatDiv").getElementsByClassName('chatWindow').length);
			  //display chat
		}	
				display(id);
			
								
		retrieveMessages(id);
}


function retrieveMessages(convo_id){
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
			var chats=document.getElementById("chatDiv").getElementsByClassName('chatWindow');
			var current_window;
			for (i=0;i<chats.length;i++){
					if(chats[i].dataset.chatId==convo_id){
						current_window=chats[i];
					}
					}
			
					
			current_window.getElementsByClassName("direct-chat-messages")[0].innerHTML="";
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				data=JSON.parse(xmlhttp.responseText);
				
				var	message;
				for(var i=0;i<data.length;i++){
					if(data[i].author=="1"){
						message=document.getElementById("left_message");

						message.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						current_window.getElementsByClassName("direct-chat-messages")[0].insertAdjacentHTML("beforeend",message.innerHTML);

					}
					else
					{
						message=document.getElementById("right_message");
						message.getElementsByClassName("direct-chat-name pull-right username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-left timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						current_window.getElementsByClassName("direct-chat-messages")[0].insertAdjacentHTML("beforeend",message.innerHTML);
					}
				}
			//	current_window.getElementsByClassName("chat-box")[0].scrollTop=9999999;
				//$('#chat_box').animate({scrollTop: $('#chat_box').get(0).scrollHeight});
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../RetrieveAllMessages",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("conversation_id="+convo_id);
	}
	return false;
}
function unreadMessages(){
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
				var	message;
				for(var i=0;i<data.length;i++){
					if(data[i].author=="1"){
						message=document.getElementById("left_message");
						message.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						current_window.getElementsByClassName("direct-chat-messages")[0].insertAdjacentHTML("beforeend",message.innerHTML);

					}
					else
					{
						message=document.getElementById("right_message");
						message.getElementsByClassName("direct-chat-name pull-right username")[0].innerHTML=data[i].username;
						message.getElementsByClassName("direct-chat-timestamp pull-left timestamp")[0].innerHTML=data[i].timestamp;
						message.getElementsByClassName("direct-chat-text text")[0].innerHTML=data[i].text;
						current_window.getElementsByClassName("direct-chat-messages")[0].insertAdjacentHTML("beforeend",message.innerHTML);
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
function sendMessage(id){
	var chats=document.getElementById("chatDiv").getElementsByClassName('chatWindow');
	var current_window;
	for (i=0;i<chats.length;i++){
			if(chats[i].dataset.chatId==id){
				current_window=chats[i];
			}
			}
	
	
	
	var message=current_window.getElementsByClassName("form-control message")[0].value;
		message_div=document.getElementById("left_message");
	
		message_div.getElementsByClassName("direct-chat-name pull-left username")[0].innerHTML=session_user_name;
		message_div.getElementsByClassName("direct-chat-timestamp pull-right timestamp")[0].innerHTML="Just Now";
		message_div.getElementsByClassName("direct-chat-text text")[0].innerHTML=message;
		current_window.getElementsByClassName("direct-chat-messages")[0].insertAdjacentHTML("beforeend",message_div.innerHTML);
	
	 //	document.getElementById("chat_box").scrollTop=9999999;
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
				current_window.getElementsByClassName("form-control message")[0].value="";
			}
			
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../NewMessage",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("text="+message+"&conversation_id="+id);
	
	}
	return false;
}
function readMessage(){
	
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

function getConversationsInfo(){
	
	//var chat_name=document.getElementById('chat_message').value;
	
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
				//alert(xmlhttp.responseText);
				
				if(xmlhttp.responseText!=""){
					data=JSON.parse(xmlhttp.responseText);
				for(i=0;i<data.length;i++){
					addConversation(data[i].chat_name,data[i].members,data[i].conversation_id);
					
				}
					
			}	
			}
			if(xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		xmlhttp.open("POST","../RetrieveConversationsInfo",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send();
	}
	return false;
}
/*
window.setInterval(function(){ document.getElementById('chat_list').innerHTML="";
getConversationsInfo();}(),10000);*/

function addConversation(chat_name,members,conversation_id)
{
    var chat_list_template=document.getElementById('chat_list_template');
	

	

var members_list="";
	for(j=0;j<members.length;j++)
	members_list+=members[j]+" ";
	chat_list_template.getElementsByClassName('chat_name')[0].parentNode.setAttribute( "onClick", "javascript: addChat("+conversation_id+",'"+chat_name+"');" );
	chat_list_template.getElementsByClassName('chat_name')[0].innerHTML=chat_name;
	chat_list_template.getElementsByClassName('user-panel box-comment')[0].title=members_list;
 	document.getElementById('chat_list').innerHTML+=chat_list_template.innerHTML;
}

/*window.setInterval(function(){
	 document.getElementById('chat_list').innerHTML="";
		getConversationsInfo();

	},10000);*/

//window.setInterval(function(){if (refresh==1)unreadMessages();}(),5000);

getConversationsInfo();