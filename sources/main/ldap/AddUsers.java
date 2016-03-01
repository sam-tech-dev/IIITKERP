/**
 * 
 */
package ldap;

import java.io.IOException;

import csv.Parser;
import fileExplorer.File;
import ldap.SimpleLdapAuthentication;

/**
 * @author Arushi
 *
 */
public class AddUsers {
	Parser obj=new csv.Parser();
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		new AddUsers().addUser("firstname","lastname","id");

	}
	public String addUser(String...s) throws IOException{
		obj.run("test.csv");
		int k=0;
		int j[]=new int[s.length];
		String username,password;
		for(int i=0;i<s.length;i++){
			 j[k]=obj.checkAndAddColumn(s[i]);
		     k++;
			
		}
		/*for(int i=0;i<3;i++){
			System.out.println(obj.get(1,j[i]));
		}*/
		
		for(int i=1;i<obj.getNumRows();i++){
			username=obj.get(i,j[0]).toLowerCase()+obj.get(i,j[1]).toLowerCase();
			password=obj.get(i,j[2]);
			//System.out.println(username+password);
			
			SimpleLdapAuthentication.addEntry(username, password);
			
		}
		return "done";
	}

}
