package CandidateRating;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		System.out.println("id in the get"+id);
	
		CandidateRating c=getEntry(id);
		
		List<FeedbackModel>feedback= new ArrayList<FeedbackModel>();
		ResultSet rs;   
        PreparedStatement pstmt;
		  Connection c1 = null;
		  
		  double Eavg=0;
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c1 = DriverManager.getConnection( url, username, password );
	            
	            String sql = "SELECT * FROM  feedbacks where candidate_id=?";
	           
	            pstmt = c1.prepareStatement( sql );
	             pstmt.setInt( 1,  id);
	              rs =pstmt.executeQuery();
	             

                  // must  match the constructor  for the model
	            while( rs.next() )	{
	            	feedback .add( new  FeedbackModel(
	            			rs.getString("name"),rs.getString( "message" ),rs.getTimestamp( "date" ),rs.getInt("rate")));
	            }
	            
	            
	            
	      
	            
	            
	 String sql1 = "select c.id ,avg(f.rate) as avg from Candidates c  inner join feedbacks f on c.id=f.candidate_id  where c.id=" + id +" group by c.id ";
	           pstmt = c1.prepareStatement( sql1 );
//	           pstmt.setInt( 1, id);  
	           System.out.println(sql1);
	            rs =pstmt.executeQuery();
		     	
		     	     while( rs.next() ) {
		     	    	Eavg= rs.getDouble( "avg" );
		     	     }
	            c1.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c1 != null ) c1.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	      //save (refrence to Edited Faculty) Application scope in order to display it in .jsp
			getServletContext().setAttribute( "c", c );			
			// save edited  entry 
			getServletContext().setAttribute( "id", id );
	        getServletContext().setAttribute( "feedback", feedback);
	        getServletContext().setAttribute( "Eavg", Eavg);
		request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id=(Integer)getServletContext().getAttribute( "id");

		//System.out.print("id in post "+id);
		
		
		String name =request.getParameter("name");
		
		String comments=request.getParameter("comments");

		  
		int rate=0;
		
		for(int i=1;i<=5;i++) {
			
					if (request.getParameter("rate"+i)!=null) {
						rate=i;
						
					}
					
		    }
		
		if(name.trim().length()==0||comments.trim().length()==0) {
			
			//response.sendRedirect( "C" );
			request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);
			return;
		}
		
		
		
		//System.out.println("name  "+name+"  "+ comments  +" rating   "+rate);
		
		//FeedbackModel f    =new FeedbackModel (name,comments,rate);
		
		
		

		
			
			Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";
	
	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            
	            
	               String sql = "insert into  feedbacks (name,message,date,candidate_id,rate) values(?,?,now(),?,?)";
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
		           pstmt.setString( 1, request.getParameter("name"));
		           pstmt.setString( 2, request.getParameter("comments"));
		           
	           
	           // must be an Integer
	           pstmt.setInt( 3,  (int) getServletContext().getAttribute( "id" ));
	           pstmt.setInt( 4,rate );
	            pstmt.executeUpdate();
	            
	         
	
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
		
			
			
	        
		
		response.sendRedirect( "CandidadatesServ" );
		//request.getRequestDispatcher("/WEB-INF/DisplayFeedback.jsp").forward(request, response);

		
	
		
	}

}
