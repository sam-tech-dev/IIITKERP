package Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReadCSV {

  public static void main(String[] args) {

	ReadCSV obj = new ReadCSV();
	obj.run();

  }

  public void run() {

	
	  String csvFile = "c1.csv";
	BufferedReader br = null;
	String line = "";
	String csvSplitBy = ",";

	try {
		 
		Map<String, String> maps = new HashMap<String, String>();
		//Set<String> maps1=new HashSet<String>();
		br = new BufferedReader(new FileReader(csvFile));
		
		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] arr = line.split(csvSplitBy);
			//System.out.println("line="+arr[0]+"..."+arr[1]);
			maps.put(arr[0], arr[1]);
			//maps1.add(arr[4]);
			//Iterator<String> it=maps1.iterator();
			
		}

		//loop map
		for (Map.Entry<String, String> entry : maps.entrySet()) { //removes duplicate values

			System.out.println("Data [code= " + entry.getKey() + " , name="
				+ entry.getValue() + "]");

		}
		/*Iterator<String> it = maps1.iterator();
	     while(it.hasNext()){
	        System.out.println(it.next());
	     }*/
		
		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Done");
  }

}