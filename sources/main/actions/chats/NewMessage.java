package actions.chats;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import settings.database.PostgreSQLConnection;

/**
 * Servlet implementation class NewMessage
 * @author Megha
 * Servlet to add new message to database.
 *  
 */
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMessage() {
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
	 * Parameters message-text, author id, conversation id
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO remove hard coding
		PreparedStatement proc;
		 try {
			proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"newMessage\"(?,?,?);");
			proc.setString(1,request.getParameter("text"));
			proc.setLong(2,Long.parseLong(request.getSession().getAttribute("erpId").toString()));
			proc.setInt(3,67);
			
			//System.out.println(proc.toString());
			 proc.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
