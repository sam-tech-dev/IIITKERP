package actions.notifications;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import postgreSQLDatabase.notifications.Notifications;
import settings.database.PostgreSQLConnection;

/**
 * Servlet implementation class sendGroupNotification
 */
public class sendGroupNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendGroupNotification() {
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
		
		PreparedStatement proc;
		Notifications notif=new Notifications();
		 try {
			 notif.setType(request.getParameter("notif_type"));
			 notif.setLink(request.getParameter("link"));
			 notif.setMessage(request.getParameter("message"));
			 notif.setAuthor(request.getParameter("notif_author"));
			SimpleDateFormat date_format = new SimpleDateFormat("mm-dd-yyyy hh:MM:ss.SSSSSS");
			 notif.setTimestamp(new java.sql.Date(date_format.parse(request.getParameter("notif_timestamp")).getTime()));
			 notif.setExpiry(new java.sql.Date(date_format.parse(request.getParameter("expiry")).getTime()));
			 String [] users_id=request.getParameter("users_id").split(",");
			 ArrayList<Long> users_id_array=new ArrayList<Long>();
			 for(String user:users_id){
				 users_id_array.add(Long.parseLong(user));
			 }
			 System.out.println(notif.getMessage()+notif.getAuthor());
			 postgreSQLDatabase.notifications.Query.addGroupNotification(notif,users_id_array);
					} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
