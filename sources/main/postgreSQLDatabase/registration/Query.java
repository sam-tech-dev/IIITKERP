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

import com.sun.mail.handlers.message_rfc822;

import exceptions.IncorrectFormatException;
import settings.database.PostgreSQLConnection;
import users.Student;

/**
 * @author Anshula
 *
 */
public class Query {
	
	static Connection conn ;
	private static PreparedStatement proc;
	
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
	
	public static ArrayList<Student> displayRegistrationData() throws SQLException,IncorrectFormatException{
		ArrayList<Student> students=null;
		 
		try {
			PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"displayRegistrationList\"();");
			//proc.setInt(1,reg_id);
			students=new ArrayList<Student>();
			ResultSet rs=proc.executeQuery();
			//System.out.println(proc);
			rs.next();

			JSONArray jArray=new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				Student current=new Student();
				current.setName(current_object.getString("name"));
				current.setFirst_name(current_object.getString("first_name"));
				current.setMiddle_name(current_object.getString("middle_name"));
				current.setLast_name(current_object.getString("last_name"));
				current.setCategory(current_object.getString("category"));
				//current.setJee_adv_rollno(current_object.getInt("jee_adv_rollno"));
				//current.setJee_main_rollno(current_object.getInt("jee_main_rollno"));
				current.setState_eligibility(current_object.getString("state"));
				current.setMobile(current_object.getString("phone_number"));
				current.setEmail(current_object.getString("email"));
				current.setDate_of_birth(current_object.getString("date_of_birth"));
				current.setProgram_allocated(current_object.getString("program_allocated"));
				//current.setAllocated_category(current_object.getString("allocated_category"));
				//current.setAllocated_rank(current_object.getInt("allocated_rank"));
				current.setStatus(current_object.getString("status"));
				//current.setChoice_no(current_object.getInt("choice_no"));
				current.setPwd(current_object.getBoolean("physically_disabled"));
				current.setGender(current_object.getString("gender"));
				//current.setQuota(current_object.getString("quota"));
				//current.setRound(current_object.getInt("round"));
				//current.setWillingness(current_object.getString("willingness"));
				//current.setPermanent_address(current_object.getString("address"));
				//current.setRc_name(current_object.getString("rc_name"));
				current.setNationality(current_object.getString("nationality"));
				current.setCsab_id(current_object.getInt("id"));
				//current.setEntry_time(new java.sql.Date(new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(current_object.getString("entry_date")).getTime()));
				current.setVerified(current_object.getBoolean("verified"));
				students.add(current);
			}
			Iterator<Student> iterator = students.iterator();	
			while(iterator.hasNext()){
				Student current=iterator.next();
				//System.out.println(current.getRegistration_id()+" "+current.getName());
			}

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;
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





public static ArrayList<Student> getCsabStudentList() throws SQLException,IncorrectFormatException{
	ArrayList<Student> students=null;
	try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"displayCsabList\"();");

		students=new ArrayList<Student>();
		ResultSet rs=proc.executeQuery();
		//System.out.println(proc);
		rs.next();
     
		JSONArray jArray=new JSONArray(rs.getString(1));

