package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofiles.AppointmentDao;
import daofiles.DoctorDao;
import beans.AppointmentBean;

@WebServlet("/AppointmentReg")
public class AppointmentReg extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    public AppointmentReg() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Appointment</title>");
        out.println("</head>");
        out.print("<body>"); 

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        int age = Integer.parseInt(request.getParameter("age"));
        String day = request.getParameter("day");
        String specialty = request.getParameter("specialty");
        String description = request.getParameter("description");
        int doctorId = Integer.parseInt(request.getParameter("docid"));

       
        if (DoctorDao.isDoctorAvailable(doctorId)) {
            AppointmentBean ab = new AppointmentBean();
            ab.setName(name);
            ab.setEmail(email);
            ab.setContact(contact);
            ab.setAge(age);
            ab.setDay(day);
            ab.setSpecialty(specialty);
            ab.setDescription(description);
            ab.setId(doctorId);

           
            int status = AppointmentDao.save(ab);
            if (status > 0) {
              
                DoctorDao.updateDoctorStatus(doctorId, "booked");
                request.getRequestDispatcher("PatientViewAppointment.jsp").forward(request, response);
            } else {
                out.println("Sorry! Unable to save the appointment.");
            }
        } else {
            out.println("Sorry! The selected doctor is already booked.");
        }

        out.print("</body>");
        out.print("</html>");
        out.close();
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
