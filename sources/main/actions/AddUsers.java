/**
 * 
 */
package actions;

import java.io.IOException;

import ldap.SimpleLdapAuthentication;
import Parser.CSVFunctions;

/**
 * @author Arushi
 *
 */
public class AddUsers {
	CSVFunctions obj=new CSVFunctions();
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		new AddUsers().addUser("firstname","lastname","id");

	}
	public String addUser(String...s) throws IOException{
		obj.run("c2.csv");
		int k=0;
		int j[]=new int[s.length];
		String username,password;
		for(int i=0;i<s.length;i++){
			 j[k]=obj.checkAndAddColumn(s[i]);
			 k++;
			
		}
		for(int i=1;i<obj.getNumRows();i++){
			username=obj.get(i, j[0]).toLowerCase()+obj.get(i, j[1]).toLowerCase();
			password=obj.get(i, j[2]);
			SimpleLdapAuthentication.addEntry(username, password);
			
		}
		return "done";
	}

}