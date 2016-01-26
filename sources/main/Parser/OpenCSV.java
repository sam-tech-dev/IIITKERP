package Parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class OpenCSV {
	
	public static void main(String args[]){
		String filename="c1.csv";
		OpenCSV obj=new OpenCSV();
		obj.parse(filename);
	}
	private void parse(String filename){
		CSVReader reader;
		try{
			reader=new CSVReader(new FileReader(filename));
			String row[];
			while((row=reader.readNext())!=null){
				for(int i=0;i<row.length;i++){
					System.out.println("Cell column index: " + i);
					System.out.println("Cell Value: " + row[i]);
					System.out.println("-------------");
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
