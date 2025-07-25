package dba;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
	    Connection con = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorappointment", "root", "");
	        System.out.println("Database connected successfully!");
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return con;
	}
}