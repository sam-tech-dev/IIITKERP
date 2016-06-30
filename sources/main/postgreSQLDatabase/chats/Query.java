/**
 * 
 */
package postgreSQLDatabase.chats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Shubhi
 *
 */
public class Query {
	static Connection conn ;

	public static Connection getConnection() {

		if(conn==null){
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn = DriverManager
						.getConnection("jdbc:postgresql://172.16.1.231:5432/iiitk",
								"developer", "developer");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void getAllUnreadMessages(long user_id){



		PreparedStatement proc;
		ArrayList<Message> history_info=new ArrayList<Message>();
		try {
			proc = getConnection().prepareStatement("SELECT public.\"getAllUnreadMessages\"(?);");


			proc.setObject(1, user_id);
			ResultSet rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();
			String postgre=rs.getString(1);
			//System.out.println(postgre);
			System.out.println("["+postgre.substring(1,postgre.length()-1)+"]");
			//JSONArray jArray=new JSONArray(rs.getString(1));
			JSONArray jArray = new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");
			//System.out.println("["+postgre.substring(1,postgre.length()-1)+"]");
			for(int i=0;i<jArray.length();i++)
			{	
				JSONObject  message_obj=new JSONObject(jArray.getString(i));
				int convo_id=message_obj.getInt("convo_id");
				JSONArray msgs_jarray=message_obj.getJSONArray("msg_info");
				ArrayList<Message> alist_msgs = new ArrayList<Message>();
				Message current=new Message();
				for(int j=0;i<msgs_jarray.length();j++){
					JSONObject msg_jobj=msgs_jarray.getJSONObject(j);
					current.setId(msg_jobj.getInt("id"));
					current.setAuthor(msg_jobj.getInt("author"));
					current.setUsername(msg_jobj.getString("username"));
					current.setText(msg_jobj.getString("text"));

					current.setTime_stamp(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").parse(msg_jobj.getString("timestamp")).getTime()));
					alist_msgs.add(current);
				}
				System.out.println(convo_id+" "+current);
			}



			rs.close();
			proc.close();
			//writer.write(message_array.toString());
		} catch (JSONException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	return history_info; 
	}
	public static void main(String[] args) {

		getAllUnreadMessages(4);

	}
}


