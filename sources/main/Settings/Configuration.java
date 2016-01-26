/**
 * 
 */
package settings;

/**
 * This file holds the configuration for the project
 * All settings here deployment specific
 * @author Joey
 *
 */
public class Configuration {
private String ldap_url;
private String ldap_base;
/**
 * @return the ldap_url
 */
public String getLdap_url() {
	return ldap_url;
}
/**
 * @param ldap_url the ldap_url to set
 */
public void setLdap_url(String ldap_url) {
	this.ldap_url = ldap_url;
}
/**
 * @return the ldap_base
 */
public String getLdap_base() {
	return ldap_base;
}
/**
 * @param ldap_base the ldap_base to set
 */
public void setLdap_base(String ldap_base) {
	this.ldap_base = ldap_base;
}
}
