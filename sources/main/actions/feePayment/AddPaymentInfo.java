package actions.feePayment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import postgreSQLDatabase.feePayment.Query;

/**
 * Servlet implementation class AddPaymentInfo
 */
public class AddPaymentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentInfo() {
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
		// challan 5
		HttpSession session=request.getSession();
        if(request.getParameter("payment_method").toString().equals("demand_draft")){
        JSONObject details=new JSONObject();
        details.put("amount",request.getParameter("amount"));
        details.put("bank",request.getParameter("bank"));
        details.put("date",request.getParameter("date"));
        details.put("dd_no",request.getParameter("dd_no"));
	int ref_id=	Query.addFeePayment("DD payment",5,details,Integer.parseInt(request.getParameter("amount")),Integer.parseInt(session.getAttribute("reg_id").toString()));
		PrintWriter writer=response.getWriter();
		JSONObject ref=new JSONObject();
		ref.put("ref_id", ref_id);
		writer.write(ref.toString());
        
        
        }
        
        if(request.getParameter("payment_method").equals("neft")){
            JSONObject details=new JSONObject();
            details.put("amount",request.getParameter("amount"));
            details.put("bank",request.getParameter("bank"));
            details.put("date",request.getParameter("date"));
            details.put("tid",request.getParameter("tid"));
    	int ref_id=	Query.addFeePayment("NEFT payment",4,details,Integer.parseInt(request.getParameter("amount")),Integer.parseInt(session.getAttribute("reg_id").toString()));
    		PrintWriter writer=response.getWriter();
    		JSONObject ref=new JSONObject();
    		ref.put("ref_id", ref_id);
    		writer.write(ref.toString());
        }
        if(request.getParameter("payment_method").equals("challan")){
            JSONObject details=new JSONObject();
            details.put("amount",request.getParameter("amount"));
            details.put("bank",request.getParameter("bank"));
            details.put("date",request.getParameter("date"));
            details.put("challan_no",request.getParameter("challan_no"));
    	int ref_id=	Query.addFeePayment("Challan payment",2,details,Integer.parseInt(request.getParameter("amount")),Integer.parseInt(session.getAttribute("reg_id").toString()));
    		PrintWriter writer=response.getWriter();
    		JSONObject ref=new JSONObject();
    		ref.put("ref_id", ref_id);
    		writer.write(ref.toString());
        }
	}

}
