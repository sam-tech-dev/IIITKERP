package actions.gradingModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import postgreSQLDatabase.gradingModule.Query;
import postgreSQLDatabase.gradingModule.Subject;

/**
 * Servlet implementation class RetrieveSubjects
 */
public class RetrieveSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveSubjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<Subject> list;
		String sem = request.getParameter("semester_name");
		PrintWriter writer = response.getWriter();
		
		

		
		
		try {
			list = Query.retrieveSubjects(Integer.parseInt(sem));
			JSONArray j_array=new JSONArray();
			Iterator<Subject> iterator = list.iterator();
			while(iterator.hasNext()){
				Subject current=iterator.next();
				JSONObject j_object=new JSONObject();
				j_object.put("code", current.getCourse_code());
				j_object.put("name", current.getCourse_name());
				j_array.put(j_object);
			}
			
			System.out.println("ListSize : " + list.size());
			writer.write(j_array.toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sem);
		
	}
	
	

}
