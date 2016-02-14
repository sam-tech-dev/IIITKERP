/**
 * 
 */
package postgreSQLDatabase.onlineTest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Shubhi
 *
 */
public class Actions {
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
				//System.out.println(current.getJSONArray("answer").toString());
				current_question.setType(current.getString("type"));
				current_question.setAnswer(current.getJSONArray("answer").toString());
				if(!current.has("option")) current_question.setOptions("[]");
				else
					current_question.setOptions(current.getJSONArray("option").toString());
				current_question.setMarks(5);
				current_question.setQuestion(current.getString("statement"));

				Query.addQuestions(current_question,test_paper_id);
			}
			//System.out.println(test_paper_id);
			Query.getQuestion(test_paper_id);


		}
		catch(Exception e){
			e.printStackTrace();

		}

	}


}