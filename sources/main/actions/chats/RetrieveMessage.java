package actions.chats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import postgreSQLDatabase.chats.Message;
import settings.database.PostgreSQLConnection;

/**
 * Servlet implementation class RetrieveMessage
 */
@WebServlet(name="RetrieveMessage",urlPatterns={"/RetrieveMessage"})
public class RetrieveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long convo_id=Long.parseLong(request.getParameter("convo_id").toString());
		PrintWriter writer=response.getWriter();
		PreparedStatement proc = null;
		ResultSet rs = null;
		ArrayList<Message> messages=new ArrayList<Message>();
		try {
			proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"retrieveUnreadMessages\"(?);");
			proc.setLong(1,convo_id);
rs=proc.executeQuery();
			rs.next();
			String postgre=rs.getString(1);
			JSONArray jArray=new JSONArray(rs.getString(1));
			//JSONArray jArray=new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");
			for(int i=0;i<jArray.length();i++)
			{	
				//JSONArray message=new JSONArray(jArray.getString(i));

				JSONObject current_object=jArray.getJSONObject(i);


				Message current=new Message();
				current.setId(current_object.getInt("id"));
				current.setUsername(current_object.getString("username"));
				current.setText(current_object.getString("text"));
				current.setAuthor(current_object.getInt("author"));
				System.out.println(current_object.getString("timestamp"));
					current.setTime_stamp(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").parse(current_object.getString("timestamp")).getTime()));
				
				messages.add(current);
			}
			Iterator<Message> iterator = messages.iterator();
			JSONArray message_array=new JSONArray();
			JSONObject message_object;
			while(iterator.hasNext()){
				message_object = new JSONObject();
				Message current=iterator.next();
				message_object.put("id",current.getId());
				message_object.put("author",current.getAuthor());
				message_object.put("username",current.getUsername());
				message_object.put("text",current.getText());
				message_object.put("timecomp",current.getTime_stamp().getTime());
				message_object.put("timestamp",new SimpleDateFormat("hh:mm a EEE dd MMM").format(current.getTime_stamp()));
				System.out.println(current.getId()+" "+current.getUsername()+" "+current.getText()+""+current.getTime_stamp());
				//writer.write(current.getId()+" "+current.getUsername()+" "+current.getText());
				message_array.put(message_object);
			}

			
			writer.write(message_array.toString());


		} catch (Exception e) {
			writer.write("");
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		}  
	}
}
