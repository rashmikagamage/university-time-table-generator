package location;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class locationConnection {
	
	 public void insertLocation(String building,String roomType,String room,String capability){
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `location` (`buildingName`,`roomType`,`room`,`capability`) VALUES (?,?,?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,building );
			    ps.setString(2,roomType );
			    ps.setString(3,room );
			    ps.setString(4,capability);
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		    }

}
