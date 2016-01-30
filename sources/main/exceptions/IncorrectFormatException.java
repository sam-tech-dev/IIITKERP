/**
 * 
 */
package exceptions;

/**
 * @author Dell 1
 *
 */
public class IncorrectFormatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -640204991518160295L;

	public IncorrectFormatException(String exception_message){
		super(exception_message);
        System.out.println(exception_message);		
	}
}
