/**
 * 
 */
package postgreSQLDatabase.chats;

import java.sql.Date;

/**
 * @author Megha
 *
 */
public class Message {
private String username;
private long id;
private long author;
private String text;
private Date time_stamp;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getAuthor() {
	return author;
}
public void setAuthor(int author) {
	this.author = author;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public Date getTime_stamp() {
	return time_stamp;
}
public void setTime_stamp(Date time_stamp) {
	this.time_stamp = time_stamp;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
}