		for(int i=0;i<jArray.length();i++)
		{
			JSONObject current_object=jArray.getJSONObject(i);
			Student current=new Student();
			current.setName(current_object.getString("name"));
			current.setFirst_name(current_object.getString("first_name"));
			current.setMiddle_name(current_object.getString("middle_name"));
			current.setLast_name(current_object.getString("last_name"));
			current.setCategory(current_object.getString("category"));
			current.setJee_adv_rollno(current_object.getInt("jee_adv_rollno"));
			current.setJee_main_rollno(current_object.getInt("jee_main_rollno"));
			current.setState_eligibility(current_object.getString("state"));
			current.setMobile(current_object.getString("phone_number"));
			current.setEmail(current_object.getString("email"));
			current.setDate_of_birth(current_object.getString("date_of_birth"));
			current.setProgram_allocated(current_object.getString("program_allocated"));
			current.setAllocated_category(current_object.getString("allocated_category"));
			current.setAllocated_rank(current_object.getInt("allocated_rank"));
			current.setStatus(current_object.getString("status"));
			current.setChoice_no(current_object.getInt("choice_no"));
			current.setPwd(current_object.getBoolean("physically_disabled"));
			current.setGender(current_object.getString("gender"));
			current.setQuota(current_object.getString("quota"));
			current.setRound(current_object.getInt("round"));
			current.setWillingness(current_object.getString("willingness"));
			current.setPermanent_address(current_object.getString("address"));
			current.setRc_name(current_object.getString("rc_name"));
			current.setNationality(current_object.getString("nationality"));
			current.setCsab_id(current_object.getInt("id"));
			current.setEntry_time(new java.sql.Date(new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(current_object.getString("entry_date")).getTime()));
			current.setReported(current_object.getBoolean("reported"));
			
			students.add(current);
		}
		Iterator<Student> iterator = students.iterator();	
		while(iterator.hasNext()){
			Student current=iterator.next();
			//System.out.println(current.getCsab_id()+" "+current.getName());
		}

		rs.close();
		proc.close();
	}  catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return students;
}




public static Student getCsabStudentProfile(int reg_id) throws SQLException,IncorrectFormatException{
	Student current=new Student();
	try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"displayCsabProfile\"(?);");
		proc.setInt(1,reg_id);
		
		ResultSet rs=proc.executeQuery();
	
		rs.next();

		JSONArray jArray=new JSONArray(rs.getString(1));
		
		
			JSONObject current_object=jArray.getJSONObject(0);
			
			
			current.setName(current_object.getString("name"));
			current.setFirst_name(current_object.getString("first_name"));
			current.setMiddle_name(current_object.getString("middle_name"));
			current.setLast_name(current_object.getString("last_name"));
			current.setCategory(current_object.getString("category"));
			current.setJee_adv_rollno(current_object.getInt("jee_adv_rollno"));
			current.setJee_main_rollno(current_object.getInt("jee_main_rollno"));
			current.setState_eligibility(current_object.getString("state"));
			current.setMobile(current_object.getString("phone_number"));
			current.setEmail(current_object.getString("email"));
			current.setDate_of_birth(current_object.getString("date_of_birth"));
			current.setProgram_allocated(current_object.getString("program_allocated"));
			current.setAllocated_category(current_object.getString("allocated_category"));
			current.setAllocated_rank(current_object.getInt("allocated_rank"));
			current.setStatus(current_object.getString("status"));
			current.setChoice_no(current_object.getInt("choice_no"));
			current.setPwd(current_object.getBoolean("physically_disabled"));
			current.setGender(current_object.getString("gender"));
			current.setQuota(current_object.getString("quota"));
			current.setRound(current_object.getInt("round"));
			current.setWillingness(current_object.getString("willingness"));
			current.setPermanent_address(current_object.getString("address"));
			current.setRc_name(current_object.getString("rc_name"));
			current.setNationality(current_object.getString("nationality"));
			current.setCsab_id(current_object.getInt("id"));
			current.setEntry_time(new java.sql.Date(new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(current_object.getString("entry_date")).getTime()));
	
			
		
		
		
		

		rs.close();
		proc.close();
	}  catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	return current;
}


