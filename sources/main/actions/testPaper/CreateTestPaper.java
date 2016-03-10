package actions.testPaper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postgreSQLDatabase.onlineTest.Actions;
import postgreSQLDatabase.onlineTest.TestPaper;

/**
 * Servlet implementation class CreateTestPaper
 */
public class CreateTestPaper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTestPaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("reached");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String status=request.getParameter("status");
		String subject=request.getParameter("subject");
		String duration=request.getParameter("duration");
		String question_file=request.getParameter("questions");
		TestPaper paper=new TestPaper();
		paper.setAuthor("megha");
		Date date = null;
		try {
			date = new SimpleDateFormat("HH:mm:ss").parse(duration);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		paper.setDuration(new java.sql.Time(date.getHours(), date.getMinutes(), date.getSeconds()));
		paper.setQuestions("[]");
		paper.setStatus(status);
		paper.setSubject(subject);
		paper.setQuestion_file(question_file);
		paper.setCreation_date(new java.sql.Date(new java.util.Date().getTime()));
		Actions.InsertTestPaper(paper);	
		//paper.setDuration();
		pw.write("success");

	}



}
