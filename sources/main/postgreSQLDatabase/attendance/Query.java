/**
 * 
 */
package postgreSQLDatabase.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import settings.database.PostgreSQLConnection;
/**
 * @author Anshula
 *
 */
public class Query {
	static Connection conn;

	public static void main(String[] args) {
		getAllocationList("EC101");
	}

	

	public static ArrayList<Attendance> getAttendanceList(String course_code) {
		ArrayList<Attendance> attendance_list = null;
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getStudentAttendanceList\"(?);");
			proc.setString(1, course_code);
			ResultSet rs = proc.executeQuery();
			rs.next();
			JSONArray jArray = new JSONArray(rs.getString(1));
			attendance_list = new ArrayList<Attendance>();
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject current = (JSONObject) jArray.get(i);
				Attendance attendance = new Attendance();

				attendance.setStudent_id(current.getString("student_id"));
				attendance.setStudent_name(current.getString("student_name"));

				attendance_list.add(attendance);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attendance_list;

	}

	public static ArrayList<Allocation> getAllocationList(String faculty_id) {
		ArrayList<Allocation> allocation_list = null;
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getSubjectAllocation\"(?);");
			proc.setString(1, faculty_id);
			ResultSet rs = proc.executeQuery();
			rs.next();
			JSONArray jArray = new JSONArray(rs.getString(1));
			allocation_list = new ArrayList<Allocation>();
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject current = (JSONObject) jArray.get(i);
				Allocation allocation = new Allocation();
				allocation.setCourse_code(current.getString("alloted_course_code"));
				allocation.setSemester(current.getInt("semester"));
				allocation.setDate(current.getString("date"));

				allocation_list.add(allocation);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocation_list;

	}

	public static ArrayList<Allocation> getFacultyCourseCode(String faculty_id, int semester) {
		ArrayList<Allocation> allocation_list = null;
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getFacultyCourseCode\"(?,?);");
			proc.setString(1, faculty_id);
			proc.setInt(2, semester);
			ResultSet rs = proc.executeQuery();
			rs.next();
			JSONArray jArray = new JSONArray(rs.getString(1));
			allocation_list = new ArrayList<Allocation>();
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject current = (JSONObject) jArray.get(i);
				Allocation allocation = new Allocation();
				allocation.setCourse_code(current.getString("alloted_course_code"));
				allocation.setSemester(current.getInt("semester"));
				allocation.setDate(current.getString("date"));

				allocation_list.add(allocation);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocation_list;

	}
	public static void insertAttendance(String class_id, JSONObject[] attendance_json) {
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"insertAttendance\"(?,?);");
			proc.setInt(1, Integer.parseInt(class_id));
			proc.setArray(2,PostgreSQLConnection.getConnection().createArrayOf("json", attendance_json));
			proc.executeQuery();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
