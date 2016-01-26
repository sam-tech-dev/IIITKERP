package postgreSQLDatabase;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class AnswerSheet {
private	int test_paper_id,id;
private	String status,author;
private	ArrayList<Integer> answer;
private	Date submission_time;
	public int getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(int test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ArrayList<Integer> getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		//this.answer = answer;
		JSONArray answer_array;
		try {
			answer_array = new JSONArray(answer);
			this.answer=new ArrayList<Integer>();
		    for(int i=0;i<answer_array.length();i++)
		    {
		    	this.answer.add(answer_array.getInt(i));
		    }
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getSubmission_time() {
		return submission_time;
	}
	public void setSubmission_time(Date submission_time) {
		this.submission_time = submission_time;
	}
	public static void main(String[] args) {
		
	}

}
