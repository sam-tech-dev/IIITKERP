function createFeeBreakUpJson(){
	
	var jsonObjGeneral=[];
	var jsonObjSc=[];
	var jsonObjDasa=[];
	
	var temp={};
	temp['name']="Admission/Tution Fees";
	temp['apf']=document.getElementById("tableA[0][0]").value;
	temp['tution']=document.getElementById("tableA[1][0]").value;
	temp['subtotal']=document.getElementById("table[0][0]").value;
	jsonObjGeneral.push(temp);
    temp={};
    temp['name']="Institute Fees";
	temp['development']=document.getElementById("tableB[0][0]").value;
	temp['library']=document.getElementById("tableB[1][0]").value;
	temp['internet']=document.getElementById("tableB[2][0]").value;
	temp['sports_creativearts']=document.getElementById("tableB[3][0]").value;
	temp['stu_welfare']=document.getElementById("tableB[4][0]").value;
	temp['tnp']=document.getElementById("tableB[5][0]").value;
	temp['exams']=document.getElementById("tableB[6][0]").value;
	temp['subtotal']=document.getElementById("table[1][0]").value;
	jsonObjGeneral.push(temp);
	temp={};
	temp['name']="Group Insurance";
	temp['insurance_fee']=document.getElementById("tableC[0][0]").value;
	temp['subtotal']=document.getElementById("table[2][0]").value;
	jsonObjGeneral.push(temp);
	temp={};
	temp['total']=document.getElementById("table[3][0]").value;
	jsonObjGeneral.push(temp);
	

	var temp={};
	temp['name']="Admission/Tution Fees";
	temp['apf']=document.getElementById("tableA[0][1]").value;
	temp['tution']=document.getElementById("tableA[1][1]").value;
	temp['subtotal']=document.getElementById("table[0][1]").value;
	jsonObjSc.push(temp);
    temp={};
    temp['name']="Institute Fees";
	temp['development']=document.getElementById("tableB[0][1]").value;
	temp['library']=document.getElementById("tableB[1][1]").value;
	temp['internet']=document.getElementById("tableB[2][1]").value;
	temp['sports_creativearts']=document.getElementById("tableB[3][1]").value;
	temp['stu_welfare']=document.getElementById("tableB[4][1]").value;
	temp['tnp']=document.getElementById("tableB[5][1]").value;
	temp['exams']=document.getElementById("tableB[6][1]").value;
	temp['subtotal']=document.getElementById("table[1][1]").value;
	jsonObjSc.push(temp);
	temp={};
	temp['name']="Group Insurance";
	temp['insurance_fee']=document.getElementById("tableC[0][1]").value;
	temp['subtotal']=document.getElementById("table[2][1]").value;
	jsonObjSc.push(temp);
	temp={};
	temp['total']=document.getElementById("table[3][1]").value;
	jsonObjSc.push(temp);
	
	var temp={};
	temp['name']="Admission/Tution Fees";
	temp['apf']=document.getElementById("tableA[0][2]").value;
	temp['tution']=document.getElementById("tableA[1][2]").value;
	temp['subtotal']=document.getElementById("table[0][2]").value;
	jsonObjDasa.push(temp);
    temp={};
    temp['name']="Institute Fees";
	temp['development']=document.getElementById("tableB[0][2]").value;
	temp['library']=document.getElementById("tableB[1][2]").value;
	temp['internet']=document.getElementById("tableB[2][2]").value;
	temp['sports_creativearts']=document.getElementById("tableB[3][2]").value;
	temp['stu_welfare']=document.getElementById("tableB[4][2]").value;
	temp['tnp']=document.getElementById("tableB[5][2]").value;
	temp['exams']=document.getElementById("tableB[6][2]").value;
	temp['subtotal']=document.getElementById("table[1][2]").value;
	jsonObjDasa.push(temp);
	temp={};
	temp['name']="Group Insurance";
	temp['insurance_fee']=document.getElementById("tableC[0][2]").value;
	temp['subtotal']=document.getElementById("table[2][2]").value;
	jsonObjDasa.push(temp);
	temp={};
	temp['total']=document.getElementById("table[3][2]").value;
	jsonObjDasa.push(temp);
	
	alert(JSON.stringify(jsonObjGeneral));
	alert(JSON.stringify(jsonObjSc));
	alert(JSON.stringify(jsonObjDasa));
   
	
	
}