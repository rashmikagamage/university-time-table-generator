package sprint2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreferredRoomConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
        
	
	public ResultSet tagsRetrieve(){
        
		ResultSet rs = null;
		try {
			String query = "SELECT Tag FROM Tags";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public ResultSet roomRetreieve(){
	    
		ResultSet rs = null;
		try {
			String query = "SELECT room FROM location";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet moduleRetreieve(){
		    
			ResultSet rs = null;
			try {
				String query = "SELECT subName FROM subjects";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}

	public void insertPrefRoom(String tag,String module,String room){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `preferRoom` (`tag`,`module`,`room`) VALUES (?,?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,tag );
		    ps.setString(2,module );
		    ps.setString(3,room );
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }
	
	public void insertRoomRes(String tag,String module,String room, String date, String sTime, String eTime){
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `ReservedRooms` (`tag`,`module`,`room`, `date`, `startTime`, `endTime`) VALUES (?,?,?,?,?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,tag );
		    ps.setString(2,module );
		    ps.setString(3,room );
		    ps.setString(4, date);
		    ps.setString(5, sTime);
		    ps.setString(6, eTime);
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	    }
}
