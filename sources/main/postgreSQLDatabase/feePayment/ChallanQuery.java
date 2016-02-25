/**
 * 
 */
package postgreSQLDatabase.feePayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exceptions.IncorrectFormatException;
import postgreSQLDatabase.onlineTest.Question;
import users.Student;

/**
 * @author Anshula
 *
 */
public class ChallanQuery {
 
	static Connection conn ;
	
	public static Connection getConnection() throws SQLException{

		if(conn==null){
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager
					.getConnection("jdbc:postgresql://172.16.1.231:5432/iiitk",
							"developer", "developer");
		}
		return conn;
	}
	
	
	public static Student getStudentDetails(int registration_id) throws SQLException, IncorrectFormatException{
		Student current=new Student();
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getStudentChallanDetails\"(?);");
			proc.setInt(1,registration_id);
			ResultSet rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();
     		JSONArray jArray=new JSONArray(rs.getString(1));

				JSONObject current_object=jArray.getJSONObject(0);
				System.out.println(current_object.getString("first_name")+" "+current_object.getString("middle_name")+" "+current_object.getString("last_name"));
				current.setName(current_object.getString("first_name")+" "+current_object.getString("middle_name")+" "+current_object.getString("last_name"));
				
				current.setGender(current_object.getString("gender"));
				current.setCategory(current_object.getString("category"));
				current.setProgram_allocated(current_object.getString("program_allocated"));
			
			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return student_details;
		return current;
	}
}
