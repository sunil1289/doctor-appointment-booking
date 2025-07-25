package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.PatientBean;
import daofiles.PatientDao;

@WebServlet("/PatientReg")
public class PatientReg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    public PatientReg() {
        super();
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

       
        PatientBean pb = new PatientBean();
        pb.setName(request.getParameter("name"));
        pb.setDob(request.getParameter("dob"));
        pb.setAddress(request.getParameter("address"));
        pb.setGender(request.getParameter("gender"));
        pb.setContact(request.getParameter("contact"));
        pb.setEmail(request.getParameter("email"));
        pb.setPassword(request.getParameter("password"));

        
        int status = PatientDao.save(pb);
        try (PrintWriter out = response.getWriter()) {
            if (status > 0) {
                out.println("<h3>Registered successfully!</h3>");
                out.println("<br>");
                request.getRequestDispatcher("PatientLogin.jsp").include(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                rd.forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        
        PatientBean up = new PatientBean();
        up.setName(request.getParameter("name"));
        up.setAddress(request.getParameter("address"));
        up.setContact(request.getParameter("contact"));
        up.setEmail(request.getParameter("email"));
        up.setPassword(request.getParameter("password"));

        int status = PatientDao.save(up);
        try (PrintWriter out = response.getWriter()) {
            if (status > 0) {
                out.println("<h3>Registered successfully!</h3>");
                request.getRequestDispatcher("PatientLogin.jsp").include(request, response);
            } else {
                System.out.println("Registration failed: Status is " + status);
                RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
                rd.forward(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
