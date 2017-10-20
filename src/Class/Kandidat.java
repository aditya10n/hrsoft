package Class;

public class Kandidat {
	Staff staff;
	Pelamar pelamar;
	Pekerjaan pekerjaan;
	
	private String id_kandidat;
	private String status;
	private String education;
	private String experience;
	private String group;
	
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
	
	
}
