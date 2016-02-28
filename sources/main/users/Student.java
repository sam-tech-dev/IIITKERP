/**
 *  @author Anshula 
 */
package users;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.IncorrectFormatException;

/**
 * @author Anshula
 *
 */
public class Student {
    private static int address_max_length=100;
    private static int name_max_length=50;
    private static int mobile_max_length=13;
    
	private String student_id;
	private int registration_id;
	private String name;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String category;
	private int jee_main_rollno;
	private int jee_adv_rollno;
	private String guardian_name;
	private String guardian_contact;
	private String guardian_email;
	private String guardian_address;
	private String father_name;
	private String mother_name;
	private String father_contact;
	private String mother_contact;
	private String gender;
	private String allocated_category;
	private java.sql.Date date_of_birth;
	private String state_eligibility;
	private String program_allocated;
	private int allocated_rank;
	private String status;
	private int choice_no;
	private int round;
	private String quota;
	private String willingness;
	private String mobile;
	private String email;
	private String permanent_address;
	private String local_address;
	private boolean hosteller;
	private String hostel;
	/**
	 * @return the hostel
	 */
	public String getHostel() {
		return hostel;
	}

	/**
	 * @param hostel the hostel to set
	 */
	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	private String room;
	private Date entry_time;
	private boolean pwd;
	private String nationality;
	private String rc_name;
	private boolean applied;
	
	/**
	 * @return the applied
	 */
	public boolean isApplied() {
		return applied;
	}

	/**
	 * @param applied the applied to set
	 */
	public void setApplied(boolean applied) {
		this.applied = applied;
	}

	ArrayList<String> category_list = new ArrayList<String>();
	ArrayList<String> gender_list=new ArrayList<String>();
	ArrayList<String> state_list=new ArrayList<String>();
	ArrayList<String> program_allocated_list=new ArrayList<String>();
	ArrayList<String> allocated_category_list=new ArrayList<String>();
	ArrayList<String> nationality_list = new ArrayList<String>();
	
