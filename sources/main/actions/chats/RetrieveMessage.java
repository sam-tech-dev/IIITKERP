package actions.chats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import postgreSQLDatabase.onlineTest.Answer;
import postgreSQLDatabase.onlineTest.Question;

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
		
			PreparedStatement proc;
			ArrayList<Message> messages=new ArrayList<Message>();
			try {
				proc = postgreSQLDatabase.onlineTest.Query.getConnection().prepareStatement("SELECT public.\"getAllConversationMessages\"(?);");
				proc.setInt(1,66);
			
				ResultSet rs=proc.executeQuery();
				rs.next();
				String postgre=rs.getString(1);
				
                
				JSONArray jArray=new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");
		
				
				for(int i=0;i<jArray.length();i++)
				{	
					JSONArray message=new JSONArray(jArray.getString(i));
					
					JSONObject current_object=message.getJSONObject(0);
					
						
					Message current=new Message();
					current.setId(current_object.getInt("id"));
					current.setAuthor(current_object.getInt("author"));
					current.setText(current_object.getString("text"));
					//current.setTime_stamp(current_object.get("time_stamp")));
					messages.add(current);
				}
				Iterator<Message> iterator = messages.iterator();
				PrintWriter writer=response.getWriter();
				while(iterator.hasNext()){
					Message current=iterator.next();
					System.out.println(current.getId()+" "+current.getAuthor()+" "+current.getText());
					writer.write(current.getId()+" "+current.getAuthor()+" "+current.getText());
				}

				rs.close();
				proc.close();
			
		
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
