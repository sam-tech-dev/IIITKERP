package actions.testPaper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import postgreSQLDatabase.onlineTest.Query;
import postgreSQLDatabase.onlineTest.Question;

/**
 * Servlet implementation class GetQuestion
 */
public class GetQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestion() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int test_paper_id=Integer.parseInt(request.getParameter("test_paper_id"));
		int question_id=Integer.parseInt(request.getParameter("question_id"));
		
		Query query_obj=new Query();
		ArrayList<Question> question_list;
		try {
			question_list = query_obj.getQuestions(test_paper_id);
			Question question = question_list.get(question_id-1);
			JSONObject ques_obj=new JSONObject();
			ques_obj.put("type",question.getType());
			ques_obj.put("id",question.getId());
			ques_obj.put("question",question.getQuestion());
			ques_obj.put("options",question.getOptions());
			ques_obj.put("answer",question.getAnswer());
			ques_obj.put("marks",question.getMarks());
			
			String question_json=ques_obj.toString();
			PrintWriter pw = response.getWriter();
			pw.write(question_json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
