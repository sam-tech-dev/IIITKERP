/**
 * 
 */
package exceptions;

/**
 * @author Megha
 *
 */
public class ConfigException extends Exception {
	private static final long serialVersionUID = -640204991518160295L;

	public ConfigException(String exception_message){
		super(exception_message);
        System.out.println(exception_message);		
	}

}
