/**
 * 
 */
package ldap;

/**
 * @author Joey
 *
 */
import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLdapAuthentication
{
	public static void main(String[] args) 
	{
		try {
		System.out.println(searchAndAuthenticate("admin", "iiitk"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public static String searchAndAuthenticate(String username,String password) throws NamingException{
		Hashtable<String, String> env = 
				new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://192.168.50.128:389");
		env.put(Context.SECURITY_AUTHENTICATION, "none");

		SearchControls searchCtrls = new SearchControls();
		searchCtrls.setReturningAttributes(new String[] {});
		searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String filter = "(&(uid=" + username + "))";

		DirContext ctx = null;
		ctx = new InitialDirContext(env);
		NamingEnumeration<SearchResult> answer = ctx.search(  "dc=iiitk,dc=com", filter, searchCtrls);

		String fullDN = null;
		if (answer.hasMore()) {

			fullDN = answer.next().getNameInNamespace();

			ctx.close();
			ctx = null;

			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, fullDN);
			env.put(Context.SECURITY_CREDENTIALS, password);

			ctx = new InitialDirContext(env);
			Attributes attrs=ctx.getAttributes(fullDN);

			JSONObject credentials = new JSONObject();
			try {
				credentials.put("type","student");
				credentials.put("name",attrs.get("cn").get(0));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return credentials.toString();
		}
		// Exception otherwise ...
		return null;

	}
	public static void addEntry(String name,String password,String type) {

		Hashtable<String, String> env = 
				new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://192.168.50.128:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=iiitk,dc=com");
		env.put(Context.SECURITY_CREDENTIALS, "iiitk");

		try {

			DirContext context = new InitialDirContext(env);

			addUser(context,name,password);


			context.close();



		} catch (NamingException e) {



			e.printStackTrace();

		}



	}
	 public static void addUser(DirContext context,String name,String password) {
 	 	
         Attributes attributes = new BasicAttributes();
 	
         Attribute attribute = new BasicAttribute("objectClass");
 	
         attribute.add("inetOrgPerson");
 	
         attributes.put(attribute);
 	
         
 	
         Attribute pwd = new BasicAttribute("userPassword");
 	
         
 	
         pwd.add(password);
 	
        
 	
         attributes.put(pwd);
 	
  
 	
         try {
 	
             context.createSubcontext(
 	
                      "cn="+name+",cn=thirdyear,ou=students,dc=iiitk,dc=com",attributes);
 	
         } catch (NamingException e) {
 	
             e.printStackTrace();
 	
         }
 	
     }
}


	



