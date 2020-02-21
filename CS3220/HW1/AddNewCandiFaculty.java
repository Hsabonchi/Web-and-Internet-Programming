package Candidate_Reviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewCandiFaculty
 */
@WebServlet("/AddNewCandiFaculty")
public class AddNewCandiFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
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
		out.println("	<h1> Add Candidate </h1>");
		
		
        out.println("	<form  class='border' method='post'>");
		
		out.println("		<label>Name:</label> <input type='text'   value=''   style='margin-left:30px'  name='name'> <br>");
		out.println("	<hr>");
		
		
		out.println("	    <label > Specialties:</label> <input    type='text'    style='margin-right:30px'   value='' + ''+  name='Specialties'> <br>");
		out.println("	<hr>");
		out.println("	    <label > Presentation: </label><input    type='text'    style='margin-right:30px'    value='' + ''+ ''  name='Presentation'> <br>");
	
		
		
		
		out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Add\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  name=  request.getParameter("name");
		String  Specialties=request.getParameter("Specialties");
		String  Presentation=request.getParameter("Presentation");
		
		// get a refrence to  the hiringfFculty list in the ServerletContext
		@SuppressWarnings("unchecked")
		ArrayList <hiringfFculty> FaccultyEntries =((ArrayList <hiringfFculty>) getServletContext().getAttribute("FaccultyEntries"));
		FaccultyEntries.add (new hiringfFculty (name, Specialties,Presentation));
		response.sendRedirect("./Candidate");
		
	}

}
