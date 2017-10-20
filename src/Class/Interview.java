package Class;

import java.sql.Date;
import java.sql.Time;

public class Interview {
	Kandidat kandidat;
	
	private String id_interview;
	private Date tanggal;
	private Time jam_mulai;
	private Time jam_selesai;
	private String dengan;
	private String lokasi;
	private String deskripsi;
	private String hasil;
	
	public String getId_interview() {
		return id_interview;
	}
	public void setId_interview(String id_interview) {
		this.id_interview = id_interview;
	}
	
	public Time getJam_mulai() {
		return jam_mulai;
	}
	public void setJam_mulai(Time jam_mulai) {
		this.jam_mulai = jam_mulai;
	}
	
	public String getDengan() {
		return dengan;
	}
	public void setDengan(String dengan) {
		this.dengan = dengan;
	}
	
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	
	public Time getJam_selesai() {
		return jam_selesai;
	}
	public void setJam_selesai(Time jam_selesai) {
		this.jam_selesai = jam_selesai;
	}
	
	public String getLokasi() {
		return lokasi;
	}
	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}
	
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	
	public String getHasil() {
		return hasil;
	}
	public void setHasil(String hasil) {
		this.hasil = hasil;
	}
	
}
