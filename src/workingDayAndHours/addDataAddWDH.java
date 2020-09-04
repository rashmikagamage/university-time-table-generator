package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addDataAddWDH {
	
	public void insertWDH(String wType, Integer wNoDays, String wWorkTime){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `workingDaysHours` (`wdhType`,`wdhNoDays`,`wdhWorkingTime`) VALUES (?,?,?)";
		     ps = 
		    connection.prepareStatement(query);
		    ps.setString(1,wType );
		    ps.setInt(2,wNoDays );
		    ps.setString(3,wWorkTime);
		    
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }

}
