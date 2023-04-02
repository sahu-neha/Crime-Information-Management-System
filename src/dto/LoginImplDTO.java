package dto;

public class LoginImplDTO implements LoginDTO {

	private String username;
	private String password;
	private String email;
	private String contact_no;

	public LoginImplDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginImplDTO(String username, String password, String email, String contact_no) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact_no = contact_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
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

	@Override
	public String toString() {
		return "Username = " + username + ", Password = " + password + ", Email = " + email + ", Contact_no = "
				+ contact_no;
	}

}
