function getCourseCode() {

	faculty = 'EC101';
	semester = document.getElementById("semester_selected").value;
	// to support all browsers
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
	// var xmlhttp=new XMLHttpRequest();

	if (xmlhttp) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				document.getElementById("course_list").innerHTML = "";

				data = JSON.parse(xmlhttp.responseText);
				for (i = 0; i < data.length; i++) {

					document.getElementById("course_list").innerHTML += "<option value=\""
							+ data[i].course_code
							+ "\">"
							+ data[i].course_code
							+ "</option>";
				}

			}
		}
		xmlhttp.open("POST", "../GetSubjectAllocation", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("faculty_id=" + faculty + "&semester=" + semester);

	}
	return false;
}

function getAttendanceList(){
	var table=document.getElementById('attendance_table');
	var j_array=[];
	for (var i = 0, row; row = table.rows[i]; i++) {
	   //iterate through rows
	   //rows would be accessed using the "row" variable assigned in the for loop
	   
	     //iterate through columns
	     //columns would be accessed using the "col" variable assigned in the for loop
		var j_object={};
		   
		   j_object["student_id"]=table.rows[i].cells[0].innerHTML;
		   if(table.rows[i].cells[2].getElementsByTagName("input")[0].checked)j_object["attendance_status"]="present";
		   else if(table.rows[i].cells[3].getElementsByTagName("input")[0].checked)j_object["attendance_status"]="absent";
		   else j_object["attendance_status"]="leave";
			   j_array.push(j_object);			   
	     
	}
	alert(JSON.stringify(j_array));
insertAttendanceInfo(JSON.stringify(j_array));
}

function insertAttendanceInfo(j_array) {

	alert('reached1');
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
	// var xmlhttp=new XMLHttpRequest();

	if (xmlhttp) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
alert('reached2');
		}
		}
		xmlhttp.open("POST", "../InsertAttendance", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("class_id=" + 1 + "&attendance_json=" + j_array);

	
	
	}
}