package CandidateRating;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
protected CandidateRating getEntry(int id) {
		
		
	ArrayList <CandidateRating> candidates =((ArrayList <CandidateRating>) getServletContext().getAttribute("candidates"));
		
		  for (CandidateRating entry : candidates) {
			  
			  if (entry.getId()==id)
		 
		               return entry;
		  }
		
		  return null;
	}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id"));  
		System.out.println(id);
	
		CandidateRating c=getEntry(id);
		System.out.println(c.getId()+c.getName());
		
		//save (refrence to Edited Faculty) Application scope in order to display it in .jsp
		getServletContext().setAttribute( "c", c );
		
		// save edited  entry 
		getServletContext().setAttribute( "id", id );
		
		request.getRequestDispatcher("/WEB-INF/EditCand.jsp").forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// Get a reference to our 
		
		ArrayList<CandidateRating> candidates = (ArrayList<CandidateRating>) getServletContext().getAttribute("candidates");
		//System.out.println(" id "+id);
		  
		
		// return id back from Application scope  to retuen the refrence
		 int id=(Integer)getServletContext().getAttribute("id");
	
		// Another  way to get  a refrence to 
		 CandidateRating ref=(CandidateRating)getServletContext().getAttribute( "c" );
		
		 CandidateRating candidate=getEntry(id);
		
		String candidateName=request.getParameter("name");
		String Specia=request.getParameter("specialties");
		String Present=request.getParameter("presentation");
		
		System.out.println(" candidateName "+candidateName);
		System.out.println(" Specia "+Specia);
		System.out.println(" Present "+Present);
		
		
		    // entry=getEntry(id);
		
		ref.setName(candidateName);
		ref.setSpecialties(Specia);
		ref.setPresentation(Present);
		
		response.sendRedirect("CandidadatesServ");
		
		
		
		
		
	}

}
