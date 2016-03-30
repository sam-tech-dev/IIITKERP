package actions.testPaper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import postgreSQLDatabase.onlineTest.AnswerSheet;
import postgreSQLDatabase.onlineTest.Query;
import postgreSQLDatabase.onlineTest.TestPaper;

/**
 * Servlet implementation class CreateAnswerSheet
 */
public class CreateAnswerSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAnswerSheet() {
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
		// TODO Auto-generated method stub
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				HttpSession session=request.getSession();
							
				Date submission_time=new java.sql.Date(new java.util.Date().getTime());
				int test_paper_id=Integer.parseInt(request.getParameter("test_paper"));
				Long author=Long.parseLong(session.getAttribute("erpId").toString());
				String status=request.getParameter("status");
				String answer_file=request.getParameter("answers");
				AnswerSheet answer_sheet=new AnswerSheet();
				answer_sheet.setAnswer("[]");
				answer_sheet.setAuthor_id(author);
				answer_sheet.setStatus(status);
				answer_sheet.setSubmission_time(submission_time);
				answer_sheet.setTest_paper_id(test_paper_id);
				answer_sheet.setAnswer_file(answer_file);
				
				
			
					int answer_sheet_id=Query.InsertAnswerSheet(answer_sheet);
					postgreSQLDatabase.onlineTest.Query.verify(answer_sheet_id);
					try {
						postgreSQLDatabase.onlineTest.Query.calculateTotal(answer_sheet_id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//paper.setDuration();
				pw.write("success");

	}

}
