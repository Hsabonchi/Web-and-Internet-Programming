package LAb10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("username")==null) {
			
			response.sendRedirect("Login_server");
			
		}
		
		
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		
		out.println("<html lang=\"en\">");
		
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Memebers</title>");
		
		
		out.println("</head>");
		
		out.println("<body>");
		
		
		out.println("<div class=\"container\">");
		out.println("	<h1> Welcome to the Members Area </h1>");
		out.println("<a href=\"Logout\">Logout</a>");

        
		
	
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");


		


		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
