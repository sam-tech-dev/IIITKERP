/**
 * 
 */
package postgreSQLDatabase.attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Anshula
 *
 */
public class Query {
	static Connection conn;

	public static void main(String[] args) {
		getAllocationList("EC101");
	}

	public static Connection getConnection() throws SQLException {

		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:postgresql://172.16.1.231:5432/iiitk", "developer", "developer");
		}
		return conn;
	}
	
	public static ArrayList<Allocation> getCourseList(String faculty_id, int semester, String branch) {
		ArrayList<Allocation> allocation_list = null;
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getCourseList\"(?,?,?);");
			proc.setString(1, faculty_id);
			proc.setInt(2, semester);
			proc.setString(3, branch);
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
				allocation.setBranch_name(current.getString("branch_name"));

				allocation_list.add(allocation);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocation_list;

	}
	
	public static ArrayList<Allocation> getBranchList(String faculty_id, int semester) {
		ArrayList<Allocation> allocation_list = null;
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getBranchName\"(?,?);");
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
				allocation.setBranch_name(current.getString("branch_name"));
				allocation_list.add(allocation);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocation_list;

	}
	
	public static ArrayList<Attendance> getStudentAttendanceList(String course_code,String branch) {
		ArrayList<Attendance> attendance_list = null;
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getStudentAttendanceList\"(?,?);");
			proc.setString(1, course_code);
			proc.setString(2, branch);
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
	
	public static void insertAttendance(String class_id, JSONObject[] attendance_json) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		class_id=dateFormat.format(date).toString();
		//System.out.println(class_id);
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"insertAttendance\"(?,?);");
			proc.setString(1,class_id);
			proc.setArray(2,getConnection().createArrayOf("json", attendance_json));
			proc.executeQuery();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static ArrayList<Attendance> getAttendanceList(String course_code) {
		ArrayList<Attendance> attendance_list = null;
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getStudentAttendanceList\"(?);");
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
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getSubjectAllocation\"(?);");
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
				allocation.setBranch_name(current.getString("branch_name"));
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
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getFacultyCourseCode\"(?,?);");
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
				allocation.setBranch_name(current.getString("branch_name"));

				allocation_list.add(allocation);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allocation_list;

	}

}
