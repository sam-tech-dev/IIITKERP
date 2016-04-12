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
	int id;
	String payment_method;

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
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the payment_mthod
	 */
	public String getPayment_mthod() {
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
		case 1:
			this.payment_method = "DD";
			break;
		case 2:
			this.payment_method = "NET BANKING";
			break;
		case 3:
			this.payment_method = "NEFT";
			break;
		}
		this.payment_method = payment_method;
	}

}
