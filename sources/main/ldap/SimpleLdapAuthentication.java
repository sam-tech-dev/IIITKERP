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
			System.out.println(searchAndAuthenticate("jpinto", "59261169"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String username = "Joey Pinto";
//		String password = "59261169";
//		String base = "cn=thirdyear,ou=students,dc=iiitk,dc=com";
//		String dn =  "uid="+"jpinto@iiitk.com" + "," + base;
//		String ldapURL = "ldap://192.168.50.128:389";
//
//		// Setup environment for authenticating
//		
//		Hashtable<String, String> environment = 
//			new Hashtable<String, String>();
//		environment.put(Context.INITIAL_CONTEXT_FACTORY,
//				"com.sun.jndi.ldap.LdapCtxFactory");
//		environment.put(Context.PROVIDER_URL, ldapURL);
//		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
//		environment.put(Context.SECURITY_PRINCIPAL, dn);
//		environment.put(Context.SECURITY_CREDENTIALS, password);
//
//		try
//		{
//			DirContext authContext = 
//				new InitialDirContext(environment);
//			Attributes attrs=authContext.getAttributes("cn=Joey Pinto,cn=thirdyear,ou=students,dc=iiitk,dc=com");
//			System.out.println(attrs.get("sn"));
//			// user is authenticated
//			
//		}
//		catch (AuthenticationException ex)
//		{
//			
//			// Authentication failed
//			ex.printStackTrace();
//
//		}
//		catch (NamingException ex)
//		{
//			ex.printStackTrace();
//		}
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
}

