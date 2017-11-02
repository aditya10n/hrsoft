package DBConn;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Class.Pelamar;

public class Candidate {
	Pelamar cand;
	SetConn conn;
	DBSingle db;
	
	public DefaultTableModel jobCandTmodel(JTable table){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2("SELECT pekerjaan.nama AS NAME, pekerjaan.lokasi AS LOKASI,"
				+ "	(SELECT "
				+ "     	COUNT(kandidat.grup) "
				+ "     FROM pekerjaan, kandidat"
				+ "    WHERE kandidat.grup='APPLICANT'"
				+ "    AND pekerjaan.id_pekerjaan=kandidat.id_pekerjaan"
				+ "    AND pekerjaan.nama=PEKERJAAN)"
				+ "    AS NAME,"
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
			"NAME", "EMAIL", "PHONE", "ADDRESS", "GROUP"
			});
		
		return dm;
		
	}
	
	public String[] listId(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmt3("SELECT id_kandidat, "
					+ "(select COUNT(id_kandidat) "
					+ "from kandidat)AS COUNT "
					+ "from kandidat");
		return hasil;
	}

}
