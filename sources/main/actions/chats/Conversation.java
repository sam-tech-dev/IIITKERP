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

}
