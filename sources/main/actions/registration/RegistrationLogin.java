package actions.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import exceptions.IncorrectFormatException;
import postgreSQLDatabase.registration.Query;
import users.Student;

/**
 * Servlet implementation class RegistrationLogin
 */
public class RegistrationLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationLogin() {
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
		PrintWriter pw=response.getWriter();
		JSONObject data = new JSONObject();
		HttpSession session = request.getSession();

		Long reg_id=Long.parseLong(request.getParameter("reg_id"));
		   
		   int status=Query.retrieveRegistrationStatus(reg_id);
		   System.out.println(status);
		   try {
			Student student=postgreSQLDatabase.registration.Query.getRegistrationStudentData(reg_id);
			session.setAttribute("name", student.getName());
		} catch (SQLException | IncorrectFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   if(status==1 || status==0){
			   session.setAttribute("reg_id", reg_id);
				data.put("redirect", "csabRegistration.jsp");
			
		   }
		   else if(status==2||status==3){
				
				session.setAttribute("reg_id", reg_id);
				data.put("redirect", "registrationPayment.jsp");
		   }
		   else if(status==4){
				
				session.setAttribute("reg_id", reg_id);
				data.put("redirect", "ldapRegistration.jsp");
		   }
		   else
			   data.put("redirect", "../login.jsp");
			   
		   pw.write(data.toString());
		   
	}

}
