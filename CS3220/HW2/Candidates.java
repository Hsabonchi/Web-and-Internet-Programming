package HW2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/Candidates")
public class Candidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	public void init(ServletConfig config) throws ServletException {
		    super.init(config);
 
		ArrayList <CandidatesModel> candidates= new ArrayList <CandidatesModel>();
		
        candidates.add(new CandidatesModel("John","Machine Learning	","10am on 2/20 in ET A227"));
        candidates.add(new CandidatesModel("Jack","Computer Vision	","10am on 2/25 in ET A332"));
        candidates.add(new CandidatesModel("Jane","Machine Learning	"," 10am on 2/25 in ET A332"));
        candidates.add(new CandidatesModel("May","Computer Science Education","3:30pm on 3/11 in FA 219"));
        
        for(CandidatesModel can:candidates) { 	
		       // System.out.println(can.Name);  
        }
        
        // save the refrence in the application scope 
        ServletContext context = this.getServletContext();
		context.setAttribute( "candidates", candidates );
       //request.getSession().setAttribute("candidates",candidates);
      
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/DisplayCandidates.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
