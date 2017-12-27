package DBConn;

import javax.swing.table.DefaultTableModel;

public class Interview {
	SetConn conn;
	DBSingle db;
	
	public DefaultTableModel interviewList(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT interview.tanggal, interview.jam_mulai, "
				+ "interview.jam_selesai, kandidat.nama, "
				+ "pekerjaan.nama, interview.dengan, "
					+ "(SELECT COUNT(interview.tanggal)  "
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan) AS COUNT "
				+ "FROM interview, kandidat, pekerjaan "
				+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
				+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan");

		dm.setDataVector(ob,
				new String[] { 
			"DATE", "FROM", "TO","CANDIDATE","JOB","WITH"
			});
		
		return dm;
		
	}
	
	public DefaultTableModel interviewToday(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT interview.tanggal, interview.jam_mulai, "
				+ "interview.jam_selesai, kandidat.nama, "
				+ "pekerjaan.nama, interview.dengan, "
					+ "(SELECT COUNT(interview.tanggal)  "
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "interview.tanggal=current_date AND "
						+ "kandidat.grup <>'DROP') AS COUNT "
				+ "FROM interview, kandidat, pekerjaan "
				+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
				+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
				+ "interview.tanggal=current_date AND "
				+ "interview.hasil is null AND kandidat.grup <>'HIRED' AND "
				+ "kandidat.grup <>'DROP'");
		
		dm.setDataVector(ob,
				new String[] { 
			"DATE", "FROM", "TO","CANDIDATE","JOB","WITH"
			});
		
		return dm;
		
	}
	
	public DefaultTableModel interviewLater(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT interview.tanggal, interview.jam_mulai, "
						+ "interview.jam_selesai, kandidat.nama, "
						+ "pekerjaan.nama, interview.dengan, "
							+ "(SELECT COUNT(interview.tanggal)  "
								+ "FROM interview, kandidat, pekerjaan "
								+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
								+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
								+ "interview.tanggal>current_date AND "
								+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
								+ "kandidat.grup <>'DROP') AS COUNT "
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "interview.tanggal>current_date AND "
						+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
						+ "kandidat.grup <>'DROP'");
		dm.setDataVector(ob,
				new String[] { 
			"DATE", "FROM", "TO","CANDIDATE","JOB","WITH"
			});
		
		return dm;
		
	}

	public DefaultTableModel interviewMissed(){
	
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT interview.tanggal, interview.jam_mulai, "
						+ "interview.jam_selesai, kandidat.nama, "
						+ "pekerjaan.nama, interview.dengan, "
							+ "(SELECT COUNT(interview.tanggal)  "
								+ "FROM interview, kandidat, pekerjaan "
								+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
								+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
								+ "interview.tanggal<current_date AND "
								+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
								+ "kandidat.grup <>'DROP') AS COUNT "
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "interview.tanggal<current_date AND "
						+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
						+ "kandidat.grup <>'DROP'");
	
		dm.setDataVector(ob,
				new String[] { 
			"DATE", "FROM", "TO","CANDIDATE","JOB","WITH"
			});
		
		return dm;
	
	}
	
	public DefaultTableModel interviewFinished(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT interview.tanggal, interview.jam_mulai, "
						+ "interview.jam_selesai, kandidat.nama, "
						+ "pekerjaan.nama, interview.dengan, "
							+ "(SELECT COUNT(interview.tanggal)  "
								+ "FROM interview, kandidat, pekerjaan "
								+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
								+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
								+ "(interview.tanggal<current_date AND "
								+ "interview.hasil is NOT NULL) OR "
								
								+ "(kandidat.id_kandidat=interview.id_kandidat AND "
								+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
								+ "kandidat.grup='HIRED') OR "
								
								+ "(kandidat.id_kandidat=interview.id_kandidat AND "
								+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
								+ "kandidat.grup='DROP')) AS COUNT "
								
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						
							+ "(interview.tanggal<current_date AND "
							+ "interview.hasil is NOT NULL) OR "
							
							+ "(kandidat.id_kandidat=interview.id_kandidat AND "
							+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
							+ "kandidat.grup='HIRED') OR "
						
							+ "(kandidat.id_kandidat=interview.id_kandidat AND "
							+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
							+ "kandidat.grup='DROP')");
	
		dm.setDataVector(ob,
				new String[] { 
			"DATE", "FROM", "TO","CANDIDATE","JOB","WITH"
			});
		
		return dm;
	
	}
	
	public void update(String id_kandidat, Kelas.Interview inter){
		db = new DBSingle();
		
			db.execute("UPDATE interview SET "
					+ "tanggal='"+inter.getTanggal()+"', "
					+ "jam_mulai='"+inter.getJam_mulai()+"', "
					+ "jam_selesai='"+inter.getJam_selesai()+"', "
					+ "dengan='"+inter.getDengan()+"',  "
					+ "lokasi='"+inter.getLokasi()+"', "
					+ "deskripsi='"+inter.getDeskripsi()+"' "
							+ "WHERE id_kandidat='"+id_kandidat+"'");
			
		
	}
	
	public void add(String id_kandidat, Kelas.Interview inter){
		db = new DBSingle();
		
			db.execute("INSERT INTO interview(id_kandidat,tanggal,jam_mulai,jam_selesai,dengan,lokasi,deskripsi) "
					+ "VALUES("
					+ "'"+id_kandidat+"', "
					+ "'"+inter.getTanggal()+"', "
					+ "'"+inter.getJam_mulai()+"', "
					+ "'"+inter.getJam_selesai()+"', "
					+ "'"+inter.getDengan()+"',  "
					+ "'"+inter.getLokasi()+"', "
					+ "'"+inter.getDeskripsi()+"') ");
			
		
	}
	
	public void delete(String id_kandidat){
		db = new DBSingle();
		
			db.execute("DELETE from interview "
					+ "WHERE id_kandidat='"+id_kandidat+"'");
			
		
	}
	
	public Kelas.Interview getDataFK(String id_kandidat){
		Kelas.Interview inter = new Kelas.Interview();
		db=new DBSingle();
		String[] hasil;
		hasil = db.hasilStmtH("SELECT tanggal, jam_mulai,"
					+ "jam_selesai, dengan, lokasi, deskripsi "
				+ "FROM interview "
				+ "WHERE id_kandidat='"+id_kandidat+"'");
		inter.setTanggal(getTglIndo(hasil[0]));
		inter.setJam_mulai(hasil[1]);
		inter.setJam_selesai(hasil[2]);
		inter.setDengan(hasil[3]);
		inter.setLokasi(hasil[4]);
		inter.setDeskripsi(hasil[5]);
		
		return inter;
	}
	
	public String[] listIdList(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
						+ "FROM interview, kandidat, pekerjaan "
						+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan) AS COUNT "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan");
		return hasil;
	}
	
	public String[] listIdToday(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal=current_date AND "
					+ "interview.hasil is null AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP') AS COUNT "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal=current_date AND "
					+ "interview.hasil is null AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP'");
		return hasil;
	}
	
	public String[] listIdLater(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal>current_date AND "
					+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP') AS COUNT "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal>current_date AND "
					+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP'");
		return hasil;
	}
	
	public String[] listIdMissed(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal<current_date AND "
					+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP') AS COUNT "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					+ "interview.tanggal<current_date AND "
					+ "interview.hasil is NULL AND kandidat.grup <>'HIRED' AND "
					+ "kandidat.grup <>'DROP'");
		return hasil;
	}
	
	public String[] listIdFinished(){
		String[] hasil=null;
		db = new DBSingle();
			hasil = db.hasilStmtV("SELECT kandidat.id_kandidat, "
					+ "(select COUNT(kandidat.id_kandidat) "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					
						+ "(interview.tanggal<current_date AND "
						+ "interview.hasil is NOT NULL) OR "
						
						+ "(kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "kandidat.grup='HIRED') OR "
					
						+ "(kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "kandidat.grup='DROP')) AS COUNT "
					+ "FROM interview, kandidat, pekerjaan "
					+ "WHERE kandidat.id_kandidat=interview.id_kandidat AND "
					+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
					
						+ "(interview.tanggal<current_date AND "
						+ "interview.hasil is NOT NULL) OR "
						
						+ "(kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "kandidat.grup='HIRED') OR "
					
						+ "(kandidat.id_kandidat=interview.id_kandidat AND "
						+ "pekerjaan.id_pekerjaan = kandidat.id_pekerjaan AND "
						+ "kandidat.grup='DROP')");
		return hasil;
	}
	
	public String[] getDetailNow(String id){
		String[] hasil=null;
		
		db = new DBSingle();
		hasil = db.hasilStmtH("SELECT "
				+ "kandidat.nama, "
				+ "kandidat.alamat, "
				+ "kandidat.experience, "
				+ "kandidat.education, "
				+ "pekerjaan.nama,"
				+ "pekerjaan.deskripsi,"
				+ "interview.deskripsi,"
				+ "interview.jam_mulai,"
				+ "interview.jam_selesai,"
				+ "interview.hasil,"
				+ "kandidat.grup "
				+ " from kandidat,pekerjaan,interview "
				+ " WHERE kandidat.id_kandidat='"+id+"' AND "
						+ "kandidat.id_pekerjaan=pekerjaan.id_pekerjaan AND "
						+ "kandidat.id_kandidat=interview.id_kandidat");
		return hasil;
	}
	
	public void updateHasil(String id_kandidat, String hasil){
		db = new DBSingle();
			db.execute("UPDATE interview SET "
					+ "hasil='"+hasil+"' "
					+ "WHERE id_kandidat='"+id_kandidat+"'");
			
		
	}
	
	public String getTglIndo(String tgl){
		db=new DBSingle();
		String hasilf = "";
		String[] hasil;
		hasil = db.hasilStmtH("SELECT "
				+ "DAY('"+tgl+"'), "
				+ "MONTH('"+tgl+"'), "
				+ "YEAR('"+tgl+"')");
		try {
			if(!hasil[0].isEmpty()){
				hasilf= hasil[0] +"-"+hasil[1]+"-"+hasil[2];
			}
		} catch (Exception e) {
			hasilf= "<Date>";
		}
		return hasilf;
	}
	
	
	
	
	
}
