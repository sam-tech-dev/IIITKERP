/**
 * 
 */
package postgreSQLDatabase.notifications;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import settings.database.PostgreSQLConnection;

/**
 * @author Anshula
 *
 */
public class Query {
	
	public static void addNotification(Notifications notif,int userid){
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addNotification\"(?,?,?,?,?,?);");
			proc.setString(1,notif.getType());
			proc.setString(2,notif.getMessage());
			proc.setString(3,notif.getLink());
			proc.setDate(4,notif.getTimestamp());
			proc.setDate(5,notif.getExpiry());
			proc.setInt(6,userid);
			proc.executeQuery();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addGroupNotification(Notifications notif,ArrayList<Long> users_id){
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addGroupNotification\"(?,?,?,?,?,?,?);");
			proc.setString(1,notif.getType());
			
			proc.setString(2,notif.getMessage());
			proc.setString(3,notif.getLink());
			proc.setString(4, notif.getAuthor());
			proc.setDate(5,notif.getTimestamp());
			proc.setDate(6,notif.getExpiry());
			proc.setArray(7,PostgreSQLConnection.getConnection().createArrayOf("bigint", users_id.toArray()));
			
			proc.executeQuery();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addGroupNotification\"(?,?,?,?,?,?,?);");
	proc.setString(1,request.getParameter("notif_type"));
	proc.setString(2,request.getParameter("msg"));
	proc.setString(3,request.getParameter("link"));
	proc.setString(4,request.getParameter("notif_author"));
	proc.setTimestamp(5, request.getParameter());
	proc.setTimestamp(6, request.getParameter(arg0));
	proc.setString(7,request.getParameter(arg0))
	//current.setTimestamp(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS")
	//.parse(current_object.getString("notif_timestamp")).getTime()));
	proc.setLong(2,Long.parseLong(request.getSession().getAttribute("erpId").toString()));
	proc.setInt(3,67);
	
	
	//System.out.println(proc.toString());
	 proc.executeQuery();
	
	*/

	
	public static void markAsRead(int userid,int notif_id){
		PreparedStatement proc;
		try {
			proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"readNotification\"(?,?);");
			proc.setInt(1,userid);
			proc.setInt(2,notif_id);
			proc.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void broadcastNotification(Notifications notif,int userid[]){
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"broadcastNotification\"(?,?,?,?,?,?);");
			proc.setString(1,notif.getType());
			proc.setString(2,notif.getMessage());
			proc.setString(3,notif.getLink());
			proc.setDate(4,notif.getTimestamp());
			proc.setDate(5,notif.getExpiry());
			//proc.setArray(6,userid);
			proc.executeQuery();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
