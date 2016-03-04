/**
 * 
 */
package settings.propertySheet;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exceptions.ConfigException;
import java.util.ArrayList;



/**
 * @author Megha
 *
 */
public class PropertySheet {

	/**
	 * @param sheet_name
	 * Creates a New Property Sheet as a JSONObject
	 */
	public static void newPropertySheet(String sheet_name){
		String content="{}";
		fileExplorer.File.writeFile(content, sheet_name);
	}	

	public static void addAttribute(String sheet_name,String attribute,boolean isArray) throws ConfigException {
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name));
		if(checkAttribute(sheet_name, attribute)){
			ConfigException e = new	exceptions.ConfigException("Attribute already exists!");
			throw(e);
		}
		if(isArray){
			object.put(attribute,"[]");
		}
		else{
			object.put(attribute,"");
		}
		fileExplorer.File.writeFile(object.toString(),sheet_name);

	}

	public static boolean checkAttribute(String sheet_name,String attribute){
		try{
			getAttribute(sheet_name, attribute);
		}
		catch(JSONException e){
			return false;
		}

		return true;
	}

	public static  JSONObject getAttribute(String sheet_name,String attribute){
		JSONObject object =new JSONObject(fileExplorer.File.readFile(sheet_name));
		return object.getJSONObject(attribute);
	}
	public static  Object getValue(String sheet_name,String attribute){
		//	System.out.println(fileExplorer.File.readFile(sheet_name));
		JSONObject object =new JSONObject(fileExplorer.File.readFile(sheet_name));
		return object.get(attribute);
	}

	public static boolean isArray(String sheet_name,String attribute){
		try{
			getAttribute(sheet_name, attribute).getJSONArray(attribute);
		}
		catch(JSONException e){
			return false;
		}

		return true;
	}

	public static void setAttribute(String sheet_name,String attribute,String value ) throws ConfigException{
		if(!checkAttribute(sheet_name, attribute)){
			ConfigException e=new exceptions.ConfigException("Attribute does not exist!");
			throw(e);

		}
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name));
		object.put(attribute, value);
		fileExplorer.File.writeFile(object.toString(),sheet_name);
		//object.put
	}

	public static void setAttributeArray(String sheet_name,String attribute,ArrayList<String> values ) throws ConfigException{
		if(!checkAttribute(sheet_name, attribute)){
			ConfigException e=new exceptions.ConfigException("Attribute array does not exist!");
			throw(e);
		}
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name)); 
		object.put(attribute,values);
		fileExplorer.File.writeFile(object.toString(),sheet_name);

	}
	public static void pushAttributeValue(String sheet_name,String attribute,String value ){
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name));
		//System.out.println(object);
		JSONArray array = (JSONArray) getValue(sheet_name,attribute);
		System.out.println(array);
		array.put(value);
		object.put(attribute,array);
		fileExplorer.File.writeFile(object.toString(),sheet_name);
	}

	public static void deleteAttribute(String sheet_name,String attribute){
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name));
		object.remove(attribute);
		fileExplorer.File.writeFile(object.toString(),sheet_name);

	}
	public static void popAttribute(String sheet_name,String attribute,String value){
		JSONObject object=new JSONObject(fileExplorer.File.readFile(sheet_name));
		//System.out.println(object);
		JSONArray array = (JSONArray) getValue(sheet_name,attribute);
		//System.out.println(array);
		java.util.Iterator<Object> iterator=array.iterator();
		int index=-1;
		while(iterator.hasNext()){ index++;
		String current=(String) iterator.next();
		if(current.equals(value)){ 
			System.out.println("removed"+index);
			array.remove(index); break;
		}
		}

		object.put(attribute,array);
		fileExplorer.File.writeFile(object.toString(),sheet_name);

	}
	public static void main(String args[]) throws IOException{
		// newPropertySheet("sheet2.config");

		ArrayList<String> list123=new ArrayList<String>();
		//		list.add("1");
		//		list.add("2");
		//		list.add("3");
		//		setAttributeArray("sheet2.config","marks",list);

		//		pushAttributeValue("sheet2.config", "marks", "7");

		//Object object = getValue("sheet2.config", "user");
		//popAttribute("sheet2.config", "marks","1");
		//isArray("sheet2.config","marks");
		//checkAttribute("sheet2.config", "login");
		//deleteAttribute("sheet2.config", "logidfgnn");
		try {
			setAttributeArray("sheet2.config", "logidfgnn", list123);
		} catch (ConfigException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//addAttribute("sheet2.config", "abc", false);
		JSONObject obj=new JSONObject(fileExplorer.File.readFile("sheet2.config"));
		System.out.println(obj);
	}
}
