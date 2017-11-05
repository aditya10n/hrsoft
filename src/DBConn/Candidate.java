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
		Object ob[][] = db.hasilStmt2("SELECT nama, grup, status FROM kandidat "
				+ "WHERE id_pekerjaan="+idPekerjaan);

		dm.setDataVector(ob,
				new String[] { 
			"NAME", "GROUP", "STATUS"
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
