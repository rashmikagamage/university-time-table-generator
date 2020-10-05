package ConsecutiveSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CSData {
	
	public ArrayList<String> getData() {
		
		ArrayList<String> data = new ArrayList<String>();
		
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
	       
		try {
	            
		    String query="select * from `sessions`";
		    ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	
			    data.add(rs.getString("id")+","+rs.getString("subject")+","+rs.getString("code")+","+rs.getString("tag")+","+rs.getString("count")+","+rs.getString("duration"));
			  }
	       
		} catch (Exception e) {
		    System.out.println(e);
		}
		return data;
	}
	
	public void addData(String cat,String s) {
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		String query = "insert into `parallelSessions`(`category`,`sessions`) values(?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, cat);
			ps.setString(2, s);;
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
