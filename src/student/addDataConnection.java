package student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class addDataConnection {
			    
    public void insertStudent(String year,String sem,String group,String subGroup,String programme , String groupId , String subGroupId ){
        
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
        
	try {
            
	    String query="INSERT INTO `students` (`year`,`sem`,`programme`,`group`,`subGroup`,`groupId`,`subGroupId`) VALUES (?,?,?,?,?,?,?)";
	    ps = connection.prepareStatement(query);
	    ps.setString(1,year );
	    ps.setString(2,sem );
	    ps.setString(3,programme );
	    ps.setString(4,group);
	    ps.setString(5,subGroup );
	    ps.setString(6,groupId);
	    ps.setString(7,subGroupId );
	    int rowsInserted = ps.executeUpdate();
            
	} catch (Exception e) {
	    System.out.println(e);
	}
        
    }

}
