
package CandidateRating;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		  
		 
	}

	

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ArrayList <CandidateRating> candidates= new ArrayList <CandidateRating>();
		
		
		 ArrayList <Double> AvgRate= new ArrayList <Double>();    
		 
		 
	        Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "SELECT * FROM `Candidates`" );

	            while( rs.next() ) {
	            	candidates .add( new CandidateRating( rs.getInt( "id" ),
	                    rs.getString( "name" ), rs.getString( "specialties" ),
	                    rs.getString( "presentation" ) ) );

	            }
	            
	           
	      
	            
	   //rs = stmt.executeQuery("select c.id ,avg(f.rate) as avg from candidates c inner join Feedbacks f on c.id=f.candidate_id group by c.id order by c.id");
	   rs = stmt.executeQuery("select c.id,avg(f.rate) as avg from Candidates c left join feedbacks f on c.id=f.candidate_id group by c.id order by c.id");
	     
	  
	   
	     while( rs.next() ) {

	    	 AvgRate.add( new Double (rs.getDouble("avg")));
	    	 
	     }

	     
	     
//	     CandidateRating e=getEntry(id);
	     
	     
	     
	     
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
		
	        ServletContext context = this.getServletContext();
	        context.setAttribute( "candidates", candidates );
	        
	        context.setAttribute( "AvgRate", AvgRate );
	        
	        
	        
	        
	        for(int i=0;i<AvgRate.size();i++) {
	           // System.out.println(AvgRate.get(index));
	        }
	        
	        
	        
	        
	        request.getRequestDispatcher( "/WEB-INF/DisplayCandidates.jsp" )
            .forward( request, response );
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
