package actions.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import exceptions.IncorrectFormatException;
import users.Student;

/**
 * Servlet implementation class retrieveRegistrationStudentData
 */
public class RetrieveRegistrationStudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveRegistrationStudentData() {
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
		long registration_id = Long.parseLong(request.getParameter("registration_id").toString());
		try {
			JSONObject j_object=postgreSQLDatabase.registration.Query.getUpdateStudentProfile(registration_id);
			PrintWriter writer=response.getWriter();
			writer.write(j_object.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
