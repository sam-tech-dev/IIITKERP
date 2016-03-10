package postgreSQLDatabase.onlineTest;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class Question {
	private int id,marks;
	private String question,type;
	ArrayList<String> options,answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		question=question.replace("+", "\\+");
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	
	public void setOptions(String options) {
		JSONArray options_array;
		try {
			options_array = new JSONArray(options);
			this.options=new ArrayList<String>();
		    for(int i=0;i<options_array.length();i++)
		    {
		    	this.options.add(options_array.getString(i));
		    }
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
		    
		
//	new JSONArray();
	}
	public static void main(String[] args) {
		
	}

}




