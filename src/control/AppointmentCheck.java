package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daofiles.AppointmentDao;
import daofiles.DoctorDao;
import beans.AppointmentBean;
import beans.DocBean;
import java.sql.Date;

@WebServlet("/AppointmentCheck")
public class AppointmentCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AppointmentCheck() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>My Appointments</title></head>");
        out.print("<body bgcolor='#ADD8E6'>");

        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        HttpSession session = request.getSession(true);

        if (session.getAttribute("email") == null) {
            response.sendRedirect("DoctorLogin.jsp");
        } else {
            String email = (String) session.getAttribute("email");
            out.println("Hello, " + email);
        }

        String email = (String) session.getAttribute("email");
        int id = Integer.parseInt(request.getParameter("id"));
        out.print("<center> <h1 style='background-color:lightgreen'>My Appointments</h1>");
        out.print("<table border='1px solid black' height='10%' width='70%'><tr>");
        out.print("<th style='background-color:#2874A6'>Patient Name</th><th style='background-color:#2874A6'>Email</th><th style='background-color:#2874A6'>Contact</th>");
        out.print("<th style='background-color:#2874A6'>Age</th><th style='background-color:#2874A6'>Date</th><th style='background-color:#2874A6'>Specialty</th>");
        out.print("<th style='background-color:#2874A6'>Description</th><th style='background-color:#2874A6'>Cancel</th></tr>");

        // Fetch doctor details
        DocBean dbe = DoctorDao.getDoctor(id, email);
        if (id == dbe.getId() || email.equals(dbe.getEmail())) {
            // Fetch appointments for this doctor
            ArrayList<AppointmentBean> list = AppointmentDao.getAppointmentById(id);
            for (AppointmentBean apps : list) {
                // Convert the day (String) to Date object
                Date appointmentDate = Date.valueOf(apps.getDay());

                // Check if the doctor is available on this date
                if (AppointmentDao.isDoctorAvailableOnDate(id, appointmentDate)) {
                    out.print("<tr style='background-color:white'><td>" + apps.getName() + "</td><td>" + apps.getEmail() + "</td>");
                    out.print("<td>" + apps.getContact() + "</td><td>" + apps.getAge() + "</td>");
                    out.print("<td>" + apps.getDay() + "</td><td>" + apps.getSpecialty() + "</td>");
                    out.print("<td>" + apps.getDescription() + "</td>");
                    out.print("<td><a href='CancelAppointment?id=" + apps.getApid() + "'>Cancel</a></td></tr>");
                } else {
                    out.print("<tr style='background-color:yellow'><td colspan='8'>Doctor is unavailable on " + apps.getDay() + ".</td></tr>");
                }
            }
        } else {
            out.print("<h3>Please Enter your Correct Id</h3>");
        }
        out.print("</table>");
        out.print("</div></center>");
        out.print("</body>");
        out.print("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Method is not used in this case, but could be implemented if needed
    }
}
