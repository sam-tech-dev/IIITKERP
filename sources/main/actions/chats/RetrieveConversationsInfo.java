package actions.chats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class RetrieveConversationsInfo
 */
public class RetrieveConversationsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveConversationsInfo() {
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
		ResultSet rs=null;
		PreparedStatement proc = null;
		PrintWriter writer=response.getWriter();
		try {
			String user_id=request.getParameter("user_id");
			
			proc = Query.getConnection().prepareStatement("SELECT public.\"getCoversationsInfo\"(?);");
			proc.setInt(1,Integer.parseInt(user_id));
			 rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();
			String postgre=rs.getString(1);
			
			JSONArray jArray=new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");
		    ArrayList<Conversation> convos=new ArrayList<Conversation>();
			for(int i=0;i<jArray.length();i++)
			{
				JSONArray current_array=new JSONArray(jArray.getString(i));
				//System.out.println(current_array);
			for(int j=0;j<current_array.length();j++)	{
				JSONObject current_object=current_array.getJSONObject(j);
				Conversation convo=new Conversation();
				convo.setChat_name(current_object.getString("chatname"));
				
				JSONArray j_array=current_object.getJSONArray("member_list");
				ArrayList<String> members=new ArrayList<String>();
				for(i=0;i<j_array.length();i++){
			       members.add(j_array.getString(i));
				}
				convo.setMembers(members);
				convos.add(convo);
			}
			JSONArray convo_array=new JSONArray();
			Iterator<Conversation>convo_iterator=convos.iterator();
			while(convo_iterator.hasNext()){
				Conversation current=convo_iterator.next();
				JSONObject convo_object=new JSONObject();
				convo_object.put("chat_name",current.getChat_name());
				ArrayList<String>members=current.getMembers();
				JSONArray members_array=new JSONArray();
				Iterator<String> members_iterator = members.iterator();
				while(members_iterator.hasNext()){
					members_array.put(members_iterator.next());
				}
				convo_object.put("members", members_array);
				convo_array.put(convo_object);
			}
			//System.out.println(convos.toString());	
				writer.write(convo_array.toString());

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			proc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
		
		
	}


