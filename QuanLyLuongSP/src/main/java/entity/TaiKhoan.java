package entity;

public class TaiKhoan {
	private String username;
	private String password;
	public TaiKhoan(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "TaiKhoan [username=" + username + ", password=" + password + "]";
	}
	
}
