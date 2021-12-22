package gen;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getDatabse() {

		Connection conn = null;
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://5.189.166.187:3306/cameroongamepyramid?autoReconnect=true", "root","gloadmin123");
			System.out.println("cameroongamepyramid DB connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	
}