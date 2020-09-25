package not_available;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LecDataConnection {

	public ArrayList<String> getData() {
		
		ArrayList<String> lecs = new ArrayList<String>();
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
	       
		try {
	            
		    String query="select lecName,EmpID from `lects`";
		    ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	
			    lecs.add(rs.getString("lecName"));
			  }
	       
		} catch (Exception e) {
		    System.out.println(e);
		}
		return lecs;
	}
	
	public void addData(String name, String d,int du) {
		System.out.println(d);
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		String query = "insert into `lecturerNotAvailable` values(?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, d);;
			ps.setInt(3,du);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
