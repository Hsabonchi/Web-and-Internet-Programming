package Candidate_Reviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Candidate")
public class Candidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Candidate() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create an array of hiringfFculty list of Entries
		ArrayList<hiringfFculty> FaccultyEntries = new ArrayList<hiringfFculty>();
		
		// Add some entries to my array list
		//FaccultyEntries.add(new hiringfFculty("Hassan Haj Mohamad","Algorithm","10am on 2/20 in ET A227"));
		
		FaccultyEntries.add(new hiringfFculty("Jack","Computer Vision","10am on 2/25 in ET A332"));
		FaccultyEntries.add(new hiringfFculty("Jane","Machine Learning","3pm on 2/27 in ET A126"));
		FaccultyEntries.add(new hiringfFculty("May","Computer Science Education"	,"3:30pm on 3/11 in FA 21"));
		
		
		// Store the array list in the Servlet Context
		ServletContext context = this.getServletContext();
		context.setAttribute("FaccultyEntries",FaccultyEntries );
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Set the content type to HTML
				response.setContentType("text/html");
				
				// Get a reference to the Print Write to talk back to the client
				PrintWriter out = response.getWriter();
				
				// The template text/html
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
				
				out.println("	<h1>Candidates <small>CS3220</small></h1>");
				
				
				// Insert the page-specific content here...
				out.println("	<table class=\"table table-bordered table-striped table-hover\">");
				out.println("		     <tr>");
				
				out.println("			<th>ID</th>");
				
				out.println("			<th>Name</th>");
				out.println("			<th>Specialties</th>");
				out.println("			<th>Presentation</th>");
				out.println("			<th>Operation</th>");
			
				out.println("		</tr>");
				
				// Get a reference to our guest book
				ArrayList<hiringfFculty> FaccultyEntries = (ArrayList<hiringfFculty>) getServletContext().getAttribute("FaccultyEntries");
				
			    for (hiringfFculty entry : FaccultyEntries) {
					out.println("		             <tr>");
					out.println("			<td>" +entry.getId()  + "</td>");
					out.println("			<td>" + entry.getName()+ "</td>");
					out.println("			<td>" + entry.getSpecialties() + "</td>");
					out.println("			<td>" + entry.getPresentation() + "</td>");
					out.println("	<td> <a href=\"EditEntry?id=" + entry.getId() + "\">Edit</a> </td> ");
					//out.println("<td> <a href='EditEntry?id='"+ entry.getId()+">"+"Edit</a> </td>");
					out.println("</tr>");
	
					
				}
				
				out.println("	</table>");
				
				
				out.println("<a href=\"AddNewCandiFaculty\">Add Candidate</a>");
				
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
