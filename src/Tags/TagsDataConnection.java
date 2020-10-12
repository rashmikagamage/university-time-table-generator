package Tags;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class TagsDataConnection {

	public void insertTag(String tag) {
		
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try { 
		    String query="INSERT INTO `Tags`(`tag`) VALUES(?)";
		    ps = connection.prepareStatement(query);
		    ps.setString(1, tag);
		    int rowsInserted = ps.executeUpdate();
		    
		} catch (Exception e) {
		    System.out.println(e);
		}	
	}
	//string
	
	public ArrayList<String> getTags() {
	
		ArrayList<String> tags = new ArrayList<String>();
		
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
	        
		try { 
		    String query="SELECT * FROM `Tags`";
		    ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    tags.add(rs.getString("Tag"));
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}	
		
		return tags;
	}
	
	public void deleteTag(String tag) {
		
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		//prepared
		try { 
		    String query="DELETE FROM `Tags` WHERE `Tag` = ?";
		    ps = connection.prepareStatement(query);
		    ps.setString(1, tag);
		    ps.executeUpdate();
		   
		} catch (Exception e) {
		    System.out.println(e);
		}	
	}
	
	public void updateTag(String newTag,String oldTag) {
		
		System.out.println(oldTag + " " + newTag);
		db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		
		try { 
		    String query="Update `Tags` SET `Tag`= ? WHERE `Tag` = ?";
		    ps = connection.prepareStatement(query);
		    ps.setString(1,newTag );
		    ps.setString(2, oldTag);
		    
		    
		    ps.executeUpdate();
		   
		} catch (Exception e) {
		    System.out.println(e);
		}	
	}
	
}
