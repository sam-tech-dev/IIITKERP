package postgreSQLDatabase.onlineTest;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class AnswerSheet {
private	int test_paper_id,id;
private	String status;
private String author;
private Long author_id;
private String answer_file;
private	ArrayList<Integer> answer;
private Long total_marks;
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
	public void setAuthor(String string) {
		this.author = string;
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
	/**
	 * @return the answer_file
	 */
	public String getAnswer_file() {
		return answer_file;
	}
	/**
	 * @param answer_file the answer_file to set
	 */
	public void setAnswer_file(String answer_file) {
		this.answer_file = answer_file;
	}
	/**
	 * @return the author_id
	 */
	public Long getAuthor_id() {
		return author_id;
	}
	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	/**
	 * @return the total_marks
	 */
	public Long getTotal_marks() {
		return total_marks;
	}
	/**
	 * @param total_marks the total_marks to set
	 */
	public void setTotal_marks(Long total_marks) {
		this.total_marks = total_marks;
	}

}
