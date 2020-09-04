package db_connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DB_Connection {
    
     public static void main(String[] args) {
         
	DB_Connection obj_DB_Connection=new DB_Connection();
	Connection connection=null;
	connection=obj_DB_Connection.get_connection();
	System.out.println(connection);
     }
     public Connection get_connection(){
         
	Connection connection=null;
    
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             connection=DriverManager.getConnection("jdbc:mysql://timetable.ct3ibccer38y.us-east-1.rds.amazonaws.com:3306/timetable","admin","rashmika123");
         } catch (SQLException ex) {
             Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
         }
	return connection;
     }
}