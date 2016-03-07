/**
 * 
 */
package postgreSQLDatabase.notifications;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
