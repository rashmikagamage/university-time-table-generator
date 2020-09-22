package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewSessionDataConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
public ResultSet showByLecturer() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `lecName` as `Name` ,`empID` as `ID`,`faculty` as `Faculty`"
					+ ",`department` as `Department`,`center` as `Center`,`building` as `Building`,`levelString` as `Level`,`rank` as `Rank` FROM sessions";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}
