package actions.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import postgreSQLDatabase.registration.Query;

/**
 * Servlet implementation class ReportStudent
 */
public class ReportStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportStudent() {
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

		int csab_id=Integer.parseInt(request.getParameter("csab_id"));
		System.out.println(csab_id);
		int reg_id=Query.reportStudent(csab_id);
		System.out.println("reg"+reg_id);
		JSONObject reg=new JSONObject();
		reg.put("reg", reg_id);
		PrintWriter pw=response.getWriter();
		pw.write(reg.toString());
	}

}
