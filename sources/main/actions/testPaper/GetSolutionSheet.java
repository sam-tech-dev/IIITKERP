package actions.testPaper;

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

import postgreSQLDatabase.onlineTest.Solution;

/**
 * Servlet implementation class GetSolutionSheet
 */
public class GetSolutionSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSolutionSheet() {
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
		try {
			PrintWriter writer=response.getWriter();
			ArrayList<Solution> list = postgreSQLDatabase.onlineTest.Query.getSolutionSheet(Integer.parseInt(request.getParameter("answer_sheet_id")));
			JSONArray j_array=new JSONArray();
			Iterator<Solution> iterator = list.iterator();
			while(iterator.hasNext()){
				Solution current=iterator.next();
				JSONObject j_object=new JSONObject();
				j_object.put("question", current.getQuestion().getQuestion());
				j_object.put("question_id",current.getQuestion().getId());
				j_object.put("marks",current.getQuestion().getMarks());
				j_object.put("question",current.getQuestion().getQuestion());
				j_object.put("type",current.getQuestion().getType());
				j_object.put("options",current.getQuestion().getOptions());
				j_object.put("correct_answer",current.getQuestion().getAnswer());
				j_object.put("given_answer",current.getAnswer().getAnswer());
				j_object.put("answer_id",current.getAnswer().getId());
				j_array.put(j_object);
			}
			writer.write(j_array.toString());
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
