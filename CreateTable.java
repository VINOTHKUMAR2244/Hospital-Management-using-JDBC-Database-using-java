package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		String dbURL="jdbc:mysql://localhost:3306/hospital";
		String user="root";
		String pass="12password12";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(dbURL,user,pass);
			Statement st=con.createStatement();
			String sql="create table if not exists java(code int,"
					+ "hours int)";
			st.executeUpdate(sql);
			System.out.println("Table created");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
