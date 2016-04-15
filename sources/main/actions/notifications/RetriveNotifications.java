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
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import postgreSQLDatabase.notifications.Notifications;
import settings.database.PostgreSQLConnection;

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
		PrintWriter writer = response.getWriter();
		PreparedStatement proc;
		HttpSession session = request.getSession();
		ArrayList<Notifications> notifications = new ArrayList<Notifications>();
		try {
			proc = PostgreSQLConnection.getConnection()
					.prepareStatement("SELECT public.\"getUnreadNotifications\"(?);");
			proc.setLong(1, Long.parseLong(session.getAttribute("erpId").toString()));
			ResultSet rs = proc.executeQuery();
			rs.next();
			String postgre = rs.getString(1);
			//System.out.println(rs.getString(1));
		if(rs.getString(1)!=null)
			{JSONArray jArray = new JSONArray(rs.getString(1));

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject current_object = jArray.getJSONObject(i);
				Notifications current = new Notifications();
				current.setId(current_object.getInt("notif_id"));
				current.setType(current_object.getString("notif_type"));
				current.setMessage(current_object.getString("message"));
				current.setLink(current_object.getString("link"));
				// System.out.println("time="+current_object.getString("notif_timestamp"));
				try {
					current.setTimestamp(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
							.parse(current_object.getString("notif_timestamp")).getTime()));
					current.setExpiry(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
							.parse(current_object.getString("expiry")).getTime()));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				notifications.add(current);
			}
			Iterator<Notifications> iterator = notifications.iterator();

			JSONArray notifications_array = new JSONArray();
			JSONObject notifications_object;
			while (iterator.hasNext()) {
				notifications_object = new JSONObject();
				Notifications current = iterator.next();
				notifications_object.put("notif_id", current.getId());
				notifications_object.put("type", current.getType());
				notifications_object.put("message", current.getMessage());
				notifications_object.put("link", current.getLink());
				notifications_object.put("timestamp",
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current.getTimestamp()));
				notifications_object.put("expiry",
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").format(current.getExpiry()));
				// System.out.println(current.getId()+"
				// "+current.getUsername()+"
				// "+current.getText()+""+current.getTime_stamp());
				// writer.write(current.getId()+" "+current.getUsername()+"
				// "+current.getText());
				notifications_array.put(notifications_object);
			}

			rs.close();
			proc.close();
			//System.out.println(notifications_array.toString());
			writer.write(notifications_array.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

	}
}