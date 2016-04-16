/**
 * 
 */
package postgreSQLDatabase.onlineTest;

/**
 * @author Joey
 *
 */
public class Solution {
private Answer answer;
private Question question;
public Solution(){
	answer=new Answer();
	question=new Question();
}
/**
 * @return the answer
 */
public Answer getAnswer() {
	return answer;
}
/**
 * @param answer the answer to set
 */
public void setAnswer(Answer answer) {
	this.answer = answer;
}
/**
 * @return the question
 */
public Question getQuestion() {
	return question;
}
/**
 * @param question the question to set
 */
public void setQuestion(Question question) {
	this.question = question;
}

}
