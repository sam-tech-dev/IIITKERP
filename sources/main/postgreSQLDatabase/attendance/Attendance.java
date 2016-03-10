/**
 * 
 */
package postgreSQLDatabase.attendance;

/**
 * @author HP
 */
public class Attendance {
	private String student_id, student_name, admission_year;

	/**
	 * @return the student_id
	 */
	public String getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id
	 *            the student_id to set
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}

	/**
	 * @param student_name
	 *            the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	/**
	 * @return the admission_year
	 */
	public String getAdmission_year() {
		return admission_year;
	}

	/**
	 * @param admission_year
	 *            the admission_year to set
	 */
	public void setAdmission_year(String admission_year) {
		this.admission_year = admission_year;
	}

}
