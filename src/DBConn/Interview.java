package DBConn;

public class Interview {
	SetConn conn;
	DBSingle db;
	
	
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
	
	
	
}
