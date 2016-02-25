/**
 * 
 */
package postgreSQLDatabase.notifications;

import java.sql.Date;

/**
 * @author Anshula
 *
 */
public class Notifications {
private int id;
private String type;
private String message;
private String link;
private Date timestamp;
private Date expiry;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the type
 */
public String getType() {
	return type;
}
/**
 * @param type the type to set
 */
public void setType(String type) {
	this.type = type;
}
/**
 * @return the message
 */
public String getMessage() {
	return message;
}
/**
 * @param message the message to set
 */
public void setMessage(String message) {
	this.message = message;
}
/**
 * @return the link
 */
public String getLink() {
	return link;
}
/**
 * @param link the link to set
 */
public void setLink(String link) {
	this.link = link;
}
/**
 * @return the timestamp
 */
public Date getTimestamp() {
	return timestamp;
}
/**
 * @param timestamp the timestamp to set
 */
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
/**
 * @return the expiry
 */
public Date getExpiry() {
	return expiry;
}
/**
 * @param expiry the expiry to set
 */
public void setExpiry(Date expiry) {
	this.expiry = expiry;
}

}
