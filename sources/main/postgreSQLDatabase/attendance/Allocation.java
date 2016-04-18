/**
 * 
 */
package postgreSQLDatabase.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author HP
 */
public class Allocation {
	private String course_code;
	private int semester;
	private java.sql.Date date;

	/**
	 * @return the date
	 */
	public String getDate() {
		java.util.Date temp_date=new java.util.Date(this.date.getTime());
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").format(temp_date);
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		
		try {
			this.date =  new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS").parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the course_code
	 */
	public String getCourse_code() {
		return course_code;
	}

	/**
	 * @param course_code
	 *            the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
