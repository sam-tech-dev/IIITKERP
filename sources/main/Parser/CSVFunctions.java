/**
 * 
 */
package Parser;

import java.io.BufferedReader;
import java.io.File;                      
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
/**
 * @author Arushi
 *
 */
public class CSVFunctions {
	ArrayList<ArrayList<String>>	array;
	int r,c;
	CSVFunctions(){
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
		CSVFunctions obj=new CSVFunctions();
		obj.run();
	}
	
	public void printList(){
		int rows=getNumRows();
		
		for(int i=0;i<rows;i++)
		for(int j=0;j<getNumCols(i);j++)
			System.out.println(get(i,j));
	}
	
	public String checkAndAddColumn(String colName) throws IOException{
		
		for(int i=0;i<getNumCols(2);i++){
			if(colName.equals(get(2,i))){
				return "found";
			}
			//System.out.println(get(2,i));
			
		}
		//CSVFunctions obj1=new CSVFunctions();
		//Add(colName,2);
		updateCSV("c1.csv",colName,2,getNumCols(2));
		
			return"col added";
	}
	
	public void run() {

		String csvFile = "c1.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {
             
			br = new BufferedReader(new FileReader(csvFile));
			r=0;
			
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] arr = line.split(csvSplitBy);
				
				//System.out.println("cols="+getNumCols(0));
				for(int i=1;i<arr.length;i++){
					//System.out.println(arr[i]);
					Add(arr[i],r);
				
				}
				r++;
				
			}
			
		printList();
		//set(14,5,"arushi");
		//System.out.println(get(14,5));
		System.out.println(checkAndAddColumn("Gender"));
		//System.out.println(contains("Gender"));

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
	public static void updateCSV(String fileToUpdate, String replace,
		    int row, int col) throws IOException {

		File inputFile = new File(fileToUpdate);

		// Read existing file 
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		// get CSV row column  and replace with by using row and column
		csvBody.get(row)[col] = replace;
		reader.close();

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
		}
}