public static Student getRegistrationStudentData(Long reg_id) throws SQLException,IncorrectFormatException{
	Student current=new Student();
	try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"retrieveRegistrationStudentData\"(?);");
		proc.setLong(1,reg_id);

		ResultSet rs=proc.executeQuery();
	//	System.out.println(rs.next());
		rs.next();

		JSONArray jArray=new JSONArray(rs.getString(1));

		
			JSONObject current_object=jArray.getJSONObject(0);
			
			System.out.println(current_object);
			current.setName(current_object.getString("name"));
			current.setFirst_name(current_object.getString("first_name"));
			current.setMiddle_name(current_object.getString("middle_name"));
			current.setLast_name(current_object.getString("last_name"));
			current.setCategory(current_object.getString("category"));
			current.setState_eligibility(current_object.getString("state"));
			current.setMobile(current_object.getString("phone_number"));
			current.setEmail(current_object.getString("email"));
			current.setDate_of_birth(current_object.getString("date_of_birth"));
			current.setProgram_allocated(current_object.getString("program_allocated"));
			current.setStatus(current_object.getString("status"));
			current.setPwd(current_object.getBoolean("physically_disabled"));
			current.setGender(current_object.getString("gender"));
			current.setPermanent_address(current_object.getString("permanent_address"));
			current.setLocal_address(current_object.getString("local_address"));
			current.setNationality(current_object.getString("nationality"));
			current.setGuardian_name(current_object.getString("guardian_name"));
			current.setGuardian_contact(current_object.getString("guardian_contact"));
			current.setGuardian_email(current_object.getString("guardian_email"));
			current.setGuardian_address(current_object.getString("guardian_address"));
			current.setFather_name(current_object.getString("father_name"));
			current.setMother_name(current_object.getString("mother_name"));
			current.setFather_contact(current_object.getString("father_contact"));
			current.setMother_name(current_object.getString("mother_name"));
			current.setHosteller(current_object.getBoolean("hosteller"));
			String json_string=current_object.getString("hostel_address");
			JSONObject address_obj=new JSONObject(json_string);
			current.setHostel(address_obj.getString("hostel"));
			current.setRoom(address_obj.getString("room"));
			current.setEntry_time((Date) new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(current_object.getString("entry_time")));
			
			//System.out.println(current.getName());
		rs.close();
		proc.close();
	}  catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	return current;
}

public static JSONArray retrieveRegistrationData() throws SQLException{
	
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"displayRegistrationList\"();");
	ResultSet rs=proc.executeQuery();
	//System.out.println(proc);
	rs.next();

	JSONArray jArray=new JSONArray(rs.getString(1));
	
	return jArray;
}
public static void updateVerified(int csab_id){
	try{
		PreparedStatement proc=getConnection().prepareStatement("SELECT public.\"updateVerified\"(?);");
		proc.setInt(1,csab_id);
		System.out.println(proc);
		proc.executeQuery();
		
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static Student getRegistrationStudentDataUpdate(Long reg_id) throws SQLException,IncorrectFormatException{
	Student current=new Student();
	try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"retrieveRegistrationStudentDataUpdate\"(?);");
		proc.setLong(1,reg_id);

		ResultSet rs=proc.executeQuery();
		System.out.println(proc);
		rs.next();

		JSONArray jArray=new JSONArray(rs.getString(1));


			JSONObject current_object=jArray.getJSONObject(0);

			
			current.setName(current_object.getString("name"));
			current.setFirst_name(current_object.getString("first_name"));
			current.setMiddle_name(current_object.getString("middle_name"));
			current.setLast_name(current_object.getString("last_name"));
			current.setCategory(current_object.getString("category"));
			current.setState_eligibility(current_object.getString("state"));
			current.setMobile(current_object.getString("phone_number"));
			current.setEmail(current_object.getString("email"));
			current.setDate_of_birth(current_object.getString("date_of_birth"));
			current.setProgram_allocated(current_object.getString("program_allocated"));
			current.setStatus(current_object.getString("status"));
			current.setPwd(current_object.getBoolean("physically_disabled"));
			current.setGender(current_object.getString("gender"));
			current.setPermanent_address(current_object.getString("permanent_address"));
			current.setLocal_address(current_object.getString("local_address"));
			current.setNationality(current_object.getString("nationality"));
			current.setGuardian_name(current_object.getString("guardian_name"));
			current.setGuardian_contact(current_object.getString("guardian_contact"));
			current.setGuardian_email(current_object.getString("guardian_email"));
			current.setGuardian_address(current_object.getString("guardian_address"));
			current.setFather_name(current_object.getString("father_name"));
			current.setMother_name(current_object.getString("mother_name"));
			current.setFather_contact(current_object.getString("father_contact"));
			current.setMother_name(current_object.getString("mother_name"));
			current.setHosteller(current_object.getBoolean("hosteller"));
			current.setApplied(current_object.getBoolean("applied"));
			current.setEntry_time((Date) new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(current_object.getString("entry_time")));
			String json_string=current_object.getString("hostel_address");
			JSONObject address_obj=new JSONObject(json_string);
			current.setHostel(address_obj.getString("hostel"));
			current.setRoom(address_obj.getString("room"));
			
			
		

		rs.close();
		proc.close();
	}  catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	return current;
}


