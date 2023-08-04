package com.fssa.learnJava.project.taskapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		Connection con = null;
		String url = "jdbc:mysql://164.52.216.41/vinit_core_java_project";
		String userName = "vinit";
		String passWord = "vinit$fssa$2023";
//		try {
//            Class.forName("com.mysql.cj.jdbc.Driver");	// Checks if the Driver is present in the memory. Driver is responsible for connection to DB. Loads a class to memory without instantiating it
		con = DriverManager.getConnection(url, userName, passWord);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Database Driver not found.", e);
//		}
		return con;
		
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
}