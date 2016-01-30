
var password_retype_authenticated=false;
var pwd_check=false;// stores if password is in specified format or not

var password_fields=document.getElementsByClassName("form-control password")[0];
password_fields.addEventListener("blur",validatePassword,true);
	 
var retype_password_fields=document.getElementsByClassName("form-control retype_password")[0];
retype_password_fields.addEventListener("blur",validateRetypePassword,true);   

function validatePassword(){
	    
	    var password=this.value;
		if(password.length>=8 && password.length<=20){
			if(password.search(/\d/) == -1){
				alert("no digit");
			}
			else if(password.search(/[a-zA-Z]/) == -1){
				alert("no alphabet");
			}
			else if(password.search(/[\@\#\$\%\&]/) == -1){
				alert("no special character");
			}
			else if(password.search(/[^a-zA-Z0-9\@\#\$\%\&]/)!= -1){
				alert("illegal character")
				
			}
			else{
				alert("correct");
				pwd_check=true;
				return true;
			}
		}    
		else
		{
			alert("length");
			
		}
}



function validateRetypePassword(){
	var password=document.getElementsByClassName("form-control password")[0].value;
	var retype_password=this.value;
	if(pwd_check==true){
	  if(password==retype_password){
		alert("Password matched");
		password_retype_authenticated=true;
	    return true;
	  }
	  else{
		alert("Password mismatch");
	    return false;
	  }
	}
	else{
		alert("password format incorrect");
	}
}