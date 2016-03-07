/**
 * 
 */
package settings.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Joey
 *
 */
public class PostgreSQLConnection {
	static Connection conn ;
	public static Connection getConnection() throws SQLException{

		if(conn==null||conn.isClosed()){
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
}
