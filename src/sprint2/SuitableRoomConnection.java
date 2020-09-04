package sprint2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SuitableRoomConnection {
	
	public void suitableLecRoom(String lecturer, String room){	
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `slecRoom` (`lecturer`,`room`) VALUES (?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,lecturer );
			    ps.setString(3,room );
			    
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
	            
		    String query="INSERT INTO `sSessionRoom` (`session`,`room`) VALUES (?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,session );
		    ps.setString(3,room );
		    
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
	            
		    String query="INSERT INTO `sgrpRoom` (`group`,`room`) VALUES (?,?)";
		     ps = connection.prepareStatement(query);
		    ps.setString(1,group );
		    ps.setString(3,room );
		    
		    int rowsInserted = ps.executeUpdate();
	            
		} catch (Exception e) {
		    System.out.println(e);
		}
	        
	}
}

