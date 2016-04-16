package actions.feePayment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import postgreSQLDatabase.feePayment.Query;


/**
 * Servlet implementation class VerifyFeePayment
 */
public class VerifyFeePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyFeePayment() {
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
		long ref_no=Long.parseLong(request.getParameter("ref_no"));
		long reg_id=Long.parseLong(request.getParameter("reg_id"));
		Query.verifyFeePayment(ref_no);
		postgreSQLDatabase.registration.Query.updateVerificationStatus(4, reg_id);
		response.sendRedirect("office/feePaymentStatusList.jsp");
	}

}
