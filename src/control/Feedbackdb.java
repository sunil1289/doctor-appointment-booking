package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daofiles.GeneralDao;
import beans.feedbackbean;


@WebServlet("/Feedbackdb")
public class Feedbackdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Feedbackdb() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		   out.println("<html>");
		   out.println("<head>");
	       out.println("<title>DoctorReg</title>");
	       out.println("</head>");
	       out.print("<body>");
	       
	       String name=request.getParameter("name");
	       String email=request.getParameter("email");
	       String contact=request.getParameter("contact");
	       String suggestion=request.getParameter("suggestion");
		   
	       feedbackbean fb=new feedbackbean();
	       fb.setName(name);
	       fb.setEmail(email);
	       fb.setContact(contact);
	       fb.setSuggestion(suggestion);
	       
	       	int status=GeneralDao.save(fb);
	       if(status>0)	{
	    	   out.print("<h3>Feedback Posted Succesfully !!</h3>");
	    	   request.getRequestDispatcher("Feedback.jsp").include(request, response);
	       }
	       else	{
	    	   out.print("<h3>Please Try Again</h3>");
	       }
	       
	   	   out.print("<br></body>");
	   	   out.print("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
