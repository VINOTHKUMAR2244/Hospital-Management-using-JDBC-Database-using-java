package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(" com. mysql. cj. jdbc.");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","12password12");
		return con;
	}

}
