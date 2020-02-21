package Team;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void init(ServletConfig config) throws ServletException {
		
		
		super.init(config);
        List <Bracketology> Teams= new ArrayList <Bracketology>();
		//String  Path = this.getServletContext().getRealPath("/WEB-INF/text.txt");
		
		ServletContext context = getServletContext();
		//returns the absolute file path on the server's filesystem would be served by a request for 
		//InputStream resource = (InputStream) getServletContext().getResourceAsStream("/WEB-INF/text.txt");
		
		
		/// Get the path to the file and create a java.io.File object
		
	    try
        {
            // read file
            Scanner in;
            in = new Scanner( new File(getServletContext().getRealPath( "/WEB-INF/teams.txt")));
            while( in.hasNextLine())
            {
                String T1 = in.nextLine();
                String T2 = in.nextLine();
                Teams.add(new Bracketology(T1, T2 ));
            }
            in.close();
        }
        catch( FileNotFoundException e )
        {
            throw new ServletException( e );
        }

	    
	  getServletContext().setAttribute( "Teams", Teams );

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getServletContext().getAttribute("Teams");
		request.getRequestDispatcher( "/WEB-INF/Bracketology.jsp" ).forward( request, response );
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	        List<Bracketology> matches = new ArrayList<Bracketology>();
		
		       //The keys in the parameter map are of type String.name="Match${Teams.id}"
    	
    	      //The values in the parameter map are of type String array value="${Teams.team2}"
			    Map<String, String[]> p=request.getParameterMap();
			    
			    for (Map.Entry<String, String[]> entry : p.entrySet()) {
			        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			    }
			    
			    
			    
			    
			    
			    for (String[] key : p.values()) {
			    	 
			        System.out.println("Key = " +key[0]);
			    }
			   
			    
			    // convert the keySet() into string array
			    String[] keys = p.keySet().toArray(new String[p.size()]);
			    
			 
			  			    
			    for (int i=0; i < keys.length; i+=2) {
			    	
			    	if(keys.length==1) {
			    		//Returns the value to which the specified key is mapped, 
			    		//or null if this map contains no mapping for the key.
				    	System.out.println(p.get(keys[i])[0]);
				    	String winer=p.get(keys[i])[0];
				    	
				    	request.getSession().setAttribute("x",winer);
				    	request.getRequestDispatcher( "/WEB-INF/FinalRound.jsp").forward( request, response );
				    	return ;   	
			    	}
			    	matches.add(new Bracketology(p.get(keys[i])[0],p.get(keys[i+1])[0]));
			    }

			    getServletContext().setAttribute( "matches", matches );
			    
				request.getRequestDispatcher( "/WEB-INF/Bracketology2.jsp" ).forward( request, response );
			    //response.sendRedirect("/WEB-INF/Bracketology.jsp" );
			    
			   
				
				
				
	}

}
