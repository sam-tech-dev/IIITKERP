package actions.notifications;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import postgreSQLDatabase.notifications.Notifications;

/**
 * Servlet implementation class RetriveNotifications
 */
public class RetriveNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveNotifications() {
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
		PreparedStatement proc;
		ArrayList<Notifications> Notificationss=new ArrayList<Notifications>();
		try {
			proc = postgreSQLDatabase.onlineTest.Query.getConnection().prepareStatement("SELECT public.\"getUnreadNotificationss\"(?);");
			proc.setInt(1,1);

			ResultSet rs=proc.executeQuery();
			rs.next();
			String postgre=rs.getString(1);


			JSONArray jArray=new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");
			for(int i=0;i<jArray.length();i++)
			{	
				JSONArray Notifications=new JSONArray(jArray.getString(i));

				JSONObject current_object=Notifications.getJSONObject(0);


				Notifications current=new Notifications();
				current.setId(current_object.getInt("notif_id"));
				current.setType(current_object.getString("notif_type"));
				current.setMessage(current_object.getString("message"));
				System.out.println(current_object.getString("timestamp"));
				try {
					current.setTimestamp(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").parse(current_object.getString("notif_timestamp")).getTime()));
					current.setExpiry(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").parse(current_object.getString("expiry")).getTime()));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Notificationss.add(current);
			}
			Iterator<Notifications> iterator = Notificationss.iterator();
			PrintWriter writer=response.getWriter();
			JSONArray Notifications_array=new JSONArray();
			JSONObject Notifications_object;
			while(iterator.hasNext()){
				Notifications_object = new JSONObject();
				Notifications current=iterator.next();
				Notifications_object.put("id",current.getId());
				Notifications_object.put("type",current.getType());
				Notifications_object.put("message",current.getMessage());
				Notifications_object.put("link",current.getLink());
				Notifications_object.put("timestamp",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").format(current.getTimestamp()));
				Notifications_object.put("expiry",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").format(current.getExpiry()));
				//System.out.println(current.getId()+" "+current.getUsername()+" "+current.getText()+""+current.getTime_stamp());
				//writer.write(current.getId()+" "+current.getUsername()+" "+current.getText());
				Notifications_array.put(Notifications_object);
			}
    
			rs.close();
			proc.close();
writer.write(Notifications_array.toString());


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}