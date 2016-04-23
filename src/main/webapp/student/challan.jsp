<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<%@page import="users.Student"%>
<%@page import="postgreSQLDatabase.registration.Query"%>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<title>Insert title here</title>
<style>
@page { size: A4 landscape;}
</style>
</head>
<body>
    <%
    //Student student=Query.getStudentProfile(Long.parseLong(request.getParameter("erpId").toString()));
    Student student=Query.getStudentProfile(Long.parseLong("1000000100"));
    %>
		
			<table border="1">
			<tbody>
			<tr>
				<td><div class="col-md-4">
				
					<div class="row" style="font-size:80%">
						<img alt="img"  src="http://localhost:8080/erp/image/sbi.jpg" class="image pull-right"/>
						<h4 class="text-center"><b>(Bank Copy)</b></h4>
					</div>
					
					<div class="row invoice-info" style="font-size:80%">
						<div class="invoice-col">
							Category: SC
							Gender(M/F): M
							
								<p style="font-size:80%"><strong><img alt="img"  src="http://localhost:8080/erp/image/iiitkota.jpg"/>Indian Institute Of Information Technology Kota(Rajasthan)</strong></p>
								
                            
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br/>
							Student ID: <%=student.getStudent_id() %><br/>
							
							Branch Name:<input type="text" name="branchname"/><br/>
							Date of Challan: 15/1/2016
							<p style="font-size:70%">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</p>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped" style="font-size:80%" >
								<tbody >
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td><%=student.getStudent_id() %></td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science &amp; Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row" style="font-size:80%">
						<h4 class="text-center">(To be filled by bank)</h4>
						Branch SOL ID <span class="pull-right">____________________</span><br/>
						Branch Transaction ID <span class="pull-right">____________________</span><br/><br/><br/>
						Seal &amp; Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
				
				</td><td>
				<div class="col-md-4">
				
					<div class="row" style="font-size:80%">
						<img alt="img"  src="http://localhost:8080/erp/image/sbi.jpg" class="image pull-right"/>
						<h4 class="text-center"><b>(Institute Copy)</b></h4>
					</div>
					
					<div class="row invoice-info" style="font-size:80%">
						<div class="invoice-col">
							Category: SC
							Gender(M/F): M
							
								<p style="font-size:80%"><strong><img alt="img"  src="http://localhost:8080/erp/image/iiitkota.jpg"/>Indian Institute Of Information Technology Kota(Rajasthan)</strong></p>
								
                            
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br/>
							Student ID: <%=student.getStudent_id() %><br/>
							
							Branch Name:<input type="text" name="branchname"/><br/>
							Date of Challan: 15/1/2016
							<p style="font-size:70%">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</p>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped" style="font-size:80%">
								<tbody>
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td><%=student.getStudent_id() %></td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science &amp; Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row" style="font-size:80%">
						<h4 class="text-center">(To be filled by bank)</h4>
						Branch SOL ID <span class="pull-right">____________________</span><br/>
						Branch Transaction ID <span class="pull-right">____________________</span><br/><br/><br/>
						Seal &amp; Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
				
				</td><td>
				<div class="col-md-4">
				
				
					<div class="row" style="font-size:80%">
						<img alt="img"  src="http://localhost:8080/erp/image/sbi.jpg" class="image pull-right"/>
						<h4 class="text-center"><b>(Student Copy)</b></h4>
					</div>
					
					<div class="row invoice-info" style="font-size:80%">
						<div class="invoice-col">
							Category: SC
							Gender(M/F): M
							
								<p style="font-size:80%"><strong><img alt="img"  src="http://localhost:8080/erp/image/iiitkota.jpg"/>Indian Institute Of Information Technology Kota(Rajasthan)</strong></p>
								
                            
						</div>
						
						<div class="invoice-col">
							<b style="text-decoration: underline;">Institute Fee</b><br/>
							Student ID: <%=student.getStudent_id() %><br/>
							
							Branch Name:<input type="text" name="branchname"/><br/>
							Date of Challan: 15/1/2016
							<p style="font-size:70%">IIIT KOTA Institute Fee Detail for 2015-2016 Even Semester</p>
						</div>
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped" style="font-size:80%">
								<tbody>
									<tr>
										<td>Account To Credit</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>Institute Code</td>
										<td>CSE</td>
									</tr>
									<tr>
										<td>Student Name</td>
										<td>Sumit Kumar Sagar</td>
									</tr>
									<tr>
										<td>Roll No.</td>
										<td><%=student.getStudent_id() %></td>
									</tr>
									<tr>
										<td>Class/Program</td>
										<td>Computer Science &amp; Engineering</td>
									</tr>
									<tr>
										<td>Section/Semester</td>
										<td>6th</td>
									</tr>
									<tr>
										<td>Amount</td>
										<td>8800</td>
									</tr>
									<tr>
										<td>Amount In Words</td>
										<td>Eight thousand and eight hundred</td>
									</tr>
									<tr>
										<td>DD/Cheque No.</td>
										<td>965456631321</td>
									</tr>
									<tr>
										<td>Bank</td>
										<td>32896056885 </td>
									</tr>
									<tr>
										<td>DD/Cheque Date</td>
										<td>26/12/2015</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row" style="font-size:80%">
						<h4 class="text-center">(To be filled by bank)</h4>
						Branch SOL ID <span class="pull-right">____________________</span><br/>
						Branch Transaction ID <span class="pull-right">____________________</span><br/><br/><br/>
						Seal &amp; Stamp of SBI Bank<span class="pull-right">Signature of Depositor</span>
						
						<h6>If Incorrect fee is deposited, student Even Semester registration may be cancelled/terminated. Even Semester Registration is Subject to fulfilling eligibility criteria</h6>
					</div>
				</div>
		</td></tr></tbody></table>	
		
</body>
</html>