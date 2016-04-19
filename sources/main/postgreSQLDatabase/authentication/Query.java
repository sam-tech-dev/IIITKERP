/**
 * 
 */
package postgreSQLDatabase.authentication;

<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import postgreSQLDatabase.attendance.Allocation;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> 3527eacc98c6acef99c31fc58e42068d06e54cfa

/**
 * @author Joey
 *
 */
public class Query {
<<<<<<< HEAD
	public static JSONArray getAutoSuggest(String input) {
		System.out.println(input);
		JSONArray jArray = null;
		try {
			PreparedStatement proc = settings.database.PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getUserAutoSuggest\"(?);");
			proc.setString(1, input);
			ResultSet rs = proc.executeQuery();
			rs.next();
			jArray = new JSONArray(rs.getString(1));
			

=======
public static void getUsername(){
	
}
static Connection conn ;

public static Connection getConnection() {

	if(conn==null){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager
					.getConnection("jdbc:postgresql://172.16.1.231:5432/iiitk",
							"developer", "developer");
>>>>>>> 3527eacc98c6acef99c31fc58e42068d06e54cfa
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		return jArray;

	}
=======
	}
	return conn;
}
public static String getUserUsername(Long erp_id){
	PreparedStatement proc ;
	try {
		proc= getConnection().prepareStatement("SELECT public.\"getUserUsername\"(?);");
		proc.setLong(1, erp_id);
		ResultSet rs=proc.executeQuery();
		rs.next();
	return rs.getString(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
}
public static void main(String[] args) {
	//getUserUsername(1000000106);
}

>>>>>>> 3527eacc98c6acef99c31fc58e42068d06e54cfa
}
