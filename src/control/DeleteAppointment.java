package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daofiles.AppointmentDao;

@WebServlet("/DeleteAppointment")
public class DeleteAppointment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteAppointment() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String did = request.getParameter("id");

        int id = Integer.parseInt(did);
        AppointmentDao.cancel(id); 
        response.sendRedirect("AppointmentDetails.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
