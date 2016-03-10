/**
 * 
 */
package actions.chats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import postgreSQLDatabase.onlineTest.Question;
import settings.database.*;
/**
 * @author Shubhi
 *
 */
public class Query {

	
		
	
		
				
		public static void main(String args[]){
			PreparedStatement proc;
			try {
				proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getCoversationsInfo\"(?);");
				proc.setInt(1,2);
				ResultSet rs=proc.executeQuery();
				System.out.println(proc);
				rs.next();
				String postgre=rs.getString(1);
				JSONArray jArray=new JSONArray("["+postgre.substring(1,postgre.length()-1)+"]");

				for(int i=0;i<jArray.length();i++)
				{
					JSONArray current_array=new JSONArray(jArray.getString(i));
					//System.out.println(current_array);
				for(int j=0;j<current_array.length();j++)	{
					JSONObject current_object=current_array.getJSONObject(j);
					System.out.println(current_object.getJSONArray("member_list")+current_object.getString("chatname"));
				}
					
					
					/*Question current=new Question();
					current.setId(current_object.getInt("id"));
					current.setMarks(current_object.getInt("marks"));
					current.setType(current_object.getString("type"));
					current.setQuestion(current_object.getString("question"));
					current.setOptions(current_object.get("options").toString());
					current.setAnswer(current_object.get("answer").toString());

					questions.add(current);  
				}
				Iterator<Question> iterator = questions.iterator();	
				while(iterator.hasNext()){
					Question current=iterator.next(); 
					System.out.println(current.getId()+" "+current.getQuestion()); */
				}

				rs.close();
				proc.close();
		

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
public static ArrayList<Conversation> getConversationInfo (int user_id) throws SQLException{
	PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getCoversationsInfo\"(?);");
	proc.setInt(1,user_id);
	ResultSet rs=proc.executeQuery();
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
	
	System.out.println();	
		

	}

	rs.close();
	proc.close();
	return convos;

}
}
