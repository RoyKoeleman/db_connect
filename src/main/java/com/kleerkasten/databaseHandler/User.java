package databaseStructure;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	public void additems(int userid,String firstname,String lastname,String mail){
		this.user_id=userid;
		this.first_name=firstname;
		this.last_name=lastname;
		this.email=mail;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
