package fis.java.topic4.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static Connection conn;
	
	public static final String DB_USER = "root";
	
	public static final String DB_PASSWORD = "Nothing@135";
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/banking";
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(DRIVER_NAME);
				
				conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
