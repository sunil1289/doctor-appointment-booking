package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.DocBean;
import daofiles.DoctorDao;

@WebServlet("/DoctorReg")
public class DoctorReg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoctorReg() {
        super();
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>DoctorReg</title></head>");
        out.print("<body>");

        // Retrieve parameters
        String docname = request.getParameter("docname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        int fees = Integer.parseInt(request.getParameter("fees"));
        String doctorTime = request.getParameter("doctorTime"); 
        String amPm = request.getParameter("amPm"); 

       
        DocBean doc = new DocBean();
        doc.setDocname(docname);
        doc.setEmail(email);
        doc.setPassword(password);
        doc.setContact(contact);
        doc.setFees(fees); 
        doc.setDoctorTime(doctorTime);
        doc.setAmPm(amPm); 

        
        int status = DoctorDao.update(doc);  
        if (status > 0) {  
            out.println("<center><h3>Updated successfully!</h3></center>");
            request.getRequestDispatcher("DoctorProfileUpdate.jsp").include(request, response);  
        } else {  
            out.println("<center><h3>Sorry! Unable to update record</h3></center>");
        }  
        out.close();  
        out.print("</body></html>");
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>DoctorReg</title></head>");
        out.print("<body>");

        
        String docname = request.getParameter("docname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String specialty = request.getParameter("specialty");
        String contact = request.getParameter("contact");
        int fees = Integer.parseInt(request.getParameter("fees")); 
        String doctorTime = request.getParameter("doctorTime"); 
        String amPm = request.getParameter("amPm"); 
        


        DocBean db = new DocBean();
        db.setDocname(docname);
        db.setEmail(email);
        db.setPassword(password);
        db.setSpecialty(specialty);
        db.setContact(contact);
        db.setFees(fees); 
        db.setDoctorTime(doctorTime); 
        db.setAmPm(amPm); 

       
        int status = DoctorDao.save(db);  
        if (status > 0) {  
            out.println("<center><h3>Record saved successfully!</h3></center>");
            request.getRequestDispatcher("AddDoctor.jsp").include(request, response);  
        } else {  
            out.println("<center><h3>Sorry! Unable to save record</h3></center>");
        }  
        out.close();  
        out.print("</body></html>");
    }
}
