package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addDataAddTimeSlots {
	
	public void insertTimeSlots(String timeSlotType, Integer startH, Integer startM, Integer endH, Integer endM, Integer workH, Integer workM){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `timeSlots` (`slotType`,`startHour`,`startMinute`,`endHour`,`endMinute`,`workHours`,`workMinutes`) VALUES (?,?,?,?,?,?,?)";
		     ps = 
		    connection.prepareStatement(query);
		    ps.setString(1,timeSlotType );
		    ps.setInt(2,startH );
		    ps.setInt(3,startM);
		    ps.setInt(4,endH);
		    ps.setInt(5,endM);
		    ps.setInt(6,workH);
		    ps.setInt(7,workM);
		    
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }

}
