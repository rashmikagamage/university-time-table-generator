package ConsecutiveSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class NotOverLapData {

	
	public void addData(String cat,String s) {
		db_connection.DB_Connection obj_DB_Connection = new db_connection.DB_Connection();
		Connection connection = obj_DB_Connection.get_connection();
		PreparedStatement ps = null;
		String query = "insert into `notOverlap`(`category`,`sessions`) values(?,?)";
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
