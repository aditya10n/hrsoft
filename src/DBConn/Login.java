package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import Kelas.Staff;

public class Login{
	
	public boolean cekPass(String username, String password){
		String pass;
		boolean hasil= false;
		DBSingle db = new DBSingle();
		pass = db.hasilStmt("select * from staff where username='"+username+"'");
		
		if(password.equals(pass)){
			hasil = true;
		}
		return hasil;
	}
}
