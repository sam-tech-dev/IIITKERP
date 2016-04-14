/**
 * 
 */
package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * @author Arushi
 *
 */
public class StudentIdGeneration {
	static Connection conn;
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
	public static void main(String args[]){
		Long id=(long) 27;
		generate_id(id);
	}
	public static void generate_id(Long id){
		String student_id;
		String code=null;
		String num=null;
		String course=null;
		String branch=null;
		String batch=null;
		String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		try{
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"getProgram\"(?);");
			proc.setLong(1, id);
			ResultSet rs = proc.executeQuery();
			rs.next();
			String program=rs.getString(1);
			//System.out.println(program);
			if(program.equals("Computer Engineering (4 Years Bachelor of Technology)")){
				code="KUCP";
			}
			if(program.equals("Electronics and Communication Engineering (4 Years Bachelor of Technology)")){
				code="KUEC";
			}
			if(program.equals("Computer Engineering (2 Years Master of Technology)")){
				code="KPCP";
			}
			if(program.equals("Electronics and Communication Engineering (2 Years Master of Technology)")){
				code="KPEC";
			}
			//System.out.println(code);
			PreparedStatement proc1 = getConnection().prepareStatement("SELECT public.\"countStudent\"(?);");
			proc1.setString(1, program);
			ResultSet rs1 = proc1.executeQuery();
			rs1.next();
			int count=rs1.getInt(1)+1;
			//System.out.println(count);
			if(count<10){
				num="0"+String.valueOf(count);
				//System.out.println(num);
			}
			else{
				num=String.valueOf(count);
			}
			if(code.equals("KUCP") || code.equals("KPCP")){
				num="10"+num;
				branch="computer science";
			}
			if(code.equals("KUEC") || code.equals("KPEC")){
				num="20"+num;
				branch="electronics and communication";
			}
			student_id=year+code+num;
			System.out.println(student_id);
			if(code.equals("KUCP")|| code.equals("KUEC")){
				course="undergraduate";
			}
			if(code.equals("KPCP")|| code.equals("KPEC")){
				course="postgraduate";
			}
			PreparedStatement proc2 = getConnection().prepareStatement("SELECT public.\"addStudent\"(?,?,?,?,?,?);");
			proc2.setLong(1,id);
			proc2.setString(2, student_id);
			proc2.setInt(3, 1);
			proc2.setString(4, course);
			proc2.setString(5, branch);
			proc2.setString(6, batch);
			ResultSet rs2 = proc2.executeQuery();
			rs2.next();
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
