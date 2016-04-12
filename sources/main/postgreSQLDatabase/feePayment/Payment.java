/**
 * 
 */
package postgreSQLDatabase.feePayment;

import java.util.ArrayList;

import org.json.JSONObject;

/**
 * @author Shubhi
 *
 */
public class Payment {
	private int ref_no;
	private String comment;
	private JSONObject details;
	private Long amount;
	private boolean verified;
	private String payment_method;
	public int getRef_no() {
		return ref_no;
	}
	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public JSONObject getDetails() {
		return details;
	}
	public void setDetails(JSONObject details) {
		this.details = details;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(int payment_method_code) {
		switch(payment_method_code){
		case 0:
			this.payment_method="CASH";
			break;
		case 1: 
			this.payment_method="DD";
			break;
		case 2:
			this.payment_method="NET BANKING";
			break;
		case 3:
			this.payment_method="NEFT";
			break;
		case 4:
			this.payment_method="CHEQUE";
			break;
		case 5:
			this.payment_method="CHALLAN";
			break;
		}
		this.payment_method = payment_method;
	}
	
	

}
