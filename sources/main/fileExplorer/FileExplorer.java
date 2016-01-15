package fileExplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;


public class FileExplorer {
    
	//dirName: directory to be deleted
	public static void deleteDirectory(String dirName)
    {
	  
		File directory = new File(dirName);
    	  //check if directory exists
    	   if(!directory.exists()){
           System.out.println("Directory does not exist.");
           System.exit(0);
           }
    	   else{
    	   if(directory.isDirectory()){
    		//directory is empty, then delete it
    		if(directory.list().length==0){
    		   directory.delete();
    		   System.out.println("Directory is deleted : " + directory.getAbsolutePath());
    		}
    		else{
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
        	     System.out.println("Directory is deleted : " + directory.getAbsolutePath());
        	   }
    		}
    		
    	}else{
    		//if file, then delete it
    		directory.delete();
    		System.out.println("File is deleted : " + directory.getAbsolutePath());
    	}
    }
}
    


   public static boolean deleteFile(String [] fileName)
   {
      boolean fileFlag=false;
      for (int i = 0; i < fileName.length; i++) {
    	  File fileDelete=new File(fileName[i]);
          if (fileDelete.exists()) {
              fileFlag=fileDelete.delete();
              System.out.println("File deleted.");
          }
          else{
        	  System.out.println("File does not exist");
          }
	}
      return fileFlag;
   }

   public static void dirContents(String dirPath){    
    File dirParent = new File(dirPath);
    String[] dirFiles = dirParent.list();
    if (dirFiles.length == 0) {
      System.out.println("The directory is empty");
      } 
    else {
    	   for (String dFile : dirFiles) {
    		    getBasicFileAttr(dirPath+"\\"+dFile);
    		    
    	   }
         }
        
    }
   public static void getBasicFileAttr(String fileAttr){
	   File dirFile= new File(fileAttr);
	   String fileType="";
	    String fileName="";
	   Path file = Paths.get(fileAttr);
       BasicFileAttributes attr=null;
	try {
		attr = Files.readAttributes(file, BasicFileAttributes.class);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  FileTime  creationTime=attr.creationTime();
	   FileTime lastModified=attr.lastModifiedTime();
	    long fileSize=attr.size();
	    try {
			fileType=Files.probeContentType(dirFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileName=dirFile.getName();
	    System.out.println(fileType);
	    System.out.println(fileName);
	    System.out.println(creationTime);
	    System.out.println(lastModified);
	    System.out.println(fileSize);
	   
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
         System.out.println("Directory created.");
         } 
      catch(SecurityException se){
        System.out.println(se);
      }        
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
	   deleteDirectory("D:\\testing");
	   
   }
}  


