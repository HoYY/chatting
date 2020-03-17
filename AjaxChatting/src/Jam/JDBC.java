package Jam;

import java.sql.*;

public class JDBC {
	public static Connection getMYSQLConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testest", 
	    	  "testaccount", "12341234");
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		return conn;
	}
	public static void close(Connection conn) {
	    try {if(conn !=null) {conn.close();}}catch(Exception e) {e.printStackTrace();}
	}
	public static void close(Statement stmt) {
		try {if(stmt !=null) {stmt.close();}}catch(Exception e) {e.printStackTrace();}
	}
	public static void close(PreparedStatement psmt) {
		try {if(psmt !=null) {psmt.close();}}catch(Exception e) {e.printStackTrace();}
	}
	public static void close(ResultSet rs) {
		try {if(rs !=null) {rs.close();}}catch(Exception e) {e.printStackTrace();}
	}	
}
