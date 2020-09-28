package sprint2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuitableRoomConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet grpRetrieve(){
	        
			ResultSet rs = null;
			try {
				String query = "SELECT groupId FROM students";
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
	
	public ResultSet lecturerRetreieve(){
	        
			ResultSet rs = null;
			try {
				String query = "SELECT lecName FROM lects";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}
	
	public ResultSet sessionRetreieve(){
        
		ResultSet rs = null;
		try {
			String query = "SELECT concat(groupId, \"_\", `code`) AS session FROM sessions;";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void suitableLecRoom(String lecturer, String room){	
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `LecturerRoom` (`lecturer`,`room`) VALUES (?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,lecturer );
			    ps.setString(2,room );
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		}
	
	public void suitableSessionRoom(String session, String room){	
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `SessionRoom` (`session`,`room`) VALUES (?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,session );
		    ps.setString(2,room );
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	}
	
	public void suitableGrpRoom(String group, String room){	
        
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try {
	            
		    String query="INSERT INTO `GroupRoom` (`group`,`room`) VALUES (?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,group );
		    ps.setString(2,room );
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	}
}

