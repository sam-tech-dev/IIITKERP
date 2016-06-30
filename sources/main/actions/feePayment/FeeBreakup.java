package actions.feePayment;


import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeeBreakup
 */
public class FeeBreakup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeBreakup() {
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
		
		int sem=Integer.parseInt(request.getParameter("semester"));
		int year=Integer.parseInt(request.getParameter("year"));
		String breakupGen=request.getParameter("fee_breakup_general");
		String breakupSc=request.getParameter("fee_breakup_sc");
		String breakupObc=request.getParameter("fee_breakup_obc");
		
		breakupGen= URLDecoder.decode(breakupGen, "UTF-8");
		breakupSc= URLDecoder.decode(breakupSc, "UTF-8");
		breakupObc= URLDecoder.decode(breakupObc, "UTF-8");
		System.out.println( breakupObc);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"GENERAL",breakupGen,year);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"SC",breakupSc,year);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"ST",breakupSc,year);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"OBC",breakupObc,year);
    
	
	}

}
