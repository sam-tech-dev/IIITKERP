/**
 * 
 */
package postgreSQLDatabase.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 * @author user
 *
 */
public class Query {

	/**
	 * @author Sattar
	 *
	 */
	public @interface java {

	}



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

	
	
	public static void addForm(String name,String fields,String format) throws SQLException{
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"addForm\"(?,?,?);");
	proc.setString(1, name);
	proc.setString(2, fields);
	proc.setString(3, format);
	
	proc.executeQuery();
}
	
	public static ArrayList<String> getFormNames(){
		
		ArrayList<String> list=new ArrayList<String>();
		
		try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getFormName\"();");
	 
	
			ResultSet rs=proc.executeQuery();
			  rs.next();
			
			JSONArray j_array=new JSONArray(rs.getString(1));
			System.out.println(j_array);
			
			
			for(int i=0;i<j_array.length();i++){
				
				JSONObject j_object=j_array.getJSONObject(i);
			
				list.add(j_object.getString("form_name"));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
public static String getFields(String formname){
		
		String fields ="SaM";
		
		try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getRequiredFields\"(?);");
		proc.setString(1, formname);
	
			ResultSet rs=proc.executeQuery();
			 
			  
			
			  rs.next();
			  
			  if(rs==null){
				return  null;  
			  }
			  
			  JSONArray j_array=new JSONArray(rs.getString(1));
				System.out.println(j_array);
				
				JSONObject j_object=j_array.getJSONObject(0);
			 // System.out.println(rs);
			  
				fields=j_object.getString("fields");
				//System.out.print(fields);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fields;
		
	}
	






public static String getFormat(String formname){
	
	String format ="SaM";
	
	try {
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getFormFormat\"(?);");
	proc.setString(1, formname);

		ResultSet rs=proc.executeQuery();
		
		  rs.next();
		  
		  JSONArray j_array=new JSONArray(rs.getString(1));
			System.out.println(j_array);
			
			JSONObject j_object=j_array.getJSONObject(0);
		 // System.out.println(rs);
		  
			format=j_object.getString("format");
			//System.out.print(fields);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return format;
	
}
	
	
	
	
}
