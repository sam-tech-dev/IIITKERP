package postgreSQLDatabase.onlineTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.*;
import java.sql.Date;

import postgreSQLDatabase.forms.Query.java;
import settings.database.PostgreSQLConnection;

/**
 * @author Megha 
 * 
 */
public class Query {

	static Connection conn ;
	
	public static void main(String[] args) {


		try {
//			Question question=new Question();
//			question.setQuestion("What's my name?");
//			question.setAnswer("[\"Sheila\"]");
//			question.setOptions("[\"Sheila\",\"Maggie\"]");
//			question.setType("MCQ");
//			question.setMarks(45);
//			//addQuestions(question,1);
//			//getQuestion(1035);
//			Answer answer=new Answer();
//			answer.setAnswer("[\"Sheila\",\"Maggie\"]");
//
//			//answer.setQuestion_id(1);
//			//addAnswer(answer,1);
//			//  getAnswer(3);
//			TestPaper paper=new TestPaper();
//			paper.setQuestions("[1,2]");
//			//paper.setDuration(null);
//			//SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			paper.setCreation_date(new Date(new java.util.Date().getTime()));
//			paper.setSubject("Maths");
//			paper.setAuthor("abewkjegc");
//			paper.setStatus("created");
//			//addNewTestPaper(paper);
//
//			AnswerSheet sheet=new AnswerSheet();
//			sheet.setAuthor("Megha");
//			sheet.setStatus("Process");
//			sheet.setSubmission_time(new Date(new java.util.Date().getTime()));
//			sheet.setAnswer("[1,2]");
//			sheet.setTest_paper_id(3);
//			//addNewAnswerSheet(sheet);


			ArrayList<Question> list = getQuestions(1);
			Iterator<Question> abc = list.iterator();
			while(abc.hasNext()){
				Question current=abc.next();
				System.out.println(current.getQuestion());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void InsertTestPaper(TestPaper paper){
		try{
        	
			int test_paper_id=Query.addNewTestPaper(paper);
			System.out.println(paper.getQuestion_file());
			JSONArray jArray=new JSONArray(paper.getQuestion_file());
			JSONObject current;
			Question current_question;
			for(int i=0;i<jArray.length();i++){
				current=(JSONObject) jArray.get(i);
				current_question=new Question();
				current_question.setType(current.getString("type"));
				current_question.setAnswer(current.getJSONArray("answer").toString());
				if(!current.has("options")) current_question.setOptions("[]");
				else
					current_question.setOptions(current.getJSONArray("options").toString());
				current_question.setMarks(5);
				current_question.setQuestion(current.getString("statement"));

				Query.addQuestions(current_question,test_paper_id);
			}
			//System.out.println(test_paper_id);
		//	Query.getQuestions(test_paper_id);


		}
		catch(Exception e){
			e.printStackTrace();
	}
	}
	public static void InsertAnswerSheet(AnswerSheet answer_sheet){
		try{
        	
			int test_paper_id=Query.addNewAnswerSheet(answer_sheet);
			
			JSONArray jArray=new JSONArray(answer_sheet.getAnswer_file());
			JSONObject current;
			Answer current_answer;
			for(int i=0;i<jArray.length();i++){
				current=(JSONObject) jArray.get(i);
				current_answer=new Answer();
				
				current_answer.setAnswer(current.getJSONArray("answer").toString());
				current_answer.setQuestion_id(current.getInt("id"));
				

				Query.addAnswer(current_answer,test_paper_id);
			}
			//System.out.println(test_paper_id);
		//	Query.getQuestions(test_paper_id);


		}
		catch(Exception e){
			e.printStackTrace();
	}
	}
	/**
	 * get questions of a particular TestPaper
	 * @param test_paper_id of testPaper to get questions
	 * @return an arrayList of questions in the specified testPaper
	 * @throws SQLException 
	 */
	public static ArrayList<Question> getQuestions(int test_paper_id) throws SQLException{
		ArrayList<Question> questions=null;
		try {
			PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getQuestions\"(?);");


			questions=new ArrayList<Question>();
			proc.setInt(1,test_paper_id);
			ResultSet rs=proc.executeQuery();
			System.out.println(proc);
			rs.next();

			JSONArray jArray=new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				Question current=new Question();
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
				System.out.println(current.getId()+" "+current.getQuestion());
			}

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return questions;
	}



	/**
	 * adds questions to the given TestPaper id
	 * @param question object of Question
	 * @param test_paper_id id of TestPaper in which question is to be added
	 * @throws SQLException
	 */
	public static void addQuestions(Question question,int test_paper_id) throws SQLException{
		PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addQuestion\"(?,?,?,?,?,?);");
		proc.setString(1,question.getQuestion().toString());
		proc.setString(2,question.getType().toString());
		System.out.println(question.getQuestion());
		proc.setArray(3, PostgreSQLConnection.getConnection().createArrayOf("text", question.getOptions().toArray()));
		proc.setArray(4, PostgreSQLConnection.getConnection().createArrayOf("text", question.getAnswer().toArray()));
		proc.setInt(5,test_paper_id);
		proc.setInt(6,question.getMarks());
		proc.executeQuery();
	}

	/**
	 * adds answer to the give AnswerSheet
	 * @param answer object of Answer
	 * @param answer_sheet_id id of the AnswerSheet in which answer is to be added
	 * @throws SQLException
	 */
	public static void addAnswer(Answer answer,int answer_sheet_id) throws SQLException{
		PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"addAnswer\"(?,?,?);");
		proc.setArray(1, PostgreSQLConnection.getConnection().createArrayOf("text", answer.getAnswer().toArray()));
		proc.setInt(2,answer_sheet_id);
		proc.setInt(3,answer.getQuestion_id());
		proc.executeQuery();
	}
	
