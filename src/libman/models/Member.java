package libman.models;

public class Member {
	private Integer libraryId;
	private String fname;
	private String lname;
	private String dob;
	private String address;
	private String phone;
	private String username;
	private String password;
	private String mem_exp;
	
	/*public Member(Integer libid,String fname,String lname,String dob,String address,
			String phone,String username,String password,String mem_exp){
		this.libraryId = libid;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.mem_exp = mem_exp;
	}*/
	
	public Integer getLibId(){
		return libraryId;
	}
	
	public void setLibId(Integer libid){
		this.libraryId = libid;
	}
	
	public String getFName(){
		return fname;
	}
	
	public void setFName(String fname){
		this.fname = fname;
	}
	
	public String getLName(){
		return lname;
	}
	
	public void setLName(String lname){
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMem_exp() {
		return mem_exp;
	}

	public void setMem_exp(String mem_exp) {
		this.mem_exp = mem_exp;
	}

}
