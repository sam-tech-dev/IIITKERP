package actions.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import postgreSQLDatabase.registration.Query;

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
		 int reg_id=Integer.parseInt(request.getParameter("reg_id"));
		   
		   int status=Query.retrieveRegistrationStatus(reg_id);
		   System.out.println(status);
		   if(status==1){
			session.setAttribute("reg_id", reg_id);
			data.put("redirect", "registrationPayment.jsp");
			
		   }
		   else if(status==0){
				session.setAttribute("reg_id", reg_id);
				data.put("redirect", "csabRegistration.jsp");
		   }
		   pw.write(data.toString());
	}

}
