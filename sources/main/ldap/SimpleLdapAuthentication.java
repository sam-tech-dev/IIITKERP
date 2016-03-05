/**
 * 
 */
package ldap;

/**
 * @author Joey
 *
 */
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLdapAuthentication
{
	public static void main(String[] args) 
	{
		try {
			//System.out.println(searchAndAuthenticate("admin", "iiitk"));
			addEntry("ricky","martin", "rickymartin", "12345","1000000001");
			//changePassword("Joey Pinto", "123456789");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public static JSONObject searchAndAuthenticate(String username,String password) throws NamingException{
		Hashtable<String, String> env = 
				new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://172.16.1.231:389");
		env.put(Context.SECURITY_AUTHENTICATION, "none");

		SearchControls searchCtrls = new SearchControls();
		searchCtrls.setReturningAttributes(new String[] {});
		searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String filter = "(&(uid=" + username + "))";

		DirContext ctx = null;
		ctx = new InitialDirContext(env);
		NamingEnumeration<SearchResult> answer = ctx.search("dc=iiitk,dc=ac,dc=in", filter, searchCtrls);

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
				int index=fullDN.indexOf("ou=")+3;
				String ou=fullDN.substring(index, fullDN.indexOf(",",index));
				if(ou.equals("students"))credentials.put("type","student");
				if(ou.equals("faculty"))credentials.put("type","faculty");
				credentials.put("name",attrs.get("cn").get(0));
				credentials.put("erpId",attrs.get("sn").get(0) );
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return credentials;
		}
		// Exception otherwise ...
		return null;

	}
	/**
	 * @param first_name
	 * @param last_name
	 * @param username
	 * @param password
	 * @param erp_id
	 */
	public static void addEntry(String first_name,String last_name,String username,String password,String erp_id) {

		Hashtable<String, String> env = 
				new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://172.16.1.231:389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn=admin,dc=iiitk,dc=ac,dc=in");
		env.put(Context.SECURITY_CREDENTIALS, "iiitk_2013");

		try {

			DirContext context = new InitialDirContext(env);
			Attributes attributes = new BasicAttributes();
			Attribute attribute = new BasicAttribute("objectClass");
			attribute.add("inetOrgPerson");
			attributes.put(attribute);
			Attribute pwd = new BasicAttribute("userPassword");
			pwd.add(password);
			attributes.put(pwd);
			Attribute sn = new BasicAttribute("sn");
			sn.add(erp_id);
			attributes.put(sn);
			Attribute uid = new BasicAttribute("uid");
			uid.add(username);
			attributes.put(uid);
			Attribute fname = new BasicAttribute("givenName");
			fname.add(first_name+" "+last_name);
			attributes.put(fname);
			try {

				context.createSubcontext(
						"cn="+first_name+" "+last_name+",cn=thirdyear,ou=students,dc=iiitk,dc=ac,dc=in",attributes);

			} catch (NamingException e) {

				e.printStackTrace();

			}

			System.out.println("entered successfully");


			context.close();



		} catch (NamingException e) {



			e.printStackTrace();

		}



	}
	public static void addUser(DirContext context,String name,String password) {

		
	}

	public static void changePassword(String username,String new_password){
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,"ldap://172.16.1.231:389");
		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		env.put(Context.SECURITY_PRINCIPAL,"cn=admin,dc=iiitk,dc=ac,dc=in");
		env.put(Context.SECURITY_CREDENTIALS,"iiitk_2013");

		try
		{
			// Create the initial directory context
			InitialDirContext initialContext = new InitialDirContext(env);
			DirContext ctx = (DirContext)initialContext;

			System.out.println("Context Sucessfully Initialized");

			ModificationItem[] mods = new ModificationItem[1];

			Attribute mod0 = new BasicAttribute("userPassword",new_password);

			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);

			ctx.modifyAttributes("cn="+username+",cn=thirdyear,ou=students,dc=iiitk,dc=ac,dc=in", mods);

		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}

}






