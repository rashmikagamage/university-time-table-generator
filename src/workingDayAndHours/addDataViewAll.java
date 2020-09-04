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
			String query = "SELECT `idworkingDaysHours` as `ID` , `wdhType` as `Type` ,`wdhNoDays` as `Working Days`,`wdhWorkingTime` as `Working Time` FROM `workingDaysHours`";
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
			String query = "SELECT * FROM `workingDaysHours` WHERE `idworkingDaysHours` = ? ";
			ps = connection.prepareStatement(query);
			ps.setInt(1, wdhID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

	public void updateWDH(String wdhType,Integer wdhNoDays,String wdhWorkTime) {
		
		try {
			
			
				String query = "UPDATE `workingDaysHours` SET `wdhType` = ? , `wdhNoDays` = ? , `wdhWorkingTime` = ?";
										
				ps = connection.prepareStatement(query);
			    ps.setString(1,wdhType );
			    ps.setInt(2,wdhNoDays );
			    ps.setString(3, wdhWorkTime);
			    
			    ps.executeUpdate();
			    
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void deleteWDH(Integer wdhId) {
		
		String query = "DELETE FROM `workingDaysHours` WHERE `idworkingDaysHours`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setInt(1,wdhId);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	

}
