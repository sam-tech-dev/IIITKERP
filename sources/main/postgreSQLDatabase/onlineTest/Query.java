package postgreSQLDatabase.onlineTest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		proc.setString(3,paper.getAuthor().toString());
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
	public static void addNewAnswerSheet(AnswerSheet sheet) throws SQLException{
		PreparedStatement proc =PostgreSQLConnection.getConnection().prepareStatement("SELECT public.\"newAnswerSheet\"(?,?,?,?,?);");
		proc.setInt(1,sheet.getTest_paper_id());
		proc.setString(2, sheet.getAuthor());
		proc.setDate(3, sheet.getSubmission_time());
		proc.setString(4, sheet.getStatus());
		proc.setArray(5,PostgreSQLConnection.getConnection().createArrayOf("integer", sheet.getAnswer().toArray()));

		proc.executeQuery();
	}


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
			//	current.setDate(current_object.getString("creation_date").toString());
				current.setQuestions(current_object.get("questions").toString());

				papers.add(current);
			}
			Iterator<TestPaper> iterator = papers.iterator();	
			while(iterator.hasNext()){
				TestPaper current=iterator.next();
				System.out.println(current.getId()+" "+current.getAuthor()+" "+current.getStatus()+" "+current.getSubject()+" "
						+current.getCreation_date()+" "+current.getQuestions());
			}

			rs.close();
			proc.close();
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return papers;
	}





}




