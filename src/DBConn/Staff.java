package DBConn;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Staff {
	Kelas.Staff staff;
	SetConn conn;
	DBSingle db;
	
	public DefaultTableModel UserListmodel(){
		
		DefaultTableModel dm = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		db = new DBSingle();
		Object ob[][] = db.hasilStmt2(
				"SELECT username, password, nama, phone, "
					+ "(SELECT COUNT(username)"
						+ "FROM staff "
						+ ") AS COUNT "
				+ "FROM staff");

		dm.setDataVector(ob,
				new String[] { 
			"USERNAME", "PASSWORD", "NAME", "PHONE"
			});
		
		return dm;
		
	}
	
	public void add(Kelas.Staff staf){
		db = new DBSingle();
		db.execute("INSERT INTO staff values("
				+ "'"+staf.getUsername()+"',"
				+ "'"+staf.getPassword()+"',"
				+ "'"+staf.getNama()+"',"
				+ "'"+staf.getPhone()+"')");
	}
	
	public void delete(String username){
		db = new DBSingle();
		db.execute("DELETE from staff where username='"+username+"'");
	}
	
	public void update(Kelas.Staff staf){
		db = new DBSingle();
		db.execute("UPDATE staff SET "
				+ "username = '"+staf.getUsername()+"',"
				+ "password = '"+staf.getPassword()+"',"
				+ "nama = '"+staf.getNama()+"',"
				+ "phone = '"+staf.getPhone()+"'"
						+ " where username='"+staf.getUsername()+"'");
	}
	
	public String getPass(String username){
		db = new DBSingle();
		return db.hasilStmt("Select password from staff where username ='"+username+"'");
	}
	
	public void setPass(String username, String pass){
		db = new DBSingle();
		db.execute("UPDATE staff SET "
				+ "password = '"+pass+"' "
						+ "where username='"+username+"'");
	}
}
