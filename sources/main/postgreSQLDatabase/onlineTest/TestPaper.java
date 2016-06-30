package postgreSQLDatabase.onlineTest;
import java.sql.Date;
import java.sql.Time;
//import java.time.Duration;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class TestPaper {
private String subject,status,question_file;
private ArrayList<Integer> questions;
private long author_id;
private String author;
int id;
private Date creation_date;
private Time duration;
public Time getDuration() {
	return duration;
}
public void setDuration(Time duration) {
	this.duration = duration;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public ArrayList<Integer> getQuestions() {
	return questions;
}
public void setQuestions(String questions) {
	JSONArray questions_array;
	try {
		questions_array = new JSONArray(questions);
		this.questions=new ArrayList<Integer>();
	    for(int i=0;i<questions_array.length();i++)
	    {
	    	this.questions.add(questions_array.getInt(i));
	    }
	    
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getCreation_date() {
	return creation_date;
}
public void setCreation_date(Date creation_date) {
	this.creation_date = creation_date;
}
/**
 * @return the question_file
 */
public String getQuestion_file() {
	return question_file;
}
/**
 * @param question_file the question_file to set
 */
public void setQuestion_file(String question_file) {
	this.question_file = question_file;
}
/**
 * @return the author_id
 */
public long getAuthor_id() {
	return author_id;
}
/**
 * @param author_id the author_id to set
 */
public void setAuthor_id(long author_id) {
	this.author_id = author_id;
}

}
