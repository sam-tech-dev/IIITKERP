function makePayment(method){
	if(method=="dd"){
	amount=document.getElementById('dd_amount').value;
	payment_method="demand_draft";
	date=document.getElementById('dd_date').value;
	bank=document.getElementById('dd_bank').value;
	no="dd_no="+document.getElementById('dd_no').value;
	}
	if(method=="cheque"){
		amount=document.getElementById('cheque_amount').value;
		payment_method="cheque";
		date=document.getElementById('cheque_date').value;
		bank=document.getElementById('cheque_bank').value;
		no="cheque_no="+document.getElementById('cheque_no').value;
		}
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
	    	
	        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				
			}
	        if(xmlhttp.status == 404)
				alert("Could not connect to server");
			}
	    var uid=1;
	    xmlhttp.open("POST","../AddPaymentInfo",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	    xmlhttp.send("amount="+amount+"&date="+date+"&payment_method="+payment_method+"&bank="+bank+"&"+no);
	   
	}
}