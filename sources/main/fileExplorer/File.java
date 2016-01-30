/**
 * 
 */
package fileExplorer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Shubhi
 *
 */
public class File {
	public static String readFile(String filename){
		String config="";
		try{
			InputStream conf=Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
			InputStreamReader i=new InputStreamReader(conf);
			BufferedReader br=new BufferedReader(i);
			String read=null;
			StringBuffer sb=new StringBuffer();
			while((read=br.readLine())!=null ){sb.append(read);}
			config=sb.toString();
			i.close();
			conf.close();
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return config;


	}

}
