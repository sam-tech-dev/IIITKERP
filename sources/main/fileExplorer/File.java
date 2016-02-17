/**
 * 
 */
package fileExplorer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
/**
 * @author Shubhi
 *
 */
public class File {
	public static String readFile(String filename){
		String config="";
		try{
			//InputStream conf=Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
			//InputStream conf = null;
			//InputStreamReader i=new InputStreamReader(conf,"C:\\Users\\Shubhi\\Desktop\\IIITKERP\\iiitk-erp\\"+filename);
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Shubhi\\Desktop\\IIITKERP\\iiitk-erp\\"+filename));
			String read=null;
			StringBuffer sb=new StringBuffer();
			while((read=br.readLine())!=null ){sb.append(read);}
			config=sb.toString();
//			i.close();
//			conf.close();
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return config;


	}

	public static void writeFile(String text,String location){
		
	    FileOutputStream out = null;
	    StringReader data=null;
	    try {
	    	 data=new StringReader(text);
	      
	       out = new FileOutputStream(location);
	       
	       int c;
	       while ((c = data.read()) != -1) {
	          out.write(c);
	       }
	    }
	       catch (Exception e){
	    	   e.printStackTrace();
	       }
	    finally {
	       if (data != null) {
	          try {
				data.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	       }
	       if (out != null) {
	          try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	       }
	    }
		
	}
}
