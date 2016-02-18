package Parser;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class FileWriter {

public static String readFile(String filename) {
	String config = "";
	 
	try {
    	 
    	InputStream conf = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    	InputStreamReader i=new InputStreamReader(conf);
    	BufferedReader br=new BufferedReader(i);
    	String read = null;
    	StringBuffer sb = new StringBuffer(); 
    	while((read = br.readLine()) != null) { sb.append(read); } 
    	config = sb.toString();
        i.close();
        conf.close();
        br.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
    
    		
    return config;
}
public static String writeFile(String text,String location){
	
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
	return location;
	
}

}
