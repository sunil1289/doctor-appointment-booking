package daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dba.ConnectionProvider;

public class AdminDao {
    public static boolean validate(String email, String password) {  
        boolean status = false;
        try {    
            Connection conn = ConnectionProvider.getConnection();
            System.out.println("Email: " + email + ", Password: " + password); 

           
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM adminlogin WHERE email=? AND password=?");
            ps.setString(1, email);  
            ps.setString(2, password);  
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            System.out.println("Validation status: " + status); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
