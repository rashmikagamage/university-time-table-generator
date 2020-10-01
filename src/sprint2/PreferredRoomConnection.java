package sprint2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreferredRoomConnection {
	public void preferRoom(String tag,String module,String room){
        
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
}
