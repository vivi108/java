package PersonAddress;

public class PersonAddress {
	private String first;
	private String last;
	private String email;
	private String phone;
	public static final String nationality ="Korea";
	
	public boolean equals(PersonAddress another) {
		return(this.first.equals(another.first)&&this.last.equals(another.last));
	}
	public void print() {
		System.out.println("first name= "+first+" last name= "+last+" e-mail address= "+email+" phone number= "+phone +" nationality= "+nationality);
	}
	
	//set method
	public void setfirstlast(String name, String name2) {
		this.first= name;
		this.last= name2;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//get each attribute
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
}
