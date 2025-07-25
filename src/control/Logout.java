package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logout() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>AdminLogout</title>");
	        out.println("</head>");
	        out.print("<body>");
           out.print("<p>!!You Successfully Log Out....  </p>");
       		        
	        HttpSession session=request.getSession();
	        session.removeAttribute("email");
	       	session.invalidate();
	   	    response.sendRedirect("Home.jsp");
	       
	        
	        out.println("</body>");
	        out.println("</html>");

		

			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		      
	}

}
