/**
 * 
 */
package settings.propertySheet;

/**
 * @author Joey
 *
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

public class PropertiesFile {
  public static void main(String[] args) {
	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
	encryptor.setPassword("jasypt"); 
	Properties prop = new EncryptableProperties(encryptor);  ;
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		prop.setProperty("database", "localhost");
		prop.setProperty("dbuser", "mkyong");
		prop.setProperty("dbpassword", "password");

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}
