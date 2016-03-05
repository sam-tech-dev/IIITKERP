/**
 * 
 */
package utilities;

/**
 * @author Joey
 *
 */
public class StringFormatter {
public static String TitleCase(String text){
	 StringBuilder titleCase = new StringBuilder();
	    boolean nextTitleCase = true;
	 
	    for (char c : text.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        } 
	 
	        titleCase.append(c);
	    } 
	 
	    return titleCase.toString();
}
}
