package lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addLecturerDataConnection {
	
	 public void insertLecturer(String lecName,String empID,String faculty,String department,String center,String building,
			 String levelString, int levelNo,String rank ){
	        
			db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
			Connection connection=obj_DB_Connection.get_connection();
			PreparedStatement ps=null;
		        
			try {
		            
			    String query="INSERT INTO `lects` (`lecName`,`empID`,`faculty`,`department`,`center`,`building`,`levelString`,`levelNo`,`rank`) VALUES (?,?,?,?,?,?,?,?,?)";
			     ps = connection.prepareStatement(query);
			    ps.setString(1,lecName );
			    ps.setString(2,empID );
			    ps.setString(3,faculty );
			    ps.setString(4,department);
			    ps.setString(5,center );
			    ps.setString(6,building);
			    ps.setString(7,levelString );
			    ps.setInt(8,levelNo );
			    ps.setString(9,rank );
			    
			    int rowsInserted = ps.executeUpdate();
		            
			} catch (Exception e) {
			    System.out.println(e);
			}
		        
		    }

}
