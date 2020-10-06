package statistics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatConnection {
	
	db_connection.DB_Connection obj_DB_Connection=new db_connection.DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();
	PreparedStatement ps=null;
	
	//returns number of lecturers
	public ResultSet lecturerNo() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT COUNT(*) FROM lects";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//returns result set for lecture graph
		public ResultSet lecturerLevel() {
			
			ResultSet rs = null;
			try {
				String query = "SELECT levelString, count(levelString) as count FROM lects GROUP BY levelString";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}
		
	//returns number of students
	public ResultSet studentNo() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT COUNT(*) FROM students";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//returns result set for student graph
			public ResultSet studentLevel() {
				
				ResultSet rs = null;
				try {
					String query = "SELECT programme, count(programme) as count FROM students GROUP BY programme";
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return rs;
			}

	//returns number of subjects
	public ResultSet subjectNo() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT COUNT(*) FROM subjects";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//returns result set for student graph
	public ResultSet subjectLevel() {
		
		ResultSet rs = null;
		try {
			String query = "SELECT subYear, count(subYear) as count FROM subjects GROUP BY subYear";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}


