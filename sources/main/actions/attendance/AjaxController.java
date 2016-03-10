package actions.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import postgreSQLDatabase.attendance.Allocation;
import postgreSQLDatabase.attendance.Attendance;

/**
 * Servlet implementation class AjaxController
 */
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals("demo1")) {
			String fullname = request.getParameter("fullname");
			out.print("Hello " + fullname);
		}
		if (action.equals("demo2")) {
			int num1 = Integer.parseInt(request.getParameter("number1"));
			int num2 = Integer.parseInt(request.getParameter("number2"));
			out.print(num1 + num2);
		}
		if (action.equals("getCourseCodeList")) {
			String faculty = request.getParameter("faculty");
			int semester = Integer.parseInt(request.getParameter("semester"));
			ArrayList<Allocation> list = postgreSQLDatabase.attendance.Query.getFacultyCourseCode(faculty, semester);
			Iterator<Allocation> iterator = list.iterator();
			out.print("<option>" + "Course-code" + "</option>");

			while (iterator.hasNext()) {
				Allocation current = iterator.next();
				out.print("<option>" + current.getCourse_code() + "</option>");

			}

		}
		if (action.equals("getStudentList")) {
			String course_code = request.getParameter("course_code");
			ArrayList<Attendance> list = postgreSQLDatabase.attendance.Query.getAttendanceList(course_code);
			Iterator<Attendance> iterator = list.iterator();

			while (iterator.hasNext()) {
				Attendance current = iterator.next();

				out.print("<tr>");
				out.print("<td>");
				out.print(current.getStudent_id());
				out.print("</td>");

				out.print("<td>");
				out.print(current.getStudent_name());
				out.print("</td>");

				out.print("<td>");
				out.print("<input type=\"radio\" name=\"" + current.getStudent_id() + "\" value=\"present" + "\">");
				out.print("</td>");

				out.print("<td>");
				out.print("<input type=\"radio\" name=\"" + current.getStudent_id() + "\" value=\"absent" + "\">");
				out.print("</td>");

				out.print("<td>");
				out.print("<input type=\"radio\" name=\"" + current.getStudent_id() + "\" value=\"leave" + "\">");
				out.print("</td>");

				out.print("</tr>");

			}

		}
	}

}
