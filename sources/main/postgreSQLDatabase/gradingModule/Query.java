/**
 * 
 */
package postgreSQLDatabase.gradingModule;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Dilip
 *
 */
public class Query {


	public static ArrayList<Subject> retrieveSubjects(int semester) throws SQLException{
		
		ArrayList<Subject> list = new ArrayList<Subject>();
		
		
		try {
			PreparedStatement proc = settings.database.PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"retrieveSubjects\"(?);");
			
			proc.setInt(1,semester);
			ResultSet rs = proc.executeQuery();
		//	System.out.println("SS : " + proc);
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
			/*
			Iterator<Subject> iterator = list.iterator();
			
			while(iterator.hasNext()){
				Subject subject = iterator.next();
				System.out.println(subject.getCourse_code()+" : " + subject.getCourse_name());
			}
*/
			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
public static ArrayList<Grade> retrieveGradeList(String course_code,Integer year) throws SQLException{
		
		ArrayList<Grade> list = new ArrayList<Grade>();
		
		
		try {
			PreparedStatement proc = settings.database.PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getCourseGradeList\"(?,?);");
			
			proc.setString(1,course_code);
			proc.setInt(2,year);
			ResultSet rs = proc.executeQuery();
			System.out.println("SS : " + proc);
			rs.next();

			JSONArray jArray = new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object = jArray.getJSONObject(i);
				
				Grade current= new Grade();
				
				current.setCourse_code(current_object.getString("course_code"));
				current.setStudent_id(current_object.getString("student_id"));
				current.setStudent_name(current_object.getString("student_name"));
				current.setStudent_grade(current_object.getString("grade"));
				
				
				list.add(current);
			}
			/*
			Iterator<Subject> iterator = list.iterator();
			
			while(iterator.hasNext()){
				Subject subject = iterator.next();
				System.out.println(subject.getCourse_code()+" : " + subject.getCourse_name());
			}
*/
			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

public static void generateCsvFile(String sFileName , String sID , String sName , String grade){
	try
	{
	    FileWriter writer = new FileWriter(sFileName , true);
	    
	    writer.append(sID);
	    writer.append(',');
	    writer.append(sName);
	    writer.append(',');
	    writer.append(grade);
	    writer.append('\n');
			
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
 }
}
