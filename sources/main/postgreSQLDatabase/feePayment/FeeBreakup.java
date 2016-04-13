/**
 * 
 */
package postgreSQLDatabase.feePayment;

import org.json.JSONObject;

/**
 * @author manisha pc
 *
 */
public class FeeBreakup {
	private String semester;
	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the breakup
	 */
	public JSONObject getBreakup() {
		return breakup;
	}
	/**
	 * @param breakup the breakup to set
	 */
	public void setBreakup(JSONObject breakup) {
		this.breakup = breakup;
	}
	/**
	 * @return the total_amt
	 */
	public Long getTotal_amt() {
		return total_amt;
	}
	/**
	 * @param total_amt the total_amt to set
	 */
	public void setTotal_amt(Long total_amt) {
		this.total_amt = total_amt;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	private String year;
	private JSONObject breakup;
	private Long total_amt;
	private String category;

	
}

