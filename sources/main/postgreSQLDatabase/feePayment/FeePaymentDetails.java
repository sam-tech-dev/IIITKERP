/**
 * 
 */
package postgreSQLDatabase.feePayment;

/**
 * @author manisha pc
 *
 */
public class FeePaymentDetails {
	String name;
	long id;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	String payment_method;
	String details;

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the payment_mthod
	 */
	public String getPayment_method() {
		return payment_method;
	}

	/**
	 * @param payment_mthod
	 *            the payment_mthod to set
	 */
	public void setPayment_method(int payment_method_code) {
		switch (payment_method_code) {
		case 0:
			this.payment_method = "CASH";
			break;
		case 5:
			this.payment_method = "DEMAND DRAFT";
			break;
		case 2:
			this.payment_method = "CHALLAN";
			break;
		case 3:
			this.payment_method = "NEFT";
			break;
		}
		//this.payment_method = payment_method;
	}

}
