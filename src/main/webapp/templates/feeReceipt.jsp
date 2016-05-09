<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<%@page import="utilities.NumberToWords"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.json.JSONObject"%>
<%@page import="postgreSQLDatabase.feePayment.FeePaymentDetails"%>
<%@page import="utilities.ServletUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head>
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<title>IIITK Fee Receipt</title>
<style>
@page { size: A4;}
</style>
</head>
<body>
    
		<% long reg_id=Long.parseLong(request.getParameter("reg_id").toString());
		  Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			String current_date=format.format(date); 
       postgreSQLDatabase.feePayment.FeePaymentDetails payment_details=postgreSQLDatabase.feePayment.Query.getFeePaymentDetails(reg_id); %>
			<table style="font-size:25px">
			<tbody>
			<tr>
				<td>
				<div class="col-md-4">
				
					<div class="row" style="font-size:80%;">
					<table><tr><td><img alt="img"  src="<%=ServletUtils.getBaseUrl(request)%>/image/sbi.jpg" class="image pull-right"/>
						</td><td><p class="text-center" align="center"><b>Indian Institute Of Information Technology Kota(Rajasthan)</b></p></td>
						<td><img alt="img"  src="http://localhost:8080/erp/image/iiitkota.jpg"/></td>
						</tr></table>
						
					</div>
					
					
					
						<div class="invoice-col" align="center">
							
							<p align="center" style="text-decoration: underline;font-size:90%;"><b>Fee Receipt</b></p>
						</div>
					
					</div>
					
					<div class="row">
						<div class="table-responsive">
							<table class="table table-striped" style="font-size:80%" >
								<tbody >
								
									<tr>
										<td><b>Date</b></td>
										<td><%=current_date %></td>
									</tr>
									
									<tr>
										<td><b>Student Name</b></td>
										<td><%=payment_details.getName() %></td>
									</tr>
									<tr>
										<td><b>Registration ID</b></td>
										<td><%=reg_id %></td>
									</tr>
									
									
									<tr>
										<td><b>Class/Program</b></td>
										<td>B Tech</td>
									</tr>
									<tr>
										<td><b>Section/Semester</b></td>
										<td>1</td>
									</tr>
									<%JSONObject details=payment_details.getDetails();
									%>
									<tr>
										<td><b>Reference Number</b></td>
										<td><%=payment_details.getId()%></td>
									</tr>
									<tr>
										<td><b>Amount</b></td>
										<td><%=details.getInt("amount")%></td>
									</tr>
									<tr>
										<td><b>Amount In Words</b></td>
										<td><%=NumberToWords.convert(details.getLong("amount"))+"Rupees only/-" %></td>
									</tr>
									<tr>
										<td><b>Mode of Payment</b></td>
										<td><%=payment_details.getPayment_method() %></td>
									</tr>
									<tr>
										<td colspan="2"><b>Payment Details</b></td>
										</tr>
										<tr>
										<td colspan="2">
										<table>
										
										<%
									   
				                		 Iterator<String> iterator= details.keys();
				                		  while(iterator.hasNext()){
				                			  String key=iterator.next();
				                			 out.print("<tr><td><strong>"+key.toUpperCase()+"</strong></td><td>"+details.getString(key)+"</td></tr>");
				                		 }
										%>
										
										</table>
										</td>
									</tr>
				
								
								</tbody>
							</table>
						</div>
					</div>
					
					
				
				
				</td>
				
				
					
				
				</tr></tbody></table>	
		
</body>
</html>