	/**
	 * get answers of a particular AnswerSheet
	 * @param answer_sheet_id of answerSheet to get answers
	 * @return an arrayList of answers in the specified answerSheet
	 * @throws SQLException 
	 */
	public static ArrayList<Answer> getAnswer(int answer_sheet_id) throws SQLException{
		ArrayList<Answer> answers=null;
		try {
			PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getAnswer\"(?);");

			answers=new ArrayList<Answer>();
			proc.setInt(1,answer_sheet_id);
			ResultSet rs=proc.executeQuery();
			rs.next();

			JSONArray jArray=new JSONArray(rs.getString(1));

			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				Answer current=new Answer();
				current.setId(current_object.getInt("id"));
				current.setQuestion_id(current_object.getInt("question_id"));
				current.setAnswer(current_object.get("answer").toString());				
				answers.add(current);
			}
			Iterator<Answer> iterator = answers.iterator();	
			while(iterator.hasNext()){
				Answer current=iterator.next();
				System.out.println(current.getId()+" "+current.getQuestion_id()+" "+current.getAnswer());
			}

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return answers;
	}

	/** 
	 * adds a new TestPaper in the database
	 * @param paper an object of type testPaper
	 * @return 
	 * @throws SQLException
	 */
	public static int addNewTestPaper(TestPaper paper) throws SQLException{
		PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"newTestPaper\"(?,?,?,?,?);");
		proc.setArray(1, PostgreSQLConnection.getConnection().createArrayOf("integer",paper.getQuestions().toArray()));
		proc.setString(2,paper.getSubject().toString());
		proc.setLong(3,paper.getAuthor_id());
		proc.setDate(4,paper.getCreation_date());
		proc.setString(5, paper.getStatus().toString());
		System.out.println(proc.toString());
		ResultSet rs = proc.executeQuery();
		rs.next();
		return rs.getInt("newTestPaper");
	}


	/**
	 * adds a new AnswerSheet to the database
	 * @param sheet an object of type AnswerSheet
	 * @throws SQLException
	 */
	public static int addNewAnswerSheet(AnswerSheet sheet) throws SQLException{
		PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"newAnswerSheet\"(?,?,?,?,?);");
		proc.setInt(1,sheet.getTest_paper_id());
		proc.setLong(2, sheet.getAuthor_id());
		proc.setDate(3, sheet.getSubmission_time());
		proc.setString(4, sheet.getStatus());
		proc.setArray(5,PostgreSQLConnection.getConnection().createArrayOf("integer", sheet.getAnswer().toArray()));

		ResultSet rs=proc.executeQuery();
		rs.next();
		return rs.getInt(1);
	}


	@SuppressWarnings("deprecation")
	public static ArrayList<TestPaper> getTestPaper() throws SQLException{
		ArrayList<TestPaper> papers=null;
		try {
			 PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getTestPaper\"();");
			papers=new ArrayList<TestPaper>();
			//proc.setInt(1,test_paper_id);
			ResultSet rs = proc.executeQuery();
			//System.out.println(proc);
			rs.next();

			JSONArray jArray=new JSONArray(rs.getString(1));
            // System.out.println(rs.getString(1));
			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				TestPaper current=new TestPaper();
				current.id = current_object.getInt("id");
				current.setSubject(current_object.getString("subject"));
				current.setAuthor(current_object.getString("author"));
				current.setStatus(current_object.getString("status"));
				current.setCreation_date((new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(current_object.getString("creation_date").toString()).getTime())));
				

				current.setDuration(new Time(new SimpleDateFormat("HH:mm:ss").parse(current_object.getString("duration").toString()).getHours(), new SimpleDateFormat("HH:mm:ss").parse(current_object.getString("duration").toString()).getMinutes(),new SimpleDateFormat("HH:mm:ss").parse(current_object.getString("duration").toString()).getSeconds()));
				current.setQuestions(current_object.get("questions").toString());

				papers.add(current);
			}
			

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return papers;
	}

	public static ArrayList<AnswerSheet> getAnswerSheets(int test_paper_id) throws SQLException{
		ArrayList<AnswerSheet> submissions=null;
		try {
			 PreparedStatement proc = PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"getAnswerSheet\"(?);");
			 submissions=new ArrayList<AnswerSheet>();
			proc.setInt(1,test_paper_id);
			ResultSet rs = proc.executeQuery();
			//System.out.println(proc);
			rs.next();
			if(rs.getString(1)!=null){
			JSONArray jArray=new JSONArray(rs.getString(1));
            // System.out.println(rs.getString(1));
			for(int i=0;i<jArray.length();i++)
			{
				JSONObject current_object=jArray.getJSONObject(i);
				AnswerSheet current=new AnswerSheet();
				current.setId(current_object.getInt("id"));
				current.setAuthor(current_object.getString("author"));
				current.setStatus(current_object.getString("status"));
				current.setSubmission_time((new Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(current_object.getString("submission_time").toString()).getTime())));
				
				submissions.add(current);
			}
			
			}
			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return submissions;
	}

	

public static ArrayList<Solution> getSolutionSheet(int answer_sheet_id) throws SQLException{
	ArrayList<Solution> list=new ArrayList<Solution>();
    PreparedStatement proc=PostgreSQLConnection.getConnection().prepareStatement("SELECT \"getSolutionSheet\"(?)");
	proc.setInt(1, answer_sheet_id);
	ResultSet rs=proc.executeQuery();
	rs.next();
	JSONArray j_array=new JSONArray(rs.getString(1));
	for(int i=0;i<j_array.length();i++){
		JSONObject j_object=j_array.getJSONObject(i);
		Solution current=new Solution();
		current.getQuestion().setId(j_object.getInt("question_id"));
		current.getQuestion().setMarks(j_object.getInt("marks"));
		current.getQuestion().setQuestion(j_object.getString("question"));
		current.getQuestion().setType(j_object.getString("type"));
		current.getQuestion().setOptions(j_object.getJSONArray("options").toString());
		current.getQuestion().setAnswer(j_object.getJSONArray("correct_answer").toString());
		current.getAnswer().setAnswer(j_object.getJSONArray("given_answer").toString());
		current.getAnswer().setId(j_object.getInt("answer_id"));
		list.add(current);
	}
    return list;
}


}




