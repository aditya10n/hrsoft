package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Class.Pekerjaan;

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
				+ "    (select count(pekerjaan.nama) from kandidat,pekerjaan where kandidat.id_pekerjaan=pekerjaan.id_pekerjaan) AS COUNT"
				+ "    "
				+ "FROM pekerjaan");

		dm.setDataVector(ob,
				new String[] { 
			"NAME", "LOCATION", "APPLICANT", "INTERVIEW", "HIRED"
			});
		
		return dm;
		
	}
	
	public String[] listId(){
		String[] hasil=null;
			hasil = db.hasilStmt3("Select id_pekerjaan from pekerjaan");
		return hasil;
	}
	

}
