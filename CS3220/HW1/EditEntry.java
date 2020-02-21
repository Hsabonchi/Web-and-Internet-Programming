package Candidate_Reviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEntry
 */
@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected hiringfFculty getEntry(int id) {
		
		
		ArrayList <hiringfFculty> FaccultyEntries =((ArrayList <hiringfFculty>) getServletContext().getAttribute("FaccultyEntries"));
		
		  for (hiringfFculty entry : FaccultyEntries) {
			  
			  if (entry.getId()==id)
		 
		               return entry;
		  }
		
		  return null;
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id =Integer.parseInt(request.getParameter("id"));
		  
		hiringfFculty entry=getEntry(id);
		
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
		out.println("	<h1> Edit Candidate </h1>");
		
        out.println("	<form  class='border' method='post'>");
        
        out.println("		id: <input readonly value=\"" + entry.getId() + "\" readonly type=\"text\" name=\"\"> <br>");
	
		out.println("	<hr>");
		out.println("		Name: <input value=\"" + entry.getName() + "\" type=\"text\" name=\"candidateName\"> <br>");
		out.println("	<hr>");
		
		
		out.println("		 Specialties: <input value=\"" +entry.getSpecialties() + "\" type=\"text\" name=\"Specia\"> <br>");
		
		out.println("	<hr>");
		out.println("		 Presentation: <input value=\"" +entry.getPresentation() + "\" type=\"text\" name=\"Present\"> <br>");
		
		
		
		out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Save\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String candidateName=request.getParameter("candidateName");
		String Specia=request.getParameter("Specia");
		String Present=request.getParameter("Present");
		
		
		//ArrayList<hiringfFculty> FaccultyEntries =  (ArrayList<hiringfFculty>)request.getServletContext().getAttribute("FaccultyEntries");
		
		int id =Integer.parseInt(request.getParameter("id"));
		  
		hiringfFculty entry=getEntry(id);
		
		

		entry.setName(candidateName);
		entry.setSpecialties(Specia);
		entry.setPresentation(Present);
		
		response.sendRedirect("Candidate");
		
		
		
		
		
		
	}

}
