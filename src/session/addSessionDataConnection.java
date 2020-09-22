package session;

import java.sql.PreparedStatement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addSessionDataConnection {
	
	 public void insertSession(String lects,String subject,String code,String tag,String groupId,int count,
			 int duration ){
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `sessions` (`lects`,`subject`,`code`,`tag`,`groupId`,`count`,`duration`) VALUES (?,?,?,?,?,?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,lects );
			    ps.setString(2,subject );
			    ps.setString(3,code );
			    ps.setString(4,tag);
			    ps.setString(5,groupId );
			    ps.setInt(6,count);
			    ps.setInt(7,duration );
			    
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		    }	
	

	

}
