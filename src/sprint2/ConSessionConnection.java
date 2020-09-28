package sprint2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConSessionConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet consecSessionRetrieve(){
	        
			ResultSet rs = null;
			try {
				String query = "SELECT concat(groupId, '_', `code`) as conSession FROM timetable.sessions WHERE id=(SELECT session1 FROM timetable.ConsecutiveSessions)";
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
	
	public void insertConSession(String cSession,String room){
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `ConsecutiveSessionRoom` (`consecutiveSession`,`room`) VALUES (?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,cSession );
			    ps.setString(2,room );
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		    }

}
