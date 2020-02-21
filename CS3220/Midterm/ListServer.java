package Mid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListServer")
public class ListServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	
	public void init(ServletConfig config) throws ServletException {
		
		 super.init(config);
		
		 // A An  ArrayList of survey
		 List <surveyModel> survey= new ArrayList <surveyModel>();
		 
		
		 
		 List<questionsModel> questions= new ArrayList <questionsModel>();
		 
		 List <String>  chocies= new ArrayList <String>();
		 
		 chocies.add("Yes");
		 chocies.add(" No, but I will complete all the six requirements by the end of Spring 2019.");
		 chocies.add("  No, and I will not be able to complete them by the end of Spring 2019.");
		
		 
		 questions.add( new questionsModel("Have you completed all the following prerequisite CS courses with minimum C grade: CS3035, CS3112, CS3186, CS3220, CS3337, and CS3801? \n" + 
		 		"\n" + 
		 		"",chocies) );
		 
		 getServletContext().setAttribute("questions", questions);
		 getServletContext().setAttribute("chocies", chocies);
		 
		 
		 survey.add( new surveyModel("CS 4961 Readiness Survey for Fall 2019",questions));
		 survey.add( new surveyModel("2016-2018 Curricular Feedback"));
		 getServletContext().setAttribute("survey", survey);
		 
				
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/ListSurvey.jsp").forward(request, response);
		
		
		//
	}
	
	
	
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
