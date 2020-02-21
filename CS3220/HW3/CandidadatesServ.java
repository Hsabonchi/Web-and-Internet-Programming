
package CandidateRating;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/CandidadatesServ")
public class CandidadatesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	public void init(ServletConfig config) throws ServletException {
		
		  super.init(config);
		  
		   // list of Candidates
			ArrayList <CandidateRating> candidates= new ArrayList <CandidateRating>();
			// each Candidate has a feed back
			ArrayList <FeedbackModel> feedback= new ArrayList <FeedbackModel>();
			
			ArrayList <FeedbackModel> feedback1= new ArrayList <FeedbackModel>();
			
			//Initaialize  each record  (John. jack ,jay, may)
			ArrayList <FeedbackModel> feedback2= new ArrayList <FeedbackModel>();
			ArrayList <FeedbackModel> feedback3= new ArrayList <FeedbackModel>();
			
			
			
			feedback.add(new FeedbackModel("Sue","I like his research. Seems to be a nice person.",3));
			
			feedback.add(new FeedbackModel("Tom","The presentation was not very well organized. He may be a good researcher but I don't think he'll be a good teacher. ",5));
	        
			
			//each candidate has name presentation , specialties, An ArrayList of feedback
			
			candidates.add(new CandidateRating("John","Machine Learning	","10am on 2/20 in ET A227",feedback));
			candidates.add(new CandidateRating("Jack","Computer Vision	","10am on 2/25 in ET A332",feedback1));
			
			
			//
			candidates.add(new CandidateRating("Jane","Machine Learning	"," 10am on 2/25 in ET A332",feedback2));
			candidates.add(new CandidateRating("May","Computer Science Education","3:30pm on 3/11 in FA 219",feedback3));
	        
			
			
			// save the refrence in the application scope 
	        ServletContext context = this.getServletContext();
			//context.setAttribute( "feedback", feedback );
			context.setAttribute( "candidates", candidates );
	       //request.getSession().setAttribute("candidates",candidates);
	      
		
		
		
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/DisplayCandidates.jsp").forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
