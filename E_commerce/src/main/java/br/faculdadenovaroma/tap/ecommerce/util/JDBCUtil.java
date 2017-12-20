package br.faculdadenovaroma.tap.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static String driver= "com.mysql.jdbc.Driver";
	private static String address= "jdbc:mysql://localhost/db_ecommerce?";
	private static String user = "jdbc:mysql://localhost/db_ecommerce?";
	private static String password= "password";
	
	public JDBCUtil() {
	}

	public static Connection fabrica() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(address, user, password);
		return conn;
	}
}
