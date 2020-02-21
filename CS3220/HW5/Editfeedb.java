package HW5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editfeedb")
public class Editfeedb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	protected FeedbackModel  getEntry(int id) {
		
		
		ArrayList <FeedbackModel> candidates =((ArrayList <FeedbackModel>) getServletContext().getAttribute("feedback"));
			
			  for (FeedbackModel entry : candidates) {
				  
				  if (entry.getId()==id)
			 
			               return entry;
			  }
			
			  return null;
		}
		
		
		
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
		FeedbackModel  Userfeed=getEntry(Integer.parseInt(request.getParameter("id")));
		
	    getServletContext().setAttribute( "Userfeed", Userfeed );
		
	    
	    request.getRequestDispatcher("/WEB-INF/EditUserfeed.jsp").forward(request, response);
	    
		
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		System.out.print("I'm in the edit  "+request.getParameter("id"));
       int rate=0;
		
		for(int i=1;i<=5;i++) {
			
					if (request.getParameter("rate"+i)!=null) {
						rate=i;
						
					}
					
		    }
		
		
		
		
		
		Connection c = null;
        try
        {
        	   
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu01";
            String password = "!mDz8Pt3";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
           
           String sql = "UPDATE   feedb  set  message=?, rate=? where id=?";
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            
            
            pstmt.setString( 1, request.getParameter("comments"));
            pstmt.setInt( 2, rate);
            pstmt.setInt( 3, Integer.parseInt(request.getParameter("id")));
          
     
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
	
		
		
//        request.getRequestDispatcher( "/WEB-INF/DisplayFeedback.jsp" )
//        .forward( request, response );
//		
        
        
    	response.sendRedirect("CandidadatesServ");
		
		
	}

}
