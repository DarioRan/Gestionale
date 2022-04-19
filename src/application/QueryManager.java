package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class QueryManager {
	
	Connection conn;
	public QueryManager() 
	{
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 Properties connectionProps = new Properties();
         connectionProps.put("user", "root");
         connectionProps.put("password", "");
         
		 try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",connectionProps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String[]> Query(String query, String[] campi) throws SQLException 
	{
		 Statement stmt;
         PreparedStatement pstmt;
         ResultSet rs = null;
         ArrayList<String[]> Risultato = new ArrayList<String[]>();
         
        
         
		 try {
			stmt = conn.createStatement();
			 rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
         try {
			while(rs.next())
			 {
				String[] ArrayRis=new String[campi.length];
				for(int i=0; i<campi.length; i++) 
				{
					
					ArrayRis[i]=rs.getString(campi[i]);
				}
				Risultato.add(ArrayRis);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         conn.close(); 
         return Risultato;
         
	}
	
	/*public static void main(String[] args) {
		
			QueryManager q= new QueryManager();
			String[] Chiavi={"Nome","CodProdotto","Prezzo"};
			ArrayList<String[]> Risultato = null;
		
			try {
				Risultato=q.Query("SELECT * FROM prodotti",Chiavi );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("Ris:"+Risultato.get(0)[0]);
			for(int i=0;i<Risultato.size();i++) 
			{
				for(int j=0; j<Risultato.get(i).length; j++) 
				{
					System.out.println("Ris:"+Risultato.get(i)[j]);
				}
			}
		
	}*/

	
	public boolean Query(String query) 
	{
		 Statement stmt;
         PreparedStatement pstmt;
         
        
         
		 try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		return false;
	}
}
