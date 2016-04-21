package actions.registration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.IncorrectFormatException;
import postgreSQLDatabase.registration.Query;
import ldap.User;
import users.Student;
import utilities.StudentIdGeneration;

/**
 * Servlet implementation class GenerateStudentId
 */
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Long id=Long.parseLong(String.valueOf(request.getSession(false).getAttribute("reg_id")));
		User user=StudentIdGeneration.generate_id(id);
		Student student;
		try {
			student = postgreSQLDatabase.registration.Query.getRegistrationStudentData(id);
			user.setFirst_name(student.getFirst_name());
			user.setLast_name(student.getLast_name());
			String erp_id=Query.registerUser(username, student.getFirst_name()+" "+student.getLast_name(), "student");
			user.setErp_id(erp_id);
			user.setUsername(username);
			user.setPassword(password);
			ldap.SimpleLdapAuthentication.addEntry(user);
			response.getWriter().write("<h1>Congratulations!</h1><br> Click <a href='login.jsp'>Here</a> to Continue");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write("<h1>Sorry There was an error!</h1><br> Please COntact the Registration Desk");
			e.printStackTrace();
		}
	
		
	}

}
