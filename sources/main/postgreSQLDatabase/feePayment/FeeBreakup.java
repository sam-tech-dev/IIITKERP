/**
 * 
 */
package postgreSQLDatabase.feePayment;

import org.json.JSONArray;

/**
 * @author manisha pc
 *
 */
public class FeeBreakup {
	private Integer semester;
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * @return the breakup
	 */
	public JSONArray getBreakup() {
		return breakup;
	}
	/**
	 * @param breakup the breakup to set
	 */
	public void setBreakup(JSONArray breakup) {
		this.breakup = breakup;
	}
	/**
	 * @return the total_amt
	 */
	public Integer getTotal_amt() {
		return total_amt;
	}
	/**
	 * @param total_amt the total_amt to set
	 */
	public void setTotal_amt(Integer total_amt) {
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
	private Integer year;
	private JSONArray breakup;
	private Integer total_amt;
	private String category;

	
}

