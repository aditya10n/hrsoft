package Class;

public class Staff {
	private String username;
	private String password;
	private String nama;
	private String phone;
	
	public Staff(String username, String password, String nama, String phone){
		setUsername(username);
		setPassword(password);
		setNama(nama);
		setPhone(phone);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
