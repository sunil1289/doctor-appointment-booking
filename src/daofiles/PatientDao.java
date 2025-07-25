package daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PatientBean;
import dba.ConnectionProvider;

public class PatientDao {

    // Validate patient credentials (email and password)
    public static boolean validate(String email, String password) {  
        boolean status = false;
        try {    
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Patients WHERE email=? AND password=?");
            ps.setString(1, email);  
            ps.setString(2, password);  

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int save(PatientBean pb) {
        int status = 0;
        try {
            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Patients(name, dob, address, gender, contact, email, password) VALUES(?,?,?,?,?,?,?)");
            
            ps.setString(1, pb.getName());
            ps.setString(2, pb.getDob());
            ps.setString(3, pb.getAddress());
            ps.setString(4, pb.getGender());
            ps.setString(5, pb.getContact());
            ps.setString(6, pb.getEmail());
            ps.setString(7, pb.getPassword());

            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

   
    public static List<PatientBean> getAllPatient() {  
        List<PatientBean> list = new ArrayList<>();  
          
        try {  
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Patients ORDER BY id");  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {  
                PatientBean pb = new PatientBean();  
                pb.setId(rs.getInt(1));  
                pb.setName(rs.getString(2));
                pb.setDob(rs.getString(3));
                pb.setAddress(rs.getString(4));
                pb.setGender(rs.getString(5));
                pb.setContact(rs.getString(6));
                pb.setEmail(rs.getString(7));
                pb.setPassword(rs.getString(8));
                
                list.add(pb);
            }
            con.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;  
    }

    
    public static int update(PatientBean up) {  
        int status = 0;  
        try {  
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ups = con.prepareStatement("UPDATE Patients SET name=?, address=?, contact=?, password=? WHERE email=?");
            
            ups.setString(1, up.getName()); 
            ups.setString(2, up.getAddress());
            ups.setString(3, up.getContact()); 
            ups.setString(4, up.getPassword());
            ups.setString(5, up.getEmail());
            
            status = ups.executeUpdate();  
            con.close();  
      
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }

        return status;
    }
}