public static void addUpdateStudentRegistrationDetails(Student student) throws SQLException{
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"addUpdateRegistrationStudentDetails\"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
	
	proc.setString(1,student.getName());
	proc.setString(2,student.getFirst_name());
	proc.setString(3,student.getMiddle_name());
	proc.setString(4,student.getLast_name());
	proc.setString(5,student.getCategory());
	proc.setString(6,student.getState_eligibility());
	proc.setString(7,student.getMobile());
	proc.setString(8,student.getEmail());
	proc.setDate(9,student.getDate_of_birth());
	proc.setString(10,student.getProgram_allocated());
	proc.setString(11,student.getStatus());
	proc.setBoolean(12,student.isPwd());
	proc.setString(13,student.getGender());
	proc.setString(14,student.getNationality());
	proc.setInt(15,student.getRegistration_id());
	proc.setString(16,student.getGuardian_name());
	proc.setString(17,student.getGuardian_contact());
	proc.setString(18,student.getGuardian_email());
	proc.setString(19,student.getGuardian_address());
	proc.setString(20,student.getFather_name());
	proc.setString(21,student.getMother_name());
	proc.setString(22,student.getFather_contact());
	proc.setString(23,student.getMother_contact());
	proc.setString(24,student.getPermanent_address());
	proc.setString(25,student.getLocal_address());
	proc.setBoolean(26,student.isHosteller());
	JSONObject address_obj=new JSONObject();
	address_obj.put("room",student.getRoom());
	address_obj.put("hostel",student.getHostel());
	proc.setString(27,address_obj.toString());
	proc.setBoolean(28,student.isApplied());
	proc.setDate(29,student.getEntry_time());
	
	proc.executeQuery();
}


public static void applyUpdate(int reg_id) throws SQLException{
	PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"applyUpdate\"(?);");
	proc.setInt(1,reg_id);
	proc.executeQuery();
}

public static int retrieveRegistrationStatus(Long reg_id){
	
	
	try {

		proc = settings.database.PostgreSQLConnection.getConnection()
				.prepareStatement("SELECT public.\"existsRegId\"(?);");
		proc.setLong(1,reg_id);
		ResultSet rs = proc.executeQuery();
		rs.next();
		System.out.println("ID exists "+rs.getBoolean(1));
		if(rs.getBoolean(1)){
		proc = PostgreSQLConnection.getConnection().
				prepareStatement("SELECT public.\"retrieveRegistrationStatus\"(?);");
		proc.setLong(1,reg_id);
		rs = proc.executeQuery();	
		  rs.next();
			boolean verified=rs.getBoolean(1);
			System.out.println("verified "+verified);
			if(verified)
			{
				return 1;
			}
			else{
				return 0;
			}
		}
		else{
			return -1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return -1;
	
}

public static int reportStudent(int csab_id) {
	try {
		PreparedStatement proc = getConnection().prepareStatement("SELECT public.\"report\"(?);");
		proc.setInt(1,csab_id);
		ResultSet rs=proc.executeQuery();
		rs.next();
		int reg_id=rs.getInt(1);
		return reg_id;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}
public static void retrieveStudentList(){
	PreparedStatement proc;
	try {
		proc = getConnection().prepareStatement("SELECT \"retrieveStudentList\"();");
	
	ResultSet rs = proc.executeQuery();
	rs.next();
	JSONArray student_list=new JSONArray(rs.getString(1));
	int i=0;
	JSONObject student;
	for(i=0;i<student_list.length();i++){
		 student = student_list.getJSONObject(i);
		
		 Student current=new Student();
		 current.setStudent_id(student.get("student_id").toString());
	}

	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void main(String[] args) {
	retrieveStudentList();
}

}



