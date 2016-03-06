/**
 * 
 */
package postgreSQLDatabase.feePayment;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import settings.database.*;
import org.json.JSONArray;
import org.json.JSONObject;

import actions.chats.Conversation;

/**
 * @author Shubhi
 *
 */
public class Query {
	


	public static ArrayList<Payment> getFeePaymentHistory (long user_id) {

		PreparedStatement proc;
		ArrayList<Payment> history_info=new ArrayList<Payment>();
		try {
			proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"retrieveFeePaymentHistory\"(?);");


			proc.setObject(1, user_id);
			ResultSet rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();
			//String postgre=rs.getString(1);
			JSONArray jArray=new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				
				Payment history=new Payment();
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
	public static void main(String[] args) {

		ArrayList<Payment> fee=getFeePaymentHistory(1);

	}
}


