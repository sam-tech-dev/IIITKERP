/**
 * 
 */
package actions.chats;

import java.util.ArrayList;

/**
 * @author Shubhi
 *
 */
public class Conversation {
private String chat_name;
private Long conversation_id;
private ArrayList<String> members;
public String getChat_name() {
	return chat_name;
}
public void setChat_name(String chat_name) {
	this.chat_name = chat_name;
}
public ArrayList<String> getMembers() {
	return members;
}
public void setMembers(ArrayList<String> members) {
	this.members = members;
}
/**
 * @return the conversation_id
 */
public Long getConversation_id() {
	return conversation_id;
}
/**
 * @param conversation_id the conversation_id to set
 */
public void setConversation_id(Long conversation_id) {
	this.conversation_id = conversation_id;
}

}
