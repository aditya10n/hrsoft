package DBConn;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Kelas.Kandidat;

public class Candidate {
	SetConn conn;
	DBSingle db;
	Kandidat kand = new Kandidat(); 
	
	public DefaultTableModel jobCandTmodel(String idPekerjaan){
		
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
	
public DefaultTableModel CandidateModel(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT kandidat.nama, pekerjaan.nama, kandidat.grup, kandidat.status,"
				+ "(SELECT COUNT(kandidat.nama) "
				+ "FROM kandidat, pekerjaan "
				+ "WHERE kandidat.id_pekerjaan=pekerjaan.id_pekerjaan) AS COUNT "
					
				+ "FROM kandidat, pekerjaan "
				+ "WHERE kandidat.id_pekerjaan=pekerjaan.id_pekerjaan");

		dm.setDataVector(ob,
				new String[] { 
			"NAME", "JOB", "GROUP", "STATUS"
			});
		
		return dm;
		
	}

public DefaultTableModel CandidateModel(String group){
	
	DefaultTableModel dm = new DefaultTableModel(){
		private static final long serialVersionUID = 1L;
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	};
	db = new DBSingle();
	Object ob[][] = db.hasilStmt2(
			"SELECT kandidat.nama, pekerjaan.nama, kandidat.status,"
			+ "(SELECT COUNT(kandidat.nama) "
			+ "FROM kandidat, pekerjaan "
			+ "WHERE kandidat.id_pekerjaan=pekerjaan.id_pekerjaan AND kandidat.grup='"+group+"') AS COUNT "
				
			+ "FROM kandidat, pekerjaan "
			+ "WHERE kandidat.id_pekerjaan=pekerjaan.id_pekerjaan AND kandidat.grup='"+group+"'");

	dm.setDataVector(ob,
			new String[] { 
		"NAME", "JOB", "STATUS"
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
	
	public String[] listId(String id){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT id_kandidat, "
					+ "(select COUNT(id_kandidat) "
					+ "from kandidat where id_pekerjaan="+id+")AS COUNT "
					+ "from kandidat where id_pekerjaan="+id);
		return hasil;
	}
	
	public String[] listId(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "from kandidat,pekerjaan where kandidat.id_pekerjaan=pekerjaan.id_pekerjaan)AS COUNT "
					+ "from kandidat,pekerjaan where kandidat.id_pekerjaan=pekerjaan.id_pekerjaan");
		return hasil;
	}
	
	public String[] listIdG(String group){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "from kandidat,pekerjaan where kandidat.id_pekerjaan=pekerjaan.id_pekerjaan AND "
					+ "kandidat.grup='"+group+"')AS COUNT "
					+ "from kandidat,pekerjaan where kandidat.id_pekerjaan=pekerjaan.id_pekerjaan AND "
					+ "kandidat.grup='"+group+"'");
		return hasil;
	}
	
	public String[] listIdP(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT id_pekerjaan, "
					+ "(select COUNT(id_pekerjaan) "
					+ "from kandidat)AS COUNT "
					+ "from kandidat");
		return hasil;
	}
	
	public String[] getDetail(String id){
		String[] hasil=null;
		
		db = new DBSingle();
		hasil = db.hasilStmtH("SELECT nama AS NAME, "
				+ "email AS EMAIL, "
				+ "phone AS PHONE, "
				+ "alamat AS ADDRESS, "
				+ "grup AS 'GROUP',"
				+ "status as 'STATUS',"
				+ "(SELECT tanggal from interview WHERE id_kandidat="+id+"), "
				+ "(SELECT jam_mulai from interview WHERE id_kandidat="+id+"),"
				+ "(SELECT jam_selesai from interview WHERE id_kandidat="+id+"),"
				+ "(SELECT dengan from interview WHERE id_kandidat="+id+"),"
				+ "(SELECT lokasi from interview WHERE id_kandidat="+id+"),"
				+ "(SELECT deskripsi from interview WHERE id_kandidat="+id+")"
				+ " from kandidat"
				+ " WHERE id_kandidat="+id);
		return hasil;
	}
	
	public Kandidat getDetailG(String id){
		String[] hasil=null;
		
		db = new DBSingle();
		hasil = db.hasilStmtH("SELECT nama AS NAME, "
				+ "email AS EMAIL, "
				+ "phone AS PHONE, "
				+ "alamat AS ADDRESS, "
				+ "grup AS 'GROUP',"
				+ "status as 'STATUS',"
				+ "education as 'EDUCATION',"
				+ "experience as 'EXPRERIENCE'"
				+ " from kandidat"
				+ " WHERE id_kandidat='"+id+"'");
		
		kand.setNama(hasil[0]);
		kand.setEmail(hasil[1]);
		kand.setPhone(hasil[2]);
		kand.setAlamat(hasil[3]);
		kand.setGroup(hasil[4]);
		kand.setStatus(hasil[5]);
		kand.setEducation(hasil[6]);
		kand.setExperience(hasil[7]);
		
		return kand;
	}
	
	public void addCandidate(Kandidat kan, String username, String id_pekerjaan){
		db = new DBSingle();
		db.execute("INSERT into kandidat VALUES("
				+ "NULL,"
				+ "'"+username+"',"
				+ "'"+id_pekerjaan+"',"
				+ "'"+kan.getStatus()+"',"
				+ "'"+kan.getEducation()+"',"
				+ "'"+kan.getExperience()+"',"
				+ "'"+kan.getGroup()+"',"
				+ "'"+kan.getNama()+"',"
				+ "'"+kan.getPhone()+"',"
				+ "'"+kan.getEmail()+"',"
				+ "'"+kan.getAlamat()+"'"
				+ ")");
	}
	
	public void editCandidate(Kandidat kan, String username, String id_pekerjaan){
		db = new DBSingle();
		db.execute("UPDATE kandidat "
				+ "SET "
				+ "username='"+username+"',"
				+ "id_pekerjaan='"+id_pekerjaan+"',"
				+ "status='"+kan.getStatus()+"',"
				+ "education='"+kan.getEducation()+"',"
				+ "experience='"+kan.getExperience()+"',"
				+ "grup='"+kan.getGroup()+"',"
				+ "nama='"+kan.getNama()+"',"
				+ "phone='"+kan.getPhone()+"',"
				+ "email='"+kan.getEmail()+"',"
				+ "alamat='"+kan.getAlamat()+"'"
				+ " WHERE id_kandidat='"+kan.getId_kandidat()+"'");
	}
	
	public void deleteCandidate(String id_kandidat){
			db = new DBSingle();
			db.execute("DELETE from kandidat "
					+ "WHERE id_kandidat='"+id_kandidat+"'");
	}
	public void editGroup(String id_kandidat, String group){
		db= new DBSingle();
		db.execute("UPDATE kandidat SET "
				+ "grup='"+group+"' "
				+ "WHERE id_kandidat='"+id_kandidat+"'");
	}
	
	public void editStatus(String id_kandidat, String status){
		db= new DBSingle();
		db.execute("UPDATE kandidat SET "
				+ "status='"+status+"' "
				+ "WHERE id_kandidat='"+id_kandidat+"'");
	}


}
