/**
 * 
 */
package postgreSQLDatabase.registration;

/**
 * @author Anshula
 *
 */
public class UsernameGeneration {

	private String first;
	/**
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	/**
	 * @return the middle
	 */
	public String getMiddle() {
		return middle;
	}
	/**
	 * @param middle the middle to set
	 */
	public void setMiddle(String middle) {
		this.middle = middle;
	}
	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}
	/**
	 * @return the program_allocated
	 */
	public String getProgram_allocated() {
		return program_allocated;
	}
	/**
	 * @param program_allocated the program_allocated to set
	 */
	public void setProgram_allocated(String program_allocated) {
		this.program_allocated = program_allocated;
	}
	/**
	 * @return the birth_year
	 */
	public int getBirth_year() {
		return birth_year;
	}
	/**
	 * @param birth_year the birth_year to set
	 */
	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}
	/**
	 * @return the reg_year
	 */
	public int getReg_year() {
		return reg_year;
	}
	/**
	 * @param reg_year the reg_year to set
	 */
	public void setReg_year(int reg_year) {
		this.reg_year = reg_year;
	}
	private String middle;
	private String last;
	private String program_allocated;
	int birth_year;
	int reg_year;
	
}
