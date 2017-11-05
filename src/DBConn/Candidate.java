package DBConn;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Class.Pelamar;

public class Candidate {
	Pelamar cand;
	SetConn conn;
	DBSingle db;
	
	public DefaultTableModel jobCandTmodel(JTable table, String idPekerjaan){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT nama, grup, status, "
					+ "(SELECT COUNT(nama)  "
						+ "FROM kandidat "
						+ "WHERE id_pekerjaan="+idPekerjaan+") AS COUNT "
				+ "FROM kandidat "
				+ "WHERE id_pekerjaan="+idPekerjaan);

		dm.setDataVector(ob,
				new String[] { 
			"NAME", "GROUP", "STATUS"
			});
		
		return dm;
		
	}
	
	public String[] getSumGroup(String idJob){
		String[] hasil;
		hasil = db.hasilStmtH("SELECT "
				+ "(select count(nama) from kandidat "
				+ "WHERE grup='APPLICANT' and id_pekerjaan="+idJob+") "
				+ "AS APPLICANT,"
				+ "(select count(nama) from kandidat "
				+ "WHERE grup='INTERVIEW' and id_pekerjaan="+idJob+")  "
				+ "AS INTERVIEW,"
				+ "(select count(nama) from kandidat "
				+ "WHERE grup='HIRED' and id_pekerjaan="+idJob+")  "
				+ "AS HIRED "
				+ "FROM kandidat where id_pekerjaan="+idJob);
		return hasil;
	}
	
	public String[] listId(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT id_kandidat, "
					+ "(select COUNT(id_kandidat) "
					+ "from kandidat)AS COUNT "
					+ "from kandidat");
		return hasil;
	}

}
