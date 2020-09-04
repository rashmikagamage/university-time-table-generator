package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class updateDataConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	public ResultSet getStudentsByGroupId(String groupID){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `students` WHERE `groupId` = ? ";
			ps = connection.prepareStatement(query);
			ps.setString(1, groupID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getStudentsBySubGroupId(String subGroupID){
		ResultSet rs = null;
		
		try {
			String query = "SELECT * FROM `students` WHERE `subGroupId` = ? ";
			ps = connection.prepareStatement(query);
			ps.setString(1, subGroupID);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	public void updateStudent(String year,String sem,String programme,String group,String subGroup,String groupId,String subGroupId,String unChangedGroupID,String unChangedSubId) {
		
		try {
			if(subGroupId.isEmpty()) {
				
				String query = "UPDATE `students` SET `year` = ? , `sem` = ? , `programme` = ? 	,`group` = ? , `groupId` = ?  where `groupId` = ? ";	
				
				 ps = connection.prepareStatement(query);
				    ps.setString(1,year );
				    ps.setString(2,sem );
				    ps.setString(3,programme );
				    ps.setString(4,group);
				    ps.setString(5,groupId);
				    ps.setString(6,unChangedGroupID );
				    ps.executeUpdate();
				    
			}else {
			
				String query = "UPDATE `students` SET `year` = ? , `sem` = ? , `programme` = ? 	,`group` = ? ,`subGroup`=? , `groupId` = ?, `subGroupid`=?  where `subGroupId` = ? ";
				
				ps = connection.prepareStatement(query);
			    ps.setString(1,year );
			    ps.setString(2,sem );
			    ps.setString(3,programme );
			    ps.setString(4,group);
			    ps.setString(5,subGroup);
			    ps.setString(6,groupId);
			    ps.setString(7,subGroupId);
			    ps.setString(8,unChangedSubId );
			    ps.executeUpdate();
			    
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public void deleteStudent(String groupId,String subGroupId) {
		String query ="";
		if(!groupId.isEmpty()) {
			
			System.out.println(groupId);
			 query = "DELETE FROM `students` WHERE `groupId`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setString(1,groupId);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else if(!subGroupId.isEmpty()) {
			
			 query = "DELETE FROM `students` WHERE `subGroupId`=?";
			try {
				ps = connection.prepareStatement(query);
				ps.setString(1,subGroupId);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}	
		
	}
	
	
	

}
