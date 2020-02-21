package DrivingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		List <Question> Ques= new ArrayList <Question>();
		
	   	
	
	    
		 String  description, answerA, answerB, answerC;
	    int correctAnswer;
	    	
    	
    	
    	String array[] = new String[5];
 
    	int i=0;
		try {
			File file = new File(getServletContext().getRealPath(("/WEB-INF/DrivingTest.txt")));
			 Scanner in = new Scanner(file);
			
			while(in.hasNextLine()) {
			        description=in.nextLine();
                	answerA=in.nextLine();
                	answerB=in.nextLine();
                	answerC=in.nextLine();
                	String num=in.nextLine();
                	correctAnswer=Integer.parseInt(num);
                		
                	//System.out.println(description);
			    	//System.out.println(answerA);
			    	//System.out.println(answerB);       
			    	//System.out.println(answerC);
                	Ques.add(new Question (description,answerA,answerB,answerC, correctAnswer));
			    	//System.out.println(correctAnswer);
			    	
			    	//NoSuchElementException - if no line was found
			    	if (in.hasNextLine()) {
                		in.nextLine();                		
                	}	    	
	    	} 
			in.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     getServletContext().setAttribute( "Ques", Ques );
     getServletContext().setAttribute("index", 0);
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Question> Ques = (List<Question>) getServletContext().getAttribute("Ques");
		 //Integer index=(Integer)getServletContext().getAttribute("index");
		 //String strindex=request.getParameter("index");
		 //int index=Integer.parseInt(strindex);
		 int index;
		 
		 
		 if(request.getParameter("index")==null) {
		     index=0; 
		 }
		 else {
		 String strindex=request.getParameter("index");
		 index=Integer.parseInt(strindex);
		 }
		 if(index==Ques.size()) {
			index=0;
			//getServletContext().setAttribute("index", 0);	 
		 }
		 
		 Question Q=Ques.get(index);
		 index++;
		 getServletContext().setAttribute("Q", Q);
		 
		 getServletContext().setAttribute("index",index);
		 
		 
		 
		 request.getRequestDispatcher("/WEB-INF/viewQuestion.jsp").forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
