/**
 * 
 */
package exceptions;

/**
 * @author Shubhi
 *
 */
public class SessionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SessionException(String exception_message){
		super(exception_message);
        System.out.println(exception_message);		
	}

	
}
