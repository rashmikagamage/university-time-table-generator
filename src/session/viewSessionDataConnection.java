package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewSessionDataConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
public ResultSet viewSessions() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `lects` as `Lecturer(s)` ,`subject` as `Subject`,`code` as `Code`"
					+ ",`tag` as `Tag`,`groupId` as `Group Id`,`count` as `Count`,`duration` as `Duration` FROM sessions";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}
