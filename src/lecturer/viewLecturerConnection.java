package lecturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewLecturerConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet viewLecturer() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `lecName`,`empID`,`faculty`,`department`,`center`,`building`,`levelString`,`levelNo`,`rank` FROM lecturers";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getLecturersByEmpId(String empID){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `lecturers` WHERE `empID` = ? ";
			ps = connection.prepareStatement(query);
			ps.setString(1, empID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

	public void updateLecturer(String lecName,String empID,String faculty,String department,String center,String building,
			 String levelString,String rank ,String stableId) {
		
		try {
			
			
				String query = "UPDATE `lecturers` SET `lecName` = ? , `empID` = ? , `faculty` = ? 	,`department` = ? ,`center`=? , "
						+ "`building` = ?, `levelString`=? , `rank`=?  where `empID` = ? ";
				
				ps = connection.prepareStatement(query);
			    ps.setString(1,lecName );
			    ps.setString(2,empID );
			    ps.setString(3,faculty );
			    ps.setString(4,department);
			    ps.setString(5,center);
			    ps.setString(6,building);
			    ps.setString(7,levelString);
			    ps.setString(8,rank);
			    ps.setString(9,stableId);
			    ps.executeUpdate();
			    
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void deleteLecturer(String empId) {
		
		String query = "DELETE FROM `lecturers` WHERE `empID`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setString(1,empId);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	

}
