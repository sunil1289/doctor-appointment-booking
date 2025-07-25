package daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;  // Add this import
import java.util.ArrayList;  // Add this import
import dba.ConnectionProvider;
import beans.DocBean;

public class DoctorDao {

    
    public static boolean validate(String email, String password) {
        boolean status = false;
        String query = "SELECT * FROM doctors WHERE email=? AND password=?";
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

   
    public static int save(DocBean db) {
        int status = 0;
        String query = "INSERT INTO doctors (docname, email, password, specialty, contact, fees, doctor_time, am_pm, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, db.getDocname());
            ps.setString(2, db.getEmail());
            ps.setString(3, db.getPassword());
            ps.setString(4, db.getSpecialty());
            ps.setString(5, db.getContact());
            ps.setInt(6, db.getFees());
            ps.setString(7, db.getDoctorTime());
            ps.setString(8, db.getAmPm());
            ps.setString(9, "available"); 

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    
    public static int update(DocBean doc) {
        int status = 0;
        String query = "UPDATE doctors SET docname=?, password=?, contact=?, fees=?, doctor_time=?, am_pm=? WHERE email=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, doc.getDocname());
            ps.setString(2, doc.getPassword());
            ps.setString(3, doc.getContact());
            ps.setInt(4, doc.getFees());
            ps.setString(5, doc.getDoctorTime());
            ps.setString(6, doc.getAmPm());
            ps.setString(7, doc.getEmail());

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        String query = "DELETE FROM doctors WHERE id=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    
    public static DocBean getDoctor(int id, String email) {
        DocBean db = null;
        String query = "SELECT * FROM doctors WHERE id=? AND email=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                db = new DocBean();
                db.setId(rs.getInt(1));
                db.setDocname(rs.getString(2));
                db.setEmail(rs.getString(3));
                db.setPassword(rs.getString(4));
                db.setSpecialty(rs.getString(5));
                db.setContact(rs.getString(6));
                db.setFees(rs.getInt(7));
                db.setDoctorTime(rs.getString(8));
                db.setAmPm(rs.getString(9));
                db.setStatus(rs.getString("status")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return db;
    }

   
    public static List<DocBean> getAllDoctors() {
        List<DocBean> list = new ArrayList<>();
        String query = "SELECT * FROM doctors ORDER BY id";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DocBean db = new DocBean();
                db.setId(rs.getInt(1));
                db.setDocname(rs.getString(2));
                db.setEmail(rs.getString(3));
                db.setPassword(rs.getString(4));
                db.setSpecialty(rs.getString(5));
                db.setContact(rs.getString(6));
                db.setFees(rs.getInt(7));
                db.setDoctorTime(rs.getString(8));
                db.setAmPm(rs.getString(9));
                db.setStatus(rs.getString("status")); 
                list.add(db);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public static boolean isDoctorAvailable(int doctorId) {
        boolean isAvailable = false;
        String query = "SELECT status FROM doctors WHERE id=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                isAvailable = "available".equalsIgnoreCase(status);  // Only available doctors can be booked
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailable;
    }

   
    public static int updateDoctorStatus(int doctorId, String status) {
        int result = 0;
        String query = "UPDATE doctors SET status=? WHERE id=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, status);
            ps.setInt(2, doctorId);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
