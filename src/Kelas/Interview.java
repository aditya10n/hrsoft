package Kelas;

import java.sql.Date;
import java.sql.Time;

public class Interview {
	Kandidat kandidat;
	
	private String id_interview;
	private String tanggal;
	private String jam_mulai;
	private String jam_selesai;
	private String dengan;
	private String lokasi;
	private String deskripsi;
	private String hasil;
	private String status;
	
	public String getId_interview() {
		return id_interview;
	}
	public void setId_interview(String id_interview) {
		this.id_interview = id_interview;
	}
	
	public String getJam_mulai() {
		return jam_mulai;
	}
	public void setJam_mulai(String jam_mulai) {
		this.jam_mulai = jam_mulai;
	}
	
	public String getDengan() {
		return dengan;
	}
	public void setDengan(String dengan) {
		this.dengan = dengan;
	}
	
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	
	public String getJam_selesai() {
		return jam_selesai;
	}
	public void setJam_selesai(String jam_selesai) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
