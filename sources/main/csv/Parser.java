/**
 * 
 */
package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;
/**
 * @author Arushi
 *
 */
public class Parser {
	ArrayList<ArrayList<String>>	array;
	int r,c;
	String csvFile;
	private static final String COMMA_DELIMITER = ",";
	
	    private static final String NEW_LINE_SEPARATOR = "\n";

	public Parser(){
		array = new ArrayList<ArrayList<String>>();
	}

	public void ensureCapacity(int num)
	{
		array.ensureCapacity(num);
	}
 
	/**
	 * Ensures that the given row has at least the given capacity. Note that
	 * this method will also ensure that getNumRows() >= row
	 * 
	 * @param row
	 * @param num
	 */
	public void ensureCapacity(int row, int num)
	{
		ensureCapacity(row);
		while (row < getNumRows())
		{
			array.add(new ArrayList<String>());
		}
		array.get(row).ensureCapacity(num);
	}
 
	/**
	 * Adds an item at the end of the specified row. This will guarantee that at least row rows exist.
	 */
	public void Add(String data, int row)
	{
		ensureCapacity(row);
		while(row >= getNumRows())
		{
			array.add(new ArrayList<String>());
		}
		array.get(row).add(data);
	}
 
	public String get(int row, int col)
	{
		return array.get(row).get(col);
	}
 
	public void set(int row, int col, String data)
	{
		//System.out.println("array size"+array.get(row).size());
		array.get(row).set(col,data);
	}
 
	public void remove(int row, int col)
	{
		array.get(row).remove(col);
	}
 
	public boolean contains(String data)
	{
		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i).contains(data))
			{
				return true;
			}
		}
		return false;
	}
 
	public int getNumRows()
	{
		return array.size();
	}
 
	public int getNumCols(int row)
	{
		return array.get(row).size();
	}
	
	public static void main(String args[]){
		Parser obj=new Parser();
		obj.run(new Parser().csvFile);
	}
	
	public void printList(){
		int rows=getNumRows();
		
		for(int i=0;i<rows;i++)
		for(int j=0;j<getNumCols(i);j++)
			System.out.print(get(i,j));
		System.out.println("\n");
	}
	
	public int checkAndAddColumn(String colName) throws IOException{
		
		for(int i=0;i<getNumCols(0);i++){
			if(colName.equals(get(0,i))){
				return i;
			}
			//System.out.println(get(2,i));
			
		}
		//CSVFunctions obj1=new CSVFunctions();
		Add(colName,0);
		
		write(csvFile,-1);
			return 0;
	}
	
	public void run(String csvfile) {

		//String csvFile = "c1.csv";
		csvFile=csvfile;
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {
             
			try {
				br = new BufferedReader(new FileReader(csvFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r=0;
			
			try {
				while ((line = br.readLine()) != null) {

				        // use comma as separator
					String[] arr = line.split(csvSplitBy);
					
					//System.out.println("cols="+getNumCols(0));
					for(int i=0;i<arr.length;i++){
						//System.out.println(arr[i]);
						Add(arr[i],r);
					
					}
					r++;
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//printList();
		//set(14,5,"arushi");
		//System.out.println(get(14,5));
		//System.out.println(checkAndAddColumn("Signature"));
		//System.out.println(contains("Gender"));
		//updateCSV("c1.csv","arushi",3,1);
		//printList();
			//removeColumn("Signature");
		//removeBlankColumn();

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
	public void updateCSV(String fileToUpdate, String replace,
		    int r, int c) throws IOException {

		//System.out.println("hello");
		//Parser.FileWriter.writeFile(new CSVFunctions().array.toString(),"c1.csv");*/
		//System.out.println(get(r,c));
		set(r,c,replace);
		write(csvFile,-1);
		
		
		}
	
	public void removeBlankColumn(){
		int count=0;
		System.out.println("hello");
		for(int i=0;i<getNumCols(2);i++){
			for(int j=0;j<getNumRows();j++){
				System.out.println(get(j,i));
				/*if(get(j,i).equals("")){
					count++;
				}
				if(count==getNumRows()){
					write("c1.csv",i);
					System.out.println("removed");
				}*/
			}
		}
	}
	
	public int EmptyRows(String colName){
		int count=0;int empty=0;
		for(int i=0;i<getNumRows();i++){
			for(int j=0;j<getNumCols(i);j++){
				if(get(i,j).equals("")){count++;}
				
			}
			if(count==getNumCols(i)){empty++;}
		}
		return empty;
	}
	
	public void removeColumn(String colName){
		int c=-1;
		for(int i=0;i<getNumCols(2);i++){
			if(colName.equals(get(2,i))){
				System.out.println("found");
				c=i;break;
			}
			//System.out.println(get(2,i));
			
		}
		write(csvFile,c);
	}
	public void write(String filename,int c){
		FileWriter fileWriter = null;

	    try{
	    	
	    	fileWriter = new FileWriter(filename);
	    	if(c==-1){
	    	for(int i=0;i<getNumRows();i++){
	    		for(int j=0;j<getNumCols(i);j++){
	    			//System.out.println(get(i,j));
	    			fileWriter.append(get(i,j));
	    			fileWriter.append(COMMA_DELIMITER);
	    		}
	    		//fileWriter.append(get(i,getNumCols(i)));
	    		fileWriter.append(NEW_LINE_SEPARATOR);

	    	}
	    	 System.out.println("CSV file was created successfully !!!");
	    	}
	    	else{
	    		for(int i=0;i<getNumRows();i++){
		    		for(int j=0;j<getNumCols(i);j++){
		    			if(j==c){continue;}
		    			else{
		    			fileWriter.append(get(i,j));
		    			fileWriter.append(COMMA_DELIMITER);}
		    		}
		    		//fileWriter.append(get(i,getNumCols(i)));
		    		fileWriter.append(NEW_LINE_SEPARATOR);

		    	}
		    	 System.out.println("CSV file was created successfully !!!");
	    	}
	    	
	    }
	    catch (Exception e) {
	    	
	    	            System.out.println("Error in CsvFileWriter !!!");
	    	
	    	            e.printStackTrace();
	    	
	    	        } 
	    finally {
	    	            try {
	    	            	fileWriter.flush();
	    	            	fileWriter.close();
	    	            } catch (IOException e) {
	    	            	System.out.println("Error while flushing/closing fileWriter !!!");
	    	
	    	                e.printStackTrace();
	    	
	    	            }
	    	    }
}
	
	
}