	public static void main(String[] args)throws IncorrectFormatException {
     Student test=new Student();
//     test.setAddress("aiebg jfgbeeeeeeeeeeeeeeeeeeeeeeeeeeeeeuuuuuuuuuuj");
//     test.setAllocated_category("open");
//     test.setCategory("sc");
//     test.setDate_of_birth("12-10-1993");
//     test.setEmail("");
//     test.setGender("male");
//     test.setMobile("1234567890");
     test.setName("joey pinto");
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
	      Pattern pattern= Pattern.compile("[a-zA-Z\\s]+");
	      Matcher matcher = pattern.matcher(name);
		//String regex = Pattern.quote("^[a-zA-Z\\s]+$");
		//Pattern pattern=Pattern.compile(regex);
		//Matcher matcher=pattern.matcher(name);
		//System.out.println(name.length()+" "+name_max_length);
		if(matcher.find()&&name.length()<=name_max_length){
		this.name = name;
		}
		else{
			throw new IncorrectFormatException("name123");
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
		//String regex = Pattern.quote("\\+?[0-9]*)");
		//Pattern pattern=Pattern.compile(regex);
		//Matcher matcher=pattern.matcher(mobile);
		 Pattern pattern= Pattern.compile("[a-zA-Z\\s]+");
	      Matcher matcher = pattern.matcher(mobile);
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
	
	/**
	 * @return the registration_id
	 */
	public int getRegistration_id() {
		return registration_id;
	}

	/**
	 * @param registration_id the registration_id to set
	 */
	public void setRegistration_id(int registration_id) {
		this.registration_id = registration_id;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}

	/**
	 * @param middle_name the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the jee_main_rollno
	 */
	public int getJee_main_rollno() {
		return jee_main_rollno;
	}

	/**
	 * @param jee_main_rollno the jee_main_rollno to set
	 */
	public void setJee_main_rollno(int jee_main_rollno) {
		this.jee_main_rollno = jee_main_rollno;
	}

	/**
	 * @return the jee_adv_rollno
	 */
	public int getJee_adv_rollno() {
		return jee_adv_rollno;
	}

	/**
	 * @param jee_adv_rollno the jee_adv_rollno to set
	 */
	public void setJee_adv_rollno(int jee_adv_rollno) {
		this.jee_adv_rollno = jee_adv_rollno;
	}

	/**
	 * @return the guardian_name
	 */
	public String getGuardian_name() {
		return guardian_name;
	}

	/**
	 * @param guardian_name the guardian_name to set
	 */
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	/**
	 * @return the guardian_contact
	 */
	public String getGuardian_contact() {
		return guardian_contact;
	}

	/**
	 * @param guardian_contact the guardian_contact to set
	 */
	public void setGuardian_contact(String guardian_contact) {
		this.guardian_contact = guardian_contact;
	}

	/**
	 * @return the guardian_email
	 */
	public String getGuardian_email() {
		return guardian_email;
	}

	/**
	 * @param guardian_email the guardian_email to set
	 */
	public void setGuardian_email(String guardian_email) {
		this.guardian_email = guardian_email;
	}

	/**
	 * @return the guardian_address
	 */
	public String getGuardian_address() {
		return guardian_address;
	}

	/**
	 * @param guardian_address the guardian_address to set
	 */
	public void setGuardian_address(String guardian_address) {
		this.guardian_address = guardian_address;
	}

	/**
	 * @return the father_name
	 */
	public String getFather_name() {
		return father_name;
	}

	/**
	 * @param father_name the father_name to set
	 */
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	/**
	 * @return the mother_name
	 */
	public String getMother_name() {
		return mother_name;
	}

	/**
	 * @param mother_name the mother_name to set
	 */
	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	/**
	 * @return the father_contact
	 */
	public String getFather_contact() {
		return father_contact;
	}

	/**
	 * @param father_contact the father_contact to set
	 */
	public void setFather_contact(String father_contact) {
		this.father_contact = father_contact;
	}

	/**
	 * @return the mother_contact
	 */
	public String getMother_contact() {
		return mother_contact;
	}

	/**
	 * @param mother_contact the mother_contact to set
	 */
	public void setMother_contact(String mother_contact) {
		this.mother_contact = mother_contact;
	}

	/**
	 * @return the allocated_rank
	 */
	public int getAllocated_rank() {
		return allocated_rank;
	}

	/**
	 * @param allocated_rank the allocated_rank to set
	 */
	public void setAllocated_rank(int allocated_rank) {
		this.allocated_rank = allocated_rank;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the choice_no
	 */
	public int getChoice_no() {
		return choice_no;
	}

	/**
	 * @param choice_no the choice_no to set
	 */
	public void setChoice_no(int choice_no) {
		this.choice_no = choice_no;
	}

	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}

	/**
	 * @return the quota
	 */
	public String getQuota() {
		return quota;
	}

	/**
	 * @param quota the quota to set
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}

	/**
	 * @return the willingness
	 */
	public String getWillingness() {
		return willingness;
	}

	/**
	 * @param willingness the willingness to set
	 */
	public void setWillingness(String willingness) {
		this.willingness = willingness;
	}

	/**
	 * @return the permanent_address
	 */
	public String getPermanent_address() {
		return permanent_address;
	}

	/**
	 * @param permanent_address the permanent_address to set
	 */
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	/**
	 * @return the local_address
	 */
	public String getLocal_address() {
		return local_address;
	}

	/**
	 * @param local_address the local_address to set
	 */
	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}

	/**
	 * @return the hosteller
	 */
	public boolean isHosteller() {
		return hosteller;
	}

	/**
	 * @param hosteller the hosteller to set
	 */
	public void setHosteller(boolean hosteller) {
		this.hosteller = hosteller;
	}



	/**
	 * @return the entry_date
	 */
	public Date getEntry_time() {
		return entry_time;
	}

	/**
	 * @param entry_date the entry_date to set
	 */
	public void setEntry_time(Date entry_date) {
		this.entry_time = entry_date;
	}

	/**
	 * @return the rc_name
	 */
	public String getRc_name() {
		return rc_name;
	}

	/**
	 * @param rc_name the rc_name to set
	 */
	public void setRc_name(String rc_name) {
		this.rc_name = rc_name;
	}

	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(boolean pwd) {
		this.pwd = pwd;
	}

	
}
