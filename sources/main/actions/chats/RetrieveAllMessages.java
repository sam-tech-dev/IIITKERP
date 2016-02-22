package actions.chats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import postgreSQLDatabase.chats.Message;
import postgreSQLDatabase.onlineTest.Answer;
import postgreSQLDatabase.onlineTest.Question;

/**
 * Servlet implementation class RetrieveMessage
 */
@WebServlet(name="RetrieveAllMessages",urlPatterns={"/RetrieveAllMessages"})
public class RetrieveAllMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveAllMessages() {
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
		ResultSet rs = null;
		PrintWriter writer=response.getWriter();
		PreparedStatement proc=null;
		ArrayList<Message> messages=new ArrayList<Message>();
		try {
			proc = postgreSQLDatabase.onlineTest.Query.getConnection().prepareStatement("SELECT public.\"retrieveChatMessages\"(?,?,?);");
			proc.setInt(1,66);
			proc.setInt(2,0);
			proc.setInt(3,1000);
			

			 rs=proc.executeQuery();
			rs.next();
			String postgre=rs.getString(1);
          System.out.println(rs.getString(1));
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
				//System.out.println(current.getId()+" "+current.getUsername()+" "+current.getText()+""+current.getTime_stamp());
				//writer.write(current.getId()+" "+current.getUsername()+" "+current.getText());
				message_array.put(message_object);
			}
    
			rs.close();
			proc.close();
writer.write(message_array.toString());


		} catch (SQLException e) {
			writer.write("");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			try {
				if(rs!=null)rs.close();
				if(proc!=null)proc.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			writer.write("");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
