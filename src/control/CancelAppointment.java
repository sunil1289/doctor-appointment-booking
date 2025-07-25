package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofiles.AppointmentDao;


@WebServlet("/CancelAppointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CancelAppointment() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int apid=Integer.parseInt(request.getParameter("id"));
		AppointmentDao.cancel(apid);
		RequestDispatcher rd=request.getRequestDispatcher("DoctorHome.jsp");
		rd.forward(request, response);
	}	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
