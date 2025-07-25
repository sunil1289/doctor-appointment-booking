package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofiles.AppointmentDao;

@WebServlet("/PatientCancelApointment")
public class PatientCancelApointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public PatientCancelApointment() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int apid=Integer.parseInt(request.getParameter("id"));
		AppointmentDao.cancel(apid);
		response.sendRedirect("PatientViewAppointment.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
