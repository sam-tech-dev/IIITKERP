/**
 * 
 */
package ldap;

import java.io.IOException;

import csv.Parser;
import fileExplorer.File;
import ldap.SimpleLdapAuthentication;
import postgreSQLDatabase.registration.Query;
import utilities.StringFormatter;

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
		String username,first_name,last_name,password;
		for(int i=0;i<s.length;i++){
			 j[k]=obj.checkAndAddColumn(s[i]);
		     k++;
			
		}
		
		
		for(int i=1;i<obj.getNumRows();i++){
			first_name=StringFormatter.TitleCase(obj.get(i,j[0]));
			last_name=StringFormatter.TitleCase(obj.get(i,j[1]));
			username=first_name.toLowerCase()+last_name.toLowerCase();
			password=obj.get(i,j[2]);
			//System.out.println(username+password);
			String erp_id=Query.registerUser(username, first_name+" "+last_name, "student");
			User user =new User();
			user.setFirst_name(first_name);
			user.setLast_name(last_name);
			user.setDepartment("computer_science");
			user.setErp_id(erp_id);
			user.setPassword(password);
			user.setRole("student");
			
			SimpleLdapAuthentication.addEntry(user);
			
		}
		return "done";
	}

}
