/**
 * 
 */
package postgreSQLDatabase.gradingModule;

/**
 * @author Dilip
 *
 */
public class Grade {

	
	private String course_code;
	private String student_name;
	private String student_grade;
	
	private String student_id;
	/**
	 * @return the student_id
	 */
	public String getStudent_id() {
		return student_id;
	}
	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	/**
	 * @return the course_id
	 */
	public String getCourse_code() {
		return course_code;
	}
	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}
	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	/**
	 * @return the student_grade
	 */
	public String getStudent_grade() {
		return student_grade;
	}
	/**
	 * @param student_grade the student_grade to set
	 */
	public void setStudent_grade(String student_grade) {
		this.student_grade = student_grade;
	}

	
}
