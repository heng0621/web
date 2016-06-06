package com.uitl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";	
	private static final String DB_URL = "jdbc:mysql:///mylibrary?user=root&password=root";
	
	public static Connection getConnection(){
		
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL);
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
