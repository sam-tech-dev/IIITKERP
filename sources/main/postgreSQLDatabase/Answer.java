package postgreSQLDatabase;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class Answer {
private	int id,question_id;
private		ArrayList<String> answer;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public ArrayList<String> getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		JSONArray answer_array;
		try {
			answer_array = new JSONArray(answer);
			this.answer=new ArrayList<String>();
		    for(int i=0;i<answer_array.length();i++)
		    {
		    	this.answer.add(answer_array.getString(i));
		    }
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		
	}

}
