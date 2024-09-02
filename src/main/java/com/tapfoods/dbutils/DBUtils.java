package com.tapfoods.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

final public class DBUtils {
	private static String url="jdbc:mysql://localhost:3306/tapfoods";
	private static String username="root";
	private static String password="Rahul@02";
	private static Connection con=null;

	public static Connection myConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
