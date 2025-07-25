package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import daofiles.PatientDao;


@WebServlet("/PatientLog")
public class PatientLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PatientLog() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>AdminDocReg</title>");
	        out.println("</head>");
	        out.print("<body>");
	        String email=request.getParameter("email");  
	        String password=request.getParameter("password");  
	              
	        if(PatientDao.validate(email,password)){  
	           
	            out.println("Welcome"+email);
	            HttpSession session=request.getSession(true);
	            session.setAttribute("email",email);
	           
	            response.sendRedirect("PatientHome.jsp");
	        }  
	        else{  		
	        	  RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");  
		            rd.forward(request,response);    
	        }  
	              
	        out.close(); 
	        
	        out.print("</body>");
	        out.print("</html>");

	}

}
