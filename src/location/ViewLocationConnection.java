package location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewLocationConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	//returns all locations
	public ResultSet viewLocation() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `idlocation` as `Location ID`, `buildingName` as `Building Name`,`roomType` as `Room Type`,`room` as `Room Name`,`capability` as `Max Size` FROM location";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(rs);
		return rs;
	}
	
	//returns location with id
	public ResultSet getLocation(String idlocation){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `location` WHERE `idlocation` = ? ";
			ps = connection.prepareStatement(query);
			ps.setString(1, idlocation);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//updates a location
	public void updateLocation(String buildingName,String roomType,String roomName,String capability, String idlocation) {
		
		try {
				String query = "UPDATE `location` SET `buildingName` = ? , `roomType` = ? , `room` = ? 	,`capability` = ? where `idlocation` = ? ";	
				
				 ps = connection.prepareStatement(query);
				    ps.setString(1,buildingName);
				    ps.setString(2,roomType );
				    ps.setString(3,roomName );
				    ps.setString(4,capability);
				    ps.setString(5,idlocation );
				    ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	//deletes location
	public void deleteLocation(String idlocation) {
		String query ="";
			
			System.out.println(idlocation);
			 query = "DELETE FROM `location` WHERE `idlocation`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setString(1,idlocation);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}	
		
	}
	


