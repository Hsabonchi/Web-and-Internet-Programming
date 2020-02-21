package Mid;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ViewQuestionServ")
public class ViewQuestionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected questionsModel getEntry(int id) {
		
		
		ArrayList <questionsModel> candidates =((ArrayList <questionsModel>) getServletContext().getAttribute("questions"));
			
			  for (questionsModel entry : candidates) {
				  
				  if (entry.getId()==id)
			 
			               return entry;
			  }
			
			  return null;
		}
	
	
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList <questionsModel> questions =((ArrayList <questionsModel>) getServletContext().getAttribute("questions"));
		int id=Integer.parseInt(request.getParameter("id"));

		
		questionsModel c=getEntry(id);
		
		
		 getServletContext().setAttribute("c", c);
		System.out.println(id);
		
		
		request.getRequestDispatcher("/WEB-INF/ViewSurvey.jsp").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
