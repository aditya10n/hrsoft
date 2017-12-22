package Kelas;

public class Kandidat {
	Staff staff;
	Pekerjaan pekerjaan;
	
	private String id_kandidat;
	private String status;
	private String education;
	private String experience;
	private String group;
	private String nama;
	private String phone;
	private String email;
	private String alamat;
	
	public String getId_kandidat() {
		return id_kandidat;
	}
	public void setId_kandidat(String id_kandidat) {
		this.id_kandidat = id_kandidat;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
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
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
