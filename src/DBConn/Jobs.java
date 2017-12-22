package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Kelas.Pekerjaan;

public class Jobs {
	Pekerjaan job;
	SetConn conn;
	DBSingle db;
	
	public DefaultTableModel tableModel(JTable table){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2("SELECT pekerjaan.nama AS PEKERJAAN, pekerjaan.lokasi AS LOKASI,"
				+ "	(SELECT "
				+ "     	COUNT(kandidat.grup) "
				+ "     FROM pekerjaan, kandidat"
				+ "    WHERE kandidat.grup='APPLICANT'"
				+ "    AND pekerjaan.id_pekerjaan=kandidat.id_pekerjaan"
				+ "    AND pekerjaan.nama=PEKERJAAN)"
				+ "    AS APPLICANT,"
				+ "    "
				+ "    (SELECT "
				+ "     	COUNT(kandidat.grup) "
				+ "     FROM pekerjaan, kandidat"
				+ "    WHERE kandidat.grup='INTERVIEW'"
				+ "    AND pekerjaan.id_pekerjaan=kandidat.id_pekerjaan"
				+ "    AND pekerjaan.nama=PEKERJAAN)"
				+ "    AS INTERVIEW,"
				+ "    "
				+ "    (SELECT "
				+ "     	COUNT(kandidat.grup) "
				+ "     FROM pekerjaan, kandidat"
				+ "    WHERE kandidat.grup='HIRED'"
				+ "    AND pekerjaan.id_pekerjaan=kandidat.id_pekerjaan"
				+ "    AND pekerjaan.nama=PEKERJAAN)"
				+ "    AS HIRED,"
				+ "    "
				+ "    (select count(pekerjaan.nama) from pekerjaan) AS COUNT"
				+ "    "
				+ "FROM pekerjaan");

		dm.setDataVector(ob,
				new String[] { 
			"NAME", "LOCATION", "APPLICANT", "INTERVIEW", "HIRED"
			});
		
		return dm;
		
	}
	
	public Pekerjaan getData(String id){
		job = new Pekerjaan();
		String[] hasil=null;
		db = new DBSingle();
		hasil = db.hasilStmtH("SELECT id_pekerjaan, "
				+ "nama, lokasi, deskripsi "
				+ "from pekerjaan WHERE id_pekerjaan="+id);
		job.setId_pekerjaan(hasil[0]);
		job.setNama(hasil[1]);
		job.setLokasi(hasil[2]);
		job.setDeskripsi(hasil[3]);
		return job;
	}
	
	public String[] listId(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT id_pekerjaan, "
					+ "(select COUNT(id_pekerjaan) "
					+ "from pekerjaan)AS COUNT "
					+ "from pekerjaan");
		return hasil;
	}
	
	public void createJob(String nama, String loc, String desc){
		db.execute("INSERT INTO pekerjaan (nama,lokasi,deskripsi) "
				+ "values ('"+nama+"','"+loc+"','"+desc+"')");
	}
	
	public void editJob(Pekerjaan job){
		db.execute("UPDATE pekerjaan SET nama = '"+job.getNama()+"',"
				+ "lokasi = '"+job.getLokasi()+"',"
				+ "deskripsi = '"+job.getDeskripsi()+"' "
				+ "WHERE id_pekerjaan ="+job.getId_pekerjaan());
	}
	
	public void deleteJob(String id_pekerjaan){
		db.execute("DELETE from pekerjaan "
				+ "WHERE id_pekerjaan='"+id_pekerjaan+"'");
	}

}
