package actions.registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

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
		
		Long reg_id=Long.parseLong(String.valueOf(request.getSession(false).getAttribute("reg_id")));
		User user=new User();
		Student student;
		try {
			student = postgreSQLDatabase.registration.Query.getRegistrationStudentData(reg_id);
			user.setFirst_name(student.getFirst_name());
			user.setLast_name(student.getLast_name());
			String erp_id=Query.registerUser(username, student.getFirst_name()+" "+student.getLast_name(), "student");
			user.setErp_id(erp_id);
			user.setUsername(username);
			user.setPassword(password);
			User reg_info = StudentIdGeneration.generate_id(Long.parseLong(erp_id),reg_id);
			user.setDepartment(reg_info.getDepartment());
			user.setRole(reg_info.getRole());
			user.setRole_id(reg_info.getRole_id());
			ldap.SimpleLdapAuthentication.addEntry(user);
			
			request.getSession().setAttribute("student_id", user.getRole_id());
			request.getSession().setAttribute("username", user.getUsername());
			URL url = new URL("localhost:8080/erp/studentRegistration/congratulations.jsp");
			URLConnection con = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String format=in.toString();
//	        String l;
//	        while ((l=in.readLine())!=null) {
//	            System.out.println(l);
//	        }
	        
		//	response.sendRedirect("studentRegistration/congratulations.jsp");
response.setContentType("application/pdf");
			
			Document document =new Document(com.itextpdf.text.PageSize.A4);
			
			
			try{
				PdfWriter.getInstance(document,response.getOutputStream());
				
				document.open();
				
				  HTMLWorker htmlWorker = new HTMLWorker(document);
				    htmlWorker.parse(new StringReader(format));
			
				document.close();
				
			}catch(DocumentException e){
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().write("<h1>Sorry There was an error!</h1><br> Please COntact the Registration Desk");
			e.printStackTrace();
		}
	
		
	}

}
