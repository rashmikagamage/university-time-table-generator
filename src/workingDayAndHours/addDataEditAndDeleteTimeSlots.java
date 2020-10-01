package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addDataEditAndDeleteTimeSlots {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet viewSaved() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `idTs` as `ID` , `slotType` as `Type` ,`startHour` as `Start Hour`,`startMinute` as `Start Minutes`, `endHour` as `End Hour`, `endMinute` as `End Minutes`, `workHours` as `Work Hours`, `workMinutes` as `Work Minutes`FROM `timeSlots`";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getDaysById(Integer tID){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `timeSlots` WHERE `idTs` = ? ";
			ps = connection.prepareStatement(query);
			ps.setInt(1, tID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

	public void updateTimeslot(String sType,Integer sHour,Integer sMin, Integer eHour, Integer eMin , Integer wHours, Integer wMins, Integer id) {
		
		try {
			
			
				String query = "UPDATE `timeSlots` SET `slotType` = ? , `startHour` = ? , `startMinute` = ? , `endHour` = ? , `endMinute` = ? , `workHours` = ? , `workMinutes` = ? where `idTs` = ? ";
										
				ps = connection.prepareStatement(query);
			    ps.setString(1,sType );
			    ps.setInt(2,sHour);
			    ps.setInt(3,sMin);
			    ps.setInt(4,eHour);
			    ps.setInt(5,eMin);
			    ps.setInt(6,wHours);
			    ps.setInt(7,wMins);
			    ps.setInt(8,id);
			    
			    
			    ps.executeUpdate();
			    
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void deleteWDH(Integer wdhId) {
		
		String query = "DELETE FROM `timeSlots` WHERE `idTs`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setInt(1,wdhId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	

}