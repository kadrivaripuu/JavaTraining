package course.jse.jdbc.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = null;

        	 String userName = "root";
             String password = "tere";
             String url = "jdbc:mysql://localhost:3306/EShopMusic";
             Class.forName ("com.mysql.jdbc.Driver").newInstance ();
             return DriverManager.getConnection (url, userName, password);
		
	}
	
	public void closeConnection(Connection toBeClosed) {
		
	}

}
