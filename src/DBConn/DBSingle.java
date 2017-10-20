package DBConn;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.util.ResultSetUtil;

public class DBSingle {
	SetConn conn = new SetConn();
	
	public String hasilStmt(String string){
		String hasil="";
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://"+conn.host+"/"+conn.db,conn.user,conn.pass);  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(string); 
			while(rs.next()){
				hasil=rs.getString(1);
			}
			
			
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		return hasil;
	}
	
	public String[][] hasilStmt2(String string){
		String[][] hasil=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://"+conn.host+"/"+conn.db,conn.user,conn.pass);  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(string);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			
			rs.next();
			int x=0;
			hasil = new String[Integer.parseInt(rs.getString("COUNT"))][rsmd.getColumnCount()];
			
			do{
				
				for(int i=1;i<rsmd.getColumnCount();i++){
					hasil[x][i-1]=rs.getString(i);
				}
				x++;
			}while(rs.next());
			
			
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		
		return hasil;
		
	}
	
	public String[] hasilStmt3(String string){
		String[] hasil=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://"+conn.host+"/"+conn.db,conn.user,conn.pass);  
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(string);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			hasil=new String[rsmd.getColumnCount()];

			//System.out.println(hasil[]);
			int x=0;
			while(rs.next()){
				hasil[x]=rs.getString(1);
				x++;
			}
			
			
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		
		return hasil;
		
	}
}
