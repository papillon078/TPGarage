package entities;




public class User {
	
	String firstname;
	
	String lastname;
	
	String role;
	
	String mail;
	
	String password;
	
	

	public User() {
		super();
	}

	public User(String firstname, String molastnameel, String role, String mail, String password) {
		super();
		this.firstname = firstname;
		this.lastname = molastnameel;
		this.role = role;
		this.mail = mail;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String molastnameel) {
		this.lastname = molastnameel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + ", mail=" + mail
				+ ", password=" + password + "]";
	}
	
	

}
