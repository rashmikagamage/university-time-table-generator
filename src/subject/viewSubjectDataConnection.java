package subject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewSubjectDataConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	

	
	
	public ResultSet viewSubjects() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT `subName` as `Subject`,`subCode` as `Code`,`subYear` as `Year`,`subSem` as `Semester`,`lecHours`,`tuteHours`,`labHours`,`evlHours` FROM subjects";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	public ResultSet getSubjectsByCode(String code){
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM `subjects` WHERE `subCode` = ? ";
			ps = connection.prepareStatement(query);
			ps.setString(1, code);
			
			 rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public void updateSubject(String name,String code,String year,String sem,int lec,int tute,int lab,int evl,String stableCode) {
		
		try {
			
			
				String query = "UPDATE `subjects` SET `subName` = ? , `subCode` = ? , `subYear` = ? ,`subSem` = ? ,`lecHours`=? , "
						+ "`tuteHours` = ?, `labHours`=? , `evlHours`=?  where `subCode` = ? ";
				
				ps = connection.prepareStatement(query);
			    ps.setString(1,name );
			    ps.setString(2,code );
			    ps.setString(3,year );
			    ps.setString(4,sem);
			    ps.setInt(5,lec);
			    ps.setInt(6,tute);
			    ps.setInt(7,lab);
			    ps.setInt(8,evl);
			    ps.setString(9,stableCode);
			    ps.executeUpdate();
			    
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	
	public void deleteSubject(String code) {
		
		String query = "DELETE FROM `subjects` WHERE `subCode`=?";
			 try {
				ps = connection.prepareStatement(query);
				ps.setString(1,code);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
	
	

}
