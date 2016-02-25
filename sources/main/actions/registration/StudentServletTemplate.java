package actions.registration;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import exceptions.IncorrectFormatException;
import users.Student;

/**
 * Servlet implementation class StudentServletTemplate
 */
public class StudentServletTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Student student=new Student();
		
		student.setAllocated_rank(Integer.parseInt(request.getParameter("allocated_rank")));
		student.setApplied(Boolean.parseBoolean(request.getParameter("applied")));
		student.setChoice_no(Integer.parseInt(request.getParameter("choice_no")));
		try {
			student.setEntry_time((Date)new SimpleDateFormat("YYYY-MM-DD HH:mm:SS.SSSSSS").parse(request.getParameter("entry_time")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setFather_contact(request.getParameter("father_contact"));
		student.setFather_name(request.getParameter("father_name"));
		student.setFirst_name(request.getParameter("first_name"));
		student.setGuardian_address(request.getParameter("guardian_address"));
		student.setGuardian_contact(request.getParameter("guardian_contact"));
		student.setGuardian_email(request.getParameter("guardian_email"));
		student.setGuardian_name(request.getParameter("guardian_name"));
		student.setHostel(request.getParameter("hostel"));
		student.setHosteller(Boolean.parseBoolean(request.getParameter("hosteller")));
		student.setJee_adv_rollno(Integer.parseInt(request.getParameter("jee_adv_rollno")));
		student.setJee_main_rollno(Integer.parseInt(request.getParameter("jee_main_rollno")));
		student.setLast_name(request.getParameter("last_name"));
		student.setLocal_address(request.getParameter("local_address"));
		student.setMiddle_name(request.getParameter("middle_name"));
		try {
			student.setDate_of_birth(request.getParameter("date_of_birth"));
			student.setEmail(request.getParameter("email"));
			student.setDate_of_birth(request.getParameter("date_of_birth"));
			student.setGender(request.getParameter("gender"));
			student.setAllocated_category(request.getParameter("allocated_category"));
			student.setMobile(request.getParameter("mobile"));
			student.setNationality(request.getParameter("nationality"));
			student.setProgram_allocated(request.getParameter("program_allocated"));
			student.setName(request.getParameter("name"));
			student.setState_eligibility(request.getParameter("state"));
			student.setCategory(request.getParameter("category"));
		} catch (IncorrectFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student.setMother_contact(request.getParameter("mother_contact"));
		student.setMother_name(request.getParameter("mother_name"));
		student.setPermanent_address(request.getParameter("permanent_address"));
		student.setPwd(Boolean.parseBoolean(request.getParameter("pwd")));
		student.setQuota(request.getParameter("quota"));
		student.setRc_name(request.getParameter("rc_name"));
		student.setRegistration_id(Integer.parseInt(request.getParameter("reg_id")));
		student.setRoom(request.getParameter("room"));
		student.setRound(Integer.parseInt(request.getParameter("round")));
		student.setStatus(request.getParameter("status"));
		student.setStudent_id(request.getParameter("student_id"));
		student.setWillingness(request.getParameter("willingness"));
		
		
		//// Student object to json
		
		Student stu_obj=new Student();
		JSONObject student_json=new JSONObject();
		
		student_json.put("allocated_category",stu_obj.getAllocated_category());
		student_json.put("allocated_rank",stu_obj.getAllocated_rank());
		student_json.put("category",stu_obj.getCategory());
		student_json.put("choice_no",stu_obj.getChoice_no());
		student_json.put("date_of_birth",stu_obj.getDate_of_birth());
		student_json.put("email",stu_obj.getEmail());
		student_json.put("entry_time",stu_obj.getEntry_time());
		student_json.put("father_contact",stu_obj.getFather_contact());
		student_json.put("father_name",stu_obj.getFather_name());
		student_json.put("first_name",stu_obj.getFirst_name());
		student_json.put("gender",stu_obj.getGender());
		student_json.put("guardian_address",stu_obj.getGuardian_address());
		student_json.put("guardian_contact",stu_obj.getGuardian_contact());
		student_json.put("guardian_email",stu_obj.getGuardian_email());
		student_json.put("guardian_name",stu_obj.getGuardian_name());
		student_json.put("hostel",stu_obj.getHostel());
		student_json.put("jee-adv_rollno",stu_obj.getJee_adv_rollno());
		student_json.put("jee_main_rollno",stu_obj.getJee_main_rollno());
		student_json.put("last_name",stu_obj.getLast_name());
		student_json.put("local_address",stu_obj.getLocal_address());
		student_json.put("middle_name",stu_obj.getMiddle_name());
		student_json.put("phone_no",stu_obj.getMobile());
		student_json.put("mother_contact",stu_obj.getMother_contact());
		student_json.put("mother_name",stu_obj.getMother_name());
		student_json.put("name",stu_obj.getName());
		student_json.put("nationality",stu_obj.getNationality());
		student_json.put("permanent_address",stu_obj.getPermanent_address());
		student_json.put("program_allocated",stu_obj.getProgram_allocated());
		student_json.put("quota",stu_obj.getQuota());
		student_json.put("rc_name",stu_obj.getRc_name());
		student_json.put("registration_id",stu_obj.getRegistration_id());
		student_json.put("room",stu_obj.getRoom());
		student_json.put("round",stu_obj.getRound());
		student_json.put("state",stu_obj.getState_eligibility());
		student_json.put("status",stu_obj.getStatus());
		student_json.put("student_id",stu_obj.getStudent_id());
		student_json.put("willingness",stu_obj.getWillingness());
		student_json.put("applied",stu_obj.isApplied());
		student_json.put("hosteller",stu_obj.isHosteller());
		student_json.put("physically_disabled",stu_obj.isPwd());
		
		
	}
		
}	
	

