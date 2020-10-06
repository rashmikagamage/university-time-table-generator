package workingDayAndHours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addDataViewAll {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet viewSaved() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `wID` as `ID` , `wdhType` as `Type` ,`wdhNoDays` as `Days`,`wMonday` as `Monday`,`wTuesday` as `Tuesday`, `wWednesday` as `Wednesday` , `wThursday` as `Thursday` , `wFriday` as `Friday` , `wSaturday` as `Saturday` , `wSunday` as `Sunday` FROM `workingDaysHours`";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getDaysById(Integer wdhID){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `workingDaysHours` WHERE `wID` = ? ";
			ps = connection.prepareStatement(query);
			ps.setInt(1, wdhID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

	public void updateWDH(Integer wID, String wdhType,Integer wdhNoDays,Boolean wMonday, Boolean wTuesday, Boolean wWednesday, Boolean wThursday, Boolean wFriday, Boolean wSaturday, Boolean wSunday) {
		
		try {
			
			
				String query = "UPDATE `workingDaysHours` SET  `wdhType` = ? , `wdhNoDays` = ? ,`wMonday` = ?, `wTuesday` = ?, `wWednesday` = ?, `wThursday` = ?, `wFriday` = ?, `wSaturday` = ?, `wSunday` = ? where `wID` = ?";
										
				ps = connection.prepareStatement(query);
				
			    ps.setString(1,wdhType );
			    ps.setInt(2,wdhNoDays );
			    ps.setBoolean(3, wMonday);
			    ps.setBoolean(4, wTuesday);
			    ps.setBoolean(5, wWednesday);
			    ps.setBoolean(6, wThursday);
			    ps.setBoolean(7, wFriday);
			    ps.setBoolean(8, wSaturday);
			    ps.setBoolean(9, wSunday);
			    ps.setInt(10, wID);
			    
			    
			    ps.executeUpdate();
			    
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void deleteWDH(Integer wdhId) {
		
		String query = "DELETE FROM `workingDaysHours` WHERE `wID`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setInt(1,wdhId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	

}
