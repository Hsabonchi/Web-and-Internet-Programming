package Mid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateSurveyServ")
public class CreateSurveyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/CreateSurvey.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <surveyModel> survey= new ArrayList <surveyModel>();
		
		
		 String Ques=request.getParameter("q");
		 survey.add( new surveyModel(Ques));
		
		 getServletContext().setAttribute("survey", survey);
		 

		 response.sendRedirect( "" );

		
	}

}
