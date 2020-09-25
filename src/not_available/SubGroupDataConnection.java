package not_available;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SubGroupDataConnection {

	public ArrayList<String> getData() {
		
		ArrayList<String> id = new ArrayList<String>();
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
	       
		try {
	            
		    String query="select `subgroupId` from `students`";
		    ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	
			    id.add(rs.getString("subgroupId"));
			  }
	       
		} catch (Exception e) {
		    System.out.println(e);
		}
		return id;
	}
	
	public void addData(String id, String d,int du) {
	
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		String query = "insert into `SubGroupNotAvailable` values(?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, d);;
			ps.setInt(3,du);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
