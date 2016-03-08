/**
 * 
 */
package postgreSQLDatabase.gradingModule;

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

import postgreSQLDatabase.onlineTest.Question;


/**
 * @author Dilip
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

	public static ArrayList<Subject> retrieveSubjects(int semester) throws SQLException{
		
		ArrayList<Subject> list = new ArrayList<Subject>();
		
		
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"retrieveSubjects\"(?);");
			
			proc.setInt(1,semester);
			ResultSet rs = proc.executeQuery();
			System.out.println("SS : " + proc);
			rs.next();

			JSONArray jArray = new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object = jArray.getJSONObject(i);
				
				Subject subject = new Subject();
				
				subject.setCourse_code(current_object.getString("course_code"));
				subject.setSemester(current_object.getInt("semester"));
				subject.setCourse_name(current_object.getString("course_name"));
				subject.setCredit(current_object.getInt("credit"));
				
				list.add(subject);
			}
			
			Iterator<Subject> iterator = list.iterator();
			
			while(iterator.hasNext()){
				Subject subject = iterator.next();
				System.out.println(subject.getCourse_code()+" : " + subject.getCourse_name());
			}

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
