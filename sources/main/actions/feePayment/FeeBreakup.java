package actions.feePayment;

import java.io.IOException;
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
		
		String sem=request.getParameter("semester");
		String year=request.getParameter("year");
		String breakupGen=request.getParameter("fee_breakup_general");
		String breakupSc=request.getParameter("fee_breakup_sc");
		String breakupObc=request.getParameter("fee_breakup_obc");
        
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"general",breakupGen,year);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"sc/st",breakupSc,year);
  postgreSQLDatabase.feePayment.Query.addFeeBreakup(sem,"obc",breakupObc,year);
  System.out.println("reached");
    
	
	}

}
