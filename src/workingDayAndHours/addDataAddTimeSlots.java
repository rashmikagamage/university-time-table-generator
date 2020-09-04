package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addDataAddTimeSlots {
	
	public void insertTimeSlots(String timeSlotType, String startTime, String endTime, String timeSlotDay){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `timeSlots` (`type`,`startTime`,`EndTime`,`Day`) VALUES (?,?,?,?)";
		     ps = 
		    connection.prepareStatement(query);
		    ps.setString(1,timeSlotType );
		    ps.setString(2,startTime );
		    ps.setString(3,endTime );
		    ps.setString(4,timeSlotDay);
		    
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }

}
