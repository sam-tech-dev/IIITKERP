package actions.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.IncorrectFormatException;
import postgreSQLDatabase.registration.Query;
import users.Student;

/**
 * Servlet implementation class UpdateStudentRegistrationData
 */
public class UpdateStudentRegistrationData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentRegistrationData() {
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
		PrintWriter writer=response.getWriter();
	 Student student=new Student();
	 try {
			student.setFirst_name(request.getParameter("first_name"));
			student.setMiddle_name(request.getParameter("middle_name"));
			student.setLast_name(request.getParameter("last_name"));
			//+"&category(request.getParameter("category"));
		student.setGuardian_name(request.getParameter("guardian_name"));
		student.setGuardian_contact(request.getParameter("guardian_contact"));
		student.setGuardian_email(request.getParameter("guardian_email"));
		student.setGuardian_address(request.getParameter("guardian_address"));
		student.setFather_name(request.getParameter("father_name"));
		student.setMother_name(request.getParameter("mother_name"));
		student.setFather_contact(request.getParameter("father_contact"));
		student.setMother_contact(request.getParameter("mother_contact"));
		//+"&gender(request.getParameter("gender"));
		//+"&date_of_birth(request.getParameter("date_of_birth"));
		//+"&state_eligibility(request.getParameter("state_eligibility"));
		//+"&program_allocated(request.getParameter("program_allocated"));
		student.setMobile(request.getParameter("mobile"));
		student.setEmail(request.getParameter("email"));
		student.setPermanent_address(request.getParameter("permanent_address"));
		student.setLocal_address(request.getParameter("local_address"));
		if(request.getParameter("hosteller").equals("true"))
		student.setHosteller(true);
		else student.setHosteller(false);
		student.setHostel(request.getParameter("hostel"));
		student.setRoom(request.getParameter("hostel_room"));
		 
		Query.addUpdateStudentRegistrationDetails(student);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IncorrectFormatException e) {
		// TODO Auto-generated catch block
		writer.write(e.getMessage());
		
	}	
		
	}

}
