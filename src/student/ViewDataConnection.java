package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDataConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet viewStudent() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `Year`,`Sem` as `Semester`,`Programme`,`Group` as `Group`,`GroupId` as `Group ID`,`SubGroup` as `Sub Group`,`SubGroupId` as `Sub Group ID` FROM students";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet filterStudent(String sem,String year) {
		ResultSet rs = null;
		try {
			String query = "SELECT `Year`,`Sem` as `Semester`,`Programme`,`Group` as `Group`,`GroupId` as `Group ID`,`SubGroup` as `Sub Group`,`SubGroupId` as `Sub Group ID` FROM students Where `year`=? AND `Sem`=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, year);
			ps.setString(2, sem);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}

}
