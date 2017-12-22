package DBConn;

public class Interview {
	SetConn conn;
	DBSingle db;
	
	
	public void update(String id_kandidat, String tanggal, String jamM, String jamS, String dengan, String lok, String desk){
		db = new DBSingle();
		
			db.execute("UPDATE interview SET "
					+ "tanggal='"+tanggal+"', "
					+ "jam_mulai='"+jamM+"', "
					+ "jam_selesai='"+jamS+"', "
					+ "dengan='"+dengan+"',  "
					+ "lokasi='"+lok+"', "
					+ "deskripsi='"+desk+"' "
							+ "WHERE id_kandidat='"+id_kandidat+"'");
		
	}
	
	
	
}
