function makePayment(method) {
	if (method == "dd") {
		amount = document.getElementById('dd_amount').value;
		payment_method = "demand_draft";
		date = document.getElementById('dd_date').value;
		bank = document.getElementById('dd_bank').value;
		no = "dd_no=" + document.getElementById('dd_no').value;
	}

	if (method == "neft") {
		amount = document.getElementById('neft_amount').value;
		payment_method = "neft";
		date = "";
		temp1 = document.getElementById('neft_bank').value;
		temp2 = document.getElementById('ifsc').value;
		;
		bank = temp1 + " " + temp2;
		no = "tid=" + document.getElementById('tid').value;
	}
	if (method == "challan") {
		amount = document.getElementById('challan_amount').value;
		payment_method = "challan";
		date = document.getElementById('challan_date').value;
		;
		bank = "";
		no = "challan_no=" + document.getElementById('challan_no').value;
	}
	var xmlhttp;
	try {
		xmlhttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer Browsers
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				// Browser doesn't support ajax
				alert("Your browser is unsupported");
			}
		}
	}

	if (xmlhttp) {
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
               alert("Payment Information saved successfully!");
               window.location.href="../SignOut";
			}
			if (xmlhttp.status == 404)
				alert("Could not connect to server");
		}
		var uid = 1;
		xmlhttp.open("POST", "../AddPaymentInfo", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("amount=" + amount + "&date=" + date + "&payment_method="
				+ payment_method + "&bank=" + bank + "&" + no);

	}
}

function verifyFee(reg_id) {
	window.location = "verifyStudentDetails1.jsp?reg_id=" + reg_id;
}
