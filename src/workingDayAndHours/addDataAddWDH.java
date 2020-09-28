package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class addDataAddWDH {
	
	public void insertWDH(String wType, Integer wNoDays, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday ){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `workingDaysHours` (`wdhType`,`wdhNoDays`,`wMonday` , `wTuesday`, `wWednesday`, `wThursday` , `wFriday` , `wSaturday` , `wSunday`) VALUES (?,?,?,?,?,?,?,?,?)";
		     ps = 
		    connection.prepareStatement(query);
		    ps.setString(1,wType );
		    ps.setInt(2,wNoDays );
		    ps.setBoolean(3, monday);
		    ps.setBoolean(4, tuesday);
		    ps.setBoolean(5, wednesday);
		    ps.setBoolean(6, thursday);
		    ps.setBoolean(7, friday);
		    ps.setBoolean(8, saturday);
		    ps.setBoolean(9, sunday);
		    
		    
		    
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }

}
