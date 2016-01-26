
package postgreSQLDatabase;

import java.sql.Connection;
import java.sql.DriverManager;




/**test class
 * @author Joey
 *
 */
public class Test {
	
@SuppressWarnings("unused")
public static void main(String[] args) {
	Connection connection = connect("ERP","postgres","joey"); //creating new connection
}

/**
 * @param database name of database to connect to
 * @param username Credentials of user to connect
 * @param password 
 * @return connection variable
 */
public static Connection connect(String database,String username,String password){
	Connection c = null;
	    try {
       Class.forName("org.postgresql.Driver");
       c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/"+database,username, password);
      
    } catch (Exception e) {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
           }
    if(settings.Execution.debugMode)System.out.println("Opened database successfully");
	return c;
}
}
