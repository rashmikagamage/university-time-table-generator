package parallelSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ParellelSessionData {

	public ArrayList<String> getData() {
		
		ArrayList<String> data = new ArrayList<String>();
		
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
	       
		try {
	            
		    String query="select id,code from `sessions`";
		    ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	
			    data.add(rs.getString("id")+","+rs.getString("code"));
			  }
	       
		} catch (Exception e) {
		    System.out.println(e);
		}
		return data;
	}
	
	public void addData(String id1,String id2) {
		
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		String query = "insert into `ConsecutiveSessions`(`session1`,`session2`) values(?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, id1);
			ps.setString(2, id2);;
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
