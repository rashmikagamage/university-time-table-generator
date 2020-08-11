package subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class addSubjectDataConnection {
	
	 public void insertSubject(String name,String code,String year,String sem,int lec,int tute,int lab,int evl){
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `subjects` (`subName`,`subCode`,`subYear`,`subSem`,`lecHours`,"
			    		+ "`tuteHours`,`labHours`,`evlHours`) VALUES (?,?,?,?,?,?,?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,name );
			    ps.setString(2,code );
			    ps.setString(3,year );
			    ps.setString(4,sem);
			    ps.setInt(5,lec);
			    ps.setInt(6,tute);
			    ps.setInt(7,lab );
			    ps.setInt(8,evl );
			  
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		    }
	

}
