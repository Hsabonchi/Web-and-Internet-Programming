package HW5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
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
				System.out.println(c.getId()+c.getName());
		
		
		
		
		
		
//		//save (refrence to Edited Faculty) Application scope in order to display it in .jsp
		getServletContext().setAttribute( "c", c );
//		
//		// save edited  entry 
	      getServletContext().setAttribute( "id", id );
//		
		
	//ArrayList <CandidateRating> candidates =((ArrayList <CandidateRating>) getServletContext().getAttribute("candidates"));
	//getServletContext().setAttribute( "candidates", c );
		request.getRequestDispatcher("/WEB-INF/EditCand.jsp").forward(request, response);
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		   Connection c = null;
	        try
	        {
	        	   
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu01?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu01";
	            String password = "!mDz8Pt3";

	            c = DriverManager.getConnection( url, username, password );
	            //Statement stmt = c.createStatement();
	            
	            
              String sql = "UPDATE   Candidates set name=?, specialties=?, presentation=? where id=?";
	            
	            PreparedStatement pstmt = c.prepareStatement( sql );
	           pstmt.setString( 1, request.getParameter("name"));
	           pstmt.setString( 2, request.getParameter("specialties"));
	           pstmt.setString( 3, request.getParameter("presentation"));
	           // must be an Integer
	           pstmt.setInt( 4,  (int) getServletContext().getAttribute( "id" ));
	           
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
		
		
		
		
		
		String candidateName=request.getParameter("name");
		String Specia=request.getParameter("specialties");
		String Present=request.getParameter("presentation");
		
		
//		System.out.println(" ID "+request.getParameter("id"));
//		System.out.println(" candidateName "+candidateName);
//		System.out.println(" Specia "+Specia);
//		System.out.println(" Present "+Present);
		
		
		    // entry=getEntry(id);
		
	
		
		response.sendRedirect("CandidadatesServ");
		
		
		
		
		
	}

}
