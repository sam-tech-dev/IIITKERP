/**
 * 
 */
package postgreSQLDatabase.feePayment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import settings.database.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PGobject;

/**
 * @author Shubhi
 *
 */
public class Query {

	private static PreparedStatement proc;
	public static ArrayList<Payment> getFeePaymentHistory (long user_id) {
		
		ArrayList<Payment> history_info = new ArrayList<Payment>();
		try {
			proc = PostgreSQLConnection.getConnection()
					.prepareStatement("SELECT public.\"retrieveFeePaymentHistory\"(?);");

			proc.setObject(1, user_id);
			ResultSet rs = proc.executeQuery();
			System.out.println(proc);
			rs.next();
			// String postgre=rs.getString(1);
			JSONArray jArray = new JSONArray(rs.getString(1));

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject current_object = jArray.getJSONObject(i);

				Payment history = new Payment();
				history.setRef_no(current_object.getInt("ref_no"));
				history.setComment(current_object.getString("comment"));
				history.setDetails(current_object.getJSONObject("details"));
				history.setAmount(current_object.getLong("amount"));
				history.setVerified(current_object.getBoolean("verified"));
				history.setPayment_method(current_object.getInt("payment_method"));
				history_info.add(history);
			}
			System.out.println();
			rs.close();
			proc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history_info;
	}
	
	
	public static FeePaymentDetails getFeePaymentDetails(long user_id) {
		FeePaymentDetails payment_details=new FeePaymentDetails();
		try {
			proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getFeePaymentDetails\"(?);");


			proc.setObject(1, user_id);
			ResultSet rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();
			JSONArray jArray=new JSONArray(rs.getString(1));
			
				JSONObject current_object=jArray.getJSONObject(0);
				payment_details.setId(current_object.getInt("ref_no"));
				payment_details.setName(current_object.getString("name"));
				String details=current_object.get("details").toString();
				payment_details.setDetails(details);
				payment_details.setPayment_method(current_object.getInt("payment_method"));
			
			
			System.out.println();	
			rs.close();
			proc.close();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payment_details;
	}
	
	public static void addFeeBreakup(String semester,String category,String breakup,String year)
    {
		System.out.println("abc "+breakup);
		try {
			
			JSONArray fee_breakup=new JSONArray(breakup);
			JSONObject amt_obj=fee_breakup.getJSONObject(fee_breakup.length()-1);
			JSONObject j_array[]=new JSONObject[fee_breakup.length()];
			for(int i=0;i<fee_breakup.length()-1;i++){
				j_array[i]=fee_breakup.getJSONObject(i);
				
			}
			int amount=Integer.parseInt((String)amt_obj.get("total"));
			proc= PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addFeeBreakup\"(?,?,?,?,?);");
			proc.setString(1,year);
			proc.setString(2,semester);
			proc.setString(3,category);
		
		    proc.setObject(4,PostgreSQLConnection.getConnection().createArrayOf("json", j_array));
			proc.setInt(5,amount);
			proc.executeQuery();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static JSONObject retrieveFeeJson(Long reg_id ){
		
		
		try {
			proc= PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"retrieveFeeJson\"(?);");
			proc.setLong(1,reg_id);
			System.out.println(proc);
			ResultSet rs=proc.executeQuery();
			rs.next();
			JSONObject fee_breakup=new JSONObject(rs.getString(1));
			return fee_breakup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//insert into payment table
	
public static int addFeePayment(String comment,int pay_method,JSONObject details,int amt,int reg_id){
	
		try {
			proc= PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addFeePayment\"(?,?,?,?,?);");
			
			proc.setString(1,comment);
			proc.setInt(2,pay_method);
			PGobject jsonObject = new PGobject();
			jsonObject.setType("json");
			jsonObject.setValue(details.toString());
			
			proc.setObject(3,jsonObject);
		
			proc.setInt(4,amt);
			proc.setInt(5,reg_id);
			System.out.println(proc);
			ResultSet rs=proc.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
public static void verifyFeePayment(long ref_no){
	
	try {
		proc= PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"feeVerify\"(?);");
		proc.setLong(1,ref_no);
		proc.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	
	

	public static void main(String[] args) throws SQLException {

		// ArrayList<Payment> fee=getFeePaymentHistory(1);
		//getFeeBreakup(1);
		System.out.println(getFeeBreakup(1));

	}

	public static JSONObject getFeeBreakup(int reg_id) throws SQLException {
		PreparedStatement proc = PostgreSQLConnection.getConnection()
				.prepareStatement("SELECT public.\"retrieveFeeJson\"(?);");
		try {
			proc.setObject(1, reg_id);
			ResultSet rs = proc.executeQuery();
			rs.next();
			String fee = rs.getString(1);
			JSONObject fee_breakup = new JSONObject(fee);
			return fee_breakup;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
