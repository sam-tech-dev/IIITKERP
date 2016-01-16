package fileExplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;

import settings.Execution;

/**
 * @author Anshula  
 *  @version 1.0
 */
public class FileExplorer {
static boolean debug_mode=false;

	/**
	 * @param dirName Directory To Be Deleted
	 * 
	 * 			SubDirectories also deleted
	 */

	public static void deleteDirectory(String dirName)
	{

		File directory = new File(dirName);
		if(!directory.exists()){
			if(Execution.debugMode)   System.out.println("Directory does not exist.");
			System.exit(0);
		}
		else{
			if(directory.isDirectory()){
				//directory is empty, then delete it
				if(directory.list().length==0){
					directory.delete();
					if(Execution.debugMode)	   System.out.println("Directory is deleted : " + directory.getAbsolutePath());
				}
				else {
					//list all the directory contents
					String files[] = directory.list();
					for (String temp : files) {
						File fileDelete = new File(directory, temp);
						if(fileDelete.isFile())
							fileDelete.delete();
						else
							if(fileDelete.isDirectory())
								deleteDirectory(dirName+"\\"+temp);
					}
					if(directory.list().length==0){
						directory.delete();
						if(Execution.debugMode)    	   System.out.println("Directory is deleted : " + directory.getAbsolutePath());
					}
				}

			}else{
				//if file, then delete it
				directory.delete();
				if(Execution.debugMode)	System.out.println("File is deleted : " + directory.getAbsolutePath());
			}
		}
	}



	/**
	 * @param fileNames Array to be deleted
	 * @return 
	 */
	public static boolean deleteFiles(String [] fileNames)
	{
		boolean fileFlag=false;
		for (int i = 0; i < fileNames.length; i++) {
			File fileDelete=new File(fileNames[i]);
			if (fileDelete.exists()) {
				try{
					fileFlag=fileDelete.delete();
				}
				catch (Exception e){
					if(Execution.debugMode)	System.out.println("File "+fileDelete.getName()+"could not be deleted.");
				}
				if(Execution.debugMode)	System.out.println("File "+fileDelete.getName()+" deleted.");
			}
			else{
				if(Execution.debugMode) {
					System.out.println("File "+fileDelete.getName()+" does not exist");
					break;
				}
			}
		}
		return fileFlag;
	}
	/**
	 * @param fileName to be deleted
	 * @return 
	 */
	public static boolean deleteFile(String fileName)
	{
		boolean fileFlag=false;

		File fileDelete=new File(fileName);
		if (fileDelete.exists()) {
			fileFlag=fileDelete.delete();
			if(Execution.debugMode)	System.out.println("File deleted.");
		}
		else{
			if(Execution.debugMode) System.out.println("File does not exist");
		}

		return fileFlag;
	}
	public static ArrayList<FileSystemObject> getDirectoryContents(String dirPath){    
		File dirParent = new File(dirPath);
		ArrayList<FileSystemObject> list=new ArrayList<FileSystemObject>();

		String[] dirFiles = dirParent.list();
		if (dirFiles.length == 0) {
			if(Execution.debugMode) System.out.println("The directory is empty");
		} 
		else {
			for (String dFile : dirFiles) {
				list.add(getBasicFileAttr(dirPath+"\\"+dFile));


			}
		}
		return list;
	}
	public static FileSystemObject getBasicFileAttr(String fileAttr){
		FileSystemObject object=new FileSystemObject();

		File dirFile= new File(fileAttr);

		Path file = Paths.get(fileAttr);
		object.setFile_path(dirFile.getAbsolutePath());
		BasicFileAttributes attr=null;
		try {
			attr = Files.readAttributes(file, BasicFileAttributes.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object.setCreated(attr.creationTime());
		object.setModified(attr.lastModifiedTime());
		object.setSize(attr.size());
		try {
			object.setFile_type(Files.probeContentType(dirFile.toPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		object.setFile_name(dirFile.getName());
		if(Execution.debugMode){
			System.out.print(object.getFile_path());
			System.out.print(object.getFile_type());
			System.out.print(object.getFile_name());
			System.out.print(object.getCreated());
			System.out.print(object.getModified());
			System.out.println(object.getSize());
		}
		return object;
	}
	public static boolean createDirectory(String dirName)
	{
		boolean dirFlag = false;
		File dirNew=new File(dirName);
		//if the directory does not exist, create it
		if (!dirNew.exists()) {
			try {
				dirNew.mkdir();
				dirFlag = true;
				if(Execution.debugMode) System.out.println("Directory created.");
			} 
			catch(SecurityException se){
				se.printStackTrace();
			}        
		}
		else {
			if(Execution.debugMode) System.out.println("Directory Already Exists.");
		}
		return dirFlag; 
	}


	public static boolean moveFile(String oldLocation,String newLocation){
		boolean movFlag=false;
		File oldFile=new File(oldLocation);
		File newFile=new File(newLocation);
		if(oldFile.exists()){
			movFlag=oldFile.renameTo(newFile);
			oldFile.delete();
		}
		return movFlag;
	}

	public static void main(String[] args) {


	}
}  


