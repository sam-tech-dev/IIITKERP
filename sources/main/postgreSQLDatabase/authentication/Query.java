/**
 * 
 */
package postgreSQLDatabase.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Joey
 *
 */
public class Query {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
