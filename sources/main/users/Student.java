/**
 *  @author Anshula 
 */
package users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.IncorrectFormatException;

/**
 * @author Dell 1
 *
 */
public class Student {
    private static int address_max_length=100;
    private static int name_max_length=50;
    private static int mobile_max_length=13;
    
	private String student_id;
	private String name;
	private String category;
	private String gender;
	private java.sql.Date date_of_birth;
	private String state_eligibility;
	private String program_allocated;
	private String allocated_category;
	private String mobile;
	private String email;
	private String address;
	private boolean pwd;
	private String nationality;
	
	ArrayList<String> category_list = new ArrayList<String>();
	ArrayList<String> gender_list=new ArrayList<String>();
	ArrayList<String> state_list=new ArrayList<String>();
	ArrayList<String> program_allocated_list=new ArrayList<String>();
	ArrayList<String> allocated_category_list=new ArrayList<String>();
	ArrayList<String> nationality_list = new ArrayList<String>();
	
	public static void main(String[] args)throws IncorrectFormatException {
     Student test=new Student();
     test.setAddress("aiebg jfgbeeeeeeeeeeeeeeeeeeeeeeeeeeeeeuuuuuuuuuuj");
     test.setAllocated_category("open");
     test.setCategory("sc");
     test.setDate_of_birth("12-10-1993");
     test.setEmail("");
     test.setGender("male");
     test.setMobile("1234567890");
     test.setName("joey8 9into");
     test.setProgram_allocated("computer engineering");
     test.setState_eligibility("Uttar Pradesh");
     test.setStudent_id("");
	}
	
	 public Student(){
	 category_list.addAll(Arrays.asList("general","sc","st","obc-ncl"));
	 gender_list.addAll(Arrays.asList("male","female"));
	 state_list.addAll(Arrays.asList("uttar pradesh","uttarakhand"));
	 program_allocated_list.addAll(Arrays.asList("computer engineering","electronics and communication engineering"));
	 allocated_category_list.addAll(Arrays.asList("open","sc","st","obc-ncl"));
	 nationality_list.addAll(Arrays.asList("indian"));
	 }

	
	/**
	 * @return the student_id
	 */
	public String getStudent_id() {
		return student_id;
	}
	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)throws IncorrectFormatException {
		String regex = Pattern.quote("[a-z A-Z]*");
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(name);
		if(matcher.find()  && name.length()<=name_max_length){
		this.name = name;
		}
		else{
			throw new IncorrectFormatException("name");
		}
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)throws IncorrectFormatException {
		if(category_list.contains(category.toLowerCase()))
			    this.category = category;
			else
				throw new IncorrectFormatException("category");
		
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender)throws IncorrectFormatException {
		
		if(gender_list.contains(gender.toLowerCase()))
		    this.gender = gender;
		else
			throw new IncorrectFormatException("gender");
	
	}
	/**
	 * @return the date_of_birth
	 */
	public java.sql.Date getDate_of_birth() {
		return date_of_birth;
	}
	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth)throws IncorrectFormatException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date;
		try {
			date = sdf.parse(date_of_birth);
			this.date_of_birth = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IncorrectFormatException("date_of_birth");
		}
		  
		
		
	}
	/**
	 * @return the state_eligibility
	 */
	public String getState_eligibility() {
		return state_eligibility;
	}
	/**
	 * @param state_eligibility the state_eligibility to set
	 */
	public void setState_eligibility(String state_eligibility) throws IncorrectFormatException{
		if(state_list.contains(state_eligibility.toLowerCase()))
			this.state_eligibility = state_eligibility;
			else
			throw new IncorrectFormatException("state");
	
		
	}
	/**
	 * @return the program_allocated
	 */
	public String getProgram_allocated() {
		return program_allocated;
	}
	/**
	 * @param program_allocated the program_allocated to set
	 */
	public void setProgram_allocated(String program_allocated)throws IncorrectFormatException {
		if(program_allocated_list.contains(program_allocated.toLowerCase()))
			this.program_allocated = program_allocated;
			else
			throw new IncorrectFormatException("program_alloted");
		
	}
	/**
	 * @return the allocated_category
	 */
	public String getAllocated_category() {
		return allocated_category;
	}
	/**
	 * @param allocated_category the allocated_category to set
	 */
	public void setAllocated_category(String allocated_category)throws IncorrectFormatException {
		if(allocated_category_list.contains(allocated_category.toLowerCase()))
			this.allocated_category = allocated_category;
		else
			throw new IncorrectFormatException("allocated category");
	
}
		
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile)throws IncorrectFormatException {
		String regex = Pattern.quote("\\+?[0-9]*)");
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(mobile);
		if(matcher.find()&& mobile.length()<=mobile_max_length && mobile.length()>=10){
		   this.mobile = mobile;
		}
		else{
			throw new IncorrectFormatException("mobile");
		}
		
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)throws IncorrectFormatException {
		
		String regex = Pattern.quote("");
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(email);
		if(matcher.find()){
			this.email = email;
		}
		else{
			throw new IncorrectFormatException("email");
		}
		
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)throws IncorrectFormatException {
		
		if(address.length()<=address_max_length){
			this.address = address;
		}
		else{
			throw new IncorrectFormatException("address");
		}
		
	}
	
	/**
	 * @return the pwd
	 */
	public boolean isPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		if(pwd.equalsIgnoreCase("yes"))
		   this.pwd = true;
		else
			this.pwd=false;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality)throws IncorrectFormatException {
		if(nationality_list.contains(nationality.toLowerCase()))
			this.nationality = nationality;
		else
			throw new IncorrectFormatException("nationality");
		
	}
}
