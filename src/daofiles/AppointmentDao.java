package daofiles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.AppointmentBean;
import dba.ConnectionProvider;

public class AppointmentDao {

    // Method to check if the doctor is available on the selected date
    public static boolean isDoctorAvailableOnDate(int doctorId, Date date) {
        boolean isAvailable = true;
        String query = "SELECT COUNT(*) FROM appointment WHERE id = ? AND day = ?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, doctorId);  // Doctor ID
            ps.setDate(2, date);      // Date of the appointment
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                isAvailable = false;  // Doctor is already booked on this date
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailable;
    }

    // Save appointment after checking availability
    public static int save(AppointmentBean ab) {  
        int status = 0;
        Date appointmentDate = Date.valueOf(ab.getDay());  // Assuming 'day' is in the format YYYY-MM-DD
        if (!isDoctorAvailableOnDate(ab.getId(), appointmentDate)) {
            // If doctor is not available, return -1 (indicating the appointment cannot be made)
            return -1;
        }

        try (Connection con = ConnectionProvider.getConnection()) {  
            String insertQuery = "INSERT INTO appointment(name, email, contact, age, day, specialty, description, id) VALUES(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, ab.getName()); 
                ps.setString(2, ab.getEmail());
                ps.setString(3, ab.getContact());
                ps.setInt(4, ab.getAge());
                ps.setString(5, ab.getDay());
                ps.setString(6, ab.getSpecialty());  
                ps.setString(7, ab.getDescription());
                ps.setInt(8, ab.getId());

                status = ps.executeUpdate();  

                if (status > 0) {
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            ab.setApid(generatedKeys.getInt(1)); 
                        }
                    }
                }
            }  
        } catch(Exception ex) {
            System.err.println("Error saving appointment: " + ex.getMessage());
            ex.printStackTrace();
        }  

        return status;  
    }

    // Fetch appointments by email
    public static ArrayList<AppointmentBean> getAppointmentByEmail(String email) {
        ArrayList<AppointmentBean> list = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment WHERE email=? ORDER BY day");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentBean app = new AppointmentBean();
                app.setApid(rs.getInt("apid"));
                app.setName(rs.getString("name"));
                app.setEmail(rs.getString("email"));
                app.setContact(rs.getString("contact"));
                app.setAge(rs.getInt("age"));
                app.setDay(rs.getString("day"));
                app.setSpecialty(rs.getString("specialty"));
                app.setDescription(rs.getString("description"));
                app.setId(rs.getInt("id"));

                list.add(app);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Fetch appointments by doctor ID
    public static ArrayList<AppointmentBean> getAppointmentById(int id) {
        ArrayList<AppointmentBean> appointmentList = new ArrayList<>();
        String query = "SELECT * FROM appointment WHERE id=? ORDER BY day";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AppointmentBean appointment = new AppointmentBean();
                    appointment.setApid(rs.getInt("apid"));
                    appointment.setName(rs.getString("name"));
                    appointment.setEmail(rs.getString("email"));
                    appointment.setContact(rs.getString("contact"));
                    appointment.setAge(rs.getInt("age"));
                    appointment.setDay(rs.getString("day"));
                    appointment.setSpecialty(rs.getString("specialty"));
                    appointment.setDescription(rs.getString("description"));
                    appointment.setId(rs.getInt("id"));

                    appointmentList.add(appointment);
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching appointments by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return appointmentList;
    }

    // Fetch all appointments
    public static ArrayList<AppointmentBean> getAllAppointments() {
        ArrayList<AppointmentBean> appointmentList = new ArrayList<>();
        String query = "SELECT * FROM appointment ORDER BY day";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AppointmentBean appointment = new AppointmentBean();
                appointment.setApid(rs.getInt("apid"));
                appointment.setName(rs.getString("name"));
                appointment.setEmail(rs.getString("email"));
                appointment.setContact(rs.getString("contact"));
                appointment.setAge(rs.getInt("age"));
                appointment.setDay(rs.getString("day"));
                appointment.setSpecialty(rs.getString("specialty"));
                appointment.setDescription(rs.getString("description"));
                appointment.setId(rs.getInt("id"));

                appointmentList.add(appointment);
            }
        } catch (Exception e) {
            System.err.println("Error fetching all appointments: " + e.getMessage());
            e.printStackTrace();
        }
        return appointmentList;
    }

    // Delete appointment by doctor ID
    public static int delete(int id) {
        int status = 0;
        String query = "DELETE FROM appointment WHERE id=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Cancel appointment by appointment ID
    public static int cancel(int apid) {  
        int status = 0;  
        String deleteQuery = "DELETE FROM appointment WHERE apid=?";
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            ps.setInt(1, apid);  
            status = ps.executeUpdate();  
        } catch(Exception e) {
            System.err.println("Error canceling appointment: " + e.getMessage());
            e.printStackTrace();
        }  
        return status;  
    }  
}
