/**
 * 
 */
package postgreSQLDatabase.registration;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exceptions.IncorrectFormatException;
import users.Student;

/**
 * @author Anshula
 *
 */
public class Query {
	
	static Connection conn ;
	
	/**
	 * @return a new connection to postgreSQL
	 * @throws SQLException
	 */
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
	

	/**
	 * @param username
	 * @param name
	 * @param user_type
	 * @return erp id
	 */
	public static String registerUser(String username, String name, String user_type) {
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"addUser\"(?,?,?);");
			proc.setString(1,username);
			proc.setString(2, name);
			proc.setString(3, user_type);
			ResultSet rs=proc.executeQuery();
			rs.next();
			String erp_id=String.valueOf(rs.getObject(1));
			return erp_id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
public static void main(String[] args) {
	System.out.println(registerUser("rickymartin", "Ricky Martin", "student"));
}


/**
 * @param csab_id
 * @return
 */
public static int reportStudent(int csab_id) {
	// TODO Auto-generated method stub
	try{
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"report\"(?);");
	proc.setInt(1,csab_id);
	
	ResultSet rs=proc.executeQuery();
	rs.next();
	int id=rs.getInt(1);
	return id;
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return 0;
}	
}
