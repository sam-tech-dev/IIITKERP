package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.util.JSON;

import ldap.*;
/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password=request.getParameter("password");

		try {	
			String result=SimpleLdapAuthentication.searchAndAuthenticate(username, password);
			if(result!=null){
			 JSONObject credentials = new JSONObject(result);
			
			HttpSession session = request.getSession();
			session.setAttribute("name",  credentials.get("name"));
			
				JSONObject data = new JSONObject();

				data.put("redirect", credentials.get("type")+"-home.jsp");
				PrintWriter writer = response.getWriter();
				writer.write(data.toString());

			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
