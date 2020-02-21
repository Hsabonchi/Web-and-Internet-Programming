package LAb10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login_server
 */
@WebServlet("/Login_server")
public class Login_server extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Login_server() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		
		// Set the content type to HTML
				response.setContentType("text/html");
				
				// Get a reference to the Print Write to talk back to the client

				PrintWriter out=response.getWriter();
				
				out.println("<!DOCTYPE html>");
				
				out.println("<html lang=\"en\">");
				
				out.println("<head>");
				out.println("	<meta charset=\"UTF-8\">");
				out.println("	<title>Candidate</title>");
				out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\""
						+ " crossorigin=\"anonymous\">");
				
				out.println("</head>");
				
				out.println("<body>");
				
				
				out.println("<div class=\"container\">");
				out.println("	<h1> Login </h1>");
				
				
		        out.println("	<form  class='border' method='post'>");
				
				out.println("		<label>Username</label> <input type='text'   value=''   style='margin-left:30px'  name='name'> <br>");
				out.println("	<hr>");
				
				out.println("		<label>Password</label> <input type='text'   value=''   style='margin-left:30px'  name='password'> <br>");
				out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Login\">");
				out.println("	</form>");
				
				
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
		
		
				
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();

		String username="cysun";
		String password="abcd";
		
			
		
		String	 str1=request.getParameter("name");
		String	 str2=request.getParameter("password");
		    
		    /*
		     * 
		     *  if(str1== null||str2==null||str1.trim().length()==0||str2.trim().length()==0){
			
		//you need to add return statment to terminate the program
		 return;
		 }
		     */
		
		
		 if (str1.equals(username) && str2.equals(password) ) {
			 
			 //out.println("	<h1> correct </h1>");
			 request.getSession().setAttribute("username",username);
			 response.sendRedirect("Member");
			 
		 }
		
		 else
			 response.sendRedirect("Login_server");
		
		
		
	}

}
