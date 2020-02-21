package CandidateRating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DisplayFeedback")
public class DisplayFeedback extends HttpServlet {
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
		
		 List<FeedbackModel>f= c.feedback;
		 
//	 for ( FeedbackModel entry : f) {
//			 
//	     System.out.println("Name of updated record"+f.get(0).name); 
//	 }
	 
		 
		System.out.println(c.getId()+c.getName());
		
		//save (refrence to Edited Faculty) Application scope in order to display it in .jsp
		getServletContext().setAttribute( "c", c );
		
		// save edited  entry 
		getServletContext().setAttribute( "id", id );
		

		
		
		request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList <CandidateRating> candidates =((ArrayList <CandidateRating>) getServletContext().getAttribute("candidates"));
		
		CandidateRating c= (CandidateRating)getServletContext().getAttribute( "c");
		

		
		
		String name =request.getParameter("name");
		
		String comments=request.getParameter("comments");
		String[] rating=request.getParameterValues("rate");
		  
		int rate = 0;
		
		
		
		
		
		// print input
		for(int i=0;i<rating.length;i++) {
			
			   if(rating[i]!=""){
				    
				   System.out.println("int value of"+Integer.parseInt(rating[i]));	
				   rate= Integer.parseInt(rating[i]);
			   }
		        }
		
		
		
		

		if(name.trim().length()==0||comments.trim().length()==0||rate==0) {
			
			//response.sendRedirect( "C" );
			request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);
			return;
			
			
		}
		
		
		
		System.out.println("name  "+name+"  "+ comments  +" rating   ");
		
		FeedbackModel f    =new FeedbackModel (name,comments,rate);
		
		
		

		c.feedback.add(f);
		
		getServletContext().setAttribute( "candidates", candidates );
		response.sendRedirect( "CandidadatesServ" );
		//request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);

		
	
		
	}

}
