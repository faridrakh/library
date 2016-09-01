package libman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private Connection conn = null;
	
	public Connection connect() throws ClassNotFoundException, SQLException{
		
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			
			return conn;
		
	}	
}
