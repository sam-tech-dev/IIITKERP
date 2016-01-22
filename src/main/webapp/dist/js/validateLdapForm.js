function validatingLdapForm(){
				ldap_username = document.getElementById("ldap_username").value;
				ldap_password = document.getElementById("ldap_password").value;

				validating_form=1;
				
				if(ldap_username == ""){
					$("#error_username").html("Please fill this field.");
					validating_form=0;
									   }
						  
						  
				if(ldap_password == ""){
					 $("#error_password").html("Please fill this field.");
			             validating_form=0;
		                              }
				if(validating_form == 0)
					return false;
				else{
					alert('Both are filled.');
					return false;
					}
							}	