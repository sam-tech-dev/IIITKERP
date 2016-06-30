package actions.gradingModule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postgreSQLDatabase.gradingModule.*;

/**
 * Servlet implementation class ExportGradesheet
 */
public class ExportGradesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportGradesheet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request ,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
        	ArrayList<Grade> list = null;
			try {
				list = Query.retrieveGradeList(request.getParameter("course_code"),Integer.parseInt(request.getParameter("year")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         Iterator<Grade> iterator = list.iterator();
         while(iterator.hasNext()){
         	Grade current = iterator.next();
         	Query.generateCsvFile("F://Table.csv", current.getStudent_id(), current.getStudent_name(), current.getStudent_grade());
         }
        
	response.sendRedirect("faculty/GradingModule.jsp");
	}
}